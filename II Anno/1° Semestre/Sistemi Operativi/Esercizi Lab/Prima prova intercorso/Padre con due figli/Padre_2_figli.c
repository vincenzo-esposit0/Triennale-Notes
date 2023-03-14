#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

void main(){
	int value,value2;
	value=fork();
	if (value==0){
		printf("\n");
		printf("Nel processo FIGLIO\n");
		printf("Il valore di ritorno di fork: %d\n", value);
		printf("\n");
	}
	else{
		printf("\n");
		printf("Nel processo PADRE\n");
		printf("Il valore di ritorno di fork: %d\n", value);
		printf("\n");
	}
	if(value >0){
		value2=fork();
		if (value2==0){
			printf("\n");
			printf("Nel secondo processo FIGLIO\n");
			printf("Il valore di ritorno di fork: %d\n", value2);
			printf("\n");
		}
		else {
			printf("\n");
			printf("Nel secondo processo PADRE\n");
			printf("Il valore di ritorno di fork: %d\n", value2);
			printf("\n");
		}
	}
}
