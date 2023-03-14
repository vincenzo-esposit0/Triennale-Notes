#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int fib (int n){
	if (n<=1) return n;
	else return (fib(n-1)+fib(n-2));
	
}
int fact(int n)
{
	if(n==0) return 1;
	else if(n==1) return 1;
	else return (n * fact(n-1));
}

main(){
	int p,p1;
	
	p=fork()
	
	if(p<0){ printf ("errore");}
	
	else if (p==0){
		signal (SIGINT, SIG_IGN);
		printf(" Sono il primo figlio, il mio pid: %d", getpid());
		for (int i=0;i<50;i++){
			printf("numeri fattoriali di %d = %d",i,fact(i));
		}
	}
	
	else {
		p1=fork();
		if (p1<0){printf("Errore");}
		
		else if(p1==0){
			signal (SIGINT, SIG_IGN);
			printf("Sono il secondo figlio,pid di mio padre: %d",getppid());
				for (int i=0;i<50;i++){
			printf("numeri fattoriali di %d = %d",i,fib(i));
		}
		}
		else {
			wait(NULL);
			wait(NULL);
			printf("Sono il padre, i miei figli sono terminati, pid primo figlio: %d , pid secondo figlio: %d",p,p1);
		}
	}
}

