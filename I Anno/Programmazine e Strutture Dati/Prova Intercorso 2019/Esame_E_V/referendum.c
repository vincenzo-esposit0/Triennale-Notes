#include <stdio.h>
#include <stdlib.h>
#include "item.h" 
#include "list.h"
#include "referendum.h"

#define N 5


/*
-CompletRef(referendum) restituisce: referendum
                        
                        1. Calcolo della lista dei seggi con l'uso dell'operatore getitem;
                        2. Confronto del valore ottenuto con il valore di partenza N;
                        3. Restituzione di TRUE se i due valori sono uguali, di FALSE altrimenti se non sono uguali.
                        
                        Precondizione: controllare che la lista esiste e  sia completa, dopodicchè otteniamo il valore del numero di seggi presenti all'interno della lista il quale viene ottenuto da sizeList
                        Post condizione: se il numero_seggi==N restituisci 1 altrimenti restituisci 0.
*/

int completRef(referendum ref)
{
    if (ref==NULL || sizelist(ref)!=N) return 0;
    return 1;
}

/*
-stampaReport(referendum) restituisce: referendum

                          1. Controllo dell'esistenza della lista;
                          2. Calcoloro del totale dei votanti, di schede nulle o bianche, di voti si, di voti no attravereso l'utilizzo dell'operatore getitem.
                          2. Stampa dei valori ottenuti.
                          
                          Precondizione: controllare che la lista esiste e  non sia vuota, dopodicchè otteniamo il totale dei valori dei votanti, di schede nulle o bianche, di voti si, di voti no .
                          Post condizione: Stampa i valori ottenuti.
*/                          
                          
void stampaReport(referendum ref)
{
     int vot=0, voti__nul=0, voti__si=0, voti__no=0;
     int i;
     if(completRef(ref)==0) printf("Errore\n");
     else {
          for(i=0;i<N;i++)
             {
             vot+=votanti(getItem(ref,i));
             voti__nul+=voti_nulli(getItem(ref,i));
             voti__si+=voti_si(getItem(ref,i));
             voti__no+=voti_no(getItem(ref,i));
             }
             
          printf("Totale Voti: %d\n",vot);
          printf("Totale Voti Nulli: %d\n",voti__nul);
          printf("Totale Si: %d\n",voti__si);
          printf("Totale No: %d\n",voti__no);
     }
}
          
