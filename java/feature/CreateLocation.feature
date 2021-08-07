Feature: Create Update Delete location


Scenario: Tc_001_Login using positive credentials
Given Enter the username as 'cypress@Testleaf.com'
Given Enter the password as 'Selbootcamp@1234'
When click Login Button
When click App Launcher
When click viewAll
When click locations
When click new in Location page
When Enter Location Name
When Enter Location Type
When Enter the External Reference
When Click on save
Then Verify the location created 
When click edit on location 
When change the location type to Building as 'Building'
When Get the text of last modified by and seperate the text from it
When click on save
Then Verify the location type is updated
When Select Delete on location
When Click Delete on Upcoming popup
Then Verify the location is deleted
