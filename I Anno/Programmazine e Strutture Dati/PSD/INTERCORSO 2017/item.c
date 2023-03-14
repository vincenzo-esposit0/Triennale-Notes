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
     scanf("%d", x);
}

void output_item(item x) {
      printf("%d", x);
}

item estraiMaxIt(item x, item y)
{
  if(x>y)
    return x;
  else
    return y;
}

item estraiMinIt(item x, item y)
{
  if(x<y)
    return x;
  else
    return y;
}

//TEST
int confronta_item(item x, item y)
{
  if(x==y)
    return 1;

  return 0;
}
