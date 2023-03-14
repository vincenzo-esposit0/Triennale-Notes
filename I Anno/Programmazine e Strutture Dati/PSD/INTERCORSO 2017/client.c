#include <stdio.h>
#include "item.h"
#include "list.h"

int main()
{

	list l=newList();
	int num,n;
	item max,el,min;


	printf("Inserisci il numero di elementi da aggiungere nella lista\n");
	scanf("%d",&num);

	inputList(l,num);

	printf("Inserisci un numero\n");
	scanf("%d",&n);

	/*max=estraiMaxN(l,n);

	printf("Max: %d\n",max);*/

	input_item(&el);

	l=insertMinN(l,el,n);

	outputList(l);

	return 0;

}
