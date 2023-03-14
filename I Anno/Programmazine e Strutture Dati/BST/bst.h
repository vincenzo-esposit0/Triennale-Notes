// file BST.h
typedef struct node *BST;

// prototipi
item getItem(struct node *N);
void setItem(struct node *N, item el); 
BST newBST(void);
int emptyBST(BST T);
int contains(BST T, item elem); 
BST figlioSX(BST T);
BST figlioDX(BST T);
BST insert(BST T, item elem);
BST creaFoglia(item elem);
BST minValue(struct node* node);
BST maxValue(struct node* node);
BST deleteNode(BST T, item elem);
int uguali(BST t);
