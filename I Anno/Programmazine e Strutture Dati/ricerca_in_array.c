#include <stdio.h>


void inserimento(int V[], int N)
     {int i=0;
     
      for (i=0;i<N;i++)
      {
      	printf("Inserisci il valore nella posizione %d del vettore: ", i);
      	scanf("%d", &V[i]);
      } 
}

      
int ricerca(int V[], int n)
     {int i=0, val=0, cont=0;
      printf("Inserisci il valore che vuoi ricercare: ");
      scanf("%d", &val);
      
      while(i<n && !cont)
      {
 	 		if(V[i]==val) cont=1;
      		else i++;
      }
      
      if(cont==1) return 1;
      else return 0;
      
      }
   

   
int main()
{int N=100, n;
int V[N];
int i=0;

printf("Quanti valori vuoi inserire: ");
scanf("%d", &n);

inserimento(V, n);

	if(ricerca(V, n)==1) 
	{ 
		printf("L'elemento ricercato esiste \n");
	}
	else printf("L'elemento ricercato non esiste \n");


return 0;

}


     
     
     
     
     
     
     
     
     
     
     
