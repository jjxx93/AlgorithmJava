package offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * Created by jiax on 2017/1/4.
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        char[] charstr = str.toString().toCharArray();
        StringBuffer sb = new StringBuffer();
        for(char a : charstr) {
            if(a == ' ')
                sb.append("%20");
            else{
                sb.append(a);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("   ");
        System.out.println(str.length());
        System.out.println(new Solution2().replaceSpace(str));
    }
}
