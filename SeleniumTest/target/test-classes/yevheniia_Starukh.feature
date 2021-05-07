Feature: Test some features of site

  Scenario: I want to close the cookie window
    Given opened site's main page
    When I click the accept button
    Then the cookie window close


  Scenario: I want to return to the main page of the site
    Given opened site's services page
    When I click on the company's logo
    Then I return to the main page


  Scenario Outline: I want to go to services subpage
    Given opened site's main page
    When I click on services button
    And click the "<servicename>" button
    Then I will be redirected to "<servicepage>" page

    Examples:
      | servicename | servicepage        |
      | consult     | consult-and-design |
      | design      | consult-and-design |
      | engineer    | engineer           |
      | operate     | operate            |
      | optimize    | optimize           |


  Scenario: I want to change language from English to Russian
    Given opened site's main page in English
    When I click the change language button
    And choose Russian language
    Then I see site's main page on Russian

  Scenario: I want to go to the contact us page
    Given opened site's main page
    When I click the contact us button
    Then I see contact us page


  Scenario Outline: I accidentally clicked on submit button on contact us page without entering the required information
    Given opened site's contact us page
    When I didn't fill "<field>"
    Then the form won't be submitted
    And it will highlight the empty "<field>" box

    Examples:
      | field      |
      | First Name |
      | Last Name  |
      | Email      |
      | Phone      |


  Scenario: I accidentally wrote email not in the corresponding form
    Given opened site's contact us page
    When I fill the email box not with an email
    Then the form will tell me that I have made wrong input


  Scenario Outline: I want to see where the company office situated in Ukraine
    Given opened site's main page
    When I click the Europe button
    And choose Ukraine from the list
    And click on map button for "<location>" location
    Then I will be redirected to the new page with map where the office "<location>" is shown

    Examples:
      | location                |
      | Lviv                    |
      | Dnipro                  |
      | Kharkiv                 |
      | Vinnytsia               |
      | Kyiv: Registered office |
      | Kyiv: Visitors office   |