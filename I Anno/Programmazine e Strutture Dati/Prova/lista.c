#include <stdio.h>
#include <stdlib.h>
#include “item.h” 
#include “list.h”

struct node {
     item value;
     struct node *next;
};

struct c_list {
     struct node *first;
     int size; 
};

int sizeList (list l)
{
     if(l == NULL)
	return -1;
     return l->size;
}

list newList(void) 
{
     struct c_list *l;
     l = malloc (sizeof(struct c_list));
     if (l != NULL) {
     	l->first = NULL;
      	l->size = 0;
          }
      return l;   
/* il programma client dovrà controllare 
    che il risultato non sia NULL  */
}

int emptyList(list l)
{
      if(l == NULL)
	return -1;
     return (l->size == 0);
}


