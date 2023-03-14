/*


ADT Queue: Specifica sintattica 

Tipo di riferimento: queue
Tipi usati: item, boolean

Operatori
newQueue() -> queue
emptyQueue(queue) -> boolean
enqueue(item, queue) -> queue
dequeue(queue) -> item



ADT Queue: Specifica semantica

Tipo di riferimento queue
queue è l’insieme delle sequenze S=a1,a2,…,an di tipo item
L’insieme queue contiene inoltre un elemento nil che rappresenta la coda vuota (priva di elementi)



Operatori
newQueue() -> q
Post: q = nil

emptyQueue(q) -> b
Post: se q=nil allora b = true altrimenti b = false

enqueue(e, q) -> q’
Post: se q = nil allora q’ = <e> altrimenti se q = <a1, a2, … an>  con n > 0 allora q’ = <a1, a2, … an, e >

dequeue(q) -> a
Pre: q = <a1, a2, …, an-1, an>   n>0    (q != nil)
Post: a = a1 e l’elemento a1 viene rimosso da q 


/*
SPECIFICA DEGLI OPERATORI INSERITI DA ME

SPECIFICA SINTATTICA
presenteQ(q,el)-> boolean
xorQ(q1,q2)-> Queue

SPECIFICA SEMANTICA

presenteQ(q,el)-> boolean

La funzione riceve in input una coda ed un elemento;
Scorre tutta la coda:
       se l'elemento ricevuto in input e' prensente nella coda restituisce 1;
       altrimenti se non e' presente restituira' 0.
       
Pre-condizione: q!=nil quindi  q = <a1, a2, … ak>  (la coda deve esistere)
Post-condizione: restituisce un valore boolean che: se quivale a 1 allora l'elemento esiste;
                                         altrimenti se quivale a 0 l'elelemnto non esiste.

xorQ(q1,q2)-> Queue

La funzione riceve in input due code q1 e q2 e restituisce una terza coda Q contenente gli elementi che sono presenti in q1 oppure in q2 ma non in entrambe le code

Post-condizione: q1=<a1,a2,...,an> e q2=<b1,b2,...,bn> code di partenza.
	             Restituice Q=<a1,a2,...,an,..b1,b2,...,bn> con gli elementi della coda q1 e della coda q2 diversi tra loro.

*/


// file queue.h

typedef struct c_queue *queue;

// prototipi

queue newQueue(void);

int emptyQueue(queue q);

item dequeue(queue q); //dequeue toglie e restituisce l’elemento in testa alla coda

int enqueue(item val, queue q); //enqueue restituisce un intero che indica l’esito dell’operazione

// Operatori creati in seguito da me
int numelQueue(queue q); //Prende in input una coda Q e ritorna quanti elementi ci sono nella coda

int printQueue(queue q); //Restituisce il numero di elementi stampati

queue inputQueue(queue q,int n); //Restituisce la coda da stampare

item *copiainvettore(queue q,int *size);

int presenteQ(queue q, item val) //Prende in input una coda ed un item, resituisce un valore boolean il quale se restituira' 1 significa che l'elemento e' presente, altrimenti restituira' 0

queue xorQ(queue q1, queue q2) //Prende in input due code, resituisce una nuova coda Q che conterra' gli elementi della coda q1 oppure gli elementi della coda q2, ma non entrambi
