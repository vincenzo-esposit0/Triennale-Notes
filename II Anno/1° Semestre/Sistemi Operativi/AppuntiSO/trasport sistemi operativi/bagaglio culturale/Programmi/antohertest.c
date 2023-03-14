#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int fact(int n)
{
	if(n==0)
	return 1;
	else if(n==1)
	return 1;
	else 
	return n * fact(n-1);
}


void sig_handler(int signo)
{
	printf("Segnale ricevuto");
}

void sig_handler2(int signo)
{

char answer[2]={0};
	printf("vuoi continuare ( c ) o uscire ( q ) ?\n");
	if(*answer== 'c' || *answer == 'C')
	{
		signal(SIGINT,SIG_IGN);
	}
	else if(*answer == 'q' || *answer == 'Q')
	{
		kill(getpid(),SIGKILL);
	}
	else
	{
		exit(0);
	}
}

int main(void)
{

signal(SIGINT,SIG_IGN);

int pid= fork();


	if(pid<0)
	{
		printf("Erroe chiamata fork");
		exit(0);
	}
	
	else if(pid == 0)
	{
	signal(SIGINT,SIG_IGN);
	
	int i;
		for(i=0;i<=500;i++)
		{
			printf("|%d|fact: %d",i,fact(i));
		sleep(1);
		}
	}
	else
	{
		int pid2=fork();
		if(pid2<0)
		{
			printf("Errore chiamata fork");
			exit(0);
		}
		else if(pid2==0)
		{
			printf("sono figlio pid2 : %d e stampo il mio pid 400 volte\n",getpid());
			int z;
			for(z=0;z<500;z++)
			{
				printf("pid: %d\n",getpid());
				sleep(1);
			}
			
		}
		else
		{
			wait(NULL);
			wait(NULL);
			printf("sono padre e i miei due figli sono terminati");
			printf("\n pid1: %d e pid2: %d\n",pid,pid2);
		}
	}

}
