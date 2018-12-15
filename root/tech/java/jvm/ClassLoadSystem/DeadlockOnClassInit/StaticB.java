public class StaticB{

static {

try{

Thread.sleep(1000);
}catch(Exception e){
	e.printStackTrace();
}



try{

Class.forName("StaticA");
}catch(ClassNotFoundException e){
	e.printStackTrace();
}


System.out.println("static b inited");

}


}