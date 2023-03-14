#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<signal.h>

int fibonacci(int n)
{
  if(n<=1)
   return n;
  else return fibonacci(n-1)+fibonacci(n-2);
}

void ctrlc_handler(int sig)
{
 int pid=fork();
 if(pid==0)
   {
    char ans,clear;
    printf("\nQUIT (q) or CONTINUE (c)? ");
    scanf("%c",&ans);
    scanf("%c",&clear);
    if(ans=='q')
      kill(getppid(),SIGKILL);
    else
      signal(SIGINT,ctrlc_handler);
    
    exit(0);
   }
 else
   wait(NULL);
}

void main()
{
  signal(SIGINT,SIG_IGN);
  int pid=fork();
  
  if(pid==0)
    { 
     int i;
     signal(SIGINT,ctrlc_handler);
     for(i=0;i<46;i++)
        printf("FIB[%d]=%d\n",(i+1),fibonacci(i+1));
     exit(0);
    }
 else
   wait(NULL);

printf("\nTERMINATO FIGLIO %d\n",pid);
}