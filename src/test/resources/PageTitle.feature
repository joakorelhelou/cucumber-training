Feature: Check the page title

  Scenario Outline: Check page title for Contact page
    Given I am on the zoo website
    When I navigate to <Link>
    Then I check page title is <Title>

    Examples: 
      | Link            | Title      |
      | "adoption_link" | "Adoption" |
      | "about_link"    | "About"    |
      | "contact_link"  | "Contact"  |
      | "home_link"     | "Home"     |
