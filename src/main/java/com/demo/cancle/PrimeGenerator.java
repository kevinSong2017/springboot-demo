package com.demo.cancle;

import com.demo.annotation.GuardedBy;
import com.demo.annotation.ThreadSafe;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * java 没有抢占式的方法用来停止任务，只能利用协作机制
 *
 * 以下是一个简单的取消任务策略
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {

    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();

    private volatile boolean cancelled;


    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel(){
        cancelled=true;
    }

    public synchronized List<BigInteger> get(){

        return  new ArrayList<>(primes);

    }


    /**
     * 一个仅运行一秒钟的素数生成器
     * @return
     */
    public static List<BigInteger> aSecondOfPrimes(){
        PrimeGenerator generator=new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            generator.cancel();
        }
        return generator.get();
    }


    public static void main(String[] args) {
        List<BigInteger> list = aSecondOfPrimes();
        System.out.println("size="+list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

    }

}
