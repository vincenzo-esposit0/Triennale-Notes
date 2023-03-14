#include "item.h"
typedef struct node *Btree;

item getItem(struct node *N); 
void setItem(struct node *N, item el); 
Btree newBtree(void);
int emptyBtree(Btree T);
struct node *getRoot(Btree T);
Btree consBtree(item val, Btree sx, Btree dx); 
Btree figlioSX(Btree T); 
Btree figlioDX(Btree T); 
Btree  inputBtree(void); 
Btree creaFoglia(item elem);
void visitaSimmetrica0(Btree T);
int altezza(Btree T);
int numFoglie(Btree T);
void outputBtree (Btree T);
void inorder(Btree T); 
int eqBtree(Btree a,Btree b); 
int ricerca (Btree b,item val);
int generazione (Btree a,Btree b);
