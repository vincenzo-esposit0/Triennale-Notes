#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>



int main(){

int pid2;//dichiarato fuori altrimenti il padre non riusciva a capire quale valore avesse pid2
int pid=fork();
if(pid<0){
	printf("Errore");
}
else if(pid==0){
printf("\nSono il figlio con pid: %d",getpid());
int i;
	printf("\n");
	for(i=1;i<=10;i++){
	printf("n:%d\n",i);
	}//dimenticato di chiudere questa parentesi

 	pid2=fork();
	if(pid2<0){
	printf("Errore");	
	}

	else if(pid2==0){
	printf("Sono pid2: %d con padre:%d\n",getpid(),getppid());
	execl("/bin/ls","ls -l",NULL);	
	}
	else{
	wait(NULL);
	exit(-1);
	}
}

else{
	wait(NULL);
	
	printf("\nI miei due figli sono terminati\n");
	printf("\nfiglio pid: %d\n",pid);
	printf("\nfiglio pid2:%d\n",posix_getpid());// getpid() per ricevere pid del figlio
	exit(-1);
}


}