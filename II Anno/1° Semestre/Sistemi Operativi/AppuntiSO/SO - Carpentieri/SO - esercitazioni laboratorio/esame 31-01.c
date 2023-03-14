#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/signal.h>

int fatt(int n){
	if(n<0){
		return -1;	
	}
		
	if(n==0){
		return 1;
	}
		
	else{
		return n*fatt(n-1);
	}
}

void sig_handler(int signo){
	char risposta[2] = {0};
	scanf("%s", risposta);
	if(*risposta=='c'|| *risposta =='C')
		{signal(SIGINT,sig_handler);}

	else if(*risposta=='q' || *risposta=='Q'){

		exit(0);
	}
	
	else { 
		exit(0);
	}
}

int main(void){
	
	signal(SIGINT,SIG_IGN);
	int pid1 = fork();
	if (pid1<0) {

		printf("Errore chiamata fork");
		exit(-1);
	}

	else if (pid1 == 0){
		signal(SIGINT,SIG_IGN);
		int i=0;
		for(i=1;i<=140;i++){
			printf("\n%d",i);
			printf("\n%d", getpid());
		}
		exit(0);
	}

	else {
		int pid2 = fork();
		if (pid2<0){
			printf("Errore chiamata fork");
		}
		else if(pid2==0){

			signal(SIGINT,sig_handler);
			int i=0;
			for (i=1;i<=4;i++){
				printf("\n%d", fatt(i));
			}

			exit(0);
		}

		else{
			signal(SIGINT,SIG_IGN);
			wait (NULL);
			wait (NULL);
			printf("figlio 1 %d e figlio 2 %d terminati",pid1,pid2);

			exit(0);
	
		}

	}

	return 0;

}
