#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>
#include<signal.h>
#include<stdlib.h>

int fib(int n)
{
	if(n<=1) return n;
	else return (fib(n-1)+fib(n-2));
}

void cntrl_c_handler(int sign)
{
	signal(SIGINT,SIG_IGN); //Nel caso in cui l'utente prema può vuolte il CTRL_C, ignora i prossimi
	char answer[512];
	int pid=fork(), status;
	if(pid<0)
                printf("Errore nella fork\n");
	else if(pid==0)
	{
		printf("Continuare l'esecuzione o terminare? (c) or (q)\n");
		scanf("%s",answer);
		if(*answer=='c') exit(0);
		else
		{
			kill(getppid(),SIGKILL); //Uccido il padre
			raise(SIGKILL); //Mi autouccido (Va bene anche aboart)
		}
	}
	else if(pid>0)
	{
		wait(&status);
		signal(SIGINT, SIG_IGN);
		exit(1);
	}


}

int main()
{
	int pid;
	pid=fork();

	if(pid<0)
		printf("Errore nella fork\n");
	else if(pid==0)
	{
		signal(SIGINT,cntrl_c_handler);
		for(int i=0;i<40;i++)
		{
			printf("fib(%2d) = %d \n",i,fib(i));
			sleep(1);
		}
		exit(1);
	}
	else if(pid>0)
	{
		signal (SIGINT, SIG_IGN);
		wait(NULL);
		printf("\nIl pid del figlio e': %d\n",getpid());
		exit(1);
	}

}
