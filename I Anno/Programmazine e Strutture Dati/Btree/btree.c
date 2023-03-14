#include <stdio.h>
#include <stdlib.h>
#include "item.h" 
#include "btree.h"
struct node {
     item value;
     struct node *left;
     struct node *right;
};


item getItem(struct node *N)
{
      if (N == NULL)  return NULLITEM;
      return N->value;
}

void setItem(struct node *N, item el)
{
     if (N==NULL) return ;
     N->value = el;  
}                             

Btree newBtree(void)
{
     return NULL;
}
 
int emptyBtree(Btree T)
{
     return T == NULL;
}

struct node *getRoot(Btree T)
{
     return T;
} 

Btree consBtree(item val, Btree sx, Btree dx)
{
      struct node *nuovo;
      nuovo = malloc (sizeof(struct node));
      if (nuovo != NULL) {
     	setItem(nuovo, val);
      	nuovo->left = sx;
 	nuovo->right = dx;
      }
      return nuovo;
}

Btree figlioSX(Btree T)
{
      if (T != NULL)    
	return  T->left;
      else 
             return NULL;
}

Btree figlioDX(Btree T)
{
      if (T != NULL)    
	return  T->right;
      else 
             return NULL;
}

Btree  inputBtree(void)
{
	Btree T1, T2;
	int ris;
	item el=newItem();
	printf("\nL'albero è vuoto? (1/0): ");
	scanf("%d", &ris);
	if (ris)  return newBtree();
	printf("\nInserisci la radice: ");
	inputItem(el);
	printf ("costruisco il sottoalbero SX\n");
	T1 = inputBtree();
	printf ("costruisco il sottoalbero DX\n");
	T2 = inputBtree();
	return consBtree(el, T1, T2);
}

Btree creaFoglia(item elem)
{       
      struct node *N;
      N = malloc (sizeof(struct node));
      if (N == NULL)   return NULL;
      setItem (N, elem);
      N -> left = NULL;
      N -> right = NULL;
      return N;
}

void visitaSimmetrica(Btree T){

  if(T!=NULL){

    visitaSimmetrica(T->left);

    outputItem(T->value);
	printf("\n");

    visitaSimmetrica(T->right);

  }

}

int altezza(Btree T)
{
    int hsx,hdx;
    if (emptyBtree(T)) return 0;
    hsx=altezza(figlioSX(T));
    hdx=altezza(figlioDX(T));
    return 1+((hsx>hdx)?hsx:hdx);
}

int numFoglie(Btree T){
    int fsx,fdx;
    if(emptyBtree(T)) return 0;
    if(emptyBtree(figlioSX(T)) && emptyBtree(figlioDX(T))) return 1;
    fsx=numFoglie(figlioSX(T));
     fsx=numFoglie(figlioDX(T));
     return (fsx+fdx);
    }

void outputBtree (Btree T)
{
  outputItem(T->value);   
}

void inorder(Btree T){
if(!emptyBtree(T)){                                                                                                              
 inorder(T->left);
  outputBtree(T);  
 inorder(T->right);
}}

int eqBtree(Btree a,Btree b) 
{
if(a==NULL && b==NULL) return 1;
if(a==NULL && b!=NULL) return 0;
if(a!=NULL && b==NULL) return 0;
if(eq(getItem(a),getItem(b))==1)
return eqBtree(figlioSX(a),figlioSX(b))&& eqBtree(figlioDX(a),figlioDX(b));
}

int ricerca (Btree b,item val){
    if(b==NULL) return 0;
    if(eq(getItem(b),val)==1) return 1;
    return ((ricerca(figlioDX(b),val)) || (ricerca(figlioSX(b),val)));
    }

int generazione (Btree a,Btree b){     
     if (b==NULL||a==NULL) return 0;
     if (ricerca(b,getItem(getRoot(a)))==1) return 1; 
     return (generazione(figlioSX(a),b) || generazione(figlioSX(a),b));
     }









