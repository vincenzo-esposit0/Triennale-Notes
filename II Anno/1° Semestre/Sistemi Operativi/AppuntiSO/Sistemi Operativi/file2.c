/*scrivere un programam c che prenda in input il nome di 2 file e scriva in f2 il contenuto di f1 invertendo le maiuscole e le minuscole il file 2 deve essere creato quando ci serve*/

#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <fcntl.h>

#define BUFFSIZE 88192

main(void){
 char f1p[100],f2p[100],mybuff[BUFFSIZE],*p;
  int f1,f2,n;

printf("inserire il nome del primo file \n");
scanf("%s",f1p);

f1=open(f1p,O_RDWR);

if(f1<0)
  {printf("il file non esiste esco");
    exit(0);}
else{printf("trovato !! \n");}


printf("inserire il nome del secondo file \n");
scanf("%s",f2p);

f2=open(f2p,O_CREAT|O_RDWR|O_EXCL,0600);

if(f2<0)
  {printf("il file non esiste lo creo !!\n");}
else{printf("trovato !! \n");}



while((n=read(f1,mybuff,BUFFSIZE))>0)
    {
       for(p=mybuff;p-mybuff<n;p++){
         if(islower(*p)) {
             *p= toupper(*p);
                printf("leggo if : %p \n",p);}
            else if(isupper(*p)) 
               {*p=tolower(*p);
                   printf("leggo else : %s \n",*p);}

            }
        write(f2,mybuff,n);

}
close(f1);
close(f2);

exit(0);}
