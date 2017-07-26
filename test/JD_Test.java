import httpMethod.HttpRequest;

import java.security.MessageDigest;
import java.util.Date;

/**
 * Created by xiongjiaxin on 2017/7/25.
 */
public class JD_Test {
    private static final String APP_ID = "22";

    private static final String SECRET_ID = "atu_wslkjzvbQa2";

    public final static String getMD5(String source) {
        String s = null;
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = source.getBytes();
            // 获得指定摘要算法的 MessageDigest对象，此处为MD5
            //MessageDigest类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
            MessageDigest md = MessageDigest.getInstance("MD5");
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            md.update(btInput);
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            // MD5 的计算结果是一个 128 位的长整数，
            byte tmp[] = md.digest();
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2];
            // 所以表示成 16 进制需要 32 个字符
            int k = 0;
            for (int i = 0; i < 16; i++) {
                // 转换成 16 进制字符的转换
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);
        } catch (Exception e) {
            System.err.println(e);
        }
        return s;
    }

    public static void main(String[] args) {
        String vid = "76706";

        long timeStamp = new Date().getTime();

        System.out.println(timeStamp);

        String sign = getMD5(vid + SECRET_ID + timeStamp);

        System.out.println(sign);

        String result = HttpRequest.sendGet("http://gw.video.jd.com/t/getPlayAddress.action?",
                "vid=442063&timestamp=1500613037768&sign=4e0f746f98225f0d10dc2e6ff3f67d8a");


//        VidDto resultDto = JSONObject.parseObject(result, VidDto.class);
//
//        if (resultDto == null) {
//            return;
//        }
//
//        if (resultDto.getCode() == -1) {
//            System.err.println("Error");
//            return;
//        }
//
//        String videoId = resultDto.getVideoId();
//        System.out.println(videoId);
    }
}
