#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>


int fact(int n)
{
if(n == 0) return 0;
else if(n == 1)return 1;
else return (n* fact(n-1));
}

void sig_handler2(int signo)
{
int pid3 = fork();//aggiunta
if(pid3<0)//aggiunta
{//aggiunta
printf("Errore generazione figlio");//aggiunta
}//aggiunta
else if(pid3 == 0)//aggiunta
{//aggiunta
execl("/bin/ps","/bin/ps",NULL);//modificato la exec
exit(1);//aggiunta
}
}


void sig_handler(int signo)
{
printf("Ricevuto ctrl-c");
}


int main(void)
{
int pid1= fork();

if(pid1<0)
{
printf("Errore generazione figlio");
}
else if(pid1 == 0)
{
signal(SIGINT,sig_handler);
int i=0;

for(i=1;i<=500;i++)
{
printf("%d e %d\n",getpid(),getppid());
sleep(1);
}
}
else
{
signal(SIGINT,SIG_IGN);//aggiunta
int pid2 = fork();

if(pid2 < 0)
{
printf("error");
}
	else if(pid2 == 0)
	{
	signal(SIGINT,sig_handler2);
	int j= 0;

	for(j=1; j<=40;j++)
	{
	printf("%d\n",fact(j));
	sleep(1);
	}
	}
else
{
signal(SIGINT,SIG_IGN);//aggiunta
wait(NULL);
wait(NULL);
printf("%d %d è terminato",pid1,pid2);
}
}
}

/* Secondo figlio interfogliato, come era in origine (guardare la sezione di codice cancellata),
 aggiunta del terzo figlio nella signal per eseguire la exec, inserito le SIG_IGN nel padre.*/
