typedef struct c_list *list;
list newList(void); //crea una nuova lista, controllare nel chiamante se restituisce NULL
int emptyList(list l); //restituisce null se lista vuota altrimenti la dim
int sizeList (list l);
item getItem (list l, int pos);
int posItem (list l, item val);//positem restituisce la pos dell'elemento altrimenti -1
int insertList(list l, int pos, item val); //insertlist crea il nodo e lo inserisce in una pos a piacere
int removeList(list l, int pos); //removeList cancella un nodo in una pos valida altrimenti restituisce la lista come era
list reverseList(list l);
int deleteList(list l); //deletelist cancella tutti i nodi della lista
list cloneList(list l); //clonelist restituisce una lista identica a quella di input
int outputList (list l);
int inputList (list l,int n);
item estraiMaxN(list l, int n);
list insertMinN(list l, item el, int n);
//TEST
int confronta_liste(list l1, list l2, int n);
void finput(char *file_name, list l, int n);
void foutput(char *file_name, list l, int n);
