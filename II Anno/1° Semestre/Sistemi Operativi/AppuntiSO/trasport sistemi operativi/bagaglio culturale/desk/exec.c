//necessari per fork
#include <sys/types.h>
#include <unistd.h>
//necessari per printf
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>

int main(void){

int pid;
pid=fork();
if(pid==0){
	printf("\nSono il figlio con pid %d e mio padre %d \n",getpid(),getppid());
	execl("/bin/ls","-l",NULL);
	exit(0);	
	}

else if(pid>0){
	int pid2=fork();
	if(pid2==0){
printf("\n\nSono il figlio con pid2: %d",getpid());
	int somma=getpid()+getppid();
	printf("\n\nLa somma pid2 figlio + pid2 padre = %d \n",somma);
	exit(0);
	      }
else if(pid2>0){
	wait(NULL);
	wait(NULL);
	printf("\n\nQuesti sono i miei due figli :  PID --> %d  e PID2 --> %d\n\n",pid,pid2);
	printf("\n\nI miei due figli sono terminati\n");
	exit(0);
	       }
else{
	printf("Errore 2");
	exit(-1);
}
	exit(0);
	}
else{
	printf("Errore");
	exit(-1);

}

}