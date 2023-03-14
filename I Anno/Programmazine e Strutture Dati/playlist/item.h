// file item.h

typedef struct song *item;

#define NULLITEM 0
#define DIMM 100399

/* per semplicità in questo es.
   il nostro tipo item è l’insieme
   degli interi positivi
   NULLITEM è un elemento che
   viene restituito quando la
   precondizione di getFirst
   viene violata */

int eq(item x, item y);
item input_item();
void output_item(item x);
item newItem(char *autore, char *titolo, int durata);
char * search_autore(item x);
