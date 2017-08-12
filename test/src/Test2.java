/**
 * Created by xiongjiaxin on 2017/8/12.
 */
public class Test2 {


    public static void main(String[] args) {
        String str1 = "A|B|C|DEFG";
        String[] strs = str1.split("\\|");
        System.out.println(strs[1]);
    }
}
