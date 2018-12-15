#include <iostream>

using namespace std;

class A{
	
	public:
		virtual void f1(){
			
			cout<<"f1 in A"<<endl;
		}
	virtual void f2(){
			
			cout<<"f2 in A"<<endl;
		}
		
		virtual void f3(){
			
			cout<<"f3 in A"<<endl;
		}
	
};


typedef void (*Fun)();

int main(){
	
	
	//virutal function table point is in the front of obj
	
	// function pointer 
	
	A a;
	
	Fun f;
	
	f=(Fun)*((int *)*(int *)(&a)+0);
	
	
	f();
	f=(Fun)*((int *)*(int *)(&a)+1);
	
	
	f();f=(Fun)*((int *)*(int *)(&a)+2);
	
	
	f();
	
	
	
	
	
	
	
	return 0;
}