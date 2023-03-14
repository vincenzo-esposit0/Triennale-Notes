#include "testing.h"

int testsuite (char filename[]){
	char nomefile[14]; //testsuite.txt
	char caso [4]; //TC1, TC2...
	int n; // elementi del caso 
	FILE *tedtsuite;
	sprintf (nomefile, "%s.txt", filename);
	testsuite=fopen (nomefile, "r");
	if (!testsuite)
	return 0;
	item buf;

	while (1){
			fscanf (suite, "%s", caso);
		fscanf (suite, "%s", &n);
		if (feof (suite))
		break;
		list l= newlist();
		list reverse, clone;
		if (!inputtest (testduit, l))
		break;
		
		outputtest (caso, n, l);
		
	}
}

int inputtest (FILE *suite, list l){
	int i;
	char nomefile [14];  //TCn_input.txt
	FILE *fin;
	
			sprintf (nomefile, "%s_input.txt", caso ); 
	fin= fopen (nomefile , "r");
	if (!fin)
	return -1; 
		
		for (i=0; i<n; i++)
		{
			buf = finputitem (caso);
			if (!insertlist (l, i, buf))
			 return 0;
			 
			
		}
		fclose (fin);
		return 1;
}
int outputtest (char caso[], int n, list l)
{
	
	char nomefile [15]; //TCn_output.txt
	FILE *fout;
	int i;
	item buf= newitem ();
	sprintf (nomefile, "%s_output.txt", caso);
	fout= fopen (nomefile, "w");
	if (!fout)
	return 0;
	list reverse, clone;

	for (i=0; i<n, i++)
	{
		buf =getitem (l, i);
		foutputitem (fout, buf);

	}
	
		reverse= reverslist (l);
	for (i=0; i<n;i++){
		buf =getitem (clone, i);
		foutpuitem (fout, buf);
	}
	
	clone = clonelist (reverse);
	for (i=0; i<n;i++)
	{
		buf=getitem (clone, i);
		foutputitem (fout, buf);
		
	}
return 1;	
}
