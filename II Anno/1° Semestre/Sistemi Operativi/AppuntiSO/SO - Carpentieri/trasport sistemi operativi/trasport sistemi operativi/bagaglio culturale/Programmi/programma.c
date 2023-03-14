#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void main(int argc,char *argv[]){
	int value;
value=fork();
if(value<0){
printf("errore system call");
}else{
printf("In main alue ==%d\n",value);
}

}