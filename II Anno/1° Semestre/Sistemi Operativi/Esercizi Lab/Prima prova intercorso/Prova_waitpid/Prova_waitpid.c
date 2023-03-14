#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

int main(){
	int pid1,pid2,pid3,status;
	
	pid1=fork();
	if(pid1==0) ; /*li usiamo per cercare di sincronizzare i processi*/
	else{
		pid2=fork();
		if(pid2==0) ;
		else{
			pid3= fork();
			if(pid3==0) ;
			else{
				printf("Termina il figlio con PID: %d\n", waitpid(pid3,&status,0)); 
				printf("Termina il figlio con PID: %d\n", waitpid(pid1,&status,0)); 
				printf("Termina il figlio con PID: %d\n", waitpid(pid2,&status,0)); 
			}
		}
	}
}
