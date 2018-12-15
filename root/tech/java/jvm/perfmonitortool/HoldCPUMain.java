
//find which thread occuppy cpu

//jps find java thread

//pidstat -p pid -u 1 3 -t

//pidstat -p pid  1 3 -u -t   find thread id;


//jstack -l pid   //find what thread doing here

public class HoldCPUMain{


public static class HoldCPUTask implements Runnable{
	
	@Override
	public void run(){
	
		while(true){
			double d=Math.random()*Math.random();
		}
	}

	

}


public static class LazyTask implements Runnable{
@Override
	public void run(){
	
	try{
		while(true){
			Thread.sleep(1000);
		}
		
		
		}catch(Exception e){
		
		
		}
	}

	
	
}




public static void main(String args[]){
	
		new Thread(new HoldCPUTask()).start();
	
		new Thread(new LazyTask()).start();
		new Thread(new LazyTask()).start();
		new Thread(new LazyTask()).start();
		
	
	}



}