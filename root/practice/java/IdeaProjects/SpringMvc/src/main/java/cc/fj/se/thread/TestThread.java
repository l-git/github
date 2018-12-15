package cc.fj.se.thread;

/**
 * Created by asus on 2015/12/6.
 */
public class TestThread {

    public static void main(String args[]){
        RunnableDemo r1=new RunnableDemo("t1");
        RunnableDemo r2=new RunnableDemo("t2");
        r1.start();
        r2.start();


    }

}
