#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "BST.h"
#include "list.h"

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
	
	BST T;
	
	int i,n;
	
	item x;
	
	/*printf("Quanti numeri vuoi inserire?\n");
	scanf("%d",&n);*/
	
		input_item(&x);
		T=insert(T,x);
	
	stampa_albero(T);
	
	return 0;
}
