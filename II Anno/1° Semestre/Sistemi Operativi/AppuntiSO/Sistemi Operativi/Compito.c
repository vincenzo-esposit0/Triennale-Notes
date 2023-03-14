
                                                  //RUSSO GENNARO MATRI=0512103160

#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>
int main()
{int i, n,t,pid1,pid2,status,p1,p2;
pid1=fork();
if(pid1<0){printf("si è verificato un errore"); exit(1);
}
if(pid1==0){printf("processo figlio %d \n processo padre =%d \n",getpid(),getppid());
exit(0); }
else {pid2=fork();}
for(i=0;i<=49;i++){t=t+i;}
if(pid2<0){printf("si è verificato un errore"); exit(1);}

if(pid2==0){ printf("processo figlio %d \n processo padre =%d somma dei primi 50 numeri =%d \n totale processo  padre + figlio +numeri=%d \n ",getpid(),getppid(), t,(getpid()+getppid()+t));
exit(0);
}
else{wait(&status);wait(&status);
printf(" pid processo figlio numero 1= %d\n pid processo flio numero 2=%d \n ",pid1,pid2);}
}


