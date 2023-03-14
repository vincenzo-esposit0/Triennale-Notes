// file item.c

/* il modulo contiene per ora tre
operatori che useremo nel seguito.
Aggiungerne altri all’occorrenza */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "item.h"

struct esami{
  char nome[25];
  int voto;
};

struct libretto{
  char nome[25];
  char cognome[25];
  char matricola[25];
  struct esame * esame;
  int n_esami=0;
};

int eq(item x, item y) {
  return (strcmp(x->titolo, y->titolo)==0 &&
  strcmp(x->autore, y->autore)==0);
}

item inputLibretto_item() {
 char nome[25];
 char cogn[25];
 char matr[25];
 
 printf("Inserisci il Nome: ");
 scanf("%s \n", nome);
 printf("Inserisci il cognome: ");
 scanf("%s \n", cogn);
 printf("Inserisci la MATRICOLA: ");
 scanf("%s \n", matr);
 return newLibretto(nome,cogn,matr);

}

item inputEsame_item() {
 char nome[25];
 int voto;
 
 printf("Inserisci il Nome: ");
 scanf("%s \n", nome);
 printf("Inserisci il voto: ");
 scanf("%d", voto);

 return newEsame(nome,voto);

}

void output_item(item x) {
  printf("Titolo: %s ", x->titolo);
  printf("Cantante o gruppo: %s ", x->autore);
  printf("Durata: %d \n", x->durata);
}

item newLibretto(char *nome, char *cogn, char *matr)
{
  struct libretto *dati;
  dati = malloc(sizeof(struct libretto));

  if(dati!=NULL)
  {
    strcpy(dati->nome,nome);
    strcpy(dati->cognome,cogn);
    strcpy(dati->matricola,matr);
    dati->n_esami = 0;
  }
}

item newEsame(char *nome, int *voto)
{
  struct esame *esami;
  esami = malloc(sizeof(struct esame));

  if(esami!=NULL)
  {
    strcpy(esami->nome,nome);
    strcpy(esami->voto,voto);
  }
}

char * search_autore(item x) {
  return x->autore;
}

