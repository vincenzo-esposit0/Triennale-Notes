#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>


int main(){

int pid;
pid=fork();

printf("Pid corrente: %d \n",getpid());

if(pid==0){
	printf("Sono il figlio con pid %d e padre %d\n",getpid(),getppid());
	exit(0);
}
else if(pid>0){
	
	int pid2=fork();
	if(pid2==0){
	int somma=getpid()+getppid();
	printf("Sono il figlio con pid2 %d\n",getpid());
	printf("Somma pid2 piu pid padre: %d\n",somma);	
	exit(0);	
	}

	else if (pid2>0){
	wait(NULL);
	wait(NULL);
	printf("I due filgi pid e pid 2 %d %d",pid,pid2);
	}
	else{
	exit(-1);
	}
}
	else{
exit(-1);
}


}
