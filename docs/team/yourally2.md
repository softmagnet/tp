---
layout: page
title: Kevin Chua's Project Portfolio Page
---

### Project: TimesTable

TimesTable is a desktop address book plus planner application for tuition teachers to keep track of their students 
and classes. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, 
and has about 17 kLoC.

Given below are my contributions to the project.

* **New feature**: Overloaded `edit` and set up base for overloading `add` command to allow user to add the next-of-kin (nok) of the Student.
  * What it does: Allows the user to add/edit a Student's nok with name, address, and location when adding/editing a Student.
  * Justification:  This feature allows the user to quickly add and edit relevant details of an nok .
   It greatly enhances the user experience to be able to see a Student's
  Next-Of-Kin easily to contact them for payments or to report something about the Student.
  * Highlights: This enhancement went through several iterations as we initially implemented the
  `nok` command to specifically to add/edit an nok, but settled on overloading the `add` and `edit` command because it would
  be faster and less confusing to add an `nok` and the Student at once.
  * Pull Requests: [\#26](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/26) [\#47](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/47)
 
* **New feature**: Store next-of-kin (nok) information in a nested json
    * What it does: Allows the saving of nok information
    * Justification:  This is so that when the program is closed and reopened, the nok information is retained. This is important as all other information is retained upon close as well.
    * Highlights: I decided to nest the json in a key `nok` instead of having fields like `nok_name`, `nok_phone` etc because it becomes clear to the user and developers what the fields are for.
    * Pull Request: [\#65](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/65)

* **New feature**: Improved colours for the GUI overall
    * What it does: Makes TimesTable more visually striking
    * Justification: The visual aspect of apps is more important than we realise and can often decide whether a user wants to use our app or not.
    * Highlights: Selecting the appropriate colour was more difficult than expected and finding the css to change was not easy.
    * Pull Request: [\#217](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/217)

* **New feature**: Added the GUI and related behaviour for the class tab
    * What it does: Allows the user to visually see which students belong to each respective class by double clicking on the class
    or using a command which is described in another section. The user can see the size of the class which changes as the number
  of students in the class change. 
    * Justification: The visual aspect allows the user to quickly tell which students belong to a class at a glance. It is also
    intuitive to use as double clicking on a class to see the students is very natural. This forms the backbone of the class feature
  as all interactions with the class is done in this tab.
    * Highlights: A deep understanding of how the GUI functioned together with the different recommended design patterns was required.
It was challenging to consider the flow of data for components while ensuring that the GUI turned out appealing.
    * Pull Request: [\#103](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/103)

* **New feature**: Add `class` feature to view a specific class without double clicking
    * What it does: It shows the students belonging to the specified class. Does the same thing as double clicking on a class. 
    * Justification: As Stuart mentioned, it is crucial because it follows the mindset of not touching the mouse or using voice commands. 
    It allows us to perform the same functionality without using a mouse, which is important.
    * Highlights: It was challenging to modify the GUI using a command, so after discussing with Stuart we decided to follow the Observer pattern,
   which proved to be very useful.
    * Pull Request (same PR as GUI): [\#103](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/103)
 
* **Code contributed**: [Reposense](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?search=yourally2&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-09-17&tabOpen=true&tabType=authorship&tabAuthor=yourally2&tabRepo=AY2122S1-CS2103T-F11-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)
  
* **Enhancements to existing features**:
    * Refactor Person to Student and make Student and next-of-kin (NOK) inherit from Person (Pull Request [\#30](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/30))
    * Wrote tests for `FindClassCommandParser` and `FindClassCommand` (Pull request [\#258](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/258)
    * Bug fixes for GUI, `class` command and `Student list` in `classes` tab (Pull request 
      [\#248](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/248),
      [\#243](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/243))
  
* **Documentation**
  *User Guide:
    * Fixed various documentation issues and touched up on UG [\#224](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/224)
  * Developer Guide
    * Added user stories [\#22](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/22)
    * Adding a class [\#86](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/86)
  
* **Community**
  * PRs reviewed (with non-trivial review comments): (Pull request,
    [\#256](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/256),
    [\#81](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/81),
    [\#50](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/50),
  * Reported bugs for other teams during PE-D: [ped issues github](https://github.com/yourally2/ped/issues)
  
