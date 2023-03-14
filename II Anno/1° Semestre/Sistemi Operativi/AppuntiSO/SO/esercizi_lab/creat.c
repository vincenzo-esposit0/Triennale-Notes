#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>



int main(){
	
	
	int filedescriptor = creat("ciao.txt", O_TRUNC);
	printf("id descriptor:\n%d", filedescriptor);
	filedescriptor = creat("babudoiu.txt", O_TRUNC);
	printf("id descriptor:\n%d", filedescriptor);
	filedescriptor = creat("davide.txt", O_WRONLY);
	printf("id descriptor:\n%d", filedescriptor);
	
	
	return 0;
	
	
	
	
}
