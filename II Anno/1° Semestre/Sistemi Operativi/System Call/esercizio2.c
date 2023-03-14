#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>

int main()
{
	int pid1, pid2, i;
	int status;
	
	/*
		Creazione Primo Figlio
	*/

	pid1= fork();

	if(pid1<0)
	{
		printf("Errore nella prima fork\n");
	}

	else if(pid1==0)
	{
		/*
			Esecuzione Primo figlio
		*/
		
		printf("PRIMO FIGLIO \n");
		printf("Il pid del Primo Figlio e' %d \n", getpid());
		
		for(i=0;i<50;i++)
		{
			printf("%d ---", i+1);
		}
		
		printf("\nIl processo figlio 1 e' terminato \n");
		exit(0);
	}

	else if(pid1>0)
	{
		       pid2= fork();
		       

			if(pid2<0)
			{
				printf("Errore nella seconda fork\n");
			}

			else if(pid2==0)
			{
				printf("SECONDO FIGLIO \n");
				printf("Il pid del padre e' = %d \n", getppid());
				
				for(i=100;i<150;i++)
				{
					printf("%d ---", i+1);
				}
				
				printf("\nIl processo figlio 2 e' terminato \n");
				exit(0);
			}
			else
			{
				wait(&status);
			        wait(&status);
				printf("\nIl pid del Primo Figlio e' %d \n", pid1);
				printf("Il pid del Secondo Figlio e' %d \n", pid2);
			}
	}	 


return(0);

}
