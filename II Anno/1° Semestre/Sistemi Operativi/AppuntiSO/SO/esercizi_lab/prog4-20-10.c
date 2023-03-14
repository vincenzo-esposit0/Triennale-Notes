/* necessari per fork() */
#include <sys/types.h>
#include <unistd.h>
/* necessario per printf() */
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>

int main(void){

int pid;

pid=fork();


if(pid==0){
	printf("\nsono il figlio, PID: %d e mio padre PID: %d\n", getpid(), getppid());
	execl("/bin/ls","-l", NULL);
	exit(0);
}
else if(pid>0){
	int pid2=fork();
	if(pid2==0){
	printf("\nSono il figlio con PID2: %d \n", getpid());		
		int somma=getpid()+getppid();
		printf("\nSomma pid2 figlio + pid2 padre: %d\n", somma);
		exit(0);
	
	}
	else if(pid2>0){
		wait(NULL);
		wait(NULL);
		printf("\n\n Questi sono i miedi due figli:PID: %d, PID2: %d", pid, pid2);		
		printf("\nI miei due figli sono terminati\n");	
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
