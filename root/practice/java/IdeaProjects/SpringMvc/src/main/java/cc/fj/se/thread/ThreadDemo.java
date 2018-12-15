package cc.fj.se.thread;

/**
 * Created by asus on 2015/12/6.
 */
public class ThreadDemo extends Thread {
    private String threadName;
    private Thread thread;
    public ThreadDemo(String threadName){
        this.threadName=threadName;
        System.out.println("create "+threadName);

    }

    @Override
    public void run(){
        System.out.println("running "+ threadName);
        for(int i=5;i<10;i++){
            System.out.println("i am thread "+threadName+",now is "+i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName+" completely");
    }

    public void start(){
        System.out.println("start "+threadName);
        if(thread==null){
            thread=new Thread(this,threadName);
            thread.start();
        }


    }

    public static void main(String args[]){
        ThreadDemo t3=new ThreadDemo("t3");
        ThreadDemo t4=new ThreadDemo("t4");
        t3.start();
        t4.start();


    }

}
