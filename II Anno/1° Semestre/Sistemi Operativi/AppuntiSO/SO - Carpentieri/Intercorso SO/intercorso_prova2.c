#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<signal.h>


void sig1 (int s)
{
	printf("\nRicevuto segnale di interruzione\n");

	int value2=fork();
	
	if (value2==0)
	{
		printf("File nella directory sono : \n");
		execl("/bin/ls","ls","-l",NULL);
	}
}

int main(void)
{
	pid_t value1;
	value1 = fork();
	
	if(value1<0)
	{
		printf("Errore nella system call!!\n");
		exit(0);
	}


	if(value1==0)
	{
		printf("\n Processo figlio 1\n");
		signal(SIGINT,sig1);
		sleep(3);

		for (int i = 1;i<=500; i++)
		{
			printf("\nIl mio pid è %d, il pid di mio padre è %d\n", getpid(), getppid());
		}
	}
	else
	{
		signal(SIGINT, SIG_IGN);
		waitpid(value1,NULL,0);
		
		printf("\n Processo padre \n");
		printf("Il mio pid è %d \n", value1);
	}

	return(0);
}





