#include <stdio.h>
int main(){



char ch;
ch=getchar();

while(ch!=EOF){
printf("getchar is %c\n",ch);
ch=getchar();
}




return 0;
}