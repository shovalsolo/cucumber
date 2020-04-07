# Example for Dependency Injection
@tag
Feature: Login Functionality 
	In order to do internet banking
	As a valid Para Bank customer
	I want to login successfully

@tag6
Scenario Outline: Login Successful
    Given am in the login page of the Para Bank Application
    When enter valid <username> and <password> with <userFullName>
    Then should be taken to the Overview page

Examples:
    |username|password|userFullName|
    |"qatest"|"qatest1"|"qatest qatest"|

