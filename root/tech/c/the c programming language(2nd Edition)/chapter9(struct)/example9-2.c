
#include <stdio.h>

struct Book {

char name[20];


};


void list(struct Book b);

struct Book getBook();

int main(int argc,char **argv,char **env){


struct Book bArr[4];

int i;
for(i=0;i<4;i++){

scanf("%s",&bArr[i]);


}

printf("\n============\n");

for(i=0;i<4;i++){
	list(bArr[i]);
}






struct Book b1=getBook();


printf("%s\n",b1.name);








return 0;

}

void list(struct Book b){


printf("%s\n",b.name);

}



struct Book getBook(){

struct Book b1;

//scanf("b1 oo",b1.name);

strcpy(b1.name,"b1 obj");


return b1;





}



