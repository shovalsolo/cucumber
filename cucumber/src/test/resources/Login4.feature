# Example for how to use Hooks

#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully

@tag5
Scenario: Login Successful
  
Given I am in the login page of the Bank Application Hooks
When I enter the valid credentials Hooks
|qatest|qatest1|
Then I should be taken to the Overview page screen Hooks

