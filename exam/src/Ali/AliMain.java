package Ali; /**
 * Created by jjxx9 on 2017/3/30.
 */
import java.util.Scanner;

public class AliMain {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int maxQps= Integer.valueOf(in.nextLine());
        final String[] rtList = in.nextLine().split(",");
        final int requestNum = Integer.valueOf(in.nextLine());
        final int threadNum = Integer.valueOf(in.nextLine());
        System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
    }
    /**
     * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
     * @return
     */
    static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {
        // TODO

        int brokerNum = rtList.length;
        int[] handleNumArray = new int[brokerNum];

        // 每个服务器每秒处理请求数
        int handleNum = 0;
        int max = 0;
        int totalHandle = 0;
        for (int i = 0; i < brokerNum; i++) {
            max = threadNum * 1000 / Integer.valueOf(rtList[i]);
            handleNum = max > maxQps ? maxQps : max;
            handleNumArray[i] = handleNum;
            totalHandle += handleNum;
        }

        long time = 1000 * requestNum / totalHandle;

        return time;

    }
}

