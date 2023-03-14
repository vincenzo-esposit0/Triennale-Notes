#include <stdio.h>
#include <stdlib.h>

#include <unistd.h>
#include <sys/types.h>

int main(void){

	int pid;
	printf("Unico processo con PID:%d \n",getpid());
	pid=fork();
	if(pid==0){
	printf("Sono il figlio con PID : %d \n",getpid());
		}
	
else if(pid>0){

	printf("Sono il padre con pid %d con  figlio pid %d \n",getpid(),getppid());
		}
	else{
	printf("Si è verificato un errore nella chiamata fork\n");
		exit(1);

		}

		exit(0);
}