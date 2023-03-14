typedef int *item;
#define NULLITEM NULL
item newItem(void);
int eq(item a, item b); 
void inputItem(item a);
void outputItem(item a);
void assign(item a, item b);
