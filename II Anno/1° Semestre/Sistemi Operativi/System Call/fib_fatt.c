/*
Scrivere un funzione c che implementi la seguente funzione.
Un processo P crea due figli ed aspetta la terminazine di entrambi.
I due figli saranno in esecuzione concorrente.
Il primo figlio scriverà i primi 30 numeri di fib e poi terminerà. In presenza di un ctrl-c dovrà scrivere a schermo il proprio pid e continuare la sua esec.
Il secondo figlio scriverà i primi 30 fattoriali. In presenza di un ctrl-c dovrà chiedere all'utente se continuare oppure terminare.
Dopo la terminazione dei due figli, il padre stamperà: il pid dei due figli e la loro terminazione.
Poi terminerà.

*/

#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>
#include<signal.h>
#include<stdlib.h>

int fib(int n)
{
	if(n<=1) return n;
	else return (fib(n-1)+fib(n-2));
}

int fatt(int n)
{
	if(n==0) return 1;
	else return (n*fatt(n-1));
}

void cntrl_c_handler_pid1(int sig)
{
	
	printf("\nIl pid del primo figlio e': %d \n", getpid());

	signal(SIGINT, cntrl_c_handler_pid1);
}

void cntrl_c_handler(int sig)
{
	/*
		Riceve un segnale, a seconda della richiesta da input sceglierà l'operazione da eseguire
	*/

	char answer[512];
	
	printf("\n\n%s%d\n\n%s", "Segnale di interruzione ricevuto, segnale= ", sig, "Vuoi continuare (c) o uscire (q)?");
	scanf("%s", answer);

	if(*answer == 'c') signal(SIGINT, cntrl_c_handler);
	else (printf("Processo terminato \n\n"));
		exit(1);
}

int main()
{

int pid1, pid2, status;
int i;

/*

	Creazione Primo Figlio

*/

pid1=fork();

if(pid1<0) printf("Errore \n");

else if (pid1==0) {
			
			signal (SIGINT, cntrl_c_handler_pid1);	//In caso di ctrl-c il seguente figlio stamperà il proprio pid
			
			for(i=0;i<30; i++) 
			{
				printf("fib(%2d) = %d\n", i, fib(i));
				sleep(2);
			}
			exit(0);
		}
else if(pid1>0)
{

/*

	Creazione Secondo Figlio

*/

	signal (SIGINT, SIG_IGN);	//Ignora il ctrl-c che verrà utilizzato sul primo figlio
	
	pid2=fork();

	if(pid2<0) printf("Errore \n");
	
	else if(pid2==0) {

			signal (SIGINT, cntrl_c_handler);	//In caso di ctrl-c il seguente figlio chiederà se continuare la sua esecuzione oppure terminarla
			
			for(i=0;i<30; i++)
			{ 
				printf("fatt(%2d) = %d\n", i, fatt(i));
				sleep(2);
			}
			exit(0);
		}

	else if(pid2>0)
	{
	/*
		
		Processo Padre

	*/

			signal (SIGINT, SIG_IGN);	//Ignora il ctrl-c che verrà utilizzato sul secondo figlio
			
			wait(&status);
			wait(&status);
			printf("\nIl pid del Primo Figlio e' %d \n", pid1);
			printf("Il pid del Secondo Figlio e' %d \n", pid2);
	}

}

			
return(0);



}
