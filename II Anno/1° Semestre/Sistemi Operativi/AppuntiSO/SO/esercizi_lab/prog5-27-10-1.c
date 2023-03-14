#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>

int main(void){

	pid_t pid;
	char s[280]={0};	

while(strcmp(fgets(s,100,stdin),"exit\n")!=0){
			
	if((pid=fork())<0){
		
		printf("Errore");

	}	
		
	else if(pid==0){
		

		s[strlen(s)-1]='\0';
		if(execlp(s,s,NULL)==-1){
			perror("execlp");

		}

		else{
			execlp(s, s, NULL);
		}
		exit(0);
	}	

	else{
			
		wait(NULL);
	
	}
}
	return 0;

}