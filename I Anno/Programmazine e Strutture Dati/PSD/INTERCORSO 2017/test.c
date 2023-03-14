//file test liste

# include <stdio.h>
# include <stdlib.h>
# include "item.h"
# include "list.h"

# define M 20

int run_test_case(char *tc_id, int n, item el)
{
       char input_fname[M], output_fname[M], oracle_fname[M];

      // costruiamo i nomi dei file
       sprintf(input_fname, "%s_input.txt", tc_id);
       sprintf(oracle_fname, "%s_oracle.txt", tc_id);
       sprintf(output_fname, "%s_output.txt", tc_id);
       // creo lista input
       list l=newList();

       finput(input_fname,l,n);        // carica file di input
       /*item el;
       printf("Inserisci l'elemento da inserire prima del minimo\n");
       input_item(&el);
       int num;
       printf("Inserisci il numero di elementi su cui calcolare il minimo\n");
       scanf("%d",&num);*/
       l=insertMinN(l,el,n);
       foutput(output_fname,l,n);  //  scrive file di output

       list l1=newList();
       finput(oracle_fname,l1,n);         //  carichiamo oracolo

       return confronta_liste(l,l1,n);	    // confrontiamo i due item
}

int main(int argc, char *argv[])
{
      FILE *test_suite, *result;
      char tc_id[M];  // stringa contenente l'identificativo del test case
      int n, pass;
      item elem;

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

       while(fscanf(test_suite, "%s%d%d", tc_id, &n,&elem) == 3) {
	pass = run_test_case(tc_id, n, elem);

	fprintf(result,"%s ", tc_id);
	if(pass == 1)
	          fprintf(result, "PASS \n");
	else   fprintf(result, "FAIL \n");
          }

        fclose(test_suite);  // chiusura file di input
        fclose(result);         // chiusura file di output
}
