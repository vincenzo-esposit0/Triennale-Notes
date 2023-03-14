#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>



int fact(n);
int fib(n);

int main(){
int n;
int pid=fork();

if(pid<0){

printf("\n\nErrore generazione figlio\n\n");
exit(-1);
}
else if(pid==0){
printf("\n\nSono il figlio pid e scrivo i primi 30 numeri di fibonacci\n\n");

}

}




int fact(n){
if(n<0){
printf("Errore, fattoriale non definito per numeri inferiori a 0\n\n");
return -1;
}
if(n==0){
return n*fattoriale(n-1);
}
}

int fib(n){
n=30;
if(n<=1)
return(n);
else return(fib(n-1) + fib(n-2));
}




