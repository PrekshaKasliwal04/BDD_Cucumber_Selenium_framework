# BDD_Cucumber_Selenium_framework
Code which is written following page-object model in BDD test framework.

Framework details:

It is Maven based project written in Selenium with Java following Behavior driven development. Below is explanation of various aspetcs of project directory

pom.xml - It is an XML file that contains information about the test assignment project and configuration details used by Maven to build the project.

properties: Object repository using properties file,locators are stored in key-value pairs.

src - Contains Projects source files

How to execute: 
1. Import project in eclipse, right click on RunTestNGTest.java and Run As TestNG Test.
2. Run pom.xml

Notes:
Properties file used to maintain object repository. (All locator values are mentioned in properties folder.)
Reusable Methods are written to optimize code, common operational methods are wrriten all pages use methods mentioned at one place.
