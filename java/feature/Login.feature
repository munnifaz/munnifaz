Feature: Login to Salesforce

#Background:
#Given Launch the browser
#And Load the application URL

Scenario: Tc_001_Login using positive credentials
Given Enter the username as 'cypress@Testleaf.com'
Given Enter the password as 'Selbootcamp@1234'
When click Login Button
Then Verify home page is displayed 


#Scenario Outline: Tc_001_Login using positive credentials
#And Enter the username as <username>
#And Enter the password as <password>
#When click Login Button
#Then Verify home page is displayed 

#Examples:
#|username|password|
#|'cypress@Testleaf.com'|'Selbootcamp@1234'|
#|'cypress@Testleaf.com'|'Selbootcamp@123'|

