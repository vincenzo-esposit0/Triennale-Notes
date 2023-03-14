
/*	
	STUDENTE: Davide Senatore
	MATRICOLA 03703
*/





#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>




int main(void){

int pid=fork();
int pid2;//dichiarazione fuori dal secondo else if

if(pid<0){
printf("Errore generazione figlio\n");
exit(-1);//exit mancante
	}

else if(pid==0){

	printf("Sono figlio pid:%d \n",getpid());
	printf("Stampo numeri da 1 a 10:\n");
	int i;
	
	for(i=1;i<=500;i++){
	
	printf("N= %d \n",i);
	}//parentesi mancante
 
pid2=fork();

if(pid2<0){
	printf("errore");
	exit(-1);//exit mancante
	  }
else if(pid2==0){
	printf("\nSono figlio pid2= %d con padre %d\n\n",getpid(),getppid());
	execl("/bin/ls","ls -l",NULL);
	exit(0);
      		}
else{

	exit(-1);

    }

	else{
		wait(NULL);
		wait(NULL);
		printf("Sono padre e i miei due figli sono terminati\n");
		printf("Figlio pid:%d \n",pid);
		printf("Figlio pid2:%d \n",getpid());//getpid() al posto di pid2
		exit(-1); 
	    }
}
}



