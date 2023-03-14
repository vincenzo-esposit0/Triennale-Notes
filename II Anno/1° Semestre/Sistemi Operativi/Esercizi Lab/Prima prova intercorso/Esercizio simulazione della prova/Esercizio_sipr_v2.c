#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

int main(){
	int pid1,pid2,status;
	pid1=fork();
	if(pid1==0) {
		printf("Sono il primo figlio con pid: %d \n",getpid());
		for (int i=0;i<50;i++){
			printf("Figlio 1 dice: %d \n",i);
		}
	}else{
		pid2=fork();
		if(pid2==0) {
			printf("Sono il secondo figlio con pid %d mio padre è: %d \n",getpid(),getppid());
			for (int i=100;i<150;i++){
				printf("Figlio 2 dice: %d \n",i);
			}
		}else{
			printf("Termina il figlio con PID: %d\n", waitpid(pid1,&status,0)); 
			printf("Termina il figlio con PID: %d\n", waitpid(pid2,&status,0)); 
		}
	}
}
