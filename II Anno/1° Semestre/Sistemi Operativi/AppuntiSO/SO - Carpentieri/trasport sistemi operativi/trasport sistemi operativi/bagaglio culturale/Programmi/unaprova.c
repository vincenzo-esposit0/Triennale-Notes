#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <fcntl.h>
#include <unistd.h>


int main(void)
{
	
	signal(SIGINT,SIG_IGN);
	int pid=fork();
	
	if (pid<0)
	{
		printf("Erroe chiamata fork");
		exit(0);
	}
	else if(pid == 0)
	{
		signal(SIGINT,SIG_IGN);
		printf("sono figlio con pid %d e padre %d\n\n",getpid(),getppid());
		int file1=open("test.txt",O_RDONLY);
		int file2=open("finaltest.txt",O_WRONLY|O_TRUNC|O_CREAT,0644);
		if (file1 < 0 || file2 < 0)
		{
		printf("Errore nell'apertura file");
		exit(-1);
		}
		
		char c='f';
		char z='F';
		while(read(file1,&c,1)>0)
		{
			if(c== 'z' || c== 'a')
			{
				write(file2,&z,1);
			}
			else if(c== 'Z' || c== 'A')
			{
				write(file2,&z,1);
			}
			else
			{
				write(file2,&c,1);
			}
		}
		exit(0);
	}
	else
	{
	wait(NULL);
	printf("Sono padre e stampo figlio: %d",pid);
	}
}
