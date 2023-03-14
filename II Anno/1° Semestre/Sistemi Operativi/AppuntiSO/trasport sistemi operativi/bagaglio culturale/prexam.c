#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>


int fact(n)
{

if(n == 0)
{
	return 0;
}

else if(n == 1)
{
return 0;
} 
else
{

return (n * fact(n-1));

}

}



int main(void)
{

	int pid1= fork();









}