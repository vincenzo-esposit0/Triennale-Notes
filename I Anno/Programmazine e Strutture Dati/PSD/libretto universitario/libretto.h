#include "list.h"
typedef list *libretto;

libretto newStudent();
int newEsame(libretto lib);
item searchEsame(libretto lib,char *esame);
void outputLibretto(libretto lib);
