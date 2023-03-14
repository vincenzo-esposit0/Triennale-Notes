#include<stdio.h>
#include"item.h"
#include"list.h"

int main()
{int val;

list lista=newList();
item min;

lista=inputList();
printf("\n");

int dim=sizeList(lista);
printf("size list: %d \n", dim);

lista=reverseList(lista);
printf("\n");

/*
printf("Inserisci il numero che vuoi ricercare: \n");
scanf("%d", &val);
posItem (lista, val);
*/

outputList(lista);
printf("\n");

min=minimo(lista);
printf("valore minore:");

output_item(min);
printf("\n");

if(deleteList(lista)) printf("Memoria liberata! \n");
else printf("Lista non eliminata");

return 0;
}
