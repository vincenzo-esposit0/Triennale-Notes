#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "item.h" 
#include "list.h"

struct node 
{
	item value;
	struct node *next;
};

list newList(void)
{
	return NULL;
}

int emptyList(list l)
{
	return l == NULL;
}

list consList(item val, list l)
{
	struct node *nuovo;
	nuovo = malloc (sizeof(struct node));
	if (nuovo != NULL) 
	{
		nuovo->value = val;
		nuovo->next = l;
		l = nuovo; 
	}
	return l;
}

list tailList(list l)
{
	list temp;
	if (l != NULL)    
		temp = l->next;
	else 
		temp = NULL;
	return temp;
}

item getFirst (list l)
{
	item e;
	if(l != NULL)    
		e = l->value;
	else 
		e = NULLITEM;
	return e;
}

int sizeList (list l)
{
	int n=0;
	while (!emptyList(l)) // finché non raggiungiamo la fine della lista 
	{
		n++;      // il primo elemento contribuisce al conteggio
		l = tailList(l);   // continuiamo la visita degli elementi successivi
	}
	return n;
}

int posItem (list l, item val)
{
	int pos =0; // contatore di posizione
	int found =0;

	while (!emptyList(l) && !found) 
	{
		if (eq(getFirst(l), val))
		found =1;

		else 
		{
			pos++; // incrementa il contatore di posizione
			l = tailList(l);  // continuiamo la visita degli elementi della lista
		}
	}    

	if(!found)
	pos = -1;  // se non trovato restituiamo come posizione -1

	return pos;
}

item getItem (list l, int pos)
{
	item e;
	int i =0;
	// prima scorriamo la lista fino alla posizione pos … se esiste
	while (i < pos && !emptyList(l))
	{ 
		i++;
		l = tailList(l);
	}

	if (!emptyList(l)) // se la lista ha almeno pos+1 elementi
	e = getFirst(l);  // elemento di posizione pos
	else e = NULLITEM;

	return e;
}

void outputList (list l)
{
	int i =0;
	item val; 

	while(!emptyList(l)) 
	{
		val = getFirst(l);
		printf("Elemento di posizione %d: ", i);  
		output_item(val);  
		printf("\n");
		l = tailList(l);
		i++;
	} 
}

list inputList (int n)
{
	item val; 
	list l = newList();

	for(int i = 0; i < n; i++) 
	{
		printf("Elemento di posizione %d: ", i);  
		input_item(&val);  
		l = consList(val, l);
	}  

	// alla fine del ciclo l contiene gli elementi della lista al contrario

	return reverseList(l);
}

list insertList (list l, int pos, item val)
{
	item x;
	int i =0;
	list ltmp = newList();     // lista di appoggio
	list lo = newList();         // lista di output

	/* scandiamo la lista di input fino alla posizione pos e
	memorizziamo i primi pos-1 elementi in una lista di appoggio ltmp */

	while (i < pos && !emptyList(l)) 
	{
		x = getFirst(l);
		ltmp = consList(x, ltmp);  
		l = tailList(l);
		i++;
	}
	// controllo della precondizione: la lista di input ha almeno pos elementi
	if(i==pos) 
	{
		lo = consList(val, l);

		// inseriamo in lo gli elementi contenuti nella lista d’appoggio l1  

		while(!emptyList(ltmp)) 
		{
		x = getFirst(ltmp);
		lo = consList(x, lo);  
		ltmp = tailList(ltmp);
		}
	}
	return(lo);
}

list removeList (list l, int pos)
{     
	list l1;    // puntatore al nodo da eliminare

	if(pos == 0 && l != NULL) 
	{       // eliminazione in posizione 0
		l1 = l;
		l = tailList(l);
		free(l1);
	}
	else 
	{

		/* se non dobbiamo cancellare in posizione 0 scorriamo la lista 
		fino alla posizione precedente a quella del nodo da eliminare */

		int i = 0;
		list prec = l;         
		while (i < pos-1 && prec!= NULL) 
		{   
			prec = prec->next;
			i++;
		}
		/* alla fine del ciclo, se prec != NULL allora prec->next punta al nodo da 
		eliminare. Se prec->next != NULL allora il nodo si può eliminare */

		if(prec != NULL && prec->next != NULL) 
		{ // short-circuit evaluation
			l1 = prec->next;
			prec->next = l1->next;
			free(l1); 
		}
	}

	return l; 
}

list reverseList (list l)
{
	list rev;
	item val;

	rev = newList();     

	while (!emptyList(l)) 
	{
		val = getFirst(l);
		rev = consList(val, rev);  
		l = tailList(l);
	}

	return rev;
}

list estraiMax(list l, int n)
{
	int i, max, pos;
	struct node *temp;
	temp = l;
	max = temp->value;
	for(i = 0; i < n; i++)
	{
		if (temp->value > max)
		{
			max = temp->value;
			temp = temp->next;
			pos = i;
		}
		temp = temp->next;
	}

	l = removeList(l,pos);

	return l;
}

list insertMinN(list l, int el, int n)
{
	int lenght, i, min, pos, final;
	struct node* temp;
	temp = l;
	min = INT_MAX;
	final = sizeList(l);
	lenght = final-n;
	for(i = 0; i < final; i++)
	{
		if (i >= (lenght-1))
		{
			if(temp->value < min)
			{
				min = temp->value;
				pos = i;
			}
		}
		temp = temp->next;	
	}
	l = insertList(l,pos,el);
	return l;
}