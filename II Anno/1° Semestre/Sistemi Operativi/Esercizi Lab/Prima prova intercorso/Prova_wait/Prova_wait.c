#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

int main(){
	int pid1,pid2,pid3,status;
	
	pid1=fork();
	if(pid1==0) sleep(1); /*li usiamo per cercare di sincronizzare i processi*/
	else{
		pid2=fork();
		if(pid2==0) sleep(3);
		else{
			pid3= fork();
			if(pid3==0) sleep(2);
			else{
				printf("Termina il figlio con PID: %d\n", wait(&status)); 
				printf("Termina il figlio con PID: %d\n", wait(&status)); 
				printf("Termina il figlio con PID: %d\n", wait(&status)); 
			}
		}
	}
}
