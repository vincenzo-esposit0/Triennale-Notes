// file item.c

/* il modulo contiene per ora tre
operatori che useremo nel seguito.
Aggiungerne altri all occorrenza */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "item.h"

struct seggio {
  int n_ident;
  int aventi_diritto;
  int votanti;
  int voti-nulli;
  int voti_si;
  int voti_no;
};

int eq(item x, item y) {
  if (x->n_ident==y->n_ident) return 0;
  return -1;
}

item input_item() {
 int n,ad,v,vnul,vs,vn;
 printf("Numero identificativo : %d \n", x->n_ident);
 scanf("%d",&n);
 printf("Aventi diritto al voto: %d \n", x->aventi_diritto);
 scanf("%d",&ad);
 printf("Numero votanti: %d \n", x->votanti);
 scanf("%d",&v);
 printf("Numero voti nulli/bianchi: %d \n", x->voti_nulli);
 scanf("%d",&vnul);
 printf("Numero voti SI: %d \n", x->voti_si);
 scanf("%d",&vs);
 printf("Numero voti NO: %d \n", x->voti_no);
 scanf("%d",&vn);
}
 return newItem(n,ad,v,vnul,vs,vn);

}

void output_item(item x) {
  printf("Numero identificativo: %d \n", x->n_ident);
  printf("Aventi diritto al voto: %d \n", x->aventi_diritto);
  printf("Numero votanti: %d \n", x->votanti);
  printf("Numero voti nulli/bianchi: %d \n", x->voti_nulli);
  printf("Numero voti SI: %d \n", x->voti_si);
  printf("Numero voti NO: %d \n", x->voti_no);
}

item newItem(int n,int ad,int v,int vnul,int vs,int vn)
{
  struct seggio *scheda;
  scheda = malloc(sizeof(struct seggio));

  if(scheda!=NULL)
  {
    scheda->n_ident = n;
    scheda->aventi_diritto = ad;
    scheda->votanti = v;
    scheda->voti_nulli = vnul;
    scheda->voti_si = vs;
    scheda->voti_no = vn;
  }
}

char * search_autore(item x) {
  return x->autore;
}

int votanti(item x)
{
    return x->votanti;
}

int voti_nulli(item x)
{
    return x->voti_nulli;
}

int voti_si(item x)
{
    return x->voti_si;
}

int voti_no(item x)
{
    return x->voti_no;
}
