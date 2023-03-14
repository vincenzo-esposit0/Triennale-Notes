#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>


int main(){

	int pid1;
	pid1=fork();

if(pid1<0){
	printf("Erroreeee");
	  }
else if(pid1==0){
	printf("Sono processo figlio con pid: %d e processo padre :%d",getpid(),getppid());
	
	exit(0);		
}
   else{
	wait(NULL);	
		int somma;
printf("\nUna prova\t:%d\n",pid1);
	somma=getpid()+pid1;
printf("\nSono processo padre con pid %d\n",getpid());
	printf("La somma di padre + figlio è:%d",somma);
exit(-1);
    	}

}








