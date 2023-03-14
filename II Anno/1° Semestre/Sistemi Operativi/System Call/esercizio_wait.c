#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>

int main()
{
	int pid1, pid2, somma_pid;
	int status;
	
	/*
		Creazione Primo Figlio
	*/

	pid1= fork();

	if(pid1<0)
	{
		printf("Errore prima fork\n");
	}
	else if(pid1==0)
	{
		printf("PRIMO FIGLIO \n");
		printf("Il pid del Primo Figlio e' %d \n", getpid());
		printf("Il pid del padre e'%d \n", getppid());
		printf("Il processo figlio 1 e' terminato %d \n", wait(&status));
	}
	else if(pid1>0)
	{
		/*
			Creazione Secondo Figlio
		*/

		pid2=fork();
		
		if(pid2<0)
		{
			printf("Errore \n");
		}
		else if(pid2==0)
		{
			printf("SECONDO FIGLIO \n");
			printf("Il pid del Secondo Figlio e' = %d \n", getpid());
			printf("Il pid del padre e' = %d \n", getppid());
			somma_pid= getpid()+getppid();
			printf("La somma dei pid e' = %d \n", somma_pid);
			printf("Il processo figlio e' terminato %d \n", wait(&status));
		 }
		else 
		{
			wait(&status);
			wait(&status);

			printf("Il pid del Primo Figlio e' %d \n", pid1);
			printf("Il pid del Secondo Figlio e' %d \n", pid2);
		}
}

return(0);

}
