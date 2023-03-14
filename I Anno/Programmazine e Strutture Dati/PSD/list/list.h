typedef struct c_list *list;

list newList(void);
int emptyList(list l);
int sizeList (list l);
item getItem (list l, int pos); 
int posItem (list l, item val);
int insertList(list l, int pos, item val);
int removeList(list l, int pos);
list reverseList(list l);  
int deleteList(list l); 
list cloneList(list l);
