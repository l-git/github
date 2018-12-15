package com.demo.zookeeper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

import sun.misc.BASE64Encoder;
 

public class MoveZkNode {
 
    public static void main(String[] args) throws Exception{
        
        ZooKeeper oldzk = new ZooKeeper("127.0.0.1:2181:2181", 60000, null);
        
        ZooKeeper newzk = new ZooKeeper("127.0.0.1:2181", 60000, null);
        
        String node = "/bart";
        List<String> children = oldzk.getChildren(node, false);
        move(oldzk, newzk, children,node);
        oldzk.close();
        newzk.close();
    }
 
    private static void move(ZooKeeper oldzk, ZooKeeper newzk, List<String> children,String parent)
            throws KeeperException, InterruptedException {
        if(children==null || children.isEmpty()){
            return;
        }else{
            for(String child:children){
                String c = parent+"/"+child;
                System.out.println(c);
                byte[] data = oldzk.getData(c, false, null);
                if(newzk.exists(c, false)==null){
                    newzk.create(c, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                }else{
                    newzk.setData(c, data, -1, null, null);
                }
                move(oldzk, newzk, oldzk.getChildren(c, false),c);
            }
        }
    }
    
    
    
    
    
    
}
