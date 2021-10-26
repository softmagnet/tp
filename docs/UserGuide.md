---
layout: page
title: User Guide
---

TimesTable is a **desktop app for managing your tuition students and classes, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, TimesTable can get your class management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer, if you do not, you can download it from [here](https://www.oracle.com/java/technologies/downloads/#jdk17-linux).

1. Download the latest `timestable.jar` from [here](https://github.com/AY2122S1-CS2103T-F11-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

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
  e.g. `n/John p/97833242 … /nok n/Harry p/87738383 …` John and 97833242 are information belonging to the student
  and John's NOK's name is Harry whose phone number is 87738383.


</div>

### Viewing help : `help`


Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

## Deleting a student : `delete`
<hr>

Deletes the specified student from the address book.

Format: `delete INDEX`

* Deletes the student at the specified `INDEX`.
* The index refers to the index number shown in the displayed student list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd student in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st student in the results of the `find` command.

## Adding a student: `add`
<hr>

Adds a student to the address book.

Format:
```
add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS ct/CLASS_TIMING l/LOCATION r/HOURLY_RATE [t/TAG]… nok/ n/NOK_NAME
    p/NOK_PHONE_NUMBER e/NOK_EMAIL
```

* This is a command that requires next-of-kin (NOK) information.
* This command is split into two segments (excluding command keyword). The first segment are the inputs before
`nok/` and the second segment are the inputs after `nok/`.
  * The segments are not fixed in order and inputs in the
  first segment are about student information whereas inputs in the second segment are about NOK's information.
* The order of input within its own segment is swappable.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A student can have any number of tags (including 0)
</div>

Examples:

```
add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 ct/Mon 2-4pm
    l/Hougang ave 5 Block 614 #11-419 r/$50 t/ALevels nok/ n/Mary Doe p/93334848 e/mary23@gmail.com
```

```
add n/Betsy Crowe ct/Mon 5-7pm l/Serangoon Nex  t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567
    t/slow learner r/$70 nok/ n/Karen e/karenSUper@gmail.com p/99994444
```

## Adding a class: `addclass`
<hr>

Add a class to the address book.

Format:

```
addclass cn/CLASS NAME ct/CLASS_TIMING r/HOUELY_RATE l/LOCATION
```

* This command adds a new class to keep track of all classes that the user is teaching.

Examples:
```
addclass cn/Sec 4 A Maths ct/mon 11:30-13:30 r/70 l/Nex Tuition Center
```
Adds a new class with name 'Sec 4 A Maths', with class timing MON 11.30-13:30, with hourly rate of $70, at Nex 
Tuition Center.

```
addclass cn/Sec 4 E Maths ct/tue 12:30-14:30 r/65 l/Block 123, Clementi Ave 6, #14-41
```
Adds a new class with name 'Sec 4 E Maths', with class timing Tue 12.30-14:30, with hourly rate of $65, at Block 123, Clementi Ave 6, #14-41.


## Adding student/students to a class: `addtoclass`
<hr>

Add a single or multiple students to an existing class

Format:
```
addtoclass CLASS_INDEX STUDENT_INDEX...
```

* This command adds any number of existing students into an existing class.
* `CLASS_INDEX` is the index number of the class in the displayed class list in the `classes` tab, which will be 
  receiving the new students.
* `STUDENT_INDEX...` are the index number/s of the students shown in the displayed student list, these students are 
  to be added into the class.
  
Example:
```
addtoclass 1 1 2 3
```
Adds the 1st, 2nd and 3rd student in the displayed student list in the `students` tab into the 1st class in the 
displayed class list in the `classes` tab.

## Delete a class: `deleteclass`
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
* `listclass` followed by `delete 2` deletes the 2nd class in the address book.

## Listing all students : `list`
<hr>

Shows a list of all students in the address book.

Format: `list`

## Listing all the classes: `listclass`
<hr>

Shows a list of all students in the address book.

Format: `listclass`

## Editing a student : `edit`
<hr>

Edits an existing student in the address book.

Format:
```
edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [ct/CLASS_TIMING] [l/LOCATION] [r/HOURLY_RATE] [t/TAG]…​
[nok/] [p/NOK_NAME] [p/NOK_PHONE_NUMBER] [e/NOK_EMAIL]

```

* Edits the student at the specified `INDEX`. The index refers to the index number shown in the displayed student
list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* An optional `nok/` field can be provided to edit the student's next-of-kin. All fields that come after `nok/`
will be for the student's next-of-kin. (same rule from `add` command applies)
  * if `nok/` is provided, at least one of the optional fields belonging to NOK must be provided.
* When editing tags, the existing tags of the student will be removed i.e adding of tags is not cumulative.
  * You can remove all the student's tags by typing `t/` without
      specifying any tags after it.

Examples (editing student information only):
* `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st student to be `91234567` and `johndoe@example.com` respectively.
* `edit 2 n/Betsy Crower t/` Edits the name of the 2nd student to be `Betsy Crower` and clears all existing tags.
* `edit 3 ct/Mon 1pm to 3pm r/$50` Edits the class timing and hourly rate of the 3rd student to be `Mon 1pm to 3pm` and `$50` respectively.
* `edit 1 n/kevin p/12345678 nok/ n/Stuart p/ 87654321` Edits the name and phone number of student 1 to become kevin and 12345678 and set his next-of-kin's name to Stuart and number of next-of-kin to be 87654321.
* `edit 4 n/John Walker l/4 Petir Road #16-04 Singapore 657891` Edits the name and location of the 4th person to be
   `John Walker` and `4 Petir Road #16-04 Singapore 657891` respectively.

Examples (also editing parent information):
* `edit 2 nok/ p/98429239 ` Edits 2nd student's NOK's number to be 98429239.
* `edit 3 ct/Mon 3-4pm nok/ p/98429239 ` Edits 3rd student's class timing to be Monday 3-4pm while also editing
NOK's number to be 98429239.

## Editing a class: `editclass`
<hr>

Edits an existing class in the class list in the `classes` tab

Format:
```
editclass 1 [cn/CLASS_NAME] [ct/CLASS_TIMING] [r/RATE] [l/LOCATION]
```

* Edits the class at the specified `INDEX`. The index refers to the index number shown in the displayed class
  list in the `classes` tab. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.

Examples:
* `editclass 1 ct/wed 15:00-17:00` Edits the 1st class in the class list class timing to be WED 15:00-17:00

## Locating students by name: `findname`
<hr>

Finds students whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)
  
## Locating class by class timing : `findclass`
<hr>

Finds a class whose class timing matches the given class timing.

Format: `findclass CLASS_TIMING`

<!---todo fill in inner working--->

Examples:
* `findclass mon 11:00-12:00` returns the class with class timing at MON 11:00-12:00.

## Locating class by class name: `findclassname`
<hr>

Finds a class whose class name matches the given keywords.

Format: `findclassname KEYWORD`

<!---todo fill in inner working--->

Examples:
* `findclassname math` returns all the classes with math in the class name.

## Clearing all entries : `clear`
<hr>

Clears all entries from the address book.

Format: `clear`

## Exiting the program : `exit`
<hr>

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>

### Showing the schedule for a specific day : `schedule`

Shows the contacts of students who have classes on a specific day.

Format: `schedule DAY`

Examples:
* `schedule Monday` will show all contacts with classes on monday.

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [ct/CLASS_TIMING] [r/HOURLY_RATE] [t/TAG] [l/LOCATION]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
**Schedule** | `schedule DAY`
