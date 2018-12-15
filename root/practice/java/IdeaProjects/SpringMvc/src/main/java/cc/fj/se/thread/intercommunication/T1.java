package cc.fj.se.thread.intercommunication;

/**
 * Created by asus on 2015/12/6.
 */
public class T1 implements Runnable {
    Chat chat;
    public T1(Chat chat){
        this.chat=chat;
        new Thread(this,"question").start();
    }
    String s1[]={"a1","a2","a3"};

    @Override
    public void run() {
        for(int i=0;i<s1.length;i++){
            chat.question(s1[i]);
        }

    }
}
