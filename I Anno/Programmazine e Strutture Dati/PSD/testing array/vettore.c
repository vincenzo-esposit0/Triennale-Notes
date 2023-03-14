// FILE:   vettore.c
// restituisce 1 se i due vettori di ingresso sono uguali, 0 altrimenti

#include "vettore.h"
#include <stdio.h>
#include <stdlib.h>

int confronta_array(int a[], int b[], int n) 
{  
	int i =0;  
	int trovato = 0;

	while (i < n && !trovato)
		if(a[i] != b[i])
			trovato = 1;	
		else i++;
	
	return (i == n) ? 1 : 0;
}

void foutput_array(char *file_name, int a[], int n) 
{  
	int i;  
	FILE *fd; 	

	fd=fopen(file_name, "w"); 		
	if( fd==NULL ) 
		printf("Errore in apertura del file %s \n", file_name);    
	else {
		for(i=0; i<n; i++)      
			fprintf(fd, "%d\n", a[i]);		
		fclose(fd); 
		}
}

void finput_array(char *file_name, int a[], int n)
{
	int i;
	FILE *fd;

	fd=fopen(file_name, "r");
	if( fd==NULL )
		printf("Errore in apertura del file %s \n", file_name);
	else {
		for(i=0; i<n; i++)
			fscanf(fd, "%d", &a[i]);
		fclose(fd);
		}
}

void ordina(int a[], int n)
{
   int ordinato = 0; // si assume array non ordinato inizialmente
   int i = 1;  // prima iterazione

   while (i < n && ! ordinato) {
        ordinato = 1;  // scommettiamo che sia ordinato
        for(int j=0; j < n-i; j++)
		if(a[j]>a[j+1]) {   // confrontiamo elementi adiacenti
                   scambia(&a[j], &a[j+1]);
                   ordinato = 0;  // se scambio elementi array non ordinato
                }
         i++;  // prossima iterazione
     }
}
