#Author: steve.email@your.domain.com
Feature: TV Validation

  Background: 
    Given user launches flipkart application
    And user login by entering valid crendentials

  Scenario: HardCoded
    When user search tv
    And user click on the tv name
    Then user validate the tv names

  @Map
  Scenario: DataTable Values
    When user search tv by One Dim List
      | Oneplus TV | Lg TV | SAMSUNG TV |
    And user click on the tv name
    Then user validate the tv names

  @Map @Dim
  Scenario: DataTable Values
    When user search tv by One Dim Map
      | 1 | Oneplus TV |
      | 2 | Lg TV      |
      | 3 | SAMSUNG TV |
    And user click on the tv name
    Then user validate the tv names

  @Skip
  Scenario Outline: 
    When user search tv by One Dim List "<TV>"
    And user click on the tv name
    Then user validate the tv names

    Examples: 
      | TV         |
      | Oneplus TV |
      | Lg TV      |
      | SAMSUNG TV |
