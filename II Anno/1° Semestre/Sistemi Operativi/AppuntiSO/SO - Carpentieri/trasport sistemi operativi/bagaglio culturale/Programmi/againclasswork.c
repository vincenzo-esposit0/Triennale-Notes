#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <fcntl.h>





int main(void)
{

signal(SIGINT,SIG_IGN);

int pid=fork();


if(pid<0)
{
printf("Errore chiamata fork\n");
exit(-1);
}
else if(pid==0)
{
	signal(SIGINT,SIG_IGN);
	
	int file1= open("pippo.txt",O_RDONLY);
	int file2= open("culo.txt", O_WRONLY|O_TRUNC,O_CREAT,0644);
	
	if(file1<0 || file2<0)
	{
	printf("Errore apertura file");
	exit(-1);
	}
	int cont=0;
	char c,s='H';

		while(read(file1,&c,1)>0)
		{
			if( c== 'a' || c=='e' || c=='i' || c=='o' || c== 'u')
			{
			write(file2,&s,1);
			cont++;
			}
			
			if( c== 'A' || c=='E' || c=='I' || c=='O' || c== 'U')
			{
			write(file2,&s,1);
			cont++;
			}
	
		else
		
		write(file2,&c,1);
		
		}
	printf("Numero di cambiamenti avvenuti: %d \n",cont);
	exit(0);
}
	
	
	else 
	{
	
	wait(NULL);
	printf("Mio figlio : %d è terminato \n",pid);
	
	}
}
