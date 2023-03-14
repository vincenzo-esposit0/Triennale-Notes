typedef struct node *list;

// prototipi

list newList(void);

int emptyList(list l);

list tailList(list l);

list consList(item val, list l);

item getFirst (list l);

int sizeList (list l);

int posItem (list l, item val);

item getItem (list l, int pos);

void outputList (list l);

list inputList (int n);

list insertList (list l, int pos, item val);

list removeList (list l, int pos);

list reverseList (list l);

list estraiMax(list l, int n);

list insertMinN(list l, int el, int n);