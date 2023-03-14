/* Un processo P crea due figli ed'aspetta la terminazione di entrambi.
il primo figlio stampa sullo schermo un messaggio indicando il proprio pid ed il pid di P poi termina.
il secondo figlio stampa sullo schermo la somma del proprio pid più il pid del padre e poi termina.
Dopo la terminazione dei due figli P stampa sullo schermo un messaggio idicando il pid dei due figli ed il fatto che sono terminati e poi termina.*/

#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>

void main(){
	int pid1,pid2,status;
	pid1=fork();
	if (pid1==0){
		printf("Sono il primo filgio il mio pid é: %d\n",getpid());
		printf("Sono il primo figlio il pid di mio padre è: %d\n", getppid());
	}
	else{
		pid2=fork();
		if (pid2==0){
			printf("Sono il secondo figlio, il mio pid è %d, il pid di mio padre è %d, la somma di questi due pid è: %d \n",getpid(),getppid(),getpid()+getppid());
		}
		else{
			printf("Il figlio con pid %d ha terminato\n", wait(&status));
			printf("Il figlio con pid %d ha terminato\n", wait(&status));
		}
	}
}



