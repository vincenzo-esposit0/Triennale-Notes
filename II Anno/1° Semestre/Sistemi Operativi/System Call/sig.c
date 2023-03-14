#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>

void sig_usr (int signo)
{
	if(signo == SIGUSR1) printf("Ricevuto SIGUSR1 \n\n");
	else if(signo == SIGUSR2) printf("Ricevuto SIGUSR2 \n\n");
}

int main()
{
	if(signal(SIGUSR1, sig_usr) == SIG_ERR)
	{
		printf("Errore di sistema: SIGUSR1 \n");
		exit(-1);
	}

	if(signal(SIGUSR2, sig_usr) == SIG_ERR)
	{
		printf("Errore di sistema: SIGUSR2 \n");
		exit(-1);
	}

	while(-1);

}
