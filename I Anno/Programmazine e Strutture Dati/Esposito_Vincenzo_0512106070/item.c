#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "item.h"

item newItem(void){

	item a=malloc(sizeof(int));
	if(a == NULL){

		return NULL;

	 }

	return a;

}


int eq(item x, item y) 
{
	if(*x==*y) return 1;
	if(*x<*y) return -1;
	if(*x>*y) return 0;
}

void inputItem(item a) 
{
     scanf("%d",a);
} 

void outputItem(item a) 
{
      printf("%d",*a);
}

void assign(item a, item b)
{
	*a=*b;
}

int minore(item x, item y)
{   
    if(x<y) return 1
    else retun 0;
    
}
