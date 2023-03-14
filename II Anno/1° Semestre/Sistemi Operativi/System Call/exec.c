#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>

int main()
{
	int pid, status;
	char stringa[25];

	while(1)
	{
		printf("Inserisci il comando da eseguire: ");
		scanf("%s", stringa);
		printf("\n");

		pid=fork();
		
		if(pid==0)
		{
			execlp(stringa, stringa, NULL);
			
		}
		if(pid>0)
		{
			wait(&status);
			printf("-------------- \n");
			printf("Processo Padre \n");
			printf("-------------- \n");
		}
	}

return (0);
}	
			
