#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>


int main(void)
{

int pid1=fork();

if(pid1 < 0)
{

printf("errore");
exit(0);
}

else if(pid1==0)
{


printf("\nSono pid1 %d e pardre %d\n", getpid(),getppid());
return 0;

}

    else
    {
        int pid2 = fork();

        if(pid2 < 0)
        {
        printf("error");
        exit(0);
        }

        else if(pid2 == 0)
        {
        int figlio= getpid();
        int padre = getppid();

        int sum = figlio - padre;

        printf("\n sum %d\n",sum);
        return 0;
        }

        else
        {
            wait(NULL);
            wait(NULL);
            printf("\n %d e %d sono terminati\n",pid1,pid2);
        }
    }   
}
