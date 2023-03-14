#include <unistd.h>
#include <stdio.h>

void main(){
	int pid=fork();
	if (pid==0){
		printf("Sono il figlio :\n");
		printf("Il mio pid è: %d \n", getpid());
		printf("Il pid di papà è: %d \n", getppid());
	}
	else
		printf("Sono il padre con pid: %d \n",getpid());
}
