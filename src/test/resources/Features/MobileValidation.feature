#Author: your.email@your.domain.com
Feature: Mobile Validation

  Scenario: HardCoded
    Given user launches flipkart app
    And user login by entering valid crendentials
    When user search mobile
    And user click on the mobile name
    Then user validate the mobile names

  Scenario: DataTable Values
    Given user launches flipkart app
    And user login by entering valid credentials
    When user search mobile by One Dim List
      | Oneplus | iphone | SAMSUNG |
    And user click on the mobile name
    Then user validate the mobile names

  Scenario: DataTable Values
    Given user launches flipkart app
    And user login by entering valid credentials
    When user search mobile by One Dim Map
      | 1 | Oneplus |
      | 2 | iPhone  |
      | 3 | SAMSUNG |
    And user click on the mobile name
    Then user validate the mobile names

  Scenario Outline: 
    Given user launches flipkart app
    And user login by entering valid credentials
    When user search mobile by One Dim List "<mobile>"
    And user click on the mobile name
    Then user validate the mobile names

    Examples: 
      | mobile  |
      | Oneplus |
      | iPhone  |
      | SAMSUNG |
