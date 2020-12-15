Feature: Delete operation
Verify different DELETE operations using REST-assured

Scenario: TC004_Verify DELETE operation after POST   
    Given I ensure to Perform POST operation for "/posts" with body as
      | id | title              | author            |
      | 5  | API Testing        | ExecuteAutomation |
    And  I Perform DELETE operation for "/posts/{postid}/"
      | postid |
      | 5      |
    And I perform GET operation with path parameter for "/posts/{postid}"
      | postid |
      | 5      |
    Then I "should not" see the body with title as "API Testing course"