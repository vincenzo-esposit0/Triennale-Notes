// File queue.c (versione con lista collegata)

#include <stdio.h>
#include <stdlib.h>
#include "item.h" 
#include "queue.h"

struct node {
     item value;
     struct node *next;
};

struct c_queue {
     struct node *head,*tail;
     int numel;
};

queue newQueue(void)
{
     struct c_queue *q;
     q = malloc (sizeof(struct c_queue));
     if (q == NULL) 
	return NULL;

     q->numel = 0;
     q->head = NULL;
     q->tail = NULL;
     return q;
} 

int emptyQueue(queue q)
{
     if (q==NULL)
            return -1;
     return q->numel == 0;
}

/*
Inserire un item in coda

Dobbiamo innanzitutto creare un nuovo nodo a cui dovrà puntare il puntatore tail
Poi bisogna distinguere il caso in cui la coda di input è vuota e il caso in cui non è vuota
	- Coda vuota: il puntatore head dovrà puntare al nuovo nodo 
	- Coda non vuota: il puntatore next dell’ultimo nodo dovrà puntare a nuovo
*/


int enqueue(item val, queue q)
{
    if (q==NULL)
            return -1;

    struct node *nuovo;
    nuovo = malloc (sizeof(struct node));
    if (nuovo == NULL) return 0;

    nuovo->value = val;
    nuovo->next= NULL;

    if(q->head==NULL)
         q->head = nuovo;         //  caso coda vuota
    else 
         q->tail->next= nuovo;  //  caso coda non vuota

    q->tail = nuovo;                // tail punta al nuovo nodo
    (q->numel)++;                   // incrementare il numero di elementi
    return 1;     
}

/* 
Rimuovere elemento da coda

Bisogna prima salvare il puntatore al nodo da eliminare (quello puntato da head)
Head dovrà quindi puntare al successivo
A questo punto si può deallocare la memoria del nodo da rimuovere
Se la coda aveva un solo elemento, ora è vuota, per cui bisogna porre anche il puntatore tail a NULL
*/

item dequeue(queue q)
{
      if (q==NULL) return NULLITEM;

      if (q->numel == 0) return NULLITEM;    //  coda vuota

      item result = q->head->value;   //  item da restituire

      struct node *temp = q->head;   //  nodo da rimuovere
     
      q->head = q->head->next;        // q->head avanza
      free(temp);                 // liberiamo memoria nodo da rimuovere

      if(q->head==NULL)   // se la coda conteneva un solo elemento
             q->tail=NULL; 
      
      (q->numel)--;

      return result;
}

int numelQueue(queue q)
{
	return q->numel;
}

int printQueue(queue q){

	int i;
	
	if(emptyQueue(q)){

		printf("Impossibile stampare una coda vuota!\n");
		return 0;

	}

	struct node *curr;
	curr=q->head;
	for(i=0; i<q->numel; i++){
		if(curr!=NULLITEM){
			output_item(curr->value);
			printf(" ");
			curr=curr->next;
		}
	}
return 1;
}

