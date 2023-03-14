#include <stdio.h>


void inserimento(int V[], int N)
     {int i=0;
     
      for (i=0;i<N;i++)
      {
      	printf("Inserisci il valore nella posizione %d del vettore: ", i);
      	scanf("%d", &V[i]);
      } 
}

      
int min(int *MIN, int V[], int n)
     {int i=0, pos=0;
       
     for(i=0;i<n;i++)
	 {
		if(V[i]< *MIN) 
		{
			MIN=&V[i];
			pos=i;
		}
		
	 }
	 return pos;
     }

   
int main()
{int N=100, n;
int V[N];
int i=0;

int *MIN=&V[0];			//inizializzazione

printf("Quanti valori vuoi inserire: ");
scanf("%d", &n);

inserimento(V, n);
printf("L'elemento minimo si trova nella posizione %d \n", min(MIN, V, n));

return 0;
}


     
     
     
     
     
     
     
     
     
     
     
