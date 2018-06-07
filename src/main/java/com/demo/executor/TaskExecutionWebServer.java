package com.demo.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 基于线程池的web服务器
 */
public class TaskExecutionWebServer {

    private static final int NTHREADS=100;

    private static final Executor executor=Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(80);
        while (true){
            final Socket socket=serverSocket.accept();
            Runnable task=new Runnable() {
                @Override
                public void run() {
                    System.out.println("----------------");
                }
            };
        }
    }

}
