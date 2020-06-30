package org.xyz.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZkClient
 * @Description TODO
 * @Author xyz
 * @Date 2020/6/1 15:42
 * @Version 1.0
 **/
public class ZkClient {
    private static String connectString = "192.168.6.133:2181,192.168.6.133:2182,192.168.6.133:2183";
    private  static  String connect1 = "192.168.0.209:2181";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void connectZk() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(connectString, 1000, event -> {
            if (Watcher.Event.KeeperState.SyncConnected == event.getState()){
                System.out.println("完成");
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();

       // zooKeeper.create("/xyz/xyz", "xyz".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);


    }

    public static void main(String[] args) throws Exception {
        connectZk();
        System.out.println(System.currentTimeMillis());
    }
}
