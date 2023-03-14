/* necessari per fork() */
#include <sys/types.h>
#include <unistd.h>
/* necessario per printf() */
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>


int main(void){
pid_t pid=fork();
int *result;

if(pid==0){

	printf("\n Sono il figlio %d", getpid());
	exit(127);
}
else if(pid>0){
	waitpid(pid,result,0); 
	printf("sono il padre ho terminato");

}
else{
	printf("Errore 1. Figlio non generato!");
	exit(-1);
}

}