queue inputQueue(queue q,int n){

	int i=0;
	item val;
	while(i<n){
		printf("digita valore:\n");
		input_item(&val);
		printf("\n");
		enqueue(val,q);
		i++;
	}

	return q;

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

item *copiainvettore(queue q,int *size)
{
	item *vet;
	
	vet=malloc(q->numel*sizeof(item));
		
	int i;
	
	*size=q->numel; //Parametro output
	
	int n=q->numel;
	
	for(i=0;i<q->numel;i++)
	{
		item x=dequeue(q);
		vet[i]=x;
	}
	
	for(i=0;i<*size;i++)
	{
		enqueue(vet[i],q);
	}
	
	return vet;
	
}

/* PROGETTAZIONE

presenteQ(q,el)-> boolean

La seguente funzione riceve in input una coda ed un item, restituisce in output un boolean

1) Controllo le precondizioni: se la coda q e' vuota, restituisco NULL

2) Utilizzo una variabile temporanea per far scorrere la coda
	
3) Scorro la coda per confrontare gli elementi con l'item ricevuto in input
   - Utilizzo una variabile temporanea che punta al primo nodo della coda, per scorrere la coda
   - Confronto gli elementi della coda con l'item ricevuto in input:
               1. se uno degli elementi della coda risultera' uguele all'item restituisce 1
   - Fin quando non ho controllato tutta la coda e i confronti non produrrano risultati assegno alla varibile temp= temp->next
   
4) Se i confronti non hanno riscontrato nessun elemento della coda uguele all'item ricevuto in input 
               2.restituisce 0.
      
*/

int presenteQ(queue q,item val)
{
	if(q==NULL)
	return 0;
		
	struct node *temp= q->head;     //nodo temporaneo
	
	while(temp!=NULL)
	{
		if(eq(temp->value,val))     //confronto dei valori della coda con l'item
		{
			return 1;
		}
		
		temp=temp->next;
	}
	
	return 0;
}

/* PROGETTAZIONE

xorQ(q1,q2)-> Q

La funzione riceve in input q1 e q2 e restituisce in output una coda Q contenente gli elementi che sono presenti in q1 oppure in q2 ma non in entrambe le code

1) Controllo le precondizioni: 
             1. se q1, q2 sono vuote, restituisco la coda Q vuota
             2. se una delle due code non esiste la coda Q sara' uguale ad una coda esistente

2) Crea una terza coda Q che conterra' gli elementi che sono presenti in q1 oppure in q2, ma non in entrambe le code
   (Come richiede la traccia)

3) Scorro la coda per confrontare gli elementi della coda q1 con gli elementi della coda q2
   - Utilizzo una variabile temporanea che punta al primo nodo della coda q1, per scorrere la coda
   - Confronto tramite la funzione presenteQ() gli elementi della coda q1 con gli elementi della coda q2:
               1. se l'elemento della coda  q1 non risultera' uguale ad un elemento della coda q2:
                     -utilizzo la funzione enqueue la quale inserira' l'elemento della coda q1 nella coda Q
               2. aggiorno la posizione della varibiale temporanea temp1= temp1->next

4) Scorro la coda per confrontare gli elementi della coda q2 con gli elementi della coda q1
   - Utilizzo una variabile temporanea che punta al primo nodo della coda q2, per scorrere la coda 
   - Confronto tramite la funzione presenteQ() gli elementi della coda q2 con gli elementi della coda q1:
               1. se l'elemento della coda  q2 non risultera' uguale ad un elemento della coda q1:
                     -utilizzo la funzione enqueue la quale inserira' l'elemento della coda q2 nella coda Q
               2. aggiorno la posizione della varibiale temporanea temp2= temp2->next

5) Poiche' ho controllato sia q1 sia q2:
           1. Restituisco la coda Q.
   

*/

queue xorQ(queue q1, queue q2)
{
      queue Q=newQueue();     //creazione della coda che conterra' gli elementi di q1 e q2, ma non entrambi
      
      if(q1==NULL || q2==NULL)
	  return 0;
      
      struct node *temp1= q1->head;
      struct node *temp2= q2->head;
      
      if(temp1==NULL)
      {
                     while(temp2!=NULL)
                     {
                          enqueue(temp2->value,Q); 
                          temp2= temp2->next;
                     } 
      }
      
      if(temp2==NULL)
      {
                     while(temp1!=NULL)
                     {
                          enqueue(temp1->value,Q); 
                          temp1= temp1->next;
                     } 
      }            
                 
     
	 
	 while(temp1!=NULL)
	 {
                    if(presenteQ(q2,temp1->value)==0)
                    {
                                                  enqueue(temp1->value,Q);                             
                    }
                    
                    temp1= temp1->next;
     }
     
     while(temp2!=NULL)
	 {
                    if(presenteQ(q1,temp2->value)==0)
                    {
                                                  enqueue(temp2->value,Q);                              
                    }
                    
                    temp2= temp2->next;
     }
     
     return Q;
}
	 
      
