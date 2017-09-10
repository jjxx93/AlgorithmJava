import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊佳新 on 2017/9/10.
 */
public class Zhaoying2 {
    public String convent(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char chars = s.charAt(i);
            if (chars >= 128) {
                if (count == 10) {
                    return sb.toString();
                }
                sb.append("<>");
                count++;
                sb.append(chars);
                if (count == 10) {
                    return sb.toString();
                }
                sb.append("<>");
                count++;
            } else {
                sb.append(chars);
            }
        }

        return sb.toString();
    }
}
