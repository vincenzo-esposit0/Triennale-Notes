
/*
 studente: Senatore Davide
*/


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <signal.h>
#include <fcntl.h>


int main(void)
{

	signal(SIGINT,SIG_IGN);
	
	int pid1 = fork();
	
	if(pid1 < 0)
	{
	printf("Errore nella chiamata fork\n");
	exit(-1);
	}
	
		else if(pid1 == 0)
		{
		signal(SIGINT,SIG_IGN);
		int ff1 = open("pippo.txt",O_RDONLY);
		int ff2 = open("antani.txt",O_WRONLY|O_TRUNC|O_CREAT,0644);
		
			if(ff1<0 || ff2<0)
			{
			printf("Errore apertura file\n\n");
			exit(-1);
			}
		
		int cont = 0;
		char equal,sost = 'H';
		
			while(read(ff1,&equal,1) > 0)
			{
				if(equal == 'a' || equal == 'e' || equal == 'i' || equal == 'o' || equal == 'u')
				{
				write(ff2,&sost,1);
				cont++;
				}
			    
			    else if(equal == 'A' || equal == 'E' || equal == 'I' || equal== 'O' || equal == 'U')
				{
				write(ff2,&sost,1);
				cont++;
				}
				
				else 
					write(ff2,&equal,1);
			}
		
		
		printf("\nNumero cambiamenti avvenuti:%d\n",cont);
		exit(0);
		}
		else
		{
		wait(NULL);
		printf("figlio : %d  è terminato\n",pid1);
		}
}
