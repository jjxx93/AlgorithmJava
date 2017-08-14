package singletons;

/**
 * 饿汉模式
 *
 * Created by xiongjiaxin on 2017/8/9.
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
