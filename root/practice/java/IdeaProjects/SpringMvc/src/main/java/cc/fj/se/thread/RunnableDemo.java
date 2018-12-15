package cc.fj.se.thread;

/**
 * Created by asus on 2015/12/6.
 */
public class RunnableDemo implements Runnable {

    private String threadName;
    private Thread thread;

    RunnableDemo(String threadName){
        System.out.println("create "+threadName);
        this.threadName=threadName;
    }

    @Override
    public void run() {
        System.out.println("running "+threadName);
        for(int i=0;i<5;i++){
            System.out.println("i am thread "+Thread.currentThread().getName()+",now is "+i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(threadName+" completely");
    }

    public void start(){
        if(thread==null){
            System.out.println("start "+threadName);
            thread=new Thread(this,threadName);
            thread.start();
        }


    }

}
