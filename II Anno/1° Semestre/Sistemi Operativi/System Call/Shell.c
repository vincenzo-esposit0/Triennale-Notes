#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>
#include<string.h>
#include<malloc.h>
#include<ctype.h>
#include<stdlib.h>

int main(void)
{
char command[100];

char *c1= NULL;
char *c2= NULL;
char *c3= NULL;
char *c4= NULL;
char *c5= NULL;
char *c6= NULL;

int start = 0;	//indice iniziale della stringa command
int flag = 0;	//indice del numero di argomenti

pid_t val;

do{
	printf("Shell: ");
	fgets(command, 100, stdin);
	for(int i=0; command[i] != '\0'; i++)
	{
		if(isspace(command[i]))
		{
			//il flag mi fa capire dove copiare la stringa
			for(int j=0; start<i; start++, j++)
			{
				switch(flag)
				{
					case 0: if(isspace(command[start])) start++;
					if(j == 0) c1 = malloc(10);
					c1[j]= command[start];
					break;
					
					case 1: if(isspace(command[start])) start++;
					if(j == 0) c2 = malloc(10);
					c2[j]= command[start];
					break;

					case 2: if(isspace(command[start])) start++;
					if(j == 0) c3 = malloc(10);
					c3[j]= command[start];
					break;

					case 3: if(isspace(command[start])) start++;
					if(j == 0) c4 = malloc(10);
					c4[j]= command[start];
					break;

					case 4: if(isspace(command[start])) start++;
					if(j == 0) c5 = malloc(10);
					c5[j]= command[start];
					break;

					case 5: if(isspace(command[start])) start++;
					if(j == 0) c6 = malloc(10);
					c6[j]= command[start];
					break;

				}
			}
			
			flag++;				

		}
	} 
	
	val=fork();
	if(val<0)
	{
		printf("Errore \n");
		exit(-1);
	}
	else if(!val)
	{
		if(execlp(c1, c1, c2, c3, c4, c5, c6, NULL) <0 && strcmp("exit \n", command))
		{
			printf("Errore \n");
			exit(-1);
		}
	}
	else if(val)
	{
		waitpid(val, NULL, 0);
	}
	
}while(strcmp(command, "exit\n"));	


}				
