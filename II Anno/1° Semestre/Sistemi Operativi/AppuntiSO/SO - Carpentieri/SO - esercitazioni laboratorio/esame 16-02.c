#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>

//rinominato nome funzione per non andare in conflitto
void SIG_USR1(int signo){
	
	printf("Ricevuto segnale SIGUSR1");


}

int main(void){


	signal(SIGINT, SIG_IGN);


	int pid=fork();
	
	if(pid<0){
		printf("Error");
		exit(-1);
	}

	else if(pid==0){
		
		signal(SIGINT,SIG_IGN);
		printf("pid figlio %d", getpid());
		int i=100;

		for(i=100;i<=500;i++){

			printf("%d\n", i);



		}


		kill(getppid(),SIGUSR1); // invia al padre il segnale SIGUSR1
		exit(0);
	}

	else{
			
			signal(SIGUSR1,SIG_USR1);//gestisce segnale SIGUSR1
			wait(NULL);
			signal(SIGINT,SIG_IGN);
			printf("figliO:%d terminato",pid);
			exit(0);
	}

}
