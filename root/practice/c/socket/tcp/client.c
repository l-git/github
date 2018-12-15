#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <string.h>
#include <arpa/inet.h>

int main(int argc,char **argv,char **env){

if(argc<2){

printf("input ip and port:\n");
return -1;

}

char ipStr[30];

int port;

if(argc>1){

strcpy(ipStr,argv[1]);

}

if(argc>2){

port=atoi(argv[2]);

}





struct sockaddr_in sin;

int socketfd;
socketfd=socket(AF_INET,SOCK_STREAM,0);

if(socketfd<0){

perror("socket fail\n");
exit(EXIT_FAILURE);

}


sin.sin_family=AF_INET;
sin.sin_addr.s_addr=inet_addr(ipStr);

sin.sin_port=htons(port);



if(connect(socketfd,(struct sockaddr *)&sin,sizeof(sin))<0){

perror("connect error\n");
exit(EXIT_FAILURE);


}


puts("connected\n");


char *msg;
msg="GET / HTTP/1.1\r\n\r\n";

if(send(socketfd,msg,strlen(msg),0)<0){

perror("send error\n");
exit(EXIT_FAILURE);


}


puts("send success\n");

char buf[3000];

if(recv(socketfd,buf,sizeof(buf),0)<0){

perror("recv error\n");
exit(EXIT_FAILURE);


}

puts("receive:\n");

puts(buf);



close(socketfd);






























return 0;

}




