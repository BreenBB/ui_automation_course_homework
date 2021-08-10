Feature: Part 1 of Lorem Ipsum variant

  Scenario: Let's verify that default setting result in text starting with Lorem ipsum:
    Given User opens 'https://lipsum.com/' page
    And User clicks on Generate Lorem Ipsum Button
    Then User checks what text of Generated Lorem Ipsum in the 1 paragraph is 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'

  Scenario: Let's verify that the word "рыба" correctly appears in the first paragraph
    Given User opens 'https://lipsum.com/' page
    And User switch to Russian language using one of the links
    Then User checks that the text of the first <p> element, which is the first paragraph, contains the word 'рыба'