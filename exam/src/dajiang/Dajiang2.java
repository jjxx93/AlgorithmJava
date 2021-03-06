package dajiang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 在 DJI 的工时打卡计算系统中，一个工作日的定义是由工作日当天的凌晨 03:00:00 开始，到隔天凌晨 03:00:00（不包含） 为止。
 这其中，工作日当天的中午 12:30:00 到下午 14:00:00（不包含）为午休时间，不计入工作时间中。Tom 由于工作繁忙，
 担心自己有时候会忘记打卡，因此每次他经过打卡机到时候都会不由自主地打一次卡。为了更好的了解自己的工作情况，
 Tom 找到了自己整个八月份的乱序打卡记录，但是这些数据不小心弄乱了，所以 Tom 想请你帮个忙。从给出的 N 条打卡记录中，
 找出所有有效的打卡工作日（即在该工作日中打卡次数 >= 2并且有效工作时间 > 0），并计算该工作日中的有效工作时间（按秒计算，除去打卡时间内出现的午休时间）。其中工作日定义为当天3:00:00到次日2:59:59为当天工作日，即当天2:59:59(包括)以前的打卡记录算作前一天打卡记录和有效工作时间，不计做当天的打卡记录和有效工作时间。
 输入
 第一行为一个整数 N （0<N<200），随后有 N 行数据，每行是一个形如 mm.dd hh:mm:ss 打卡记录。
 输出
 输出若干行数据，按照时间先后排序，每行包括工作日的起始日期以及工作的总时长，如 08.01 36000 。如果全部数据中有效打卡工作日为0，输出-1。

 样例输入
 12
 08.10 01:00:00
 08.09 23:59:59
 08.10 17:00:00
 08.10 18:00:00
 08.01 01:00:00
 08.01 04:00:00
 08.03 10:00:00
 08.03 12:29:59
 08.04 10:00:00
 08.04 12:30:00
 08.07 01:00:00
 08.07 02:00:00
 样例输出
 08.03 8999
 08.04 9000
 08.06 3600
 08.09 3601
 08.10 3600
 */
public class Dajiang2 {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        int length = Integer.valueOf(sc.nextLine());

        Map<String, Calendar[]> times = new HashMap<String, Calendar[]>();

        for (int i = 0; i < length; i++) {
            String tempStr = sc.nextLine();

            SimpleDateFormat formatter = new SimpleDateFormat("MM.dd HH:mm:ss");
            Date date = formatter.parse(tempStr);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR,2017);
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)-3);

            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            String nowDate = ((month < 10) ? ("0" + month) : month) + "." + ((day < 10) ? ("0" + day) : day);

            if (times.containsKey(nowDate)) {
                Calendar[] calendars = times.get(nowDate);

                if (calendars[1] != null) {
                    if (calendar.after(calendars[1])) calendars[1] = calendar;
                    if (calendar.before(calendars[0])) calendars[0] = calendar;
                } else {
                    if (calendar.before(calendars[0])) {
                        calendars[1] = calendars[0];
                        calendars[0] = calendar;
                    } else {
                        calendars[1] = calendar;
                    }
                }
            } else {
                Calendar[] calendars = new Calendar[2];
                calendars[0] = calendar;

                times.put(nowDate, calendars);
            }
        }

        Set<String> dateSet = times.keySet();
        List<String> timeList = new ArrayList<String>(dateSet.size());
        for (String date : dateSet) {
            timeList.add(date);
        }
        Collections.sort(timeList);

        SimpleDateFormat format = new SimpleDateFormat("YY:MM:dd HH:mm:ss");
        List<String> results = new ArrayList<String>();
        for (String time : timeList) {
            Calendar[] calendarPair = times.get(time);
            if (calendarPair[1] != null) {

                long ms=0;

                //减去午休时间
//                say(calendarPair[0]);
//                System.out.println();
//                say(calendarPair[1]);
//                System.out.println();

                Calendar sleepStart = (Calendar) calendarPair[0].clone();
                sleepStart.set(Calendar.HOUR_OF_DAY, 9);
                sleepStart.set(Calendar.MINUTE, 30);
                sleepStart.set(Calendar.SECOND, 0);
//                System.out.print("休息开始：");say(sleepStart);System.out.println();


                Calendar sleepEnd = (Calendar) calendarPair[0].clone();
                sleepEnd.set(Calendar.HOUR_OF_DAY, 11);
                sleepEnd.set(Calendar.MINUTE, 0);
                sleepEnd.set(Calendar.SECOND, 0);
//                System.out.print("休息结束：");say(sleepEnd);System.out.println();




                if (calendarPair[0].before(sleepStart) && calendarPair[1].after(sleepEnd)) { //上班--开始休息--结束休息--下班
                    ms = calendarPair[1].getTimeInMillis() - calendarPair[0].getTimeInMillis() - 5400000;

                } else if (calendarPair[0].before(sleepStart) && calendarPair[1].before(sleepStart)) {//上班--开始休息--下班--结束休息
                    ms = calendarPair[1].getTimeInMillis() - calendarPair[0].getTimeInMillis();

                } else if (calendarPair[0].before(sleepStart) && calendarPair[1].before(sleepEnd)) {//上班--下班--开始休息
                    ms = sleepStart.getTimeInMillis() - calendarPair[0].getTimeInMillis();

                } else if (calendarPair[0].before(sleepEnd) && calendarPair[1].after(sleepEnd)) {
                    ms = calendarPair[1].getTimeInMillis() - sleepEnd.getTimeInMillis();

                }else if (calendarPair[0].before(sleepEnd) && calendarPair[1].before(sleepEnd)){
                    ms=0;

                }else if (calendarPair[0].after(sleepEnd) && calendarPair[1].after(sleepEnd)){
                    ms = calendarPair[1].getTimeInMillis() - calendarPair[0].getTimeInMillis();
                }


                results.add(time + " " + ms / 1000);
            }

        }

        // 输出结果
        if (results.size() == 0) {
            System.out.println(-1);
        } else {
            for (String str : results) {
                System.out.println(str);
            }
        }
    }

    public static void say(Calendar calendar) {

        Date date = calendar.getTime();
        String result = date.getMonth() + "." + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        System.out.print(result);

    }
}

/*
12
08.10 01:00:00
08.09 23:59:59
08.10 17:00:00
08.10 18:00:00
08.01 01:00:00
08.01 04:00:00
08.03 10:00:00
08.03 12:29:59
08.04 10:00:00
08.04 12:30:00
08.07 01:00:00
08.07 02:00:00
123
 */