  Feature: POST operation
  Verify different POST operations using REST-assured

  Scenario: TC002_Verify Post operation for Profile
    Given I Perform POST operation for "/posts/{profileNo}/profile" with body
      | name | profile |
      | Sams | 2       |
    Then I should see the body has name as "Sams"
    
    Scenario: Verify Post operation for Posts
    Given I ensure to Perform POST operation for "/posts" with body as
     | id | title             | author|
     | 5 | Amruta            | Amruta example |
    Then I should see the body has name as "ExecuteAutomation"