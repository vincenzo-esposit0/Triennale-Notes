// file item.c 

/* il modulo contiene per ora tre 
operatori che useremo nel seguito. 
Aggiungerne altri all’occorrenza */

#include <stdio.h>
#include "item.h"

int eq(item x, item y) {
   return x == y;
}

void input_item(item *x) {
     printf("Inserisci elemento: ");
     scanf("%d", x);
} 

void output_item(item x) {
      printf("%d", x);
} 

int minore(item x,item y)
{
	if(x<y)
		return 1;
}

int compreso(item x,item y,item k)
{
    if(x>=k&&y<=k)
       return 1;
}
