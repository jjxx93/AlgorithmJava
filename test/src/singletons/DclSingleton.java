package singletons;

/**
 * 双重锁定
 *
 * Created by xiongjiaxin on 2017/8/9.
 */
public class DclSingleton {
    private static volatile DclSingleton instance;

    private DclSingleton() {

    }

    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }

        return instance;
    }
}
