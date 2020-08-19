package com.joyming;

/**
 * 单例模式
 * 饿汉式 线程安全 类加载相对慢，获取对象速度快
 */
public class Singleton {

    //1、构造方法私有化，不允许外部持有
    private Singleton() {
    }

    //2、创建类的唯一实例，用private static修饰
    private static Singleton instance = new Singleton();

    //3、提供外部获取唯一实例的方法，用public static修饰
    public static Singleton getInstance() {
        return instance;
    }
}
