Feature: To test contact form works when there are no errors

  Scenario: Check form is validated when there are no errors
    Given I am on the zoo website
    When I navigate to "contact_link"
    And populate the contact form
      | Fields   | Value         |
      | Name     | Jack Joe      |
      | Address  | Happy Land    |
      | Postcode | A1 522        |
      | Email    | test@test.com |
    Then I check page title is "Contact Confirmation"