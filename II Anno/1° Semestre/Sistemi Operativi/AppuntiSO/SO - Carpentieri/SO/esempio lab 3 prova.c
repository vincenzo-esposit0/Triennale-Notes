#include<ctype.h>
#include<fcntl.h>
#define BUFFSIZE 1024

main(int argc, char *argv[])

{
char mybuf[BUFFSIZE], *p;
int in_fd, out_fd,n;

in_fd=open(argv[1],O_RDONLY);
out_fd=open(argv[2], O_WRONLY|O_EXCL|O_CREAT,0600);

while((n = read (int_fd,mybuf, BUFFSIZE)) >0)
	{
	for(p=mybuf;p - mybuf<n;p++)
		if(isslower(*p))*p = toupper(*p);
			else if (isupper(*p)) *p = tolower(*p);
	write(out_fd,mybuf,n);
	}
	
	close(in_fd);
	close(out_fd);
}