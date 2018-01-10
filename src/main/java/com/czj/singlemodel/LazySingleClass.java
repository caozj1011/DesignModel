package com.czj.singlemodel;

/**
 * Created by caozhiia on 2018/1/10.
 */

/**
 * 懒汉式单例模式
 * 会存在线程安全问题，所以在多线程情况下，应该考虑线程安全问题，可在获取实例的方法上加锁限制
 */
public class LazySingleClass{
    private static LazySingleClass singleClass = null;

    private LazySingleClass() {
        System.out.println("我正在创建~~~");
    }

    public static synchronized LazySingleClass getInstance() {
        if (singleClass == null) {
            if(singleClass == null){
                singleClass = new LazySingleClass();
            }
        }
        return singleClass;
    }



}

/**
 * 饿汉式单例模式，不会存在线程安全问题，类在加载的时候就该实例就已经创建完成。
 */
class HungrySingleClass {
    private static HungrySingleClass hungrySingleClass = new HungrySingleClass();

    private HungrySingleClass(){
        System.out.println("我是饿汉式单例模式");
    }
    public static HungrySingleClass getInstance(){
        return hungrySingleClass;
    }
    public static void main(String[] args) {

    }
}

class Th extends Thread{
    @Override
    public void run() {
        LazySingleClass singleClass = LazySingleClass.getInstance();
        HungrySingleClass hungrySingleClass = HungrySingleClass.getInstance();
//        System.out.println(Th.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Th().start();
        }
    }

}
