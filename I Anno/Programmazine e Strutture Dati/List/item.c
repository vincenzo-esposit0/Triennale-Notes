/* il modulo contiene per ora tre 
operatori che useremo nel seguito. 
Aggiungerne altri all’occorrenza */

#include <stdio.h>
#include "item.h"

int eq(item x, item y) 
{
   return x == y;
}

void input_item(item *x) 
{
     scanf("%d", x);
} 

void output_item(item x) 
{
      printf("%d", x);
}

item minore(item a, item b)
{
if(a<b) return a;
else return b;
}
