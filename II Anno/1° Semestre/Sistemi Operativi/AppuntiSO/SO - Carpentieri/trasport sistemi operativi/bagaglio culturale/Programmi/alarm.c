#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>


void nullfcn(){
printf("\nCiao\n");
}// non fa niente

void sleep2 (int secs)
{

if(signal(SIGALRM,nullfcn) == SIG_ERR)
	{
	printf("ERRORE DI SISTEMA\n");
	exit(1);
	}
alarm(secs);
pause();
}


int main()
{
printf("Sleep2 per 2 secondi\n\n");

sleep2(2);

printf("Sleep2 per 1 secondo\n\n");
sleep2(1);

printf("Sleep2 per 4 secondi\n\n");
sleep2(4);
}
