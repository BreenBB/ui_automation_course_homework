Feature: PLorem Ipsum auto tests

  Scenario: Let's verify that default setting result in text starting with Lorem ipsum:
    Given User opens 'https://lipsum.com/' page
    And User clicks on Generate Lorem Ipsum Button
    Then User checks what text of Generated Lorem Ipsum in the 1 paragraph is 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'

  Scenario: Let's verify that the word "рыба" correctly appears in the first paragraph
    Given User opens 'https://lipsum.com/' page
    And User switch to Russian language using one of the links
    Then User checks that the text of the first <p> element, which is the first paragraph, contains the word 'рыба'

  Scenario: Let's verify the checkbox:
    Given User opens 'https://lipsum.com/' page
    And User unchecks <start with Lorem Ipsum> checkbox
    And User clicks on Generate Lorem Ipsum Button
    Then User verifies that result no longer starts with Lorem ipsum

  Scenario Outline: Let's verify that Lorem Ipsum is generated with correct size:
    Given User opens "https://lipsum.com/" page
    And User clicks on "<type>"
    And User input <number> into the number field
    When User clicks on Generate Lorem Ipsum Button
    Then User verifies the result has <result> of "<type>"

    Examples:
      | type  | number  | result  | unused
      | words | 10      | 10      | 0
      | bytes | 10      | 10      | 0

  Scenario Outline: Let's check that randomly generated text paragraphs contain the word "lorem" with probability of more than 40%:
    Given User opens "https://lipsum.com/" page
    Then Run the generation <number> times and paragraphs contain word lorem with probability of more than 40 percent

    Examples:
      | number  | unused
      | 10      | 0