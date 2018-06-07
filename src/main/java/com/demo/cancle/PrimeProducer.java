package com.demo.cancle;


import java.math.BigInteger;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import static java.util.concurrent.TimeUnit.SECONDS;

public class PrimeProducer extends  Thread {

    private final BlockingDeque queue;

    public PrimeProducer(BlockingDeque queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        BigInteger p=BigInteger.ONE;
        while (!Thread.currentThread().isInterrupted()){
            try {
                queue.put(p=p.nextProbablePrime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void cancel(){
        interrupt();
    }














    public static void main(String[] args) {
        BlockingDeque queue=new LinkedBlockingDeque();
        PrimeProducer primeProducer=new PrimeProducer(queue);
        primeProducer.start();
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            primeProducer.cancel();
        }
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(":"+iterator.next());
        }
        System.out.println(primeProducer.isInterrupted());
    }

}
