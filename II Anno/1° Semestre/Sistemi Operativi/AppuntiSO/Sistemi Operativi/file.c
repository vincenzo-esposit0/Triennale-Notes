#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>

#define BUFFSIZE 88192

main(void){
int n ;
char buf[BUFFSIZE];

while((n=read(STDIN_FILENO,buf,BUFFSIZE))>0)
 if(write(STDOUT_FILENO,buf,n)!=n)
    {printf("errore\n"); 
      exit(1);}

if(n<0)
  {printf("errore");
    exit(1);}

exit(0);

}
