#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "item.h"
#include "list.h"
#include "libretto.h"

int main()
{
  libretto l=newStudent();

  newEsame(l);

  outputLibretto(l);

  return 0;

}
