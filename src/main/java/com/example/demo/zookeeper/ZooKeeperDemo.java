package com.example.demo.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.CountDownLatch;

public class ZooKeeperDemo {

    private static final String CONNECTION_STRING="47.98.162.133:2181";

    private static final int SESSION_TIMEOUT=5000;

    private static CountDownLatch latch=new CountDownLatch(1) ;

    public static void main(String[] args) throws  Exception{
        System.out.println("-----------:"+"11");

        ZooKeeper zk=new ZooKeeper(CONNECTION_STRING, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState()==Event.KeeperState.SyncConnected){
                    latch.countDown();
                }
            }
        });
        latch.await();

        System.out.println("------------:"+zk);
        System.out.println("------------:"+zk.getClass().getName());
    }



}
