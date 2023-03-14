#include <stdio.h>
#include <stdlib.h>
#include "item.h" 
#include "queue.h"


int main(int argc, char *argv[]) 
{
	int i,n;
	item x;
	
	queue q=newQueue();

	printf("Quanti elementi vuoi inserire nella coda?\n");
	scanf("%d",&n);
	
	q=inputQueue(q,n); //Inserisco gli elementi nella coda
	
	//CANCELLARE DALLA CODA L'ELEMENTO MASSIMO TRA N ELEMENTI DATI DA INPUT
	
	item max=estraiMaxN(q,n);
	
	printf("L'elemento massimo fra %d elementi della coda e' ",n);
	output_item(max);
	
	printf("\n\n\n");
	
	
	printf("Stampa degli elementi nella coda senza %d\n",max);
	
	printQueue(q);
	
	printf("\n\n\n");
	
	

   //INSERIRE UN ELEMENTO PRIMA DEL MINIMO FRA GLI UTLIMI N ELEMENTI, DOVE N E' STATO IN INPUT
	
	printf("Reinserisci gli elementi nella nuova coda\n");
	
	queue q1=newQueue(); //Nuova coda
	item el;
	
	q1=inputQueue(q,n); //Inserimento degli elementi nella nuova coda
	
	printf("Inserisci l'elemento da aggiungere prima del minimo tra gli ultimi n elementi\n");
	input_item(&el);
		
	q1=inserMin(q1,el,2);
	
	printf("Stampa degli elementi nella coda con l'aggiunta dell'elemento %d\n",el); 
    
	printQueue(q1);

	
	system("pause");
}
