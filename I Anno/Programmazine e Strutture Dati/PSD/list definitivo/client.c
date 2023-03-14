#include <stdio.h>
#include "item.h"
#include "list.h"

int main()
{

	list l;
	int num;

	printf("Inserisci il numero di elementi da aggiungere nella lista\n");
	scanf("%d",&num);

	inputList(num);

	outputList(l);

	return 0;

}
