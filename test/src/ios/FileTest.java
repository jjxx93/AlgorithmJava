package ios;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("./test");

        // 输出文件名
        System.out.println(file.getName());
        System.out.println(file.getPath());

        String[] fileList = file.list();
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
    }
}
