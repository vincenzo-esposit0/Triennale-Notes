#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>

/*
 *
pid_t wait(int*statloc);

Chiamata da un processo padre ottiene in statloc lo stato di terminazione di un figlio.
Restituisce Pid se ok;
Restituisce -1 in caso di errore.

Prende un puntatore statloc perche' modifica il valore della variabile e ci mettera' lo stato del filgio

*/

int main()
{
	int pid1, pid2, pid3, status;

	pid1=fork();

	if(pid1==0)
		sleep(1);
	else
	{
		pid2=fork();
		
		if(pid2==0)
			sleep(3);
		else
		{
			pid3= fork();

			if(pid3==0)
				sleep(2);
			else
			{
				printf("Termina il figlio con pid %d \n ", wait(&status));
				printf("Termina il figlio con pif %d \n ", wait(&status));
				printf("Termina il figlio con pid %d \n ", wait(&status));
	
		}
	}

	return(0);
}

