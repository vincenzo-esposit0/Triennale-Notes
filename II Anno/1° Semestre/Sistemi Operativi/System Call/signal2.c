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
	char answer[512];
	int pid=fork(), status;
	if(pid<0)
                printf("Errore nella fork\n");
	else if(pid==0)
	{
		printf("Continuare l'esecuzione o terminare? (c) or (q)\n");
		scanf("%s",answer);
		if(*answer=='c') signal(SIGINT,cntrl_c_handler);
		else
		{
			printf("Terminazione di entrambi i processi");
			exit(1);
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
	int pid, status;
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
		wait(&status);
		printf("\nIl pid del figlio e': %d\n",getpid());
		exit(1);
	}

}
