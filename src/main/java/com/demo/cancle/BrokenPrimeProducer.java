package com.demo.cancle;


import java.math.BigInteger;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *  不要这么做！
 */
public class BrokenPrimeProducer extends Thread{

    private final BlockingDeque<BigInteger> queue;
    private volatile boolean cancelled=false;

    public BrokenPrimeProducer(BlockingDeque<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BigInteger p=BigInteger.ONE;
        while (!cancelled){
            try {
                queue.put(p=p.nextProbablePrime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void cancel(){
        cancelled=true;
    }

    public void consumePrimes() {
        BlockingDeque<BigInteger> primes=new LinkedBlockingDeque<>();
        BrokenPrimeProducer brokenPrimeProducer=new BrokenPrimeProducer(primes);
        brokenPrimeProducer.start();
        while (true){

        }
    }

}
