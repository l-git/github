#include <stdio.h>
#include <stdlib.h>
#include <time.h>
struct Card {

char *face;
char *suit;


};

void fill(struct Card *card,char *face[],char *suit[]);

void shuffle(struct Card *card);

void deal(struct Card *card);



int main(int argc,char **argv,char **env){


char **t;
t=env;
while(*t!=NULL){
printf("%s\n",*t);
t++;
}


srand(time(NULL));

struct Card cards[52];

char *face[]={"H","D","C","S"};
char *suit[]={
"1",
"2",
"3",
"4",
"5",
"6",
"7",
"8",
"9",
"10",
"11",
"12",
"13"
};


fill(cards,face,suit);
shuffle(cards);
deal(cards);






return 0;
}



void fill(struct Card *card,char *face[],char *suit[]){

int i;
for(i=0;i<52;i++){

card[i].face=face[i/13];
card[i].suit=suit[i%13];

}


}

void shuffle(struct Card *card){

int i,j;

struct Card tmp;

for(i=0;i<52;i++){

j=rand()%52;

tmp=card[i];

card[i]=card[j];
card[j]=tmp;



}



}

void deal(struct Card *card){

int i;
for(i=0;i<52;i++){
struct Card c=card[i];
printf("%2s--%2s%c",c.face,c.suit,(i+1)%4?'\t':'\n');

}

}













