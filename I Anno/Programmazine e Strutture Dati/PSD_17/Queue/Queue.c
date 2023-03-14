/*
Implementazione della queue con liste collegate
per gestire la politica FIFO conviene avere accesso sia al primo elemento (estrazione) sia all’ultimo (inserimento).

Il tipo queue è definito come un puntatore ad una struct che contiene 
-Un intero numelem che indica il numero di elementi della coda
-Un puntatore head ad uno struct nodo
-Un puntatore tail ad uno struct nodo

*/

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

queue newQueue(void)		//funzione che crea una nuova coda
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

int enqueue(item val, queue q)	//funzione che aggiunge elementi
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
ELIMINAZIONE

1) Bisogna prima salvare il puntatore al nodo da eliminare (quello puntato da head)
   Head dovrà quindi puntare al successivo
2) A questo punto si può deallocare la memoria del nodo da rimuovere
Se la coda aveva un solo elemento, ora è vuota, per cui bisogna porre anche il puntatore tail a NULL

*/

item dequeue(queue q)		//funzione che elimina un nodo
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

/*
-copiacodavett(q) -> vettore
		Precondizione: coda esistente (q!=nil)
		Post-condizione: elementi della coda copiati all'interno del vettore 
*/

item copiacodavett(queue q)		//copia degli item di queue in vettore item
{                
	if(q->numel==0){
		printf("La coda è vuota");
		return -1;							//se la coda è vuota esce e ritorna meno 1
	}
	item *vit;                              //vettore di item
	int i=0, j;
	j=q->numel;
	vit=malloc(sizeof(item));               //allocazione di vettore item
	while(q->head!= NULL){                  //finchè head!=NULL
		vit[i]=dequeue(q);                     //copia nel vettore
		i++;
	}
	
	for(i=0;i<=j;i++){                      //ciclo per ristabilire q
		enqueue(vit[i],q);                      //reinserimento degli elementi in q
	}
	
	return vit;
}

/*
-fondiqueue(q1, q2) -> q3
		Precondizione: q1 e q2 esistenti (q!=nil)
		Post-condizione: q1=<a1, a2, … an> e q2=<b1, b, … bn> copiati in q3=<a1, a2,… an, b1, b,… bn> con gli elementi di q1 != elementi di q2
*/

queue fondiqueue(queue q1, queue q2) 	//fondi 2 code senza ripetizione di elementi
{                         
	int i=0;
	int j=0;
	int flag;
	queue q3=newqueue();                          //creo nuova coda 
	item *v1=copiacodavett(q1);						//creo vettore prima coda
	item *v2=copiacodavett(q2);						//creo vettore seconda coda
	for(i=0;i<=q1->numel;i++){						//copio il primo vettore nella coda fusa
		enqueue(v1[i],q3);
	}
	for(i=0;i<=q2->numel;i++){						//controllo ogni elemento del secondo vettore copia con ogni elemento del primo
		flag=0;
		for(j=0;q1->numel;j++){                     //controllo effettivo
			if(v2[i]==v1[j]){
				flag++;								//aumento flag per vedere se esiste un valore uguale ad un altro	
			}			
		}
	if(flag==0){									//se flag è diverso da zero non inserisce l'elemento nella nuova coda
		enqueue(v2[i],q3);
		}
	}
	return q3;
}

/*
-cancdaitem(q, el) -> q
		Precondizione: q esistente ed el esistente nella coda (q!=nil)
		Post-condizione: q1=<a1, a2, el, a3, a4, a5>; se esiste l'elemento: elimina tutti gli elementi successivi ad el q1=<a1, a2, el>, 
						altrimenti non svolgere nessuna operazione.
*/

queue cancdaitem(queue q,item el){					//cancella da elemento item in poi 
	int i=0, j;			
	int pos,flag=0;
	item *v;
	j=q->numel;
	for(i=0;i<=j;i++){
		v[i]=dequeue(q);							//libera q dagli elementi	
		if(v[i]==el){								//controlla l'esistenza dell'elemento
			pos=i;
			flag=1;									//flag indica la presenza o meno di esso
		}
	}
	if(flag==1){
		while(i<=pos){
		enqueue(v[i],q);							//reinserisce gli elementi fino ad el incluso in q
		i++;
		}
		printf("Il valore è stato trovato!!!");
	}else{
		while(i<=j){
			enqueue(v[i],q);						//reinserisce tutti gli elementi visto che el non è presente in q
			i++;
		}
		printf("Il valore da lei cercato è inesistente");
	}
	return q;
}

