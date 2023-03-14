#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>


int main(void)
{


int pid1=fork();


if(pid1<0)
{
printf("error");
return(-1);
}
else if(pid1==0)
{


printf("\nsono figlio pid1 con pid%d e padre %d", getpid(),getppid());

return 0;
}
else
{
int pid2=fork();

	if(pid2<0)
	{
	printf("error");
	return(-1);
	}
	else if(pid2==0)
	{
	printf("\nsono figlio pid2 con pid %d",getpid());
return 0;	
	}
	else
	{
	wait(NULL);
	wait(NULL);
	printf("\n\nMio figlio pid1: %d\n\n\n",pid1);
	printf("\n\nMio figlio pid2: %d\n\n",pid2);
	return (0);
	}
}

}