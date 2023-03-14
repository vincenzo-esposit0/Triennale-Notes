/*

Un file fd è un intero non negativo associato ad un file.
Ogni nuovo processo apre 3 file standard: input, output, error;
fa riferimento ad essi tramite i file descriptor:
-0 (STDIN_FILENO)
-1 (STDOUT_FILENO)
-2 (STDERR_FILENO)

-Operazione: Open
	#include<sys/type.h>
	#include<sys/stat.h>
	#include<fcntl.h>
	
	int open(const char *pathname, int oflag..., mode_t mode);

	Restituisce: un file descriptor se OK, -1 altrimenti.

	L'argomento oflag indica una moltitudine di opzioni:
	-O_RDONLY(aperto per sola lettura), 
	-O_WRONLY(aperto per sola scrittura),
	-O_RDWR(aperto per lettura e scrittura).

-Operazione: Close
	#include<unistd.h>

	int close(int filedes);

	essa chiude il file con il file descriptor filedes
	Restituisce: 0 se ok oppure -1.
	Quando un processo termina, tutti i file aperti vengono chiusi automaticamente dal kernel.

-Operazione: lseek
	#include<unistd.h>

	off_t lseek(int filedes, off_t offset, int whence);

	Restituisce: il nuovo offset se Ok, -1 altrimenti.
	L'argomento whence può assumere valore:
	-SEEK_SEK, ci si sposta del valore offset a partire dall'inizio;
	-SEEK_CUR, ci si sposta del valore di offset a partire dlla posizione corrente;
	-SEEK_END, ci si sposta del valore di offset a partire dalla fine del file.

-Operazione: Read
	#include<unistd.h>

	ssize_t read(int filedes, void *buff, size_t nbytes)

	Legge da file con file descriptor filedes un numero di bytes che è al più nbyte e li mette in buff.
	Restituisce: il numero di byte letti, 0 se alla fine del file, -1 (errore) altrimenti.

-Operazione: Write
	#include<unistd.h>
	
	ssize_t write(int filedes, cont void*buff, size_t nbytes)

	Scrive nbyte presi da buff sul file con file descriptor filedes.
	Restutuisce: il numero di byte scritti se ok, -1 altrimenti.

*/


#include<stdlib.h>
#include<stdio.h>
#include<unistd.h>

#define buffer_size 100

int main(void)
{
	int n;
	char buff[buffer_size];

	while((n=read(STDIN_FILENO, buff, buffer_size))>0)	//Legge una stringa da input al più buffersize elementi. Nel while viene svolto infinite volte
	{
		if(write(STDOUT_FILENO, buff, n) != n)	//Prende gli n elementi, li mette nel buffer e li scrive in standard output
		{
			printf("Write error. \n");
			exit(1);
		}
	}
	if(n<0)
	{
		printf("Read error. \n");
		exit(1);
	}


	exit(0);
}








