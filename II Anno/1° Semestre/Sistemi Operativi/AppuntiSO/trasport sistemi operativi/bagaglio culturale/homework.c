#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>


int main(void)
{

int pid1=fork();

if(pid1<0)
{
printf("errore");
return (-1);
}
else if(pid1==0)
{
printf("\nSono figlio pid1 con pid: %d e padre %d \n\n",getpid(),getppid());
	
exec

return(0);
}
else
{
int pid2=fork();	

	if(pid2<0)
	{
	printf("errore");
	return(-1);
	}
	else if(pid2==0)
	{
	int sum=getpid()+getppid();
	printf("pid2 ha pid %d e il padre %d\n\n ",getpid(),getppid());
	printf("\n\nLa somma del pid2 + il pid del padre è: %d",sum);
	int j=0;	
for (j=0; j<10;j++)
{
printf("\n\nSono figlio 2\n");
sleep(1);
}
	
	}
	else
	{
	wait(NULL);
	wait(NULL);
	printf("\n\nMio figlio pid1 %d e figlip pid2 %d sono terminati\n\n",pid1,pid2);
	 	
	}
}


}