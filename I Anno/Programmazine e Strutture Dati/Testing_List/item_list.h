#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NULLITEM 0



item input_item(void);		//Permette di prendere in input un item
int eq(item a, item b);		//Restituisce 1 se gli item a e b sono uguali
void output_item(item a);	//Stampa su stdout l'item a
int foutitem (FILE*fout, item a);
item finputitem  (FILE *fin);
