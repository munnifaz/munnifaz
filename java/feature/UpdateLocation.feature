Feature: Login to Salesforce


Scenario: Tc_001_Login using positive credentials
Given Enter the username as 'cypress@Testleaf.com'
Given Enter the password as 'Selbootcamp@1234'
When click Login Button
When click App Launcher
When click viewAll
When click locations
When search location created in Tc001
When click edit on location 
When change the location type to Building as 'Building'
When Get the text of last modified by and seperate the text from it
When click on save
Then Verify the location type is updated













