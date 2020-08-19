package com.joyming;

/**
 * 单例模式
 * 懒汉式 线程不安全 类加载相对快，获取对象速度慢
 */
public class Singleton2 {

    //1、构造方法私有化，不允许外部持有
    private Singleton2() {
    }

    //2、声明类的唯一实例，用private static修饰
    // JVM的指令重排 ,volatile关键字对线程中的对象立即刷新
    private static volatile Singleton2 instance = new Singleton2();

    //3、提供外部获取唯一实例的方法，用public static修饰
    //加锁解决线程不安全的问题
    public static Singleton2 getInstance() {
        //同步代码块
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
