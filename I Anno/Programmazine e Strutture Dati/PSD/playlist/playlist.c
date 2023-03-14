#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"item.h"
#include"list.h"
#include"playlist.h"

playlist newplaylist()
{
  playlist pl;

  pl = newList();
  if(pl==NULL)
    return NULL;

  return pl;
}

/* Input: prende una playlist
Output restituisce un intero (Output di insertList)
*/

int addsong(playlist pl, item x)
{
  int pos=0;

  if(emptyList(pl)==-1 || x==NULLITEM)
    return -1;

  pos=sizeList(pl)+1;
  return insertList(pl, pos, x);
}

int removeplaylist(playlist pl, int pos)
{
  if(emptyList(pl)==-1)
    return -1;

  return removeList(pl,pos);
}

playlist forward(playlist pl, int pos)
{
  item temp1,temp2;
  int i=0;

  if(pos<0||pos>=sizeList(pl))
    return pl;

  temp1=getItem(pl,pos);
  removeList(pl,pos);
  insertList(pl,pos+1,temp1);

  return pl;
}

playlist back(playlist pl, int pos)
{
  item temp1,temp2;
  int i=0;

  if(pos<=0||pos>sizeList(pl))
    return pl;

  temp1=getItem(pl,pos);
  removeList(pl,pos);
  insertList(pl,pos-1,temp1);

  return pl;
}

int outputplaylist(playlist pl)
{
  return outputList(pl);
}

int inputplaylist(playlist pl, int pos, item val)
{
  return insertList(pl,pos,val);
}

playlist sottoplaylist(playlist pl,char *x)
{
  item val;
  int i=0; //Indice per playlist input pl
  int j=0; //Indice per playlist output pl1

  playlist pl1=newplaylist();

  for(i=0;i<sizeList(pl);i++)
  {
    val=getItem(pl,i);
    if(strcmp(x,(search_autore(val))==0))
    {
      insertList(pl1,j,val);
      j++;
    }
  }

  return pl1;

}
