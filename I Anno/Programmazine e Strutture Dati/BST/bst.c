/*
BST: definizione

Se l’albero non è vuoto, allora:
-ogni elemento del sottoalbero di sinistra precede (<) la radice;
-ogni elemento del sottoalbero di destra segue (>) la radice.

I sottoalberi sinistro e destro sono alberi di ricerca binaria.

*/

#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "bst.h"


struct node {
     item value;
     struct node *left;
     struct node *right;
};

item getItem(struct node *N)   //funzione che restituisce il valore del nodo//
{
      if (N == NULL)  return NULLITEM;
      return N->value;
}

void setItem(struct node *N, item el)	//funzione che inserisce all'interno del nodo l'elemento//
{
     if (N==NULL) return;
     N->value = el;  
}                             

BST newBST (void)		//funzione che crea un albero e lo setta a NULL//
{
     return NULL;
}
 
int emptyBST (BST T)	//funzione che restituisce se un albero è NULL//
{
     return T == NULL;
}

BST figlioSX(BST T)		//funzione che restituisce il puntatore al figlio sinistro//
{
      if (T != NULL)    
	return  T->left;
      else 
             return NULL;
}

BST figlioDX(BST T)		//funzione che restituisce il puntatore al figlio destro//
{
      if (T != NULL)    
	return  T->right;
      else 
             return NULL;
}

/*
RICERCA: 

1) Se l’albero è vuoto allora restituisce false
2) Se l’elemento cercato coincide con la radice dell’albero restituisce true
3) Se l’elemento cercato è minore della radice restituisce il risultato della ricerca dell’elemento nel sottoalbero sinistro
4) Se l’elemento cercato è maggiore della radice restituisce il risultato della ricerca dell’elemento nel sottoalbero destro

*/

int contains(BST T, item val)	//funzione ricorsiva
{
      if (T == NULL)  return 0;
      if (eq(val, getItem(T))==1)  return 1;
      if (eq(val, getItem(T))==-1)
            return (contains(figlioSX(T), val));
      else
            return (contains(figlioDX(T), val));
}


BST creaFoglia(item elem)	//funzione che crea un nodo e inserisce il valore all'interno
{       
      struct node *N;		//puntatore alla struttura
      N = malloc (sizeof(struct node));		//esegue una malloc di tutta la struttura
      if (N == NULL)   return NULL;
      setItem (N, elem);		//inserisce l'elemento nel nodo
      N -> left = NULL;
      N -> right = NULL;
      return N;
}

/*
INSERIMENTO:

1) Se l’albero è vuoto allora crea un nuovo albero con un solo elemento
2) Se l’albero non è vuoto 
3) se l’elemento coincide con la radice non fa niente
4) se l’elemento è minore della radice allora lo inserisce nel sottoalbero sinistro
5) se l’elemento è maggiore della radice allora lo inserisce nel sottoalbero destro

*/

BST insert(BST T, item elem)
{       
    if (T==NULL)    return creaFoglia(elem);
    
    else   if (eq(elem, getItem(T))==-1)			//controlla se l'elemento da inserire e' minore della radice
                  T->left = insert(T->left, elem);
                  
              else  if (eq(getItem(T), elem)==-1)	//controlla se l'elemento da inserire e' maggiore della radice
                  T->right = insert(T->right, elem);
    return T;
}

struct node * minValue(struct node* node)	//funzione che restituisce il valore minimo dell'albero
{
    struct node* current = node;
    while (current->left != NULL)
        current = current->left;
    return current;
}

struct node * maxValue(struct node* node)	//funzione che restituisce il valore massimo dell'albero
{
    struct node* current = node;			//crea un nodo temporaneo uguale al nodo passato per scorrere l'albero
    
	while (current->right != NULL)			//scorre l'albero fin quando non trova l'elemento prima di NULL
        current = current->right;
    return current;
}


/*
ELIMINAZIONE:

Allora abbiamo più casi, prima di cancellare il nodo:
1) Albero vuoto: non viene realizzata alcuna cancellazione;
2) L’elemento el < radice albero: la cancellazione va effettuata nel sottoalbero sinistro; elimina(radice->sinistro,el);
3) L’elemento el > radice albero: la cancellazione va effettuata nel sottoalbero destro; elimina(radice->destro,el); 
4) L’elemento el == radice albero. Si considerano i seguenti casi:
5) La radice è una foglia.
6) Il nodo ha un sottoalbero non vuoto e l’altro vuoto.
7) Il nodo ha entrambi i sottoalberi non vuoti; 
Quindi:
-si cerca l'elemento minimo nel sottoalbero destro (da notare che tale elemento non ha sottoalbero sinistro, la cui radice sarebbe minore)
-il nodo che contiene l'elemento minimo viene eliminato
-mentre al nodo che contiene l'elemento da eliminare viene assegnato il valore minimo

*/

struct node* deleteNode(struct node* root, item key)
{
    if (root == NULL) return root;		//1) Albero vuoto: non viene realizzata alcuna cancellazione;
 
    if (eq(key, root->value)==-1)					//2) L’elemento el < radice albero: la cancellazione va effettuata nel sottoalbero sinistro; 
    	root->left = deleteNode(root->left, key);	// elimina(radice->sinistro,el);
    	
        
    else if (eq(root->value, key)==-1)				//3) L’elemento el > radice albero: la cancellazione va effettuata nel sottoalbero destro;  
        root->right = deleteNode(root->right, key); // elimina(radice->destro,el);
 
    else											//4) L’elemento el == radice albero.
    												// (root->value == key)
    {
        if (root->left == NULL)
        {
            struct node *temp = root->right;
            free(root);
            return temp;
        }
        
        else if (root->right == NULL)
        {
            struct node *temp = root->left;
            free(root);
            return temp;
        }
        //else
        struct node* temp = minValue(root->right);
        root->value = temp->value;
        root->right = deleteNode(root->right, temp->value);
    }
    return root;
}


int uguali(BST t)
{
	if(t==NULL) return 1;
	
	if(figlioSX(t)==NULL || figlioDX(t)==NULL)return 0; 
	item minore,maggiore;
	
	assign(minore,getItem(maxValue(figlioSX(t))));
	assign(maggiore,getItem(maxValue(figlioDX(t))));
	
	if ((eq(getItem(t),minore)==0) && (eq(getItem(t),maggiore)==-1)) return (verifica(figlioSX(t)) && verifica(figlioDX(t)));
	else return 0;
}












