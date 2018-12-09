Feature: Registration Page

Scenario: Checking Title of the page
Given User is on RegistrationPage
Then Check the title of the page

Scenario: Entering valid Details
Given User is on RegistrationPage
When User enters all valid details
Then  navigate to next page

Scenario: Entering Invalid FirstName
Given User is on RegistrationPage
When  User enters Invalid FirstName
Then generate  error message

Scenario: Entering Invalid MobileNumber
Given User is on RegistrationPage
When  User enters Invalid MobileNumber
||
|987456321|
|98745632100|
|2365419870|
|3216549870|
|4569871230|
|abcf1345|
Then generate  error message

Scenario: Entering Invalid MailId
Given User is on RegistrationPage
When  User enters Invalid MailId
||
|$sindhu@gmail.com|
|sindhugmail.com|
|sindhu@.com|
|gmail.com|
Then generate  error message

Scenario: Entering Invalid Address 
Given User is on RegistrationPage
When  User enters Invalid adresss
||
Then generate  error message

Scenario: Submits empty form
Given User is on RegistrationPage
When  User doesnot enters any details
And Clicks submit button
Then generate  error message

