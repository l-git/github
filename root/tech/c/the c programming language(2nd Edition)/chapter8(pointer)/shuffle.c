#include <stdio.h>

#include <time.h>


void shuffle(int a[4][13]);

void deal(int a[4][13],char *p1[],int p2[]);


int main(int argc,char **argv,char **env){



srand(time(NULL));

char *p1[4]={"Hearts","Diamons","Clubs","Spades"};

int p2[13];

int i;
for(i=0;i<13;i++){
	
	p2[i]=i+1;

}


int a[4][13];

shuffle(a);



deal(a,p1,p2);


printf("\n========================================\n");

shuffle(a);



deal(a,p1,p2);







return 0;
}







void shuffle(int a[4][13]){

int r,c,card;

int i,j;
for(i=0;i<4;i++){

for(j=0;j<13;j++){

a[i][j]=0;
	
}

}


for(card=1;card<=52;card++){


do{

r=rand()%4;
c=rand()%13;


}while(a[r][c]!=0);

a[r][c]=card;



}




}

void deal(int a[4][13],char *p1[],int p2[]){

int card,r,c;

for(card=1;card<52;card++){

	for(r=0;r<4;r++){
	
		for(c=0;c<13;c++){
		
			
			if(card==a[r][c]){
				printf("%10s:%3d",p1[r],p2[c]);
				

					if(card%4==0){
						printf("\n");
					}else{
					printf("\t");
					}
	
				
			}
		
		}
	}


}


}







