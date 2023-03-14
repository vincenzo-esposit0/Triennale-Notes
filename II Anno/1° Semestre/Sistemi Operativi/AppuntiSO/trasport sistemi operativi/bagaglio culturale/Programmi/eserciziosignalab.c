#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>



double fibonacci(int n){
	if(n == 0) return 0;
	else if(n ==1) return 1;
	else return (fibonacci(n-1)+fibonacci(n-2));
}



int main(void){

int pid1 = fork();

	if(pid1 < 0){
	printf("Errore nella chiamata FORK per pid1");
	exit(-1);
	}
	
	else if(pid1 == 0){
	printf("Sono figlio pi
	}



}
