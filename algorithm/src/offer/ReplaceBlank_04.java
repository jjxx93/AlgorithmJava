package offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * Created by jiax on 2017/1/4.
 */
public class ReplaceBlank_04 {
    public String replaceSpace(String str) {
        char[] originChars = str.toCharArray();

        int blankNum = 0;
        for (char originChar : originChars) {
            if (originChar == ' ') {
                blankNum++;
            }
        }

        char[] newChars = new char[originChars.length + 3 * blankNum];
        int j = newChars.length - 1;
        for (int i = originChars.length - 1; i >= 0; i--) {
            if (originChars[i] == ' ') {
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';
            } else {
                newChars[j--] = originChars[i];
            }
        }

        return String.copyValueOf(newChars);
    }

    public static void main(String[] args) {
        String str = "   ";
        System.out.println(str.length());
        System.out.println(new ReplaceBlank_04().replaceSpace(str));
    }
}
