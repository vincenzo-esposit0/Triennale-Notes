#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>



int main(){
	
	int pid=fork();
	int i;
if(pid==0){
	  printf("\nSono il figlio con pid %d\n",getpid());
	for(i=1;i<=50;i++){
		printf("%d\n",i);
	}
	  }
else if(pid>0){
	int pid2=fork();
	int z;	
	if(pid2==0){
	printf("\nSono il pid2:%d con padre:%d\n",getpid(),getppid());	
	for(z=101;z<=150;z++){
		printf("%d\n",z);
	}	
}
	else if(pid2>0){
	wait(NULL);
	wait(NULL);
	printf("\n");
	printf("pid1:%d e pid2:%d \n",pid,pid2); 
	
}
	else if(pid2<0){
	exit(-1);	
}	

	else{
	exit(-1);	
}
}
	



}