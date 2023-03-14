#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "BST.h"
#include "list.h"


struct node {
     item value;
     struct node *left;
     struct node *right;
};

item get_Item(struct node *N);
void setItem(struct node *N, item el); 

item get_Item(struct node *N)
{
      if (N == NULL)  return NULLITEM;
      return N->value;
}

void setItem(struct node *N, item el)
{
     if (N==NULL) return;
     N->value = el;  // correttezza di =
}                             // dipende dal tipo item

struct node *getRoot(BST T)
{
     return T;
} 

int emptyBtree(BST T)
{
     return T == NULL;
}


BST newBST (void)
{
     return NULL;
}
 
int emptyBST (BST T)
{
     return T == NULL;
}

BST figlioDX(BST T)
{
      if (T != NULL)  return  T->right;
      else            return NULL;
}

BST figlioSX(BST T)
{
      if (T != NULL) return  T->left;
      else       return NULL;
}

int contains(BST T, item val) //Se l'elemento cercato è presente nell'albero la funzione restituisce 1 altrimenti 0
{
     if (T == NULL)  return 0;
      if (eq(val, get_Item(T)))  return 1;
      if (minore(val, get_Item(T)))
            return (contains(figlioSX(T), val));
      else
            return (contains(figlioDX(T), val));
}

BST creaFoglia(item elem)
{       
      struct node *N;
      N = malloc (sizeof(struct node));
      if (N == NULL)   return NULL;
      setItem (N, elem);
      N -> left = NULL;
      N -> right = NULL;
      return N;
}

BST insert(BST T, item elem)
{       
    if (T==NULL)    return creaFoglia(elem);
    else   if (minore(elem, get_Item(T)))
                  T->left = insert(T->left, elem);
              else  if (minore(get_Item(T), elem))
                  T->right = insert(T->right, elem);
    return T;
}

//  deve essere usata sempre nel modo
//   bst = insert(bst, elem);

struct node * minValue(struct node* node)
{
    struct node* current = node;
    while (current->left != NULL)
        current = current->left;
    return current;
}

/*

Allora abbiamo più casi, prima di cancellare il nodo:
1) Albero vuoto: non viene realizzata alcuna cancellazione;
2) L’elemento el < radice albero: la cancellazione va effettuata nel sottoalbero sinistro; elimina(radice->sinistro,el);
3) L’elemento el > radice albero: la cancellazione va effettuata nel sottoalbero destro; elimina(radice->destro,el); 
4) L’elemento el==radice albero. Si considerano i seguenti casi:
5) La radice è una foglia.
6) Il nodo ha un sottoalbero non vuoto e l’altro vuoto.
7) Il nodo ha entrambi i sottoalberi non vuoti.

*/

struct node* deleteNode(struct node* root, item key)
{
	
    if (root == NULL) return root; //Caso base 1
    //Casi del divid et impera 2,3 e 4
	if (minore(key, root->value)) 
        root->left = deleteNode(root->left, key);
    else if (minore(root->value, key))
        root->right = deleteNode(root->right, key);
 
    else //(Questo else significa) Fase di combina: root-value=key. Abbiamo trovato l'elemento
    {
        if (root->left == NULL) //Nodo con solo figlio destro. Salviamo il sottoalbero destro per non perderlo ed eliminiamo il padre (Automaticamente prende il posto del padre)
        {
            struct node *temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL) //Nodo con solo figlio sinistro. Salviamo il sottoalbero sinistro per non perderlo ed eliminiamo il padre
        {
            struct node *temp = root->left;
            free(root);
            return temp;
        }
        struct node* temp = minValue(root->right); //Cerco l'elemento minimo nel sottoalbero destro
        root->value = temp->value; //Salvo il minimo elemento nel nodo dell'elemento da eliminare
		root->right = deleteNode(root->right, temp->value); //Chiamiamo ricorsivamente la funzione sul sottoalbero destro passando come key il valore di mindx
    }
    return root;

}

struct node * maxValue(struct node* node)
{
    struct node* current = node;
    while (current->right != NULL)
        current = current->right;
    return current;
}

/*La funzione RecorsiveCompresi() prende in input un albero,due item e un intero (posizione per inserire nella lista)
1) Base ricorsiva: T==NULL ritorna la lista
2) Passo ricorsivo: Se la radice è compresa tra i due item essa verrà inserita nella lista e chiamerà ricorsivamente la funzione sul figlio sinistro e sul figlio destro


RAFFINAMENTO PASSO 2

1) Se la radice è minore del valore minimo ricorsivamente solo sul figlio dx
2) Se la radice è maggiore del minimo ricorsivamente solo sul figlio sx

*/
   

static list recorsiveCompresi(BST T,list l,item val1,item val2,int pos)
{
     if(T==NULL) //Caso base
      return l;
     if(compreso(val1,val2,get_Item(T)))
     {
               insertList(l,pos,get_Item(T));
               pos++;                                         
     }    
     recorsiveCompresi(figlioSX(T),l,val1,val2,pos); //Passi ricorsivi
     recorsiveCompresi(figlioDX(T),l,val1,val2,pos);  
     
     if(minore(get_Item(T),val1)) // Item minore del minimo
     {
         l=recorsiveCompresi(figlioDX(T),l,val1,val2,pos);  
     }
     
     if(minore(val2,get_Item(T)))
     {
         l=recorsiveCompresi(figlioDX(T),l,val1,val2,pos);
     }                       
}

list elementiCompresi(BST bt,item elem1,item elem2)
{
     int i=0;
     
     list l=newList(); //Creo la lista vuota
     
     item min,max;
     
     if( (contains(bt,elem1)==0)||(contains(bt,elem2)==0) ) // Precondizione elementi esistenti nell'albero
     {
         return NULL;
     }
     
     if(minore(elem1,elem2)) //Se elemento 1 minore del 2
     {
        min=elem1;
        max=elem2;
	}	
     else 
     {
      if(eq(elem1,elem2)) //Se uguali
      {
         if(contains(bt,elem1)==1) 
            insertList(l,i,elem1);
            i++;
            return l;
      }
      
      //Se elemento 1 maggiore del 2
      min=elem1;
      max=elem2;
     }
     
      l=recorsiveCompresi(bt,l,min,max,i);
      
      return l;                             
}

/*
La funzione cancMaggiori() prende in input un albero ed un item e restituisce l'albero privo degli elemento maggiori dell'elemento dato in input
Questa funzione visita tutto l'albero e ogni volta che la radice è maggiori dell'elemento dato in input elimina il nodo per poi richiamare ricorsivamente essa stessa sul nodo destro e sul nodo sinistro

1) Passo base della ricorsione T==NULL
2) Se l'elemento è maggiore dell'elemento passato cancello l'elemento dall'albero

RAFFINAMENTO PASSO 2 (Passo ricorsivo)


1) Ricorsione sul figlio destro 
2)  Ricorsione sul figlio sinistro

*/

BST cancMaggiori(BST T,item elem)
{
    if(T==NULL) //Passo base
       return T;
   if(minore(elem,get_Item(T)))
     deleteNode(T,get_Item(T));
     
   T=cancMaggiori(T,get_Item(figlioDX(T)));
   T=cancMaggiori(T,get_Item(figlioSX(T)));
       
}

void stampa_albero(BST T)
{
	if(T!=NULL)
	{
		stampa_albero(T->left);
		output_item(T->value);
		stampa_albero(T->right);
	}
}
