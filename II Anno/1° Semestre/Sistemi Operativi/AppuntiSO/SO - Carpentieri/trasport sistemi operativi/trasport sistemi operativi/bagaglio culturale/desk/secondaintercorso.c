#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>



int main()
{	//apertura main

int pid1;
int pid2;
int i;

pid1=fork();

	if(pid1<0)
	{
	printf("Errore durante la chiamata fork\n");
	}
	else if(pid1 == 0)
	{
	signal(SIGINT,SIG_ING);
	printf("\nSono figlio pid1:%d\n",getpid());
		for(i=1;i<=50;i++)
		{
		printf("\nNumero:%d\n",i);
		}
	exit(0);
	}
	else
	{
	pid2=fork();
	
		if(pid2 < 0)
		{
		printf("Errore nella chiamata fork");
		exit(1);
		}
		
		else if(pid2 == 0)
		{
		printf("Sono figlio pid2 e stampo il mio processo padre:%d\n",getppid());
		execl("/bin","ls",NULL);
		exit(0);
		}
		
		else
		{
		wait(NULL);
		wait(NULL);
		printf("\nProcesso pid1:%d \t processo pid2:%d  terminati\n",pid1,pid2);
		
		}
	
	}


}//chiusura main
