 Feature: Verify JSON Validation
 
 Scenario: Verify GET operation with json validation 
    Given I perform authentication operation for "/auth/login" with body
      | email             | password |
      | techie@email.com | techie  |
    Given I perform GET operation for "/posts/1"
    Then I should see the author name as "Abhilasha" with json validation
