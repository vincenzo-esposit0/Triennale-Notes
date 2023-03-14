# include <stdio.h>
# include <stdlib.h>
# include "vettore.h"

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
