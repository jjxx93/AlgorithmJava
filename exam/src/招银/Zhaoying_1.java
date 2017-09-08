package 招银;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jjxx9 on 2017/5/8.
 */
public class Zhaoying_1 {
    public static String getType(String url) {
        int index = url.indexOf(':');
        return url.substring(0, index);
    }

    public static List<String> getUrl(String url) {
        int index = url.indexOf(':');
        if (url.length() <= index + 1) return null;
        String subString = url.substring(index + 1);

        List<String> out = new ArrayList<>();
        String[] strings = subString.split(",");
        Collections.addAll(out, strings);
        return out;
    }

    public static void main(String[] args) {
        System.out.println(Zhaoying_1.getType("运动:url1,url2"));
        System.out.println(Zhaoying_1.getUrl("运动:url1,url2").get(1));
    }
}
