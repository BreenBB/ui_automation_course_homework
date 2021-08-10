Feature: Part 2 of Lorem Ipsum variant

  Scenario Outline: Let's verify that Lorem Ipsum is generated with correct size:
    Given User opens 'https://lipsum.com/' page
    And User clicks on '<type>'
    And User input '<number>' into the number field
    When User clicks on Generate Lorem Ipsum Button
    Then User verifies the result has '<result>' of '<type>'

    Examples:
      | type  | number  | result
      | words | 10      | 10