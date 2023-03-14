// file PQueue.h

typedef struct c_PQ *PQueue;

// prototipi

PQueue newPQ(void);

int emptyPQ(PQueue q);

int getMax(PQueue q);

int deleteMax(PQueue q);

int insert (PQueue q, int key);

/*
SPECIFICA SEMANTICA

TIPI:  

	1) PRIORITYQUEUE= insieme delle code a priorità, dove: v appartenete a PRIORITYQUEUE  (coda vuota) 

	2) BOOLEAN = {vero, falso}

	3) ITEM = (K x V) è l’insieme delle coppie (k, v) con k appartenete a K e v appartenete a V

		- K è un insieme qualsiasi non vuoto sul quale è definita una relazione d’ordine =

		- V è un insieme qualsiasi non vuoto
		
OPERATORI:

	1) newPQ ( ) = PQ
		pre: 
		post:  PQ = v

	2) emptyPQ (PQ) = v
		pre:
		post:  se PQ è vuota, allora v = vero, altrimenti v = falso
 	
	3) getMax (PQ) = elem
		pre: PQ non è vuota
		post:  elem è la entry con la massima priorità fra quelle contenute in PQ 

	4) deleteMax (PQ) = PQ’
		pre: PQ non è vuota
		post:  PQ’ contiene tutte le entry di PQ tranne quella con massima priorità

	5) insertPQ (PQ, elem) = Q’
		pre:
		post: PQ’ contiene elem e tutte le entry contenute in PQ 
		
	Gli operatori insert() e deleteMax() restituiscono un valore 0 se l’operazione fallisce, 1 se termina con successo




