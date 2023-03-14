#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

int main()
{	
	int value2;
	int value= fork();

	if(value==0)
	{
		printf("------------------------- \n");
		printf("Nel processo figlio \n");
		printf("Il valore di ritorno di fork: %d \n", value);
		printf("------------------------- \n");
	}
	else
	{
		printf("------------------------ \n");
		printf("Nel processo padre il valore di ritorno di fork: %d \n", value);
		printf("------------------------ \n");
	}

	if(value2>0)
	{
		value2=fork();

		if(value2==0)
		{
			printf("Nel secondo processo figlio il valore di fork: %d \n", value2);
		}
		else
		{
			printf("il valore di ritorno del padre e': %d \n", value2);
	}


}
return(0);
}
