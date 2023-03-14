/* Scrivere un programma C che implementi la seguente situazione
   un processo P crea due figli ed aspetta la terminazione di entrambi.
   I due figli saranno in esecuzione concorrente
   Il primo figlio scrivera' i primi 30 numeri di Fibonacci e poi terminera
   in presenza di un CTRL-C immesso da tastiera dovra' scrivere a schermo il pid
   e continuare la sua esecuzione.
   Il secondo figlio scrivera i primi 30 fattoriali ed in presenza di un CTRL-C immesso
   da tastiera dovra richiedere all'utente se deve continuare la sua esecuzone o terminare
   (e regolarsi di conseguenza)
   dopo la terminzaione dei due figli il padre P stampera sullo schermo un messaggio
   indicando il pid dei due figli ed il fatto che sono teminati e poi termininera'
*/

#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

void mull(int sd){}

int fatt(int n){
  if(n==0)
    return 1;
  return n*fatt(n-1);
}
void handler_1 (int sig){
  printf("Ricevuto segnale : %d, il mio pid e' %d",sig,getpid());

}
void handler_2 (int sig){
  char answer [512];

  printf("\n\n%s%d\n\n %s","Ricevuto segnale di interruzione, segnale =",sig,"vuoi continuare (c) o ucire (q) = " );
  scanf("%s",answer);

  if(*answer == 'c')
    signal(SIGINT, handler_2);
  else{
    printf("processo terminato dall'utente \n\n");
    exit(1);
  }

}
int fib (int n){

  if(n<=1) return (n);
  return (fib(n-1) + fib(n-2));

}
int main(void){

  int pid,pid2,status;

  pid = fork();

  if(pid<0){
    printf("ERRORE\n");
    exit(1);
  }
  if(pid==0){ //figlio uno
    if(signal(SIGINT,handler_1) == SIG_ERR){
      printf("ERRORE ASSEGNAZIONE SIGUSR1\n");
      exit(1);
    }
    for(int i=0;i<30;i++)
      printf("fib (%d) : %d\n",i,fib(i));

  }
  else{ //padre

    pid2 = fork();

    if(pid2<0){
      printf("ERRORE\n");
      exit(1);
    }
    if(pid2==0){ //figlio due
      if(signal(SIGINT,handler_2) == SIG_ERR){
        printf("ERRORE ASSEGNAZIONE SIGUSR1\n");
        exit(1);
      }
      for(int i=0;i<45;i++){
        printf("fatt (%d) : %d\n",i,fatt(i));
        sleep(1);
      }

    }
    else{ //padre
      if(signal(SIGINT,mull) == SIG_ERR){
        printf("ERRORE ASSEGNAZIONE SIGUSR1\n");
        exit(1);
      }
      printf("Io sono il padre di %d %d e il mio PID e' %d\n",pid,pid2,getpid());

      //printf("processo %d terminato con status %d\n",wait(&status),status);
      printf("processo %d terminato con status %d\n",waitpid(pid,&status,0),status);

      //printf("processo %d terminato con status %d\n",wait(&status),status);
      printf("processo %d terminato con status %d\n",waitpid(pid2,&status,0),status);
    }
  }
}
