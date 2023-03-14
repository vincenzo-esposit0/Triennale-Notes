/* File: item.c
 * Implementazioni del tipo di dato item e dei suoi operatori.
 * 
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"item.h"

struct brano{
	char tit[30];
	char aut[30];
	float time;
};

item newItem(char* tit, char *aut, int durata)
{
	struct brano* e = malloc(sizeof(struct brano));
	if(e != NULL)
	{
		strcpy(e->tit, tit);
		strcpy(e->aut, aut);
		e->time = time;
	}
	return e;
}

char *cantante (item x)
{
     char *cant;
     cant = malloc (30 * sizeof(char));
     if (!cant)  return NULL;
     strcpy(cant, x->aut);
     return cant;
}

int eq(item x, item y)	// Confronta due stringhe(i nomi degli esami);
{
	return strcmp(x->aut, y->aut);
}


item input_item()
{
	char tit[30];
	char aut[30];
	float time;
	printf("Inserire nome del brano: ");
	scanf("%s", tit);
	printf("Inserire nome dell'autore: ");
	scanf("%s", aut);
	printf("Inserire durata in secondi: ");
	scanf("%f", &time);
	
	return newItem(tit, aut, time);
}


void output_item(item x)
{
	printf("Titolo: %s\n", x->tit);
	printf("Autore: %s\n", x->aut);
	printf("Durata: %f.\n\n", x->time);
}
