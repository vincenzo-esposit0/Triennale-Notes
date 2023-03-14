// file item.c

/* il modulo contiene per ora tre
operatori che useremo nel seguito.
Aggiungerne altri all’occorrenza */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "item.h"

struct song {
  char autore[25];
  char titolo[25];
  int durata;
};

int eq(item x, item y) {
  return (strcmp(x->titolo, y->titolo)==0 &&
  strcmp(x->autore, y->autore)==0);
}

item input_item() {
 char tit[20];
 char aut[20];
 int dur;
 printf("inserisci il cantante o il gruppo: ");
 scanf("%s", tit);
 printf("inserisci titolo della canzone: ");
 scanf("%s", aut);
 printf("inserisci la durata: ");
 scanf("%d", &dur);
 return newItem(aut,tit,dur);

}

void output_item(item x) {
  printf("Titolo: %s ", x->titolo);
  printf("Cantante o gruppo: %s ", x->autore);
  printf("Durata: %d \n", x->durata);
}

item newItem(char *autore, char *titolo, int durata)
{
  struct song *playlist;
  playlist = malloc(sizeof(struct song));

  if(playlist!=NULL)
  {
    strcpy(playlist->autore,autore);
    strcpy(playlist->titolo,titolo);
    playlist->durata = durata;
  }
}

char * search_autore(item x) {
  return x->autore;
}
