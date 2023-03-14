# include <stdio.h>
# include <stdlib.h>
# include "vettore.c"

void ordina_array(int x[], int n) 
{
   int i, j, app;
   for (i = 1; i < n; i++)
   {
      app = x[i];
       
      for (j = i - 1; (j >= 0) && (x[j] > app); j--)
               x[j+1] = x[j];
       
      x[j + 1] = app;
   }
}
