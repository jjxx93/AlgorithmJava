package singletons;

/**
 * 内部类
 *
 * Created by xiongjiaxin on 2017/8/9.
 */
public class InnerSingleton {
    private InnerSingleton() {}

    public static class Holder {
        static InnerSingleton instance = new InnerSingleton();
    }

    public static InnerSingleton getInstance() {
        return Holder.instance;
    }
}
