# ChattyDuke User Guide
ChattyDuke is a **personal assistant chatbot** that helps to keep track of user's tasks. It has the ability allowing
user to add, delete, mark, unmark and to find tasks. Besides, tasks can be categorised into three types such as todo,
deadline ( task with a deadline ), event ( task with a start and end date ).

## Features
> [!NOTE]  
> 1. Command prompt are **case-insensitive** but must be exactly the same.  
> 2. Words in **UPPER_CASE** are the parameters to be supplied by the user.
> 3. For example: todo TASK_NAME where TASK_NAME is a parameter which can be used as todo do revision.  
> 4. Keyword provided for the search function: `find` are **case-sensitive**.

### Adding todo:
Add a todo task into the list.  
Command: `todo TASK_DESCRIPTION`  
Example: `todo read book`  
Expected output:
```
todo read book
    ____________________________________________________________
    Got it. I've added this task:
    [T][ ] read book
    Now you have 4 tasks in the list.
    ____________________________________________________________

    ____________________________________________________________

```

### Adding deadline:
Add a deadline task into the list.  
Command: `deadline TASK_DESCRIPTION /by DEADLINE`  
Example: `deadline read book /by 6th June`  
Expected output:
```
deadline read book /by 6th June
    ____________________________________________________________
    Got it. I've added this task:
    [D][ ] read book (by: 6th June)
    Now you have 4 tasks in the list.
    ____________________________________________________________

    ____________________________________________________________

```

### Adding event:
Add an event task into the list.  
Command: `event TASK_DESCRIPTION /from START_TIME /to END_TIME`  
Example: `event read book /from afternoon /to night`  
Expected output:
```
event read book /from afternoon /to night
    ____________________________________________________________
    Got it. I've added this task:
    [E][ ] read book (from: afternoon to: night)
    Now you have 3 tasks in the list.
    ____________________________________________________________

    ____________________________________________________________

```

### List all tasks:
List out all the tasks saved into the list.  
> [!NOTE]  
> 1. ChattyDuke save remaining task in the list to the hard disk automatically whenever the task list changes.  
> 2. User are able to load the data from the hard disk when the chatbot starts up with the command `list`.  

Command: `list`  
Example: `list`  
Expected output:
```
list
    ____________________________________________________________
    Here are the tasks in your list:
    1.[T][ ] read book
    2.[T][ ] return book (by: June 6)
    3.[E][ ] read book (from: afternoon to: night)
    ____________________________________________________________

```

### Mark task as done:
Mark specific task in the list as done.  
Command: `mark TASK_INDEX`  
Example: `mark 1`  
Expected output:
```
mark 1
    ____________________________________________________________
    Nice! I've marked this task as done:
    [T][X] read book
    ____________________________________________________________
    
```

### Mark task as undone ( Unmark ):
Mark specific task in the list as undone.  
Command: `unmark TASK_INDEX`  
Example: `unmark 1`  
Expected output:
```
unmark 1
    ____________________________________________________________
    OK, I've marked this task as not done yet:
    [T][ ] read book
    ____________________________________________________________

```

### Remove task from list:
Delete specific task in the list.  
Command: `delete TASK_INDEX`  
Example: `delete 1`  
Expected output:
```
delete 1
    ____________________________________________________________
    Noted. I've removed this task:
    [T][ ] read book
    Now you have 3 tasks in the list.
    ____________________________________________________________

```

### Search for task with keyword:
Search for specific task using keyword that matches task description.  
Command: `find KEYWORD`  
Example: `find book`  
Expected output:
```
find book
    ____________________________________________________________
    Here are the matching tasks in your list: 
1. [T][ ] return book (by: June 6)
2. [E][ ] read book (from: afternoon to: night)
3. [D][ ] read book (by: 6th June)
    ____________________________________________________________

```

### End program:
Ends the program.  
Command: `bye`  
Example: `bye`  
Expected output:
```
bye
    ____________________________________________________________
    Bye. Hope to see you again soon!
    ____________________________________________________________

```
