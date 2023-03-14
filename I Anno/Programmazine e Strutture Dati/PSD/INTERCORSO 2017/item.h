// file item.h

typedef int item;

#define NULLITEM 0

/* per semplicità in questo es.
   il nostro tipo item è l’insieme
   degli interi positivi
   NULLITEM è un elemento che
   viene restituito quando la
   precondizione di getFirst
   viene violata */

int eq(item x, item y);
void input_item(item *x);
void output_item(item x);
item estraiMaxIt(item x, item y);
item estraiMinIt(item x, item y);
//TEST
int confronta_item(item x, item y);
