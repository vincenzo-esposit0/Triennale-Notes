// file item.h

typedef struct seggio *item;

#define NULLITEM 0
#define DIMM 000

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
item newItem(int n,int ad,int v,int vnul,int vs,int vn);
int votanti(item x);
int voti_nulli(item x);
int voti_si(item x);
int voti_no(item x);

