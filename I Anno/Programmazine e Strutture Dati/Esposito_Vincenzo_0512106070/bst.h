// file BST.h
typedef struct node *BST;

// prototipi
item getItem(struct node *N);
void setItem(struct node *N, item el); 
BST newBST(void);
int emptyBST(BST T);
int contains(BST T, item elem); 
BST figlioSX(BST T);
BST figlioDX(BST T);
BST insert(BST T, item elem);
BST creaFoglia(item elem);
BST minValue(struct node* node);
BST maxValue(struct node* node);
BST deleteNode(BST T, item elem);
list elementiCompresi(BST T, item elem1, item elem2);
list RicercaRicorsiva(BST T, list l, item minimo, item massimo);
BST cancMaggiori(BST T, item elem1);



/* 
ADT bst()

BST: definizione

Se l’albero non è vuoto, allora:
-ogni elemento del sottoalbero di sinistra precede (<) la radice;
-ogni elemento del sottoalbero di destra segue (>) la radice.

I sottoalberi sinistro e destro sono alberi di ricerca binaria.

Specifica Sintattica e Semantica

Tipi: 
-BST: è il nostro albero binario;
-item: elemento.
NULL: è un elemento che viene restituito quando la precondizione di viene violata 

Operatori:
-elementiCompresi(BST, elem1, elem2) restituisce: list

prende in input un albero ed un item, visiona tutto l'albero e quando trova che una radice dell'elemento la elimina per poi richiamare ricorsivamente la stessa fuznione sui nodi destri e sinistri.

                    Precondizione: bst e elem1, elem2 non nulli.
                    Post condizione: se l'elem1 è uguale ad uni degli elementi all'interno dell'albero e se l'elem2 è uguale ad uno degli elementi all'interno dell'albero stampa tutti i valori compresi tra i due item;
                                     altrimenti restituisci la lista vuota.
                    bst = < e1, e2, e3, e4, e5, e6 >  con elem1=e2 ed elem2=e5 
                    il risultato sarà: list1 = <e2, e3, e4, e5> se gli elemnti sono prensenti
                    altrimenti restituisce l'albero senza nessuna modifica.
                    
-RicercaRicorsiva():
                    prende in input un'albero, una lista e due item
                    se la radice e' compresa tra i due item essa verra' inserita all'interno della lista dopodicche' essa si richiamera' ricorsivamente.
                    

-cancMaggiori(BST, elem1) restituisce: BST

                         Precondizione: bst e elem1 non nulli
                         Post condizione: se l'item è uguale ad uno degli elementi prensenti all'nterno dell'albero controlla se ci sono elementi maggiori del valore dell'item e li elimina;
                                          altrimenti restituisce una lista vuota. 
                         BST =  <e1, e2, e3, e4, e5, e6 >  con elem1=e2
                         controlla se vi sono elementi maggiori del valore di elem1 e li elimina
                         Il risultato sara': BST =  <e1, e2, e3, e4 > ho presupposto che elem1 e' minore dell'elemento e5,e6.
                         
*/
