/* necessari per fork() */
#include <sys/types.h>
#include <unistd.h>
/* necessario per printf() */
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>


int main(void){

	int pid=fork();
	int i=0;
	if(pid==0){
		printf("\nSono il figlio. Questo è il mio pid: %d\n", getpid());
		
		for(i=1;i<=50;i++){
			printf("\n:%d", i);		
		}
		exit(0);	
	}
	else if(pid>0){
		int pid2=fork();
		if(pid2==0){
			printf("Sono il secondo figlio. Questo è mio padre: %d", getppid());
			for(i=101;i<=150;i++){
				printf("\n%d", i);			
			}
			exit(0);
		}
		else if(pid2>0){
			wait(NULL);
			wait(NULL);
			printf("Questi sono i miedi figli: %d, %d", pid, pid2);
			exit(0);
		}
		else{
			printf("errore generazione figlio 2");	
		}
	}
	else{
		printf("errore generazione figlio");
	}





}