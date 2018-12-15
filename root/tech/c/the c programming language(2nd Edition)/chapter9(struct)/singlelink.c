
#include <stdio.h>
#include <stdlib.h>

struct string {

char c;
struct string *n;


};


struct string *create();

void print(struct string *head);



int main(int argc,char **argv,char **env){



struct string *head;

head=create();


printf("\nprint\n");


print(head);






return 0;
}


void print(struct string *head){

	if(head==NULL){
		printf("\nlink is null");
	}else{
		struct string *tmp;
		tmp=head;
		while(tmp!=NULL){
			printf("%c\t",tmp->c);
			tmp=tmp->n;
		
		}
	
	}

}


struct string *create(){

struct string *head;
head=NULL;
struct string *p1,*p2;

p1=p2=(struct string *)malloc(sizeof(struct string));

if(p1!=NULL){

	printf("input char:\n");
	scanf("%c",&p1->c);
	p1->n=NULL;
}

while(p1->c!='\n'){

if(head==NULL){
	
	head=p1;
}else{
	
	p2->n=p1;
	
	

}

p2=p1;

p1=(struct string *)malloc(sizeof(struct string));

if(p1!=NULL){
	
	printf("input char:\n");
	scanf("%c",&p1->c);
	p1->n=NULL;

}




}







return head;


}

