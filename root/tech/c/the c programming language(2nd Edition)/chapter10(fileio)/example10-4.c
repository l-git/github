
#include <stdio.h>

int main(int argc,char **argv,char **env){


FILE *fp;




char c;
char name[30];
char *filename;

filename=name;


printf("input read file name:\n");

gets(name);


fp=fopen(filename,"r");




/**
while((c=fgetc(fp))!=EOF){

putchar(c);

}

*/
char w[81];

while((fgets(w,80,fp))!=NULL){

printf("%s",w);

}


















fclose(fp);











return 0;
}














