#include<stdio.h>
#include<stdlib.h>
#include"item.h"
#include"list.h"
#include"playlist.h"

int main()
{
  playlist pl=newplaylist();
  int i,num,salvati=0;
  item x,y;
  char s[25];

  printf("Quante canzoni vuoi inserire?\n");
  scanf("%d",&num);

  for(i=0;i<num;i++)
  {
    x=input_item();
    salvati=inputplaylist(pl,i,x);
    salvati++;
  }

  printf("Inserisci il cantante\n");
  scanf("%s",s);


  pl=sottoplaylist(pl,s);
  //pl=back(pl,1);

  outputplaylist(pl);

}
