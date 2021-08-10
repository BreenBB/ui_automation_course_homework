Feature: Part 2 of Lorem Ipsum variant

  Scenario: Let's verify the checkbox:
    Given User opens 'https://lipsum.com/' page
    And User unchecks <start with Lorem Ipsum> checkbox
    And User clicks on Generate Lorem Ipsum Button
    Then User verifies that result no longer starts with Lorem ipsum