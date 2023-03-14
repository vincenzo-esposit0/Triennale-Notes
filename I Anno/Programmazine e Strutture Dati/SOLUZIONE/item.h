/* File: item.h
 * Interfaccia del tipo generico item.
 * Definisce il tipo item.
 */


#define NULLITEM NULL

typedef struct brano* item;


item newItem(char* tit, char *cant, int durata);


int eq(item x, item y);	// Confronta due stringhe(i nomi dell'autore del brano);


item input_item();


void output_item(item x);

char *cantante (item x);
