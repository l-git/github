#include <stdio.h>
int main(int argc,char **argv,char **env){

printf("%d\n",EOF);
FILE *fp;


fp=fopen("mydata.txt","w");


if(fp==NULL){
printf("file open error\n");
}
else{

printf("file open success\n");

int i;
for(i=0;i<100;i++){

fputc(i,fp);

}

fputc('\n',fp);
for(i=0;i<100;i++){

fputc('=',fp);

}





printf("write success\n");
fclose(fp);



}







return 0;
}








