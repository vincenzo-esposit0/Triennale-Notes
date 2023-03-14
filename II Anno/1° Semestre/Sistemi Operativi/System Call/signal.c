#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>
#include<signal.h>
#include<stdlib.h>

/*
Il segnale è un evento asincrono: esso può arrivare in un momento qualunque ad un processo 

La funzione prende due argomenti: 
-il nome del segnale signo
-il puntatore alla funzione funz da eseguire come azione da associare all'arrivo della signo

Sintassi:

#include<signal.h>

void(*signal(int signo, void (*func)(int)))(int);


System Call: kill
Essa manda un segnale ad un processo o ad un gruppo di processi specificato da pid

int kill(pid_t pid, int signo);

System call: raise
Essa consente ad un processo di mandare un messaggio

int raise(int signo)


*/

int fib(int n)
{
	if(n<=1) return n;
	else return (fib(n-1)+fib(n-2));
}

void cntrl_c_handler(int sig)
{
	char answer[512];
	
	printf("\n\n%s%d\n\n%s", "Segnale di interruzione ricevuto, segnale= ", sig, "Vuoi continuare (c) o uscire (q)?");
	scanf("%s", answer);

	if(*answer == 'c') signal(SIGINT, cntrl_c_handler);
	else (printf("Processo terminato \n\n"));
		exit(1);
}

int main()
{
int i;

printf("Il segnale SIGINT equivale a %d \n\n", SIGINT);
signal (SIGINT, cntrl_c_handler);

for(i=0;i<40; i++) 
printf("fib(%2d) = %d\n", i, fib(i));

}
