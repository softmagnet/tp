---
layout: page
title: Ong Zheng Lin's Project Portfolio Page
---

### Project: TimesTable

TimesTable is a desktop address book plus planner application for tuition teachers to keep track of their students 
and classes. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, 
and has about 17 kLoC.

Given below are my contributions to the project.

* **New feature**: Added a schedule command that filters and sort students by their class timing (V1.2)
  * What it does: Allows the user to filter students by day of which they are attending their class, so that user 
    can see who he is teaching and when.
  * Justification:  Provides early functionality to sort students by their class timing during the early phases of 
    the application. Provides some early work towards functions like `sort` and back-end processing of 
    `TuitionClass` and `ClassTiming`.
  * Highlights: Provide a foundation for later iteration which improved the functionality of `TuitionClass` and `ClassTiming`.
  
* **New feature**: Added the GUI support for the `TuitionClass list` in the `classes` tab 

* **Code contributed**: [Reposense](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?search=f11&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-09-17&tabOpen=true&tabType=authorship&tabAuthor=Ongzl&tabRepo=AY2122S1-CS2103T-F11-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false)
  
* **Enhancements to existing features**:
    * Link the `JSON` file and `UniqueClassList` in model, allowing the model to save (Commits [1](https://github.com/AY2122S1-CS2103T-F11-1/tp/commit/e632b2de0b0f44bc67e84de601d8632e28696bf1),
      [2](https://github.com/AY2122S1-CS2103T-F11-1/tp/commit/7ddac4e24d6abc6da6b669c0daf50a85601c3f5a),
      [3](https://github.com/AY2122S1-CS2103T-F11-1/tp/commit/d344612297e2d21c988653b51a7eaa7d409cdacb),
      [4](https://github.com/AY2122S1-CS2103T-F11-1/tp/commit/39d388fd3f0bf55dd3dcab9995d41ccf0419f0c6))
    * Wrote additional tests for existing features to increase coverage (Pull request [\#234](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/234))
    * Bug fixes for features `Class size` in `classes` tab and `Student list` in `classes` tab (Pull request [\#106](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/106) , [\#137](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/137))
    * Fix old test cases which were outdated due to change in commands (Pull request [\#115](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/115), [\#155](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/155))
  
* **Documentation**
  *User Guide:
    * Added some documentation for features `addclass`, `deleteclass`, `addtoclass`, `editclass`, `findclass`, 
      `listclass` [\#130](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/130)
  * Developer Guide
    * Added use cases [\#17](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/17)
  
* **Community**
  * PRs reviewed (with non-trivial review comments): (Pull request [\#26](),
    [\#40](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/40),
    [\#47](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/47#partial-pull-merging),
    [\#53](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/53),
    [\#92](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/92),
    [\#152](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/152),
    [\#237](https://github.com/AY2122S1-CS2103T-F11-1/tp/pull/237))
  * Reported bugs for other teams during PE-D: [ped issues github](https://github.com/Ongzl/ped/issues)