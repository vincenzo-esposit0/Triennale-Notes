/*
	STUDENTE:  Davide Senatore
	MATRICOLA: 03703 
*/
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>



int main(){


int pid=fork();
if(pid<0){
	printf("Errore generazione figlio\n");
	exit(-1);
}
else if(pid==0){
printf("\nSono il figlio con pid: %d",getpid());
int i;
	printf("\n");
	for(i=1;i<=500;i++){
	printf("n:%d\n",i);
	}//dimenticato di chiudere questa parentesi

 	
}

else{
	int pid2=fork();
	if(pid2<0){
	printf("Errore");
	exit(-1);	
	}

	else if(pid2==0){
	printf("Sono pid2: %d con padre:%d\n",getpid(),getppid());
	execl("/bin/ls","ls -l",NULL);
	exit(0);	
	}
	else{
	wait(NULL);
	wait(NULL);
	printf("\nI miei due figli sono terminati\n");
	printf("\nfiglio pid: %d\n",pid);
	printf("\nfiglio pid2:%d\n",pid2);
	exit(0);
	}


}


}


/*Le modifiche apportate a questo programma sono:

-Dimenticato di chiudere una parentesi al for che genera i numeri da 1 a 500.

-Ho generato il pid2 nel padre di pid, poichè nel programma senza apportare modifiche il padre di pid non riusciva a trovare il pid2,
quindi è stato sufficiente invertire l'ordine,ovvero in termini atecnici, prendere il pezzo di codie che parte da "int pid2=fork()" fino alla exit 
che si trova dopo la exec, e spostarla nell' "else di pid.Poi il blocco di codice dell'else finale, spostarlo nell'else di pid2.

-Dimenticato le exit nel caso in cui pid e pid2<0
*/