#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#define BUFFERSIZE 8192

int main()
{
	int n;
	char buff[BUFFERSIZE];
	while((n=read(STDIN_FILENO,buff,BUFFERSIZE))>0) //Legge una stringa di al pù buffersize elementi. Nel while perchè lo fa infinite volte
	{
		if(write(STDOUT_FILENO,buff,n)!=n) //Prende gli n elementi, li mette nel buffer e li scrive in standard output
		{
			printf("Errore nella write\n");
			exit(1);
		}
	if(n<0)
	{
		printf("Errore nella read\n");
		exit(1);
	}
	return 0;
	}
}
