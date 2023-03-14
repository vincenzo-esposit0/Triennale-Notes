#include<stdio.h>
#include<stdlib.h>
#include"item.h"
#include"list.h"

struct node {
	item value; //Dato contenuto nl nodo
	struct node *next; //puntatore al nodo successivo
};

struct c_list {
	struct node *first; //puntatore al primo nodo della lista
	int size; //numero di elementi contenuti nella lista
};

list newList(void)
{
     struct c_list *l;
     l = malloc (sizeof(struct c_list));
     if (l != NULL) {
     	l->first = NULL;
      l->size = 0;
          }
      return l;
/* il programma client dovrà controllare
    che il risultato non sia NULL  */
}

item getFirst (list l)
{
      item e;
      if(l != NULL)
	e = l->value;
      else
             e = NULLITEM;
      return e;
}

item getItem (list l, int pos) //Restituisce l’elemento in l di posizione pos, oppure l’elemento nullo se la lista ha meno di pos+1 elementi
{
       if(l == NULL)
	return NULLITEM;

        /* avendo l->size non abbiamo bisogno di scorrere la lista
           per verificare la precondizione pos < sizeList(l)                 */

        if (pos<0 || pos>=l->size)
                  return NULLITEM;  // precondizione non verificata

        struct node *temp = l->first; // temp è usato per scorrere la lista
        int i = 0;

        while (i < pos) {  // finchè non si arriva al nodo in posizione pos
               i++;
               temp=temp->next;   // temp !=NULL garantito da pos < l->size
           }

        return temp->value;    // temp punta al nodo in posizione pos
}

int posItem (list l, item val) //Restituisce la posizione della lista in cui appare la prima occorrenza dell’elemento, oppure -1 se l’elemento non è presente
{
       if(l== NULL)
			 		return -1;
      int pos =0;
      int found =0;

      struct node *temp = l->first;         // temp è usato per scorrere la lista

      while (temp!=NULL && !found){  // visita finalizzata
          if (eq(temp->value, val))
                 found =1;                             // elemento trovato
          else {
              temp=temp->next;                 // continua ricerca nella lista
              pos++;
              }
          }
           // se è stato trovato viene restituita la posizione altrimenti -1

        if(!found)
      	 pos = -1;
       return pos;
}


/* la funzione insertNode inserisce un nodo nella lista collegata */

static struct node* insertNode (struct node* n, int pos, item val);

int insertList (list l, int pos, item val)
{
  if(l == NULL)
			return 0;
  if (pos<0 || pos>l->size)  // precondizione non soddisfatta
	return 0;

  struct node* tmp = insertNode(l->first, pos, val);
  if(tmp==NULL)   // se l’inserimento è fallito
	return 0;  // restituisce 0 e non modifica la lista

  // se l’inserimento è riuscito modifichiamo la lista
  l->first = tmp;
  l->size++;
  return 1;
}

/* la funzione makeNode crea un nodo e ne restituisce il puntatore (simile a consList) */

static struct node* makeNode(item val, struct node* nxt);


/* la funzione insertNode restituisce NULL se non riesce ad
   allocare memoria per il nuovo nodo da inserire                             */

static struct node* insertNode (struct node* nxt, int pos, item val)
{
     struct node *n1;
     if(pos == 0)                        // caso inserimento in testa
	return makeNode(val, nxt);
int i = 0;
     struct node* prec = nxt;
     while (i < pos-1) {           // scorro la lista fino a posizione pos - 1
        prec = prec->next;
        i++;
     }
 /* All’uscita prec punta all’elemento di posizione pos-1.
    Il controllo su prec != NULL nella condizione del while questa volta
    è inutile perché insertNode viene chiamata da insertList solo se la
    lista ha almeno pos elementi (la precondizione è soddisfatta)           */

     n1 = makeNode(val, prec->next);     // creo nuovo nodo
     if(n1 == NULL)
              return NULL;   //  operazione di inserimento non riuscita

     prec->next = n1;
     return nxt;                    // operazione di inserimento riuscita
}

static struct node* makeNode(item val, struct node* nxt)
{
      struct node *nuovo = malloc (sizeof(struct node));

      if (nuovo != NULL) {
     	  nuovo->value = val;
      	nuovo->next = nxt;
	}

      return nuovo;
}

/* la funzione removeNode rimuove un nodo dalla lista collegata */

static struct node* removeNode(struct node* n, int pos);


int removeList (list l, int pos)
{
    if(l == NULL)
				return 0;

    if (pos<0 || pos>=l->size)     // precondizione non soddisfatta
	return 0;

    l->first = removeNode(l->first, pos);
    l->size--;
    return 1;
}

static struct node* removeNode(struct node* n, int pos)
{
    struct node* n1;                        // puntatore al nodo da eliminare

    if(pos == 0) {                              // eliminazione in posizione 0
        n1 = n;
        n = n->next;
        free(n1);
    }

/* NB: in questo caso non serve controllare anche che n != NULL
   perché removeNode viene invocata da removeList solo se il
   numero di elementi nella lista è maggiore di pos (la precondizione
   è soddisfatta)  */
else {   // caso in cui pos > 0
        int i = 0;
        struct node* prec = n;
        while (i < pos-1) {   // scorriamo la lista fino a posizione pos-1
            prec = prec->next;
            i++;
          }
/*  Alla fine del ciclo, prec->next punta al nodo da eliminare.
    Il controllo su prec != NULL nella condizione del while questa volta
    è inutile perché removeNode viene chiamata da removeList solo se la
    lista ha almeno pos elementi (la precondizione è soddisfatta)
    Per lo stesso motivo è soddisfatta anche prec->next != NULL */

         n1 = prec->next;
         prec->next = n1->next;
         free(n1);
        }
    return n;
}

list reverseList(list l) {
      if(l == NULL)
	     return NULL;
      list l1 = newList();                     // creiamo la nuova lista di output
      struct node *temp = l->first;    // serve a scorrere la lista di input

     // si scorre la lista di input e si inseriscono in testa alla nuova lista
      while(temp!=NULL) {
             l1->first = makeNode(temp->value, l1->first);
             temp=temp->next;
         }

// l1->first è NULL se l è vuota o se makeNode non ha allocato memoria
      if (l1->first!=NULL)
	     l1->size=l->size;

// se l1->first è NULL allora l1->size è 0 (quella inizializzata da newList)
      return l1;
}
/* NB: per semplicità nel ciclo non si controlla se makeNode
restituisce NULL */

/* deleteList trasforma la lista di input in lista vuota,
    cancellando la lista collegata di nodi                         */

int deleteList (list l) {
      if(l == NULL)
              return 0;

      struct node *temp = l->first;    // serve a scorrere la lista di input
      struct node *temp1;                 // punta al nodo da eliminare

      while(temp!=NULL) {   // scorre la lista per eliminare i nodi
             temp1 = temp;
             temp=temp->next;
             free(temp1);
         }

      l->first = NULL;
      l->size = 0;
      return 1;
}

list cloneList(list l)
{

	if(l == NULL)
	 return NULL;
	list l1 = newList();                     // creiamo la nuova lista di output
	struct node *temp = l->first;
	struct node *temp1 = l1->first;   // serve a scorrere la lista di input

	while(temp!=NULL){
		 temp1 = makeNode(temp->value, l1->first);
		 temp1=temp1->next;
		 temp=temp->next;
		 l1->size++;
	}

	return l1;

}

list inputList(int n)
{
	if(n <= 0)
           return newList();

       item val;
       list l = newList();
			 for(i=0;i<n;i++)
			 {
				 
			 }
}
