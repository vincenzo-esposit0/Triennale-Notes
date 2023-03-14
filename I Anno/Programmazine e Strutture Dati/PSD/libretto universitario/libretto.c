#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "item.h"
#include "list.h"

struct libretto
{
  char nome[25];
  char cogn[25];
  char mat[25];
  list esami;
};

libretto newStudent()
{
  struct libretto lib;

  lib=malloc(sizeof(struct libretto));
  if(lib==NULL)
    return NULL;

    char nome[25], cogn[25], mat[25];
    printf("Inserisci il nome dello studente");
    scanf("%s",nome);
    printf("Inserisci il cognome dello studente");
    scanf("%s",cogn);
    printf("Inserisci la matricola dello studente");
    scanf("%s",mat);

    strcpy(lib->nome,nome);
    strcpy(lib->cogn,cogn);
    strcpy(lib->mat,mat);

    return lib;
}

int newEsame(libretto lib)
{
  list esame;

  if(lib!=NULL)
  {
    esame=inputList(1);

    return 1;
  }

  return 0;
}

item searchEsame(libretto lib,char *esame)
{

  item x;

  for(i=0;i<n;i++)
  {
    x=getItem(lib->esami,i)
    if(strcmp(x,search_esame(x))==0)
    {
      return item;
    }
  }

  return NULLITEM;

}

void outputLibretto(libretto lib)
{
  printf("Nome studente:\n",lib->nome);
  printf("Cognome studente:\n",lib->cogn);
  printf("Matricola studente:\n",lib->mat);
  output_item(lib->esami);
}
