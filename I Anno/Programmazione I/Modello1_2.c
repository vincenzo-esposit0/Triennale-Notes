#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void sottoelenco (char lett){

	FILE *fp, *fp1;
	char name[20], surname[20];
	int n;

	if((fp=fopen("elenco.txt","r"))== NULL)
	{
		printf("Error\n");
		exit (1);
	}

	fp1 = fopen("sottoelenco.txt","a");
	while((n = fgetc(fp)) != EOF){
		
		ungetc(n, fp);
		fgets(surname, 20, fp);
		fgets(name, 20, fp);
		if(surname[0] == lett)
			fprintf(fp1,"%s%s",surname, name);
	}

	fclose(fp);
	fclose(fp1);
}

int main (void)
{
	char c;
	printf("Dammi una lettera\n");
	scanf(" %c",&c);
	sottoelenco(c);
}