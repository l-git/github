#include <stdio.h>

#include <time.h>

#define size 10


void sort(int a[],int i,int (*p)(int p1,int p2));

void swap(int *p1,int *p2);

int ascending(int a,int b);

int descending(int a,int b);

int main(int argc,char **argv,char **env){



int order;
int (*p)();

int a[size];

srand(time(NULL));

int count;

for(count=0;count<size;count++){
	
	a[count]=rand()%100;
	printf("%5d",a[count]);

}


printf("\nscanf order:\n");
scanf("%d",&order);
if(order==1){
p=ascending;
}else{
	p=descending;
}


sort(a,size,p);
printf("\n========================\n");
for(count=0;count<size;count++){
	printf("%5d",a[count]);
}






return 0;


}





void sort(int a[],int n,int (*p)(int p1,int p2)){


int i,j;
for(i=0;i<n;i++){

for(j=0;j<i;j++){

if((*p)(a[i],a[j])>0){
 swap(&a[i],&a[j]);
}

}

}


}

void swap(int *p1,int *p2){

	int tmp;
	tmp=*p1;
	*p1=*p2;
	*p2=tmp;

}

int ascending(int a,int b){
	return b-a;
}

int descending(int a,int b){

return a-b;

}





