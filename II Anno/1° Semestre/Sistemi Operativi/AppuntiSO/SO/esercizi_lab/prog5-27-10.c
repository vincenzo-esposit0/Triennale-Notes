#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>

int main(void){

	pid_t pid;
	char s[280]={0};
	char *x[280]={0};	

while(strcmp(fgets(s,100,stdin),"exit\n")!=0){
			
	if((pid=fork())<0){
		
		printf("Errore");

	}	
		
	else if(pid==0){
		
	int i=0;
	int z=0;
	int y=0;
	char temp[280]={0};

		s[strlen(s)-1]='\0';

	while(s[i]!='\0'){
		y=i;
		while(s[i]!=' ' && s[i]!='\0'){
		
			temp[i]=s[i];
			i++;
		}	
		x[z]=&temp[y];
		z++;
		i++;

	}
	x[z]=NULL;
		if(execvp(x[0],x)==-1){
			perror("execvp");

		}

		else{
			execvp(x[0], x);
		}
		exit(0);
	}	

	else{
			
		wait(NULL);	
	}
}
	return 0;

}