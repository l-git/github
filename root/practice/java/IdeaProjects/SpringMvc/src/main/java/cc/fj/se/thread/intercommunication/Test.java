package cc.fj.se.thread.intercommunication;

/**
 * Created by asus on 2015/12/6.
 */
public class Test {
    public static void main(String args[]){
        Chat chat=new Chat();
        T1 t1=new T1(chat);
        T2 t2=new T2(chat);



    }
}
