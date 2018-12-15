#include <stdio.h>

#include <string.h>
struct Person {


int id;

char name[20];




};




int main(int argc,char **argv,char **env){


char filename[20];
strcpy(filename,"a.txt");
FILE *fp;

fp=fopen(filename,"w");



struct Person p={0,"0"};




int len=sizeof(struct Person);

if(fp==NULL){

printf("file open error\n");
}else{

int i;

for(i=0;i<100;i++){

fwrite(&p,len,1,fp);

}


printf("write success\n");



}



printf("\n=============================\n");


int id;

printf("please input id:\n");

scanf("%d",&p.id);

while(p.id!=0){

getchar();
printf("input name\n");

gets(p.name);

fseek(fp,(p.id-1)*len,0 );

fwrite(&p,len,1,fp);

printf("input id:\n");

scanf("%d",&p.id);



}

rewind(fp);

fclose(fp);



fp=fopen(filename,"r");


printf("record:\n");


printf("id\tname\t\n");
while(!feof(fp)){

int a=fread(&p,len,1,fp);

//printf("read:\t%d\n",a);
if(p.id!=0){

printf("%d\t%s\n",p.id,p.name);
}



}



printf("read ok\n");

















fclose(fp);












return 0;
}


