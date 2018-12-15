#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <arpa/inet.h>

#include <pthread.h>


//https://www.binarytides.com/socket-programming-c-linux-tutorial/


//gcc -lpthread server.c



void *connection_handler(void *);

int main(int argc,char **argv,char **env){


int socketfd;

socketfd=socket(AF_INET,SOCK_STREAM,0);

if(socketfd<0){

perror("socket error\n");
exit(EXIT_FAILURE);

}


struct sockaddr_in server;

struct sockaddr_in client;


server.sin_family=AF_INET;
server.sin_addr.s_addr=INADDR_ANY;
server.sin_port=htons(8080);

if(bind(socketfd,(struct sockaddr *)&server,sizeof(server))<0){

perror("bind error\n");
return -1;

}

puts("bind ok\n");


listen(socketfd,3);


puts("waiting for connection.....\n");


int new_socket;
while((new_socket=accept(socketfd,(struct sockaddr *)&client,(socklen_t *)&client))){

puts("connection accept\n");

char *msg;
msg="hello client\n";


//write(new_socket,msg,strlen(msg));
//
//
//
//
//


pthread_t sniffer_thread;
int *new_sock;
new_sock=malloc(sizeof(new_sock)*1);
*new_sock=new_socket;

if(pthread_create(&sniffer_thread,NULL,connection_handler,(void *)new_sock)<0){

perror("could not create thread\n");
return 1;


}


puts("handler assigned\n");







//puts("write success\n");

}

if(new_socket<0){

perror("accept failed\n");
return 1;

}

return 0;

}



void *connection_handler(void *socketfd){


int sockfd=*(int *)socketfd;

char *msg;
msg="i am connection handler\n";

write(sockfd,msg,strlen(msg));

msg="type something i will repeat what you type:\n";

write(sockfd,msg,strlen(msg));

int read_size;

char client_message[2000];

while((read_size=recv(sockfd,client_message,sizeof(client_message),0))>0){

write(sockfd,client_message,strlen(client_message));

}

if(read_size ==0){

puts("client disconnect\n");
fflush(stdout);
}else if(read_size==-1){

perror("recv error\n");

}


free(socketfd);


return 0;











}




