# Duck - User Guide
By: `Wang Qin` Since: `Sep 2020`


* [1. Introduction](#introduction)
* [2. Quick Start](#quick-start)
* [3. Features](#features)
    + [3.1. Add a task:](#addtask) `add`
    + [3.2. Undo previous operations:](#undo) `undo`
    + [3.3. Delete a task:](#delete) `delete`
    + [3.4. Mark a task as done:](#done) `done`
    + [3.5. Check all task due/happene on a certain date:](#due) `due`
    + [3.6. Search tasks by a keyword:](#find) `find`
    + [3.7. List all tasks:](#list) `list`
    + [3.8. Delete all tasks:](#clear) `clear`
    + [3.9. Display system preferences:](#sys) `sys` 
    + [3.10. Change system language:](#change) `change`
    + [3.11. Allow entering duplicated tasks:](#allow) `allow`
    + [3.12. Change username:](#username) `username`
    + [3.13. Change password:](#pw) `pw`
    + [3.14. Traverse history command:](#Navi) `UP``DOWN`
    + [3.15. Display all functions:](#help) `help`
    + [3.16. Exit the program:](#bye) `bye`
* [4. FAQ](#faq)
* [5. Command Summary](#command-summary)


<a name="introduction"></a>


##  1. Introduction
Duck is a task manage system

<a name="quick-start"></a>

## 2. Quick Start

*    Ensure that `Java 11` or above is installed in your Computer.
*    Download the latest `Duck.jar` [_here_](https://github.com/JosephLimWeiJie/duke/releases/download/v0.2.0/duke.jar).
*    Double click the jar file
*    Enter the correct `username` and `password` (default username is `duck` default password is `123`) ,then press `ENTER` key

  ![Alt Text](./login.gif)


<a name="features"></a>
## 3. Features

No. | Command | Purpose | Syntax
----|---------|---------|-------
1|todo |Add a `todo` task|_todo \<taskname\>_
2|deadline | Add a `deadline` task|_deadline \<taskname\> /by \<deadline datetime\>_
3|event|Add an `event` task|_event \<task name\> /at \<start datetime\>
4|undo|Undo a `DATA-EDIT` operation|_undo_
5|delete|Delete a task|_delete \<index\>_
6|done|Mark a task as done|_done \<index\>_
7|due|Check all tasks on a specific date|_due \<date\>_
8|find|Search tasks by keyword|_find \<keyword\>_
9|list|List all tasks|_list_
10|clear|Delete all tasks|_clear_
11|sys|Display system preferences|_sys_
12|change|Change system language|_change \<para\>_
13|allow|Allow user entering duplicated tasks|_allow \<para\>_
14|name|Change username|_name \<new username\>_
15|pw|Change password|_pw \<new password\>_
16|UP/DOWN|Traverse history command|_UP/DOWN_
17|help|Display all functions|_help_
18|bye|Exit the program|_exit_

<a name="addtask"></a>

### 3.1 Add a task: `add`

Adds a task into Duck
There are two ways of adding tasks to the system.
The first (recommanded) way is using the 'menu bar' at the top left corner of the program.
It is recommanded because you can select the date using the calendar.

*       Click the 'New' -> 'Task'
*       Select the corret task type 
*       Enter 'task infomation' and select 'date' if neccessary

![Alt Text](./add_task_through_bar.gif)

The second way of adding tasks is through through the command line.

* **Format**: 
    * `todo TASK_DESCRIPTION`
    * `deadline TASK_DESCRIPTION /by DATE_TIME`
    * `event TASK_DESCRIPTION /at START_DATE_TIME`

* **Examples**:
    * `todo return book`
    * `deadline Thesis submission /by 12-12-2019`
    * `event Wedding Ceremony /at 12-12-2019`
    
    
    ![Alt Text](./add_todo.gif)
    

<a name="list"></a>

### 3.2. Undo previous operations: `undo`

This command allows you undo your previous 'DATA-EDIT' operations.
'DATA-EDIT'operations refer to those operations that modify the task list in the system. 
Some examples for 'DATA-EDIT'operations are 'add task', 'clear', 'delete', 'done'.
In the example gif below, the user deleted all his tasks mistakenly, he tries to undo the operation by this command.

**Format**: `undo`

![Alt Text](./undo.gif)


<a name="delete"></a>

### 3.3 Delete a task: `delete`
Deletes a specified task from Duke.

**Format**: `delete INDEX`

* **Examples**:
    * delete 1
    * delete 2

```javascript
    * Deletes the task at the specified INDEX.
    * The index refers to the index number shown on the displayed task list.
    * The index must be a positive number 1,2,3,...
```
   ![Alt Text](./delete_command.gif)


<a name="done"></a>

### 3.4 Mark a task as done: `done`

You can simply mark a task as done by its index.

**Format** : `done` + task index

**Example**: `done 1`

```javascript
    * The index refers to the index number shown on the displayed task list.
    * The index must be a positive number 1,2,3,..
```
    
   ![Alt Text](./done.gif)

<a name="due"></a>

### 3.5 Check all tasks on a specific date: `due`
Check all tasks on a specific date

**Format**: `due`

**Example**: `due 12-12-2020`

   ![Alt Text](./due.gif)
    
    
<a name="find"></a>

### 3.6 Search tasks by a keyword: `find`

Search tasks by a keyword.

**Format**: `find` + INDEX

* **Examples**:
    * find book



<a name="list"></a>

### 3.7. List all tasks: `list`

List all tasks.
Sometimes you may have a very long task list, you can always scroll up / down with you mouse.

**Format**: `list`



<a name="clear"></a>

### 3.8. Delete all tasks: `clear`
This command allows you quickly delete all you current tasks.
It could be dangerous if you mistakenly use this command. 
However, you can always use `undo` command to recover your data.

**Format**: `clear`

* **Example**:
    * clear

    ![Alt Text](./clear.gif)


<a name="sys"></a>

### 3.9 Display system preferences: `sys` 

Display system preferences.
System language
System music
System duplicated tasks allowed
Username
Password

**Format**: `sys`


   ![Alt Text](./sys.gif)


<a name="change"></a>

### 3.10 Change system language: `change`

Changes the system display language.
Both upper-case and lower-case formats are accepted.
The default language is English.
(The duck system supports English and Chinese)

**Format**: `change Language`
* **Example**:
    * change Chinese
    
    ![Alt Text](./change_language.gif)



<a name="allow"></a>

### 3.11 Allow user entering duplicated tasks: `allow`

Change the setting about duplicated tasks.
The parameter `0` means not allowing duplicated tasks.
The parameter `1` means not allowing duplicated tasks.
The default setting for duplicated tasks is allowing duplicated tasks.

**Format**: `allow` + parameter
* **Example**:
    * allow 0
    
    ![Alt Text](./allow.gif)
    
    
<a name="username"></a>

### 3.12 Change username: `username`

Duck allows you customize your username. 
However, since the username is used when you login the system, make sure you remember the username.
Incase you forget your username, you can always find it inside the `data` folder.
The first line is the username.
The default username is `duck`.

**Format**: `username` + username
* **Example**:
    * username duck
    
    ![Alt Text](./username.gif)


<a name="pw"></a>

### 3.13 Change password: `pw`

Duck allows you customize your password as well. 
However, since the username is used when you login the system, make sure you remember the password.
Incase you forget your password, you can always find it inside the `data` folder.
The second line is the password.
The default password is `123`.

**Format**: `pw`
* **Example**:
    * pw 123
    
    ![Alt Text](./pw.gif)
    
    

<a name="Navi"></a>

### 3.14 Traverse history command: `UP``DOWN`

Want to input a command quickly?
If you have used the command previously, then congratulation! 
You can easily navigate previous command by press the `UP``DOWN` key on you keyboard.

**Format**: `UP``DOWN`

    
   ![Alt Text](./traverse_history_command.gif)
    

<a name="help"></a>

### 3.15 Display all functions: `help`

Unfamililar with some DUCK commands?
The help command is designed for you to quickly check all possible commands.
There are two ways of displaying all the commands.
The first way is using the menu bar at the top left corner.
`Help` -> `Display Help Message`

   ![Alt Text](./help_bar.gif)

The second way is using the command line by typing in `help`.

**Format**: `help`


### 3.16 Exit the program: `exit`

Exit the program.
The program will automatically save all your tasks before it closes.

**Format**: `exit`


<a name="faq"></a>

## 4. FAQ


*Q1:* Why the program name is DUCK?

*A:* Quake, Quake!


*Q2:* What is the backgound music used in the program?

*A:* https://www.bilibili.com/video/BV1VZ4y1u7qy 


*Q3:* Why the jar file is larger than others?

*A:* Because the jar file includes several third-party libraries.  




<a name="command-summary"></a>

## 5. Summary of Commands

No. | Command | Purpose | Syntax
----|---------|---------|-------
1|todo |Add a 'todo' task|_todo \<taskname\>_
2|deadline | Add a 'deadline' task|_deadline \<taskname\> /by \<deadline datetime\>_
3|event|Add an 'event' task|_event \<task name\> /at \<start datetime\>
4|undo|Undo a 'DATA-EDIT' operation|_undo_
5|delete|Delete a task|_delete \<index\>_
6|done|Mark a task as done|_done \<index\>_
7|due|Check all tasks on a specific date|_due \<date\>_
8|find|Search tasks by keyword|_find \<keyword\>_
9|list|List all tasks|_list_
10|clear|Delete all tasks|_clear_
11|sys|Display system preferences|_sys_
12|change|Change system language|_change \<para\>_
13|allow|Allow user entering duplicated tasks|_allow \<para\>_
14|name|Change username|_name \<new username\>_
15|pw|Change password|_pw \<new password\>_
16|UP/DOWN|Traverse history command|_UP/DOWN_
17|help|Display all functions|_help_
18|bye|Exit the program|_exit_





