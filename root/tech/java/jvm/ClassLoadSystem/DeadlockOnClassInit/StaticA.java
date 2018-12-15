public class StaticA{

static {

try{

Thread.sleep(1000);
}catch(Exception e){
	e.printStackTrace();
}



try{

Class.forName("StaticB");
}catch(ClassNotFoundException e){
	e.printStackTrace();
}


System.out.println("static a inited");

}


}