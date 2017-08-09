package singletons;

/**
 * 懒汉模式
 *
 * Created by xiongjiaxin on 2017/8/9.
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }
}
