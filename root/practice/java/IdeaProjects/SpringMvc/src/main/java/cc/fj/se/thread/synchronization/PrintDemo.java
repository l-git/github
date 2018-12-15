package cc.fj.se.thread.synchronization;

/**
 * Created by asus on 2015/12/6.
 */
public class PrintDemo {

    public void print(){

        for(int i=10;i>0;i--){
            System.out.println("count "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
