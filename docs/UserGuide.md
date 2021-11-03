---
layout: page
title: User Guide
---

![Logo](images/TimestableLogo.png)

TimesTable is a **desktop app for managing your tuition students and classes, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, TimesTable can get your class management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer, if you do not, you can download it from [here](https://www.oracle.com/java/technologies/downloads/#jdk17-linux).

1. Download the latest `timestable.jar` from [here](https://github.com/AY2122S1-CS2103T-F11-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample student data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press 'Enter' to execute it. e.g. typing **`help`** and pressing 'Enter' will open the help window.<br>
   Here are some example commands which you can use on our sample students data before using your own students data:

   * **`add `**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 nok/ n/Jack Doe p/10987654 e/jackd@example.com a/311, Clementi Ave 2, #02-25` : Adds a contact named `John Doe` to the Address Book.

   * **`delete `**`3` : Deletes the 3rd contact shown in the current list.
   
   * **`sort `**`name asc` : Sorts the students by their name in ascending alphabetic order.
    
   * **`addclass `**`cn/Sec 4 A Maths ct/FRI 11:30-13:30 r/70 l/Nex Tuition Center`: Adds a new class with name 'Sec 4 A Maths', with class timing MON 11.30-13:30, with hourly rate of $70, at Nex Tuition Center.
    
   * **`addtoclass `**`1 2 3`: Adds the 2nd and 3rd student in the student list in the `students` tab into the 1st class in the `classes` tab

   * **`view `**`classes` : Changes the tab the user is on to the `classes` tab which displays all the classes.
   
   * **`view `**`timetable` : Changes the tab the user is on to the `timetable` tab which displays a timetable with all the classes. 
   
   * **`exit `** : Exits the app.

1. Once you are ready to fill in Timestable with your own students, simply use the  **`clear`** command to delete all the sample students, instead of having to delete them one by one.
   Now you can start putting your students into Timestable.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the inputs to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is an input which can be used as `add n/John Doe`.

* The inputs before the `/` are known as _parameters_, and the ones after the `/` are known as _arguments_.<br>
  e.g `n/NAME` (`/n` is the parameter for name, `NAME` is the argument),   
  e.g `a/ADDRESS` (`/a` is the parameter for name, `ADDRESS` is the argument) etc.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* For commands that require next-ok-kin (NOK) information, all inputs regarding NOK should be after `nok/` and all
  inputs regarding the student should be before `nok/`. Timestable does not allow order swap!<br>
  e.g. `n/John p/97833242 … /nok n/Harry p/87738383 …` `John` and `97833242` are information belonging to the student
  and `John`'s NOK's name is `Harry` whose phone number is `87738383`.

* For commands that require index (e.g. EditClass, AddToClass, etc), zero, negative and out-of-range indices are 
rejected with an error message.

</div>

### Clearing all entries : `clear`
<hr>

Clears all entries from the address book.

Format: `clear`

### Adding a student: `add`
<hr>

Adds a student to the address book.

Format:
```
add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]… nok/ n/NOK_NAME p/NOK_PHONE_NUMBER e/NOK_EMAIL a/NOK_ADDRESS
```

* This is a command that requires next-of-kin (NOK) information.
* This command is split into two segments (excluding command keyword). The first segment are the inputs before
  `nok/` and the second segment are the inputs after `nok/`.
    * The segments are not fixed in order and inputs in the first segment are about student information whereas inputs in the second segment are about NOK's information.
* The order of input within its own segment is swappable.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A student can have any number of tags (including 0).
</div>

Examples:

```
add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 t/ALevels nok/ n/Mary Doe p/93334848 e/mary23@gmail.com a/311, Clementi Ave 2, #02-25 
```

```
add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/slow learner nok/ n/Karen e/karenSUper@gmail.com p/99994444 a/311, Clementi Ave 2, #02-25 
```

### Adding a class: `addclass`
<hr>

Add a class to the address book.

Format:

```
addclass cn/CLASS NAME ct/CLASS_TIMING r/HOURLY_RATE l/LOCATION
```

* This command adds a new class to keep track of all classes that the user is teaching.
* `CLASS_TIMING` must be in the form `ct/DAY HH:MM-HH:MM`
* `DAY` is case insensitive.
* `CLASS_TIMING` can only start at the hour mark or half hour mark, but can end at 23:59

Examples:
```
addclass cn/Sec 4 A Maths ct/MON 11:30-13:30 r/70 l/Nex Tuition Center
```
Adds a new class with name `Sec 4 A Maths`, with class timing `MON 11:30-13:30`, with hourly rate of $`70`, at `Nex
Tuition Center`.

```
addclass cn/Sec 4 E Maths ct/TUE 12:30-14:30 r/65 l/Block 123, Clementi Ave 6, #14-41
```
Adds a new class with name `Sec 4 E Maths`, with class timing `Tue 12:30-14:30`, with hourly rate of $`65`, at `Block 123, Clementi Ave 6, #14-41`.


### Adding student/students to a class: `addtoclass`
<hr>

Add a single or multiple students to an existing class.

Format:
```
addtoclass CLASS_INDEX STUDENT_INDEX...
```

* This command adds any number of existing students into an existing class.
* `CLASS_INDEX` is the index number of the class in the displayed class list in the `classes` tab, which will be
  receiving the new students.
* `STUDENT_INDEX...` are the index number/s of the students shown in the displayed student list, these students are
  to be added into the class.
* Exactly one class index must be provided and at least one student index must be provided
* Students that already exist in the class can't be added to the same class
* If you enter duplicate student indices in one command, it will work normally as Timestable just adds the student once.

Example:
```
addtoclass 1 1 2 3
```
Adds the 1st, 2nd and 3rd student in the displayed student list in the `students` tab into the 1st class in the
displayed class list in the `classes` tab.

### Editing a student : `edit`
<hr>

Edits an existing student in the address book.

Format:
```
edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​ [nok/] [n/NOK_NAME] [p/NOK_PHONE_NUMBER] [e/NOK_EMAIL]

```

* Edits the student at the specified `INDEX`. The index refers to the index number shown in the displayed student
  list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* An optional `nok/` field can be provided to edit the student's next-of-kin (NOK). All fields that come after `nok/`
  will be for the student's next-of-kin. (same rule from `add` command applies)
    * If `nok/` is provided, at least one of the optional fields belonging to NOK must be provided.
* When editing tags, the existing tags of the student will be removed i.e adding of tags is not cumulative.
    * You can remove all the student's tags by typing `t/` without
      specifying any tags after it.

Examples (editing student information only):
* `edit 1 p/91234567 e/johndoe@example.com` Edits the `PHONE` and `EMAIL` of the 1st student to be `91234567` and `johndoe@example.com` respectively.
* `edit 2 n/Betsy Crower t/` Edits the `NAME` of the 2nd student to be `Betsy Crower` and clears all existing `TAG`s.
* `edit 1 n/kevin p/12345678` Edits the `NAME` and `PHONE` of student 1 to become `kevin` and `12345678`.
* `edit 4 n/John Walker a/4 Petir Road #16-04 Singapore 657891` Edits the `NAME` and `ADDRESS` of the 4th person to be
  `John Walker` and `4 Petir Road #16-04 Singapore 657891` respectively.

Examples (also editing parent information):
* `edit 2 nok/ p/98429239 ` Edits 2nd student's NOK's `PHONE` to be `98429239`.
* `edit 3 a/Com2 nok/ p/98429239 ` Edits 3rd student's `ADDRESS` to be `Com2` while also editing
  NOK's `PHONE` to be `98429239`.

### Editing a class: `editclass`
<hr>

Edits an existing class in the class list in the `classes` tab.

Format:
```
editclass 1 [cn/CLASS_NAME] [ct/CLASS_TIMING] [r/RATE] [l/LOCATION]
```

* Edits the class at the specified `INDEX`. The index refers to the index number shown in the displayed class
  list in the `classes` tab. 
  * The index **must be a positive integer** 1, 2, 3, …​
  * The index must also not be out of rage.
* At least one of the optional fields must be provided.
* `CLASS_TIMING` can only start at the hour mark or half hour mark.
* Edit commands that will create a **clash of class timing** is not accepted.

Examples:
* `editclass 1 ct/wed 15:00-17:00` Edits the first class in the class list's `CLASS_TIMIMG` to be `WED 15:00-17:00`.

### Sorting students and classes: `sort`
<hr>

Sorts the students based on thier `NAME` alphabetically, 
or classes based on `CLASS_TIMING` in ascending or descending order.

Format:
```
sort PARAMETER_TO_SORT_BY DIRECTION_OF_SORT
```

* `PARAMETER_TO_SORT_BY` can either be `students` or `timing` which sorts the students and classes respectively.
* `DIRECTION_OF_SORT` can either be `asc` or `desc` to represent ascending and descending respectively.

Examples:
* `sort name asc` sorts students alphabetically by their `NAME` in ascending order.
* `sort name desc` sorts students alphabetically by their `NAME` in descending order.
* `sort timing asc` sorts classes based on their `CLASS_TIMING` starting from the earliest in the week to the latest.
* `sort timing desc` sorts classes based on their `CLASS_TIMING` starting from the latest in the week to the earliest.

### Locating students by name: `findname`
<hr>

Finds students whose `NAME` contain any of the given keywords.  
Note that you have to run `list` to display all the students again.

Format:
```
findname KEYWORD, [MORE_KEYWORDS]
```

* The search is case-insensitive. e.g. `hans` will match `Hans`.
* The keywords are split by commas. e.g. `findname alex lim, bernice yu`
* Only the `NAME` is searched.
* Partial matches will still be matched e.g. `Han` will match `Hans`.
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `findname alex lim, bernice yu` will return `Alex Lim`, `Bernice Yu`.
* The entire keyword is used for matching e.g. `findname Alex L` will match `Alex Lim`
    but not `Alex Yu`

Examples:
* `findname John` returns `john` and `John Doe`.
* `findname alex, david` returns `Alex Yeoh`, `David Li`.<br>

  ![result for 'findname alex david'](images/findAlexDavidResult.png)

### Locating class by class timing : `findclass`
<hr>

Finds a class whose `CLASS_TIMING` matches the given keyword.  
Note that you have to run `listclass` to display all the classes again.

Format: `findclass KEYWORD...`

<!---todo fill in inner working--->

* The valid keywords for this command are limited to the following types:
    1. 3 letter abbreviation for day of the week e.g. `Mon`, `Tue`, etc.
    2. Time expressed in HH:MM-HH:MM format   e.g. `11:30-12:30`, `15:00-16:00`, etc.
* Either a single keyword or two keywords of different types should be provided or no classes would be returned
  because a single class can't happen at two different times.
    * Important clarifications: In timestable, class refers to a single session of a type of class. E.g. A Physics class
      might have multiple sessions, but each session can only occur at one time.
* If two keywords are entered, then the class returned would be the one that match all the keywords
  (see example below).

Examples:
1. Single keyword
    * `findclass mon` returns all classes on Monday
    * `findclass 10:00-12:00` returns all classes scheduled for `10:00 to 12:00` no matter which day of the week it belongs
      to
2. two keywords
    * `findclass mon 11:00-12:00` returns the exact class on `Mon at 11:00-12:00`.
    * `findclass tue 11:00-12:00` returns the exact class on `Tue at 11:00-12:00`.
   

### Locating class by class name: `findclassname`
<hr>

Finds a class whose class name matches the given keywords.  
Note that you have to run `listclass` to display all the classes again.

Format:
```
findclassname KEYWORD...
```
<!---todo fill in inner working--->

* Case-insensitive `PHYSICS` will match 'physics'.
* Each keyword is separated by a space.
* Only classes that match all keywords will be shown.
* A match happens when a whole word is matched and not a part e.g. if keyword is `Phy` then the class with name
  `Physics` would not be part of the result because it is not a whole word match.

Examples:
* `findclassname math` returns all the classes with math in the class name.
* `findclassname Sec 4 maths` returns all the classes with `sec`, `4`, and `maths` in the class name. Hence,
  class with name `maths sec 4` and class with name `sec 4 maths` would both be returned.

### Locating students by tag: `findtag`
<hr>

Finds students whose `TAG`s contain any of the given keywords.  
Note that you have to run `list` to display all the students again.

Format:
```
findtag KEYWORD, [MORE_KEYWORDS]
```

* The search is case-insensitive. e.g `math` will match `Math`.
* The keywords are separated by commas. e.g. `findtag math, physics` will find students
  with tags containing `math` or `physics`.
* Only the `TAG` is searched.
* Partial matches will still be matched e.g. `math` will match `A Math`, `C Math`, and `Math`.
* Students matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `findtag math, physics` will return students with the `Math` `TAG` but no `Physics` `TAG`,
  students with only the`Physics` `TAG` but no `Math` `TAG`, and students with both `TAG`s.

Examples:
* `findtag math` returns `Alex Yeoh` with the `A Math` `TAG` and `John Doe` with the `C Math` `TAG`.
* `findtag math, physics` returns `Alex Yeoh` with the `A Math` and `Biology` `TAG`s.
  <br>

### Viewing of different tabs: `view`
<hr>

Views an existing tab in Timestable without the need to use the mouse to click.

Format:
```
view TAB_TO_VIEW   
```

* `TAB_TO_VIEW` has to be an existing tab in Timestable (`students`, `classes`, `timetable`).

Examples:
* `view timetable` switches the displayed tab to be the `timetable` tab.

### Selecting of classes: `class`
<hr>

Selects a class in the class tab and displays its students without the need to use the mouse to click.

Format:
```
class CLASS_INDEX   
```

Examples:
* `class 1` selects the class with `CLASS_INDEX` of `1` and displays its students in the class tab.

### Listing all students : `list`
<hr>

Shows a list of all students in the Students tab.

Format: `list`

### Listing all the classes: `listclass`
<hr>

Shows a list of all classes in the Class tab.

Format: `listclass`

### Removing students from a class: `removefromclass`
<hr>

Removes a single or multiple students from an existing class.

Format:
```
removefromclass CLASS_INDEX STUDENT_INDEX...
```

* This command removes any number of existing students from an existing class.
* `CLASS_INDEX` is the index number of the class in the displayed class list in the `classes` tab, which will be
  removing the students.
* `STUDENT_INDEX...` are the index number/s of the students shown in the displayed student list of the class to remove from in the `classes` tab, these students are
  to be removed from the class.

Example:
```
removefromclass 1 1 2 3
```
Removes the 1st, 2nd and 3rd student in the displayed student list of the 1st class in the `classes` tab.

### Deleting a student : `delete`
<hr>

Deletes the specified student from the address book.

Format:
```
delete INDEX
```
* Deletes the student at the specified `INDEX`.
* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd student in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st student in the results of the `find` command.

### Delete a class: `deleteclass`
<hr>

Deletes the specified class from the address book.

Format:
```
deleteclass INDEX
```

* Deletes the class at the specified `INDEX`.
* The index refers to the index number shown in the displayed class list in the `classes` tab.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `listclass` followed by `deleteclass 2` deletes the 2nd class in the address book.

### Viewing help : `help`
<hr>

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Exiting the program : `exit`
<hr>

Exits the program.

Format: `exit`

### Saving the data
<hr>

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file
<hr>

AddressBook data are saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>

[comment]: <> (### Showing the schedule for a specific day : `schedule`)

[comment]: <> (Shows the contacts of students who have classes on a specific day.)

[comment]: <> (Format: `schedule DAY`)

[comment]: <> (Examples:)

[comment]: <> (* `schedule Monday` will show all contacts with classes on monday.)

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Add class** | `addclass cn/CLASS NAME ct/CLASS_TIMING r/HOUELY_RATE l/LOCATION` <br> e.g., `addclass cn/Sec 4 A Maths ct/mon 11:30-13:30 r/70 l/Nex Tuition Center`
**Add to class** | `addtoclass CLASS_INDEX STUDENT_INDEX...` <br> e.g., `addtoclass 1 1 2 3`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Delete class** | `deleteclass INDEX` <br> e.g., `deleteclass 2`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG] …​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Edit class** | `editclass 1 [cn/CLASS_NAME] [ct/CLASS_TIMING] [r/RATE] [l/LOCATION]` <br> e.g., `editclass 1 ct/wed 15:00-17:00`
**Exit** | `exit`
**Find name** | `findname KEYWORD [MORE_KEYWORDS]` <br> e.g., `find Stuart`
**Find class** | `findclass CLASS_TIMING` <br> e.g., `findclass mon 11:00-12:00`
**Find class name** | `findclassname KEYWORD` <br> e.g., `findclassname math`
**Find tag** | `findtag KEYWORD, [MORE_KEYWORDS]` <br> e.g., `findtag  math, physics`
**Help** | `help`
**List** | `list`
**List class** | `listclass`
**Remove from class** | `removefromclass CLASS_INDEX STUDENT_INDEX...` <br> e.g., `removefromclass 1 1 2 3`
**Select class** | `class` <br> e.g., `class 1`
**Sort** | `findclassname PARAMETER_TO_SORT_BY DIRECTION_OF_SORT` <br> e.g., `sort name asc`
**View** | `view TAB_TO_VIEW` <br> e.g., `view timetable`

## Glossary
- NOK: Next-of-kin. Refers to the student's guardian, parent or perhaps close friend to be contacted regarding admin matters like payment. 
- Parameters: Inputs in a command that are before the `/`. 
- Arguments: Inputs in a command after the `/`.  
  e.g `n/NAME` (`/n` is the parameter for name, `NAME` is the argument),   
  e.g `a/ADDRESS` (`/a` is the parameter for name, `ADDRESS` is the argument) etc.

