#include <stdio.h>


struct score {

int math;
int eng;


};


struct stu {

char name[12];

struct score sco;

};



int main(int argc,char **argv,char **env){


struct stu s1={"hello",100,30};


struct stu s2;
s2=s1;

s2.name[0]='H';


printf("%s\t%d\t%d\t\n",s1.name,s1.sco.math,s1.sco.eng);
printf("\n=========================\n");
printf("%s\t%d\t%d\t\n",s2.name,s2.sco.math,s2.sco.eng);








return 0;

}






