#include <stdio.h>
#include <stdlib.h> 
#include "item.h"
#include "list.h"
#include "referendum.h"
#define N 5

struct referendum
{
	list l;
	int N;
};




void stampaReport(referendum ref)
{
     int vot=0,vnul=0,vsi=0,vno=0;
     int i;
     if(comletRef(ref)==0) printf("Impossibile stampare l' esito del referendum \n");
     else {
          for(i=0;i<N;i++){
             vot+=votanti(getItem(ref,i));
             vnul+=voti_nulli(getItem(ref,i));
             vsi+=voti_si(getItem(ref,i));
             vno+=voti_no(getItem(ref,i));
             }
          printf("Totale Voti Espressi : %d\n",vot);
          printf("Totale Voti Nulli    : %d\n",vnul);
          printf("Totale Si            : %d\n",vsi);
          printf("Totale No            : %d\n",vno);
     }
}
