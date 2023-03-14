#include<stdio.h>
#include<sys/types.h>
#include<fcntl.h>
#include<stdlib.h>
#include<unistd.h>

int main(int argc, char *argv[])
{
	int fd;
	char buf[14];
	/* write */ 
	
	fd = open("myfile.txt", O_CREATE | O_WRONLY, 0600);  // read and write permissions
	
	if(fd == -1)
	{
		printf("Failed to create and open the file.\n");
		exit(1);
	}
	
	write(fd, "Hello world\n", 13 )
	close(fd);
	
	
	/* read */
	
	fd = open("myfile.txt", RDONLY);  // read and write permissions
	
	if(fd == -1)
	{
		printf("Failed open and read the file.\n");
		exit(1);
	}
	
	read(fd, buf,13);
	buf[13] = '\0';
	
	
	close(fd);
	
	
	printf("buf:%s\n",buf);
	
	return 0;
}