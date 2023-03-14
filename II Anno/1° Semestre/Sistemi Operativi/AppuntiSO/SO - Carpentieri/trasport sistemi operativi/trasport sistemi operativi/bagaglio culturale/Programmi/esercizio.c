#include <stdio.h>
#include <sys/types.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>


int f1=0;
int f2=0;
int myfather;
f1=fork();
if(f1!=0){
	printf("Pid processo filgio:%d",getpid());
	f2=fork();
}
if(f2!>0){
	int sum;
	sum=
	printf("Somma pid figlio e padre:%d",
}
if(f1==0||f2==0){
	myfather=fork();
}


