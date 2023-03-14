#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>




void sig_handler(int signo){

	if(signo == SIGINT)
	{
	printf("Segnale di interruzione ricevuto");
	}

}




int main(void)
{


	if(signal(SIGINT,sig_handler)== SIG_ERR)
	{
	printf("\nNon posso prendere Segnale\n");
	
	}

	while(1)
	sleep(1);
	return 0;

}
