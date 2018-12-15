#include <stdio.h>



int main(int argc,char **argv,char **env){


FILE *fp;

char c;
char filename[20];
char *name;
name=filename;

printf("input file name:\n");
gets(filename);
fp=fopen(name,"w");

if(fp==NULL){

printf("error\n");
}else{


while((c=getchar())!=EOF){
	
	fputc(c,fp);

}




}



fclose(fp);



return 0;

}






