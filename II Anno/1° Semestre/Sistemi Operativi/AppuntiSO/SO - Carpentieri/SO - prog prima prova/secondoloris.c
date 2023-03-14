#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>


int main(void)
{
	int pid=fork();
	

	if(pid<0){

	return -1;

	}

	else if(pid==0){
	printf("sono il figlio : %d, mio padre e' :%d", getpid(), getppid());
	return 0;
	}
	
	else
{
	
	int pid2= fork();

	if( pid2 < 0)
	{
	
	printf("Error");
return -1;	
	}
	else if(pid2 == 0)
{		

	printf("\n\nSono secondo filgio %d\n\n",getpid());	
	int j= 0;
for(j=0;j<8;j++){
	printf("\nLoris gay\n");sleep(1);}
	return 0;
}
	else

	{
		wait(NULL);
wait(NULL);

	printf("\n\nEcco, sono terminati, pid %d  e pid2 %d!!!\n\n",pid,pid2);
	return 1;
	}
}










}