#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include <stdio.h>

int main()
{
	int pid1 ,pid2,i;

	pid1=fork();

	if(pid1<0){
			 printf(" Si è verificato un errore");
             exit(1);
              }

if(pid1==0){
          signal(SIGINT,SIG_IGN);
          printf(" Pid processo primo figlio=%d ",getpid());

			for(i=1;i<50;i++)
			{
                printf("\n i numeri = %d",i);

                          
			}
           } 

	else 
		{
				pid2=fork();

		 if(pid2<0){
					printf(" Si è verificato un errore"); 
						   exit(1);
				   }

		if(pid2==0){
					  signal(SIGINT,SIG_IGN);
				printf(" Pid processo primo padre=%d ",getppid());
				  
				execlp("ls","ls",NULL);

					  exit(0);
				   }

		 else{
						 signal(SIGINT,SIG_IGN);
						 wait (NULL);

						 wait(NULL);

				   printf(" \n processo pid1=%d \n Processo pid2=%d \n            Teminato",pid1,pid2);}
              
		}
}
