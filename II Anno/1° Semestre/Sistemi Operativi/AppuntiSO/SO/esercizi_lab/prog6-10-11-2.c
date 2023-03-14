#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define BUFFSIZE 8192

int main(void){
	int n;
	char buf[BUFFSIZE];

	int filedescriptor;
	int filedescriptor2;
	
	filedescriptor = open("/home/paolo/Desktop/esercizi_lab/F1.txt", O_RDONLY);
	filedescriptor2 = open("/home/paolo/Desktop/esercizi_lab/F2.txt", O_RDONLY);
	
	printf("%d", filedescriptor);

	exit(0);
}