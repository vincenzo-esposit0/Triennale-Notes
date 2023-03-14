#include <stdio.h>
#include <string.h>
#include  <stdlib.h>
#define SIZE 100
char * acrostico_alternato (char *v[], int n)
{
		char * str;
		int count=0,i=0,j=0;

		for(i=0;i<n;i++)
		{
			if(i%2==0)
			{
				if(v[i]!=NULL)
					count++;
			}
		}

		str=malloc((count+1)*sizeof(char));

		for(i=0;i<n;i++)
		{
			if(i%2==0)
			{
				if(v[i]!=NULL)
				{
					str[j] = v[i][0];
					j++;
				}
			}
		}

		str[j] = '\0';
		return str;


}

int main  (void)
{
	char *v[SIZE];
	int n,i=0;

	printf("Quant è grande n? ");
	scanf("%d",&n);

	for(i=0;i<n;i++)
	{
		printf("Inserisci la %d stringa:",i);
		scanf("%ms", &v[i]);
	}

	printf("Stampiamo le stringa: ");
	for(i=0;i<n;i++)
	{
		printf("Str %d: %s\n", i, v[i]);
	}

	printf("Risultato: %s\n", acrostico_alternato(v,n));

	return 0;
}	