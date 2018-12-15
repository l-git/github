package com.demo.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;

import java.util.List;

/**
 * Created by user on 
 */
 
 //sync node from one zookeeper to anather
 
public class CuroatorTest {


    @Test
    public void t1(){

        String ZK_ADDRESS="192.168.1.1:2181";

        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new RetryNTimes(10, 5000)
        );
        client.start();
        System.out.println("zk client start successfully!");


        try {



            client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/tmp/aaaa/192:34354","abcd".getBytes());

            System.out.println("ll");

           /* List cmds=client.getChildren().forPath("/");

            System.out.println(cmds.toString());*/

            //System.out.println(text.toString());


           /* String tmp="/tmp";

            PathChildrenCache watcher = new PathChildrenCache(
                    client,
                    tmp,
                    true    // if cache data
            );
            watcher.getListenable().addListener(new PathChildrenCacheListener(){

                public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {

                    ChildData data = pathChildrenCacheEvent.getData();
                    if (data == null) {
                        System.out.println("No data in event[" + pathChildrenCacheEvent + "]");
                    } else {
                        System.out.println("Receive event: "
                                + "type=[" + pathChildrenCacheEvent.getType() + "]"
                                + ", path=[" + data.getPath() + "]"
                                + ", data=[" + new String(data.getData()) + "]"
                                + ", stat=[" + data.getStat() + "]");
                    }

                }
            });
            watcher.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
            System.out.println("Register zk watcher successfully!");

            Thread.sleep(1000000000);*/

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

   static CuratorFramework client;

  /*  @Test
    public void t2(){


        String ZK_ADDRESS="192.168.1.212:2181";

        client = CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new RetryNTimes(10, 5000)
        );
        client.start();



        traverce("/bart");




    }*/


   /* static void traverce(String path){

        try {
        List<String> root=client.getChildren().forPath(path);

            if(root.size()>0){
                for(String s:root){

                    if(path.equals("/")){
                        String p=path+s;
                        System.out.println(p);
                        byte b[]=client.getData().forPath(p);
                        String s1="";
                        if(b==null){

                        }else{
                            s1=new String(b);
                        }
                        System.out.println(s1);
                        System.out.println("============================");
                        traverce(p);
                    }else{
                        String p=path+"/"+s;
                        System.out.println(p);
                        byte b[]=client.getData().forPath(p);
                        String s1="";
                        if(b==null){

                        }else{
                            s1=new String(b);
                        }
                        System.out.println(s1);
                        System.out.println("============================");
                        traverce(p);
                    }



                }
            }



    } catch (Exception e) {
        e.printStackTrace();
    }

    }*/


    @Test
    public void sync(){


        String serverAddr="192.168.129.143:2181";
        String clientAddr="192.168.129.142:2181";
        String pathNode="";
        pathNode="/bart";


        CuratorFramework server = CuratorFrameworkFactory.newClient(
                serverAddr,
                new RetryNTimes(10, 50000)
        );
        server.start();
        System.out.println("zk client start successfully!");

        CuratorFramework client = CuratorFrameworkFactory.newClient(
                clientAddr,
                new RetryNTimes(10, 50000)
        );
        client.start();
        System.out.println("zk client start successfully!");

        sync(server,client,pathNode);
    }


    static void sync(CuratorFramework server,CuratorFramework client,String path){

        try {
            List<String> root=server.getChildren().forPath(path);

            if(root.size()>0){
                for(String s:root){

                    if(path.equals("/")){
                        String p=path+s;
                        System.out.println(p);
                        byte b[]=server.getData().forPath(p);
                        String s1="";
                        if(b==null){

                        }else{
                            s1=new String(b);
                        }
                        System.out.println(s1);
                        System.out.println("============================");
                        createNode(client,p,s1);
                        sync(server, client, p);
                    }else{
                        String p=path+"/"+s;
                        System.out.println(p);
                        byte b[]=server.getData().forPath(p);
                        String s1="";
                        if(b==null){

                        }else{
                            s1=new String(b);
                        }
                        System.out.println(s1);
                        System.out.println("============================");
                        createNode(client,p,s1);
                        sync(server, client, p);
                    }



                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void createNode(CuratorFramework client,String path,String data){

        try {
            data.contains("dd");
            System.out.println("create node:\n"+path+"\n"+data);
            String r=client.create().forPath(path,data.getBytes());
            System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
