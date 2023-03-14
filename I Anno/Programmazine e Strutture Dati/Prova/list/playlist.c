/* File: playlist.c
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"item.h"
#include"list.h"
#include"playlist.h"


// Progettazione Operatori:

/* newPlist:
 *		1. Creazione e restituzione della nuova playlist vuota.
 *				Creazione della lista attraversol'operatore newList
 *
 */
playlist newPlist()
{
	playlist p = newList();
	
	return p;
}



/* addTail:
 *		1. Calcolo della dimensione della playlist
 *				Uso dell'operatore per le liste sizeList.
 *		2. Inserimento del nuovo brano(item) in coda.
 *				Uso dell'operatore insertList.
 *		3. Restituzione di TRUE se l'inserimento è stato effettuato correttamente, 
 *              di FALSE altrimenti.
 *
 */
int addTail(item song, playlist p)
{
	if(p == NULL)	// playlist indefinita.
		return 0;
	
	int end = sizeList(p);	// Calcolo della posizone in coda alla lista.
	if(insertList(p, end, song) == 1)	// Inserire nuovo brano(item) in coda alla lista e verifica del corretto inserimento.
		return 1;
	else 
		return 0;
}


/* removeSong:
 * 		1. Verifica sulla validità di pos.(compresa tra 0 e la grandezza della playlist.)
 * 		2. Rimozione del brano(item) in posizione pos attraverso l'operatore per le liste removeList.
 * 		3. In caso di successo restituzione di TRUE in caso di fallimento restituzione di FALSE.
 */
int removeSong(int pos, playlist p)
{
	if(p == NULL)	// playlist indefinita.
		return 0;
	
	if((pos < 0) ||(pos > sizeList(p)))
		return 0;
	
	return removeList(p, pos); 	// Rimozione dell'elemento in posizione pos e restituzione di 1 o 0 in base alla corretta eliminazione.
}



/* forwardSong
 * 		1. Controllo sulla validità di pos.
 * 		2. Ottenimento temporaneo del brano(item) in posizione pos attraverso 
 *          la funzione getItem.
 * 		3. Rimozione dell'elemento in posizione pos dalla playlist attraverso 
 *          la funzione removeList.
 * 		4. Inserimento del brano prelevato precedentemente in posizione pos+1 
 *          della playlist.
 * 		5. Restituzione di 1 in caso di successo o di 0 in caso di fallimento.
 */
int forwardSong(int pos, playlist p)
{
	if(p == NULL)	// playlist indefinita.
		return 0;
	
	if((pos < 0) || (pos > (sizeList(p)-1)))
		return 0
	
	item temp;	// Item temporaneo per lo spostamento nella nuova posizione.
	temp = getItem(p, pos);
	if(removeList(p, pos) == 0)
		return 0;	// Fallimento della rimozione.
	if(insertList(p, pos+1, temp) == 0)
		return 0; 	// Fallimento dell'inserimento nella nuova posizione.
	
	return 1;	// Corretto inserimento nella nuova posizione.
}



/* backSong
 * 		1. Controllo sulla validità di pos.
 * 		2. Ottenimento temporaneo del brano(item) in posizione pos attraverso la funzione getItem.
 * 		3. Rimozione dell'elemento in posizione pos dalla playlist attraverso la funzione removeList.
 * 		4. Inserimento del brano prelevato precedentemente in posizione pos-1 della playlist.
 * 		5. Restituzione di 1 in caso di successo o di 0 in caso di fallimento.
 * 
 * 
 */
int backSong(int pos, playlist p)
{
	if(p == NULL)	// playlist indefinita.
		return 0;
	
	if((pos < 1) || (pos > sizeList(p)))
		return 0;
	
	item temp;	// Item temporaneo per lo spostamento nella nuova posizione.
	temp = getItem(p, pos);
	if(removeList(p, pos) == 0)
		return 0;	// Fallimento della rimozione.
	if(insertList(p, pos-1, temp) == 0)
		return 0; 	// Fallimento dell'inserimento nella nuova posizione.
	
	return 1;	// Corretto inserimento nella nuova posizione.
}



/* subPlist
 * 		1. Creazione di una nuova playlist(attraverso l'operatore newPlist).
 * 		2. Finché la playlist ricevuta in input non è vuota(ciclo da i = 0 a i = sizeList(p)):
 *				Prelevamento dell'elemento in posizione i dalla playlist ricevuta in input.
 * 				Confronto con la stringa autore ricevuta in input del campo autore dell'elemento estratto(operatore eq del modulo item).
 * 				In caso coincidono aggiunta dell'elemento estratto in coda alla nuova playlist(attraverso l'operatore addTail definito precedentemente nel modulo).
 * 		3. Restituzione della nuova playlist.
 */
playlist subPlist(char *autore, playlist p)
{
	item el; 	
	char *au;
	if(p == NULL)	// playlist indefinita.
		return NULL;
	
	playlist p1 = newPlist();	// Creazione della nuova playlist(subplaylist da restituire).
	if(p1 == NULL)	// playlist indefinita.
		return NULL;
	
	item temp;		// item temporaneo per l'estrazione degli elementi dalla playlist p e l'inserimento nella playlist p1..
	int i;		// i = indice di scorrimento di p;
	int end = sizeList(p);
	for(i = 0; i < end; i++)
	{
		temp = getItem(p, i);
		au = cantante (temp);
		if(strcmp(autore, au)==0)	// se i campi autore di temp e riferimento coincidono.
			addTail(temp, p1);	// Inserimento in coda
	}
	
	return p1;
}



/* printPlist
 * 		1. Controllo dell'esistenza della playlist
 * 		2. Stampa della playlist attraverso l'operatore outputList del modulo listc
 */
int printPlist(playlist p)
{
	if(p == NULL)
		return 0;
	
	return outputList(p);
}
