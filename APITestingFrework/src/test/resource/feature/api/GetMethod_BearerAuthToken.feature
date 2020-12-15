Feature: Verify Get method using the Brearer Authentication Tokens

Scenario: TC001_Verify GET operation with bearer authentication token
    Given I perform authentication operation for "/auth/login" with body
      | email             | password |
      | techie@email.com  | techie    |
     And I perform GET operation for "/posts/2"
     Then I should see the author name as "Amita"