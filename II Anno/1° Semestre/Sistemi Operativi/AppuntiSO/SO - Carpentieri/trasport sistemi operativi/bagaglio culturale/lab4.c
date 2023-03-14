#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>


int main()
{
	
int pid=fork();

	if(pid<0){
		printf("ERROE");

	}
	
	else if(pid==0){
		printf("\n\n\n\n\n\n\n\n %d", 10);
		
		execlp("ls","-l",NULL);

		
	}
	else{
		wait(NULL);
	}
	
	return 0;
}