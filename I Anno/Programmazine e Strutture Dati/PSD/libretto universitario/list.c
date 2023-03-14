#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "list.h"

struct node {	//STRUTTURA DI OGNI NODO
     item value;
     struct node *next;
};

struct c_list {	//STRUTTURA NODO INTESTAZIONE
     struct node *first;
     int size;
};

int sizeList (list l)
{
     if(l == NULL)
	return -1;
     return l->size;
}
list newList(void)
{
     struct c_list *l;
     l = malloc (sizeof(struct c_list));
     if (l != NULL) {
     	l->first = NULL;
      l->size = 0;
          }
      return l;
}

int emptyList(list l)
{
      if(l == NULL)
	     return -1;
     return (l->size == 0);
}

item getItem(list l, int pos){

        if(l == NULL)
	return NULLITEM;

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
int posItem (list l, item val){
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

static struct node* makeNode(item val, struct node* nxt) //crea un nodo
{
      struct node *nuovo = malloc (sizeof(struct node));
      if (nuovo != NULL) {
     	  nuovo->value = val;
      	nuovo->next = nxt;
	}

      return nuovo;
}

static struct node* insertNode (struct node* nxt, int pos, item val) //inserisce un nodo nella lista in una pos valida
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
     n1 = makeNode(val, prec->next);     // creo nuovo nodo
     if(n1 == NULL)
              return NULL;   //  operazione di inserimento non riuscita

     prec->next = n1;
     return nxt;                    // operazione di inserimento riuscita
}

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

static struct node* removeNode(struct node* n, int pos)
{
    struct node* n1;                        // puntatore al nodo da eliminare

    if(pos == 0) {                              // eliminazione in posizione 0
        n1 = n;
        n = n->next;
        free(n1);
    }
   else {   // caso in cui pos > 0
        int i = 0;
        struct node* prec = n;
        while (i < pos-1) {   // scorriamo la lista fino a posizione pos-1
            prec = prec->next;
            i++;
          }
         n1 = prec->next;
         prec->next = n1->next;
         free(n1);
        }
    return n;
}

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
list cloneList (list l) {

list l1;
l1=newList();
struct node *tmp=l->first;
l1->first=makeNode(tmp->value,NULL); //CREA IL PRIMO NODO
struct node *tmp1=l1->first;
while(tmp->next!=NULL){ //scorro prima lista
tmp1->next=makeNode(tmp->next->value,NULL);
tmp=tmp->next;
tmp1=tmp1->next;
}
l1->size=l->size;
return l1;
}

int outputList(list l){ //io funziona
int i=0;
struct node *temp;
temp=l->first;
	while(temp!=NULL){

		printf("elemento di posizione %d:",i);
		output_item(temp->value);
		printf("\n");
		temp=temp->next;
		i++;
	}

return i;

}

int inputList (list l,int n)  //io funziona
{

  struct node *temp=l->first;
  int i;
  item val;

  if(l==NULL)
    return 0;

  for(i=0;i<n;i++)
  {
    input_item(&val);
    insertList (l,i,val);
  }

  return 1;

}

item estraiMaxN(list l, int n)
{
  struct node *temp=l->first;
  int i;
  item max=temp->value;

  if(l==NULL || sizeList(l)<n) //Precondizione non soddisfatta
  {
    return NULLITEM;
  }

  for(i=0;i<n;i++) //Trovo max
  {
    max=estraiMaxIt(max,temp->value);
    temp=temp->next;
  }

  temp=l->first; //Temp sarà uguale al primo nodo per scorrere nuovemente la lista

  for(i=0;i<n;i++) //Scorro la lista per eliminare il nodo che ha l'elemento massimo
  {
    if(max==temp->value)
    {
      removeList(l,i);
    }
    temp=temp->next;
  }

  return max;

}

list insertMinN(list l, item el, int n)
{
  struct node *temp=l->first;
  int i;
  item min=temp->value;

  if(l==NULL || sizeList(l)<n) //Precondizione non soddisfatta
  {
    return NULL;
  }


  for(i=0;i<n;i++) //Trovo max
  {
    min=estraiMinIt(min,temp->value);
    temp=temp->next;
  }

  temp=l->first; //Temp sarà uguale al primo nodo per scorrere nuovemente la lista

  for(i=0;i<n;i++) //Scorro la lista per eliminare il nodo che ha l'elemento massimo
  {
    if(min==temp->value)
    {
      insertList(l,i,el);
    }
    temp=temp->next;
  }

  return l;
}

//TEST

int confronta_liste(list l1, list l2, int n)
{
  int i =0;
	int trovato = 0;

	while(i<n)
  {
    item a=getItem(l1,i);
    item b=getItem(l2,i);
    if(confronta_item(a,b)==0) //Se sono diversi metto trovato=1 ed esco dal ciclo
    {
      trovato=1;
      break;
    }
    i++;
  }

	return (i == n) ? 1 : 0; //Ritorna 1 se i==n altrimenti 0
}

void finput(char *file_name, list l, int n)
{
	int i;
	FILE *fd;
  item x;

	fd=fopen(file_name, "r");
	if( fd==NULL )
		printf("Errore in apertura del file %s \n", file_name);
	else {
		for(i=0;i<n;i++)
    {
			fscanf(fd, "%d", &x);
      insertList (l,i,x);
    }
		fclose(fd);
		}
}

void foutput(char *file_name, list l, int n)
{
	int i;
	FILE *fd;
  item x;

	fd=fopen(file_name, "w");
	if( fd==NULL )
		printf("Errore in apertura del file %s \n", file_name);
	else {
		for(i=0; i<n; i++)
    {
      x=getItem(l,i);
			fprintf(fd, "%d\n", x);
    }
		fclose(fd);
		}
}
