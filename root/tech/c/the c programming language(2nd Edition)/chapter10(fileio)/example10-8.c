#include <stdio.h>


struct Person{

int id;
char name[20];
float money;


};



int main(int argc,char **argv,char **env){




int len;

int i;

struct Person p={1,"f",1.2};


FILE *fp;
fp=fopen("credit.dat","w");


len=sizeof(struct Person);
if(fp==NULL){
printf("file open error\n");

}else{

for(i=0;i<100;i++){

fwrite(&p,len,1,fp);

}

fclose(fp);

printf("write scucess\n");

}










return 0;

}








