
/*

Scrivere una funzione C che implementi la seguente situazione:

Un processo P crea due figli ed aspetta la terminzione di entrambi.

I due figli saranno in esecuzione concorrente.

Il pirmo figlio scriverà i primi 30 numeri di Fibonacci e poi terminerà. In presenza di un CRTRL + c, immesso da
tastiera  dovrà scrivere a schermo il proprio pid e continuare sua esecuzione.

Il secondo figlio scriverà i primi 30 fattoriali ed in presenza di un Ctrl + c, immesso da tastiera socrà chiedere
all'utente se deve continuare la sua esecuzione o terminare. 

Dopo la terminazione dei due figli il padre F stamperà sullo schermo un messaggio indicando il pid dei due figli ed 
il fatto che sono terminati e poi terminerà.

*/
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>


double fibonacci(int n){
	if(n == 0) return 0;
	else if(n ==1) return 1;
	else return (fibonacci(n-1)+fibonacci(n-2));
}

double fattoriale(int n){
	if(n == 0 || n ==1) return 1;
	else if(n>1) return n*fattoriale(n-1);
	else return -1;
}

void cntl_c_handler_first(int sig){
	printf("\nPRIMO FIGLIO: ricezione di un'interruzione segnale = %d ",sig);
	printf("\nPRIMO FIGLIO: Mio pid= %d ",getpid());
}


void cntl_c_handler_second(int sig){

char answer[512];

printf("\nSECONDO FIGLIO:ricezione di un interruzione segnale= %d",sig);
	
printf("\nSECONDO FIGLIO: per uscire (q) per continuare (c): ");
	scanf("%s",answer);

if(*answer == 'c') signal(SIGINT,cntl_c_handler_second);

else{
	printf("SECONDO FIGLIO:richiesta di terminazione,processo terminato");
	exit(0);
	}
}




int main(void)
{



int i,pid1,pid2;
printf("Segnale di interruzione= %d\n\n",SIGINT);
pid1=fork();

		if(pid1 < 0){
			printf("Errore durante la chiamata di fork");
			exit(-1);
		}

	else if(pid1 == 0){  //processo figlio
	signal(SIGINT, cntl_c_handler_first);
	for(i = 0; i < 30;i++)
		printf("PRIMO FIGLIO: fib(%d) =\t %f\n",i,fibonacci(i));

	exit(0);
					} //fine processo figlio

		
		else{	//processo padre
			
			pid2=fork();
			if(pid2 < 0){
			printf("Errore nella chiamata di fork");
			exit(-1);
			}
								else if(pid2 == 0){ //secondo processo figlio
								signal(SIGINT,cntl_c_handler_second);
								for(i=0;i < 30;i ++)
								{
									printf("SECONDO FIGLIO: fattoriale (%d) = %.11f\n",i,fattoriale(i));
									sleep(2);			  
								}
									exit(0);
												  }
			
					
					else{	//processo padre
					signal(SIGINT,SIG_IGN);
					wait(NULL);
					wait(NULL);
					printf("nPADRE: Processi figli terminati pid1=%d, pid2=%d\n",pid1,pid2);
						}

}
exit(0);



}//chiusura main
