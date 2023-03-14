// file queue.h

typedef struct c_queue *queue;

// prototipi

queue newQueue(void);

int emptyQueue(queue q);

item dequeue(queue q);

int enqueue(item val, queue q);

item copiacodavett(queue q);

queue fondiqueue(queue q1, queue q2);

queue cancdaitem(queue q,item el);

/*
SPECIFICA SEMANTICA

Tipo di riferimento: queue
	-queue è l’insieme delle sequenze S=a1,a2,…,an di tipo item
	-L’insieme queue contiene inoltre un elemento nil che rappresenta la coda vuota (priva di elementi)

Tipi usati: item, boolean

Operatori:
	-newQueue() -> queue
		Post: q = nil
		
	-emptyQueue(queue) -> boolean
		Post: se q=nil allora b = true altrimenti b = false
	
	-enqueue(item, queue) -> queue
		Post: se q = nil allora q’ = <e> altrimenti se q = <a1, a2, … an>  con n > 0 allora q’ = <a1, a2, … an, e >	
	
	-dequeue(queue) -> item
		Pre: q = <a1, a2, …, an-1, an>   n>0    (q != nil)
		Post: a = a1 e l’elemento a1 viene rimosso da q 


