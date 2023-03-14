#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>

int fib(int n)
{
	if(n==0) return 0;
	else if(n==1) return 1;
	else return (fib(n-1) + fib(n-2));
}

int fact(int n)
{
	if(n==0) return 1;
	else if(n==1) return 1;
	else return (n * fact(n-1));
}


void sig_handler1(int signo)
{
	char answer[2]={0};

	printf("Vuoi continuare o interrompere [y/n]?");
	scanf("%c",answer);

		if( *answer=='y' || *answer=='Y')
		{
			signal(SIGINT,sig_handler1);
		}
		else if(*answer=='n'||*answer=='N')
		{
			kill(getpid(),SIGKILL);
		}
		else
		{
		exit(-1);
		}
}

void sig_handler2(int signo)
{
	printf("SegnaleRicevuto\n");
}


int main(void)
{

	signal(SIGINT,SIG_IGN);
	int pid1=fork();
	
	if(pid1<0)
	{
	printf("Errore generazione figlio\n");
	}
	
	else if(pid1==0)
	{
	
		signal(SIGINT,sig_handler2);
		printf("Sono figlio pid1:%d con padre:%d \n",getpid(),getppid());
		int i=0;
		for(i=1;i<=500;i++)
		{
			printf("%d| fattoriale: %d \n",i,fact(i));
			sleep(1);
		}
	}
	else
	{
		int pid2=fork();
		
		if(pid2<0)
		{
		printf("Errore generazione figlio");
		exit(-1);
		}
	
		else if(pid2==0)
		{
		printf("Sono figlio pid2: %d \n",getpid());
		int i=0;
		
			signal(SIGINT,sig_handler1);
			for(i=1;i<=50;i++)
			{
			printf("%d|fattoriale: %d ",i,fact(i));
			sleep(1);
			}
		}
	
		else
		{
		signal(SIGINT,SIG_IGN);
		wait(NULL);
		wait(NULL);
		printf("Figlio pid1: %d e Figlio pid2: %d  sono terminati\n",pid1,pid2);
		exit(-1);
		}
	}
}
