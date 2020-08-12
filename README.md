# Automation Project: Lieferando App.

## Introduction
This project was created from scratch using my beginner knowledge in Automation with Selenium. My goal this time is to automate some scenarios on Lieferando App, an online food delivery.

The test cases automated are the following:
*AddressValidationTest: this scenario verifies the address that the user enters and the expected result is to receive the restaurants list that matches with the address entered.
*AddToCartValidation: this scenario verifies all the steps from the start when the users enter its address, choose a restaurant and finally the user add a new item to the cart.
*PaypalPaymentValidation: this scenario is an E2E test case that starts from the beginning when the user enters its address, choose a restaurant and a menu, completes the delivery information and finally go to the PayPal page to pay his order.

#### *IDE: 
Eclipse
#### *Test automation framework: 
Selenium.
#### *Selenium tool: 
Selenium WebDriver.
#### *Programming language: 
Java.
#### *Type of Framework: 
I used the hybrid framework using page object model design pattern. for test data, I used data provider of Testng framework.
As per Page Object Model, I have maintained a separate class for every webpage. Each webpage has a separate class and these class holds all the elements locators and methods 
with the actions on this elements. I also separate classes for every individual test.

#### *Maven: 
Using Maven for build, execution, and dependency purpose.(dependencies added to my POM.xml: Apache POI, webdriverManager, testng)
I defined a standardized maven project, with to folders: all the tests are kept under src/test/java and all the other remaining files are kept under src/main/java (Base class,
test data, element locators (POM classes)).

1) src/main/java
*Test Base Class: with 2 methods: one to initialize the driver, browser configurations, the second method is to close the browser after the test.
*Data: excel file to provide the data to my tests.
*excelReader: java code to take control over the excel file.
*PageObjects: elements locators, one class for every page.

2) src/test/java
TestCases: a class for every test case, one to validate the address inserted, the other test is to add an item to the cart.

#### *Testing Framework: 
Using TestNG for Assertions, Grouping, and Parallel execution.

#### *Version Control: 
GIT.


