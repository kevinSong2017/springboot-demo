package com.demo.executor;

import java.util.concurrent.Executor;

public class ThreadPerTaskExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("执行逻辑aaabbb");
            }
        };
        ThreadPerTaskExecutor threadPerTaskExecutor =new ThreadPerTaskExecutor();
        threadPerTaskExecutor.execute(runnable);



    }
}
