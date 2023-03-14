#include <signal.h>
#include <stdlib.h>
#include <stdio.h>

void sig_usr(int);

int main(void)
{
signal(SIGUSR1,sig_usr);
signal(SIGUSR2,sig_usr);
for(;;)
pause();
}


void sig_usr(signo)
{
if(signo==SIGUSR1)
	printf("SIGUSR1\n");
	else if(signo==SIGUSR2)
		printf("SIGUSR2");
	else(segnale: %d\n\n",signo);

}

