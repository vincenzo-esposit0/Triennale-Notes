#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>

int main(void)
{
	int pid=fork();

	if(pid<0){
	return -1;
	}
	
	else if (pid==0) {
		printf("Sono il figlio : %d, mio padre è %d", getpid(), getppid());
		return 0;
	}
	
	{
	int pid2=fork();
		if(pid2<0){
		printf("Error");
		return -1;
		}

	else if (pid2==0) {
		int diff = getpid() - getppid();
		printf("sono il secondo figlio, la differenza tra il mio pid e quello di mio padre e' %d", diff);
		}
	else
		{
		wait(NULL);
		wait(NULL);
		printf("sono il padre. sono terminati i miei due figli : pid %d /n/n e pid2 %d /n/n", pid, pid2); return 1; 
	     }
	}
} 
