#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "item.h"

struct seggio
{
	int n_identificativo;
	int n_aventid;
	int n_votanti;
	int n_nulli;
	int n_si;
	int n_no;
};

item newItem(int n_identificativo, int n_aventid,int n_votanti,int n_nulli,int n_si,int n_no;)
{
	struct seggio* i = malloc(sizeof(struct seggio));
	
	i->n_identificativo = n_identificativo;
	i->n_aventid = n_aventid;
	i->n_votanti = n_votanti;
	i->n_nulli = n_nulli;
	i->n_si = n_si;
	i->n_no = n_no;
	return i;
}

item input_item(item *x)
{
	printf("Inserire n_id: ");
	scanf("%d", &n_identificativo );
	printf("Inserire : ");
	scanf("%d", &n_aventid);
	printf("Inserire : ");
	scanf("%d", &n_votanti );
	printf("Inserire : ");
	scanf("%d", &n_nulli );
	printf("Inserire : ");
	scanf("%d", &n_si );
	printf("Inserire : ");
	scanf("%d", &n_no );

	return newItem(n_identificativo, n_aventid, n_votanti, n_nulli, n_si, n_no);
}

void output_item(item x) 
{
	printf("Numero identificativo: %d", x->n_identificativo);
	printf("\n");
	//reminder
} 

int eq (item i1, item i2)
{
	if(i1->n_identificativo == i2->n_identificativo)
	{
		return 1;
	}
	else 
	{
		return 0;
	}
}
