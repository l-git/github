#include <stdio.h>

#include <string.h>


struct Person {


int id;

char name[20];




};


int main(int argc,char **argv,char **env){



FILE *fp;

char filename[20];


strcpy(filename,"a.txt");


fp=fopen(filename,"r");


struct Person p;

while(!feof(fp)){

fread(&p,sizeof(struct Person),1,fp);

if(p.id!=0){
printf("%d\t%s\n",p.id,p.name);
}

}












return 0;

}






