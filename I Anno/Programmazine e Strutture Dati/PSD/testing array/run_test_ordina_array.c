// file run_test_ordina_array.c

# include <stdio.h>
# include <stdlib.h>
# include "vettore.h"

# define M 20

int run_test_case(char *tc_id, int n)
{
       char input_fname[M], output_fname[M], oracle_fname[M];	

      // costruiamo i nomi dei file
       sprintf(input_fname, "%s_input.txt", tc_id);
       sprintf(oracle_fname, "%s_oracle.txt", tc_id);
       sprintf(output_fname, "%s_output.txt", tc_id);	
       // allochiamo memoria per array di input
       int *a = (int*) calloc(n, sizeof(int));
       if(a == NULL) {
	printf("Memoria insufficiente \n");
	return -1;
	}

       finput_array(input_fname, a, n);        // carica file di input
       ordina(a, n); 		             // ordina array
       foutput_array(output_fname, a, n);  //  scrive file di output
       // allochiamo memoria per array oracolo
       int *oracle =  calloc(n, sizeof(int));

       if(oracle == NULL) {
	printf("Memoria insufficiente \n");
	return -1;
	}

       finput_array(oracle_fname, oracle, n);        // carichiamo oracolo

       return confronta_array(a, oracle, n);	    // confrontiamo array
}

int main(int argc, char *argv[]) 
{ 	
      FILE *test_suite, *result;  
      char tc_id[M];  // stringa contenente l'identificativo del test case
      int n, pass;
	
      if(argc < 3) {
	printf("Nomi dei file mancanti \n");
	exit(1);
       }    
       test_suite = fopen(argv[1], "r");  // apro file contenente test suite               
       result = fopen(argv[2], "w");   // apro file contenente risultati test        
       if( test_suite==NULL || result == NULL ) {
	printf("Errore in apertura dei file \n");    
	exit(1);
       } 
/* Scansione del file di input nel ciclo while. 
     Ad ogni iterazione si leggono i due elementi di una riga:
     l’identificative del test case tc_id e il numero n di elementi
     da ordinare */
	
       while(fscanf(test_suite, "%s%d", tc_id, &n) == 2) {
	pass = run_test_case(tc_id, n);
	
	fprintf(result,"%s ", tc_id);
	if(pass == 1)
	          fprintf(result, "PASS \n");
	else   fprintf(result, "FAIL \n");			
          }	

        fclose(test_suite);  // chiusura file di input
        fclose(result);         // chiusura file di output
}


