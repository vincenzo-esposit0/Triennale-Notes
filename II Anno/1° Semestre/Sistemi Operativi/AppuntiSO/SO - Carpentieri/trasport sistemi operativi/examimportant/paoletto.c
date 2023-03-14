#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>




int main(void){

pid_t pid;
pid=fork();

if(pid<0){
printf("Errore");
exit(-1);
}
else if(pid==0){
	printf("Mio pid:%d",getpid());
int i;
	for(i=1;i<=10;i++){
		printf("\n%d",i);
	}
	exit(0);
}
else{
pid_t pid2;
pid2=fork();	
	if(pid2<0){
		printf("Errore");
		exit(-1);	
	}
	else if(pid2==0){
		
		printf("pid mio e pid di mio padre: %d %d\n", getpid(), getppid());
		execlp("ls","ls",NULL);
	}
	else{
	wait(NULL);
	wait(NULL);
	printf("I miei due figli sono terminati");
	printf("pid dei miei figli :  %d  %d ",pid,pid2);
	exit(0);	
	}//chiusura else
}
	return 0;
}