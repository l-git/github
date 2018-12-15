#include <stdio.h>
#include <ctype.h>
int main(int argc,char **argv,char **env){


char ch;

FILE *fp;

fp=fopen("encrypt.txt","w");




ch=getchar();


while(ch!=EOF){
printf("%c\t",ch);



if(isalpha(ch)){

if((ch>='w'&&ch<='z')||(ch>='W'&&ch<='Z')){
	ch=ch-22;
}else{
	
	ch=ch+4;

}






}
fputc(ch,fp);
ch=getchar();
}





fclose(fp);







return 0;
}

