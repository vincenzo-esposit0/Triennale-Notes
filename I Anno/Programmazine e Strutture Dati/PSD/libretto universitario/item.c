// file item.c

/* il modulo contiene per ora tre
operatori che useremo nel seguito.
Aggiungerne altri all’occorrenza */

#include <stdio.h>
#include<stdlib.h>
#include<string.h>
#include "item.h"

struct libretto{
  char esame[25];
  int voto;
  int data[6];
};

/*int eq(item x, item y) {
  return strcmp(x->nome,y->nome)==0;
}*/

item input_item() {
 char esame[25];
 int voto,data[6];
 printf("Inserisci il nome dell'esame: ");
 scanf("%s", esame);
 printf("Inserisci il voto (Compreso tra 18 e 30): ");
 scanf("%d",&voto);
 if(voto<18 || voto>30)
 {
   printf("Voto non vaido!");
   exit(1);
 }
 printf("Inserisci la data nel formato gg/mm/aa (Senza gli /): ");
 for(i=0;i<6;i++)
 {
   scanf("%d", &data[i]);
 }
 return newItem(esame,voto,data);

}

void output_item(item x) {
  printf("Nome esame: %s ", x->nome);
  printf("Voto: %d ", x->voto);
  printf("Data: %d \n", x->data);
}

item newItem(char *esame, int voto, int data[])
{
  struct esame *lib;
  lib=malloc(sizeof(struct esame));

  if(lib!=NULL)
  {
    strcpy(lib->esame,esame);
    lib->voto=voto;
    lib->data=data;
  }
}

char * search_esame(item x) {
  return x->esame;
}
