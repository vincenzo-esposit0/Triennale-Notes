// file stack.h


typedef struct c_stack *stack;

// prototipi

stack newStack(void);

int emptyStack(stack s);

int pop(stack s);

int push(item val, stack s);

item top (stack s);
