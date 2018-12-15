package cc.fj.se.thread.intercommunication;

/**
 * Created by asus on 2015/12/6.
 */
public class T2 implements Runnable {
    private Chat chat;
    String s1[]={"b1","b2","b3"};
    public T2(Chat chat){
        this.chat=chat;
        new Thread(this,"answer").start();

    }

    @Override
    public void run() {

        for(int i=0;i<s1.length;i++){
            chat.answer(s1[i]);
        }


    }
}
