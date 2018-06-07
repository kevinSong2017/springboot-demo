package com.demo.util;

/**
 * 饿汉式
 * 线程安全
 * 这种方式在类加载的时候就完成了初始化，
 * 所以类加载比较慢，
 * 但获取对象的速度快，
 * 这种基于类加载的机制避免了多线程同步的问题。
 */
public class Singleton {
    private static  Singleton instance= new Singleton();
    public Singleton() {
    }
    public static  Singleton getInstance(){
        return instance;
    }
}

/**
 * 懒汉式
 * 线程不安全
 * 节约资源
 */
class LazySingleton{
    private static  LazySingleton lazySingleton ;

    public LazySingleton() {
    }

    public  static  LazySingleton getLazySingleton(){
        if (lazySingleton==null){
            lazySingleton= new LazySingleton();

        }
        return  lazySingleton;
    }
}

/**
 * 懒汉式  线程安全
 */
class LazySafeSingleton{

    private static LazySafeSingleton lazySafeSingleton ;

    public LazySafeSingleton() {
    }

    public static synchronized  LazySafeSingleton getLazySafeSingletonInstance(){
        if (lazySafeSingleton==null){
            lazySafeSingleton=new LazySafeSingleton();
        }
        return lazySafeSingleton;
    }

}

/**
 * 双重检索模式（DCL）
 */
class DoubleRetrievalSingleton{
    private  volatile  static  DoubleRetrievalSingleton doubleRetrievalSingleton ;
    public DoubleRetrievalSingleton() {
    }
    public static DoubleRetrievalSingleton getInstance(){
        if (doubleRetrievalSingleton==null){
            synchronized (DoubleRetrievalSingleton.class){
                if (doubleRetrievalSingleton==null){
                    doubleRetrievalSingleton=new DoubleRetrievalSingleton();
                }
            }
        }
        return doubleRetrievalSingleton;
    }
}

/**
 * 静态内部类单例模式
 * 第一次加载StaticInnerClassSingleton的时候不会初始化instance ，只有在第一次调用的getInstance()方法的时候虚拟机加载SingletonHolder并
 * 初始化instance，这样不仅能确保线程安全也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式
 */

class StaticInnerClassSingleton{

    private StaticInnerClassSingleton() {
    }

    public static  class  SingletonHolder{
        private static final StaticInnerClassSingleton instance=new StaticInnerClassSingleton();
    }


    public static StaticInnerClassSingleton  getInstance() {
        return SingletonHolder.instance;
    }

}





















