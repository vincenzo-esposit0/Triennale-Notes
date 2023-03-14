/*
Scrivere un programma in c che prenda come input due nomi di file F1 e F2 e scriva in F2 il contenuto di F1 invertendo maiscole e minuscole.

#include<stdio.h>
#include<c_type.h>

int islower(char c);
int isupperr(char c),

int tolower(char c);
int toupper(char c);

*/

#include<stdlib.h>
#include<stdio.h>
#include<unistd.h>
#include<sys/type.h>
#include<sys/stat.h>
#include<fcntl.h>

#define buffer_size 100

int main(void)
{
	char F1[buffer_size], F2[buffer_size];
	char buff[buffer_size];
	int n, m;	

	printf("Inserisi nome F1:  \n");
	scanf("%s", F1);
	
	printf("Inserisi nome F2:  \n");
	scanf("%s", F2);

	if(n = open(F1, O_RDONLY, 0777) != -1)
	{
		if(m = read(F1, buff, buffer_size)>0)
		{
			for(int i=0, i<buffer_size, i++)
			{
				if(tolower(buff[i]) && toupper(buff[i+1])
				{
					write(F2, buff[i+1], buffer_size);
					write(F2, buff[i], buffer_size);
				}
				else if(toupper(buff[i+1] && tolower(buff[i]))
				{
					write(F2, buff[i], buffer_size);
					write(F2, buff[i+1], buffer_size);
				}
			}
		}
	}

}
					


		
	

