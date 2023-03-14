/*
Un heap è un albero binario con le seguenti proprietà:

1) Proprietà strutturale: 
	quasi perfettamente bilanciato e le foglie a livello h sono tutte addossate a sinistra

2) Proprietà di ordinamento: 
	ogni nodo v ha la caratteristica che l’informazione ad esso associata è la più grande tra tutte le informazioni presenti nel sottoalbero che ha v come radice
	
*/

#include <stdio.h>
#include <stdlib.h>
#include "PQueue.h"
#include "list.h"
#define MAXPQ 50

struct c_PQ {
     int vet[MAXPQ];
     int numel;
};

static void scendi (PQueue q);
static void sali (PQueue q);

PQueue newPQ(void)
{
     PQueue q;
     q = malloc (sizeof(struct c_PQ));
     if (q == NULL) return NULL;
     q->numel = 0;
     return q;
}

int emptyPQ(PQueue q)
{
     if (!q)  return 1;
     return q->numel == 0;
}


int getMax(PQueue q)
{
     return q->vet[1];
     // NON VERIFICA LA
     // PRECONDIZIONE
     // LA CODA NON PUO’
     // ESSERE VUOTA
}

static void scendi (PQueue q)
{
    int temp, n=q->numel, i=1, pos;

    while (1)
    {
       if (2*i+1 <= n)               // IL NODO CORRENTE HA 2 FIGLI
                  pos =  (q->vet[i*2] > q->vet[i*2+1])  ?   i*2  :   i*2+1;		//se il primo elemento nella parentesi e' maggiore del secondo elemento considera i*2
                  																//altrimenti considera l'altro.

       else  if (2*i <= n)          // IL NODO CORRENTE HA 1 FIGLIO
                  pos = 2*i;
       else  break;                  // IL NODO CORRENTE NON HA FIGLI E' FOGLIA
         
       if (q->vet[pos] > q->vet[i])     // SCAMBIO LE CHIAVI E PROSEGUO 
       {
             temp = q->vet[i];
             q->vet[i] = q->vet[pos];
             q->vet[pos] = temp;
             i = pos;
       }
       else
           break;   // NON CI SONO PIU’ SCAMBI DA FARE, MI FERMO 
     }
}

int deleteMax(PQueue q)
{
     if (!q || q->numel==0) return 0;   // CODA VUOTA

     q->vet[1] = q->vet[q->numel];  //SPOSTO L’ULTIMO ELEMENTO
     q->numel --;                               // IN POSIZIONE 1

     scendi(q);      // RIAGGIUSTO LO HEAP SCENDENDO

     return 1;
} 


static void sali (PQueue q)
{
    int temp, pos=q->numel, i=pos/2;

    while (pos>1)
    {
                
       if (q->vet[pos] > q->vet[i])
       {
             temp = q->vet[i];
             q->vet[i] = q->vet[pos];
             q->vet[pos] = temp;
             pos = i;
             i = pos/2;
       }
       
       else
             break;
     }
}

int insert (PQueue q, int key)
{

     if (!q || q->numel==MAXPQ) return 0; // CODA PIENA 

     q->numel++;
     q->vet[q->numel] = key;   // INSERISCI IN ULTIMA POSIZIONE
     
     sali(q);     // AGGIUSTA LO HEAP RISALENDO

     return 1;
} 

list estraiHeap(PQueue q, int k)	//funzione che inserisce nella lista l gli elementi >= a K 
{
	list l=newList();
	int i, pos=0;
	
	for(i=1;i<=q->numel;i++)
	{
		if(k>=q->vet[i])		//controlla se k e' maggiore o uguale dell'elemento della coda
		{
			insertList(l,pos,q->vet[i]);		//inserimento valori maggiori di k
			pos++;
		}
	}
}

PQueue copia(PQueue q)	//funzione che copia la coda in una variabile temporanea
{
	int i;
	PQueue temp=newPQ(void);
	
	if(emptyPQ(PQueue q))	//controlla se la lista e' vuota
	{
		return -1;
	}
	
	for(i=1;i<=q->numel;i++)	//esegue la copia
	{
		insert (temp->vet[i], q->vet[i]);
	}
	
	return temp;
}

list listkeys(PQueue q)		//funzione che 
{
	PQueue temp=copia(q);
	list f=newlist();
	int i, elem,pos=0;
	for(i=1;i<=temp->numel;i++)
	{
		if(i==temp->numel)		//controllo per coda di un solo elemento o coda arrivata alla fine
		{
			insertlist(f,pos,temp->vet[i]);
		}
		
		else if(temp->vet[i]>=temp->vet[i+1])		//controlla tra valori
		{
			insertlist(f,pos,temp->vet[i]);			//inserisce nella lista l'elemento con chiave maggiore
			pos++;
		}
		
		else		//esegue l'inserimento del secondo elemento confrontato poiche' dal precendete controllo e' stato inserito il primo elemento del confronto
		{
			insertlist(f,pos,temp->vet[i+1]);
			pos++;
			temp->vet[i+1]=temp->vet[i];		//spostamento dell'elemento piu' piccolo prima confrontato
		}
	}

}


