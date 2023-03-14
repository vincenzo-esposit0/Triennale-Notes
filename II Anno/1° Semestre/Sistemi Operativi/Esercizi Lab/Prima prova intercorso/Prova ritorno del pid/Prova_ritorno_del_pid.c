#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

void main(){
	printf("pid del processo: %d\n", getpid());
	printf("pid del processo padre: %d\n", getppid());
}

