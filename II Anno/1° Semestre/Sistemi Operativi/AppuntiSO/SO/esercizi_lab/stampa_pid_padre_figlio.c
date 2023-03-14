/* necessari per fork() */
#include <sys/types.h>
#include <unistd.h>
/* necessario per printf() */
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>

int main()
{
int pid;
int n;
scanf("%d", &n);
printf("Unico processo con (PID: %d).\n",getpid());
pid = fork();

if(pid==0){
		printf("\nsono il figlio con PID: %d\n", getpid());
}
else if(pid>0){
		
		printf("\nsono il padre con PID: %d con figlio  PID: %d\n", getpid(), pid);
		
		
}
else {
		printf("errore");
		exit(1);
}

}  
