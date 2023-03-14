#include <stdio.h>
#include <stdlib.h> 
#include "item.h"
#include "list.h"
#include "referendum.h"
#define N 5

struct seggio
{
	list l;
	int N;
};

seggio newSeggio(void)
{
	seggio s;
	s->l = newList();
	s->N = 0;
	return s;
}

seggio inserSeggio(item s, list l)
{
	int i, eq;
	for(i = 0; !emptyList(l); i++)
	{
		eq = posItem(s);
		if(eq == 1)
		{
			return NULL;
		} 
	}
	return l;
}

int nosiRef(seggio s)
{
	item temp;
	int no,si;
	for(i = 0; !emptyList(l); i++)
	{
		temp = getItem(l,i);
		no = no + temp->n_no;
		si = si + temp->n_si;
	}
	if(si>no)
		return 1;
	else
		return 0;
}