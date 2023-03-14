#include<sys/types.h>
#include<sys/wait.h>
#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<signal.h>

#include<unistd.h>

int main()
{
int pid;
int in_fd, out_fd;
int status, n, contatore=0;
char buff;

pid = fork();		//Creazione del figlio
	
if(pid<0)	printf("Errore nella fork \n");

if(pid==0)
	{
		signal(SIGINT, SIG_IGN);	 //Ignora il segnale immesso da input
		in_fd=open("PIPPO.txt", O_RDONLY);
		out_fd=open("TOPOLINO.txt", O_CREAT|O_WRONLY|O_TRUNC, 0600);

		while((n=read(in_fd,&buff,1))>0)
		{
			if(buff!='A'&&buff!='a'&&buff!='E'&&buff!='e'&&buff!='I'&&buff!='i'&&buff!='O'&&buff!='o'&&buff!='U'&&buff!='u')
			{	
				contatore=contatore+1;
				printf("%d\n",contatore);
				
				if(write(out_fd,&buff,1)!=1)
				{
					printf("Errore nella write \n");
				}
			}
		}
		printf("Il numero di consonanti scritte e': %d \n", contatore);
		close(in_fd);
		close(out_fd);
		exit(1);
	}
else if(pid>0)
{
		signal(SIGINT, SIG_IGN);
		wait(&status);
		printf("Il pid di mio figlio e': %d \n", getpid());
		printf("Il processo padre termina \n");
		exit(1);
	}
	
return 0;

}
	
		
		
		
		
	
