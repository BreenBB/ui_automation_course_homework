Feature: BBC Auto Tests

  Scenario: Let's check name of the headline article:
    Given User opens "https://www.bbc.com" page
    And User clicks on News tab
    Then User checks what the name of the headline article is 'Taliban raise flag over resistance stronghold'

  Scenario: Let's check name of the secondary articles:
    Given User opens "https://www.bbc.com" page
    And User clicks on News tab
    Then User checks what the names of the secondary articles

  Scenario: Let's check search using category link of the headline article:
    Given User opens "https://www.bbc.com" page
    And User clicks on News tab
    Then User type in search category link and checks result

  Scenario Outline: Let's check send us your questions functionality:
    Given User opens "https://www.bbc.com" page
    And User clicks on News tab
    When User press on Coronavirus tab
    And User press on Your Coronavirus Stories tab
    When User press on Your Questions link
    And User types in "<text>", "<name>", "<email>", "<contactNumber>" and "<location>" into appropriate fields
    And User "<checkbox>" on check box
    When User clicks on Submit button
    Then User checks what error message is displayed

    Examples:
      | text          | name          | email                 | contactNumber   | location        | checkbox    | unused
      | Some Text     | Some Person   | Some_Person@ukr.net   |                 |                 | don't press | 0
      | Some Text     | Some Person   |                       | null            | null            | press       | 0
      |               | Some Person   | Some_Person@ukr.net   |                 |                 | press       | 0
      | Some Text     |               |                       | null            | null            | press       | 0