/* ADT referendum()

Specifica Sintattica e Semantica

Tipi: 
-Referendum: è l’insieme delle sequenze di n item, con N>= 0;
-Schede: insieme di elementi.
NULLITEM: è un elemento che viene restituito quando la precondizione di getFirst viene violata 

Operatori:
-newRef() restituisce: referendum 

           1. Creazione e restituzione della nuova list vuota.
           2. Creazione della lista attraverso l'operatore newList.

-InserSeggio(referendum, item) restituisce: referendum

                         1. Calcolo della dimensione della lista referendum con l’uso dell'operatore per le liste sizeList;
                         2. Inserimento di un nuovo item in coda con l’uso dell'operatore insertList;
                         3. Restituzione di TRUE se l'inserimento è stato effettuato correttamente, di FALSE altrimenti produce una nuova lista con l’inserimento del nuovo item.
                         
                         Precondizione: item =! NULLITEM per non inserire item nulli all’interno della lista.
                         Post condizione: list = < e1, e2, ..., en > con n >=0 il risultato sarà: list1 = < e1, e2, ..., en, el > con n >=0 notiamo ch è stato aggiunto in coda l'item el.

-CompletRef(referendum) restituisce: 
                        
                        1. Calcolo della lista dei seggi con l'uso dell'operatore getitem;
                        2. Confronto del valore ottenuto con il valore di partenza N;
                        3. Restituzione di TRUE se i due valori sono uguali, di FALSE altrimenti se non sono uguali.
                        
                        Precondizione: controllare che la lista esiste e non sia vuota, dopodicchè otteniamo il valore del numero di seggi presenti all'interno della lista
                        Post condizione: se il numero_seggi==N restituisci 1 altrimenti restituisci 0.
                        
-nosiRef(referendum) restituisce:
                     
                     1. Calcolo dei voti complessivi;
                     2. Suddivisione dei voti in si e no;
                     3. Confronto dei due valori ottenuti;
                     3. Restituzione di TRUE se si>no, altrimenti restituzione di FALSE se si<no.
                     
                      Precondizione: controllare che la lista esiste e non sia vuota, dopodicchè otteniamo il valore dei si e dei no.
                      Post condizione: se il si>no restituisci 1 altrimenti restituisci 0.
                      
-stampaReport(referendum) restituisce: referendum

                          1. Controllo dell'esistenza della lista;
                          2. Calcoloro del totale dei votanti, di schede nulle o bianche, di voti si, di voti no.
                          2. Stampa dei valori ottenuti.
*/

typedef struct referendum* referendum;


referendum newRef(void);
referendum inserSeggio(item s, list l);
int stampaReport(list l);
