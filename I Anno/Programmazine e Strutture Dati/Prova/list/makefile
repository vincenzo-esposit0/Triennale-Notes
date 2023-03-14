eseguibile.o :	list.o item.o main.o
	gcc list.o item.o main.o -o eseguibile.o

list.o :	list.c list.h item.h
	gcc -c list.c

item.o :	item.c item.h
	gcc -c item.c

main.o :	main.c list.h item.h
	gcc -c main.c
