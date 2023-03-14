#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

int main()
{
	int value = fork();

	if(value<0)
	{
		printf("Errore \n");
	}
	else if(value==0)
	{
	printf("Ritorno del valore della fork del figlio: %d \n", value);
	}
	else
	{
		printf("Ritorno del valore della fork del padre: %d \n", value);
 	
	}

	return(0);
}
