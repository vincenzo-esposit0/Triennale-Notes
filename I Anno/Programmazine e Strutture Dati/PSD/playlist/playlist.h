typedef struct c_list *playlist;

playlist newplaylist();
int addsong(playlist pl, item x);
int removeplaylist(playlist l, int pos);
playlist forward(playlist pl, int pos);
playlist back(playlist pl, int pos);
int outputplaylist(playlist pl);
int inputplaylist(playlist pl, int pos, item val);
playlist sottoplaylist(playlist pl,char *x);
