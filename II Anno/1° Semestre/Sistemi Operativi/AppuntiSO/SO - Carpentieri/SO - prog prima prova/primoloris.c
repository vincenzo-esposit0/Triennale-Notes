#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>




int main(void)
{


	int pid = fork();



	if(pid < 0)
{
	return -1;
}

	else if(pid == 0)
{
	printf("\n\nSono il figlio %d e padre %d\n\n\n", getpid(), getppid());	
	int j = 0;

	for(j=0; j<10;j++)
{
	printf("\n%d",getpid());
	sleep(1);
}	

return 0;
}

	else
{
	wait(NULL);
	printf("\n\nSono il padre e mio figlio :%d  e io sono padre %d \n\n",pid,getpid());
return 1;
		
}












}