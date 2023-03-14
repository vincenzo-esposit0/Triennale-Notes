#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <sys/types.h>

int main()
{


	int pid = fork();

	if(pid < 0)
{
		printf("errore");

}

	else if(pid == 0)
{

	printf("Sono il figlio con pid %d  con padre %d ", getpid(), getppid());
	
	
}
	else
{
	wait(NULL);
	printf("Sono il figlio %d", pid);
}

	
}