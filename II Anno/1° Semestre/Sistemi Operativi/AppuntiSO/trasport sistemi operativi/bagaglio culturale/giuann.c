#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
 

int main(){


int pid1 = fork();

	if (pid1<0){

	printf("errore");
	return(-1);
}
	else if (pid1==0){
	printf("sono il figlio %d, e padre %d\n\n", getpid(), getppid());
	return(0);

}
	

else 
{

int pid2 = fork();
if (pid2<0){

	printf("errore");
	return -1;

}
else if (pid2==0){


	printf("\n\nsono il figlio %d , sono il padre %d\n\n\n",getpid(), getppid());
	return(0);
}else {
wait(NULL);
wait(NULL);
printf ("\n\nsono il primo figlio %d , sono il secondo figlio %d\n\n\n",pid1,pid2);

printf("\n\nProva prova %d \n\n", getpid());

}


}

}