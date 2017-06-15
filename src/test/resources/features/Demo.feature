Feature: Demo
  As a User,
  Google searching should work on all platforms

  @C001 @smokeTest @regression
  Scenario: Google Search - Appium
    Given I am on "http://www.google.com"
    When I search for "appium"
    And select "Appium" in the search results
    Then the User views the Appium homepage "http://appium.io/"

  @C002 @regression
  Scenario: Google Search - Cucumber
    Given I am on "http://www.google.com"
    When I search for "Cucumber Java"
    And select "Cucumber JVM" in the search results
    Then I am presented with the "https://cucumber.io/docs/reference/jvm" homepage

  @C003 @smokeTest @regression
  Scenario: Google Search - Selenium
    Given I am on "http://www.google.com"
    When I search for "selenium"
    And select "Selenium - Web Browser Automation" in the search results
    Then I am presented with the "http://www.seleniumhq.org/" homepage

  @C004 @regression
  Scenario: Google Search - IntelliJ
    Given I am on "http://www.google.com"
    When I search for "IntelliJ"
    And select "IntelliJ IDEA" in the search results
    Then I am presented with the "https://www.jetbrains.com/idea/" homepage