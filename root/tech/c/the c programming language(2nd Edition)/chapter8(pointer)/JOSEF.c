#include <stdio.h>

#define size 30

void goout(int a[],int b[],int n);


int main(int argc,char **argv,char **env){


printf("josef\n");



int a[size];
int b[size];

int n;

int i;
for(i=0;i<size;i++){

	a[i]=i+1;

}



printf("input n:\n");

scanf("%d",&n);

goout(a,b,n);


printf("b:\n");

for(i=0;i<size;i++){

printf("%d\t",b[i]);
}












return 0;
}

void goout(int a[],int b[],int n){


int *p;
p=a;

int temp;

int i;
for(i=0;i<size;i++){


temp=0;

while(temp<n){

if(*p!=0){
	
	if(p==(a+size)){
		p=a;
	}else{
		p=p+1;
		temp++;
	}
	
	
	
}else{

if(p==(a+size)){
	p=a;
}
p++;


}



}

p=p-1;
b[i]=*p;
*p=0;










}





}



