#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#define BUFFSIZE 8192

int main(void){
	int n;
	char buf[BUFFSIZE];

	while((n = read(STDIN_FILENO, buf, BUFFSIZE))> 0){
		if(write(STDOUT_FILENO, buf, n) != n){
			printf("write error\n");
			exit(-1);
		}
		if(n<0){
			printf("read error\n");
			exit(-1);
		}

	}
exit(0);
}