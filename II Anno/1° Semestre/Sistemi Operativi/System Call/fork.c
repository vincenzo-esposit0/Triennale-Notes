#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(void)
{
	int value = fork();

	if(value<0)
			
	{
		printf("Errore \n");

	}

	else
	{
		printf("In main value: %d \n", value);

	}

	return 0;
}


