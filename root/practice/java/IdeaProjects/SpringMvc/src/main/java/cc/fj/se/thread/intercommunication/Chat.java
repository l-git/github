package cc.fj.se.thread.intercommunication;

/**
 * Created by asus on 2015/12/6.
 */
public class Chat {
    private boolean flag;

    public synchronized void question(String msg){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag=true;
        notify();

    }

    public synchronized void answer(String msg){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag=false;
        notify();

    }



}
