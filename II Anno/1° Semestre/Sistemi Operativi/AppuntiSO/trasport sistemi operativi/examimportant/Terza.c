#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>
#include <sys/types.h> 


int fact(int n);

int fact(int n)
{
if(n==0)
return 1;
else if(n==1)
return 1;
else return n * fact(n-1);
}


void sig_handler(int signo)
{
char answer[2]={0};
printf("Vuoi continuare o interrompere? : Q per interrompere e c per continuare\n");
scanf("%s",answer);
	if(*answer== 'c'||*answer== 'C')
	{
	signal(SIGINT,sig_handler);
	}
	else if (*answer=='q' || *answer=='Q')
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
	printf("\nRicevuto ctrl-c\n");
}



int main(void)
{
signal(SIGINT,SIG_IGN);
int pid=fork();
	
	if(pid<0)
	{
		printf("Errore generazione figlio");
		exit(-1);
	}
	
	else if(pid==0)
{
		signal(SIGINT,sig_handler2);
	int i=0;
		for(i=1;i<=500;i++)
		{
		printf("figlio: %d e padre %d \n",getpid(),getppid());
		sleep(1);
		}
	}

	else
	{
	int pid2=fork();
		if(pid2<0)
		{
		printf("errore chiamata fork per pid2\n");
		exit(-1);
		}
		
		else if(pid2 == 0)
		{
			
			signal(SIGINT,sig_handler);
			printf("sono secondo figlio\n");
			int i=0;
			for(i=1;i<=40;i++)
			{
			printf("%d\n",fact(i));
			sleep(1);
			}
			exit(0);
		}
		else
		{
		
		wait(NULL);//aspetta terminazione figlio
		wait(NULL);
		printf("I miei due figli sono terminati: pid %d e pid2: %d \n",pid,pid2);
		exit(-1);
		}
	}
}

