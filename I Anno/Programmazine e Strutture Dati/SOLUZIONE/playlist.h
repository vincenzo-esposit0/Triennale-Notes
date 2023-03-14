/* File: playlist.h
 * ADT playlist
 * Specifica sintattica:
 * 		Tipo di riferimento: playlist
 *		Tipi di dati usati: item, boolean, int, stringa di caratteri.
 * Specifica semantica: 
 * 		playlist = elenco di canzoni, ognuna composta da tre campi: titolo, nome del cantante/gruppo e durata in secondi.
 *
 * Implementazione: playlist = lista(tipo list).
 					item = brano, record con 3 campi: titolo(stringa), autore(stringa) e durata(float).
 */

#include"item.h"
#include"listc.h"

typedef list playlist;


// Specifica operatori:
/* newPlist: crea una nuova playlist.
 * Specifica sintattica:
 * 		newPlist(void) -> playlist
 * 
 * Specifica semantica:
 * 		newPlist() -> p
 * 			post: p = playlist vuota, lista vuota.
 * 	
 */

playlist newPlist();


/* addTail: aggiunge un brano in coda alla playlist
 * Specifica sintattica:
 * 		addTail(item, playlist) -> boolean
 * 
 * Specifica semantica:
 * 		addTail(song, playlist) -> b
 * 			pre: song = item non nullo
 * 			post: b = TRUE se l'inserimento è effettuato correttamente, altrimenti b = FALSE
 */

int addTail(item song, playlist p);


/* removeSong: rimuove un brano dalla playlist data la sua posizione
 * Specifica sintattica:
 * 		removeSong(int, playlist) -> boolean
 * Specifica semantica:
 * 		removeSong(pos, p) -> b
 * 			pre: 0 < pos <= sizeList(p) AND p = definita.
 * 			post: b = TRUE in caso di corretta rimozione, b = FALSE in caso di fallimento.
 */
int removeSong(int pos, playlist p);


/* forwardSong: spostamento alla posizione successiva di una canzone in posizione pos.
 * Specifica sintattica: 
 * 		forwardSong(int, playlist) -> boolean
 * Specifica semantica:
 * 		forwardSong(pos, p) -> b
 * 			pre: 0 < pos <= (sizeList(p)-1)
 * 			post: b = TRUE se il brano è correttamente spostato alla posizione pos+1, altrimenti b = FALSE.
 */
int forwardSong(int pos, playlist p);


/* backSong: spostamento alla posizione precedente di una canzone in posizione pos.
 * Specifica sintattica: 
 * 		backSong(int, playlist) -> boolean
 * Specifica semantica:
 * 		backSong(pos, p) -> b
 * 			pre: 1 <= pos <= sizeList(p)
 * 			post: b = TRUE se il brano è correttamente spostato alla posizione pos-1, altrimenti b = FALSE.
 * 
 */
int backSong(int pos, playlist p);



/* subPlist: restituisce una playlist contenente solo i brani con uno stesso autore(nome dell'autore ricevuto in input)
 * Specifica sintattica:
 * 		subPlist(char *, playlist) -> playlist
 * Specifica semantica:
 * 		subPlist(autore, p) -> p1
 * 			pre: autore: nome dell'autore non nullo(non stringa vuota)
 * 			post: p1 = elenco dei brani presenti in p che presentano il nome dell'autore = autore(parametro di input).
 * 
 */
playlist subPlist(char *autore, playlist p);



/* printfPlist: stampa a video la playlist ricevuta in input.
 * Specifica sintattica:
 * 		printPlist(playlist) -> boolean
 * Specifica semantica:
 * 		printPlist(p) -> b
 * 			pre: p = non nulla(non indefinita)
 * 			post: b = TRUE in caso di corretta stampa, altrimenti b = FALSE
 * 
 */
int printPlist(playlist p);
