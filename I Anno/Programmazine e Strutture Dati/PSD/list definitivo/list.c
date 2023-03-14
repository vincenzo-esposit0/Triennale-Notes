#include <stdio.h>
#include <stdlib.h>
#include "item.h" 
#include "list.h"

struct node{
     item value;
     struct node *next;
};

struct c_list {
     struct node *first;
     int size;
};

list newList(void) //numero di elementi nella lista
{
	struct c_list *l;
	l=malloc(sizeof(struct c_list));

	if (l!=NULL) {
	     	l->first = NULL;
	      	l->size = 0;
          }

	return l;   
}

int emptyList(list l) //azzera lista
{
    if(l == NULL)
	return -1;
    return(l->size == 0);
}

int sizeList (list l)
{
    if(l == NULL)
	return -1;
    return l->size;
}

int posItem (list l, item val){
    if(l== NULL)
	return -1;

    int pos=0;
    int found=0;
          
    struct node *temp = l->first;         // temp è usato per scorrere la lista
          
    while(temp!=NULL && !found){  // visita finalizzata
		if(eq(temp->value, val))
			found=1;                             // elemento trovato
		else{
			temp=temp->next;                 // continua ricerca nella lista
			pos++;
		}
    }
	// se è stato trovato viene restituita la posizione altrimenti -1
           
    if(!found)
    pos = -1;
    return pos;
}

item getItem(list l, int pos){

	if(l == NULL)
	return NULLITEM;
    /* avendo l->size non abbiamo bisogno di scorrere la lista 
	per verificare la precondizione pos < sizeList(l)                 */
	
    if(pos<0 || pos>=l->size)
		return NULLITEM;  // precondizione non verificata
       
    struct node *temp = l->first; // temp è usato per scorrere la lista
    int i = 0;
        
    while(i < pos){  // finchè non si arriva al nodo in posizione pos            
        i++;          
        temp=temp->next;   // temp !=NULL garantito da pos < l->size    
    }      

    return temp->value;    // temp punta al nodo in posizione pos
}

static struct node* make_node(item val, struct node* nxt) //crea un  nodo
{
    struct node *nuovo = malloc (sizeof(struct node));
    
    if (nuovo != NULL) {
        nuovo->value = val;
        nuovo->next = nxt;
    }
    
    return nuovo;
}

static struct node* insertNode (struct node* l, int pos, item val)
{
    struct node *n1;
    if(pos == 0)                        // caso inserimento in testa
        return make_node(val, l);
    int i = 0;
    struct node* prec = l;
    while (i < pos-1) {           // scorro la lista fino a posizione pos - 1
        prec = prec->next;
        i++;
    }
    /* All’uscita prec punta all’elemento di posizione pos-1.
     Il controllo su prec != NULL nella condizione del while questa volta
     è inutile perché insertNode viene chiamata da insertList solo se la
     lista ha almeno pos elementi (la precondizione è soddisfatta)           */
    
    n1 = make_node(val, prec->next);     // creo nuovo nodo
    if(n1 == NULL)
        return NULL;   //  operazione di inserimento non riuscita
    
    prec->next = n1;
    return l;                    // operazione di inserimento riuscita
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


list reverseList (list l)
{
    if(l == NULL)
        return NULL;
    list l1 = newList();                     // creiamo la nuova lista di output
    struct node *temp = l->first;    // serve a scorrere la lista di input
    
    // si scorre la lista di input e si inseriscono in testa alla nuova lista
    while(temp!=NULL) {
        l1->first = make_node(temp->value, l1->first);
        temp=temp->next;
    }
    
    // l1->first è NULL se l è vuota o se makeNode non ha allocato memoria
    if (l1->first!=NULL)
        l1->size=l->size;
    
    // se l1->first è NULL allora l1->size è 0 (quella inizializzata da newList)
    return l1;
}

list inputList (int n)
{
    list l;
    l=newList();
    l->size=n;
    struct node *temp; //creo un nodo per scorrere la lista
    int i=1;
    item x;
    input_item(&x);

    l->first=make_node(x,NULL); //creo il primo nodo che punta a NULL
    temp= l->first;
    while(i<n)
    {
        input_item(&x);
        temp -> next = make_node(x,NULL);
        temp = temp->next;
        i++;
    }
   
    return l;
}

void outputList (list l)
{
    struct node *temp = l->first; //creo un nodo per scorrere la lista

    while(temp!=NULL){
        output_item(temp->value);
        temp=temp->next;
    }
}

int insertList (list l, int pos, item val)
{
  if(l == NULL)
        return 0;
  if (pos<0 || pos>l->size)  // precondizione non soddisfatta
        return 0;	
  struct node* tmp= insertNode(l->first, pos, val);
  if(tmp==NULL) return 0;
  l->first = tmp;
  l->size++;
  return 1;                  
}   



int removeList (list l, int pos)
{     
     if(l == NULL)
        return 0;
    
    if (pos<0 || pos>=l->size)     // precondizione non soddisfatta
        return 0;
    
    l->first =removeNode(l->first, pos);
    l->size--;
    return 1;
}

list clone_list(list l){  //crea un clone della lista

    if(l==NULL){
        return NULL;
    }

    if(emptyList(l)){
        return newList();
    }

    struct node *temp = l->first; //creo un nodo per scorrere la lista
    list lclone=newList(); //dichiaro una lista clone
    lclone->first=make_node(temp->value,NULL); //creo primo nodo
    struct node *temp1=lclone->first; //puntatore all'ultimo nodo di lclone

    while(temp->next!=NULL){
        temp1->next= make_node(temp->next->value, NULL);
        temp=temp->next;
        temp1=temp1->next;
    }

    lclone->size=l->size;
    return lclone;

} 

int delete_list(list l){
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

