Feature: Broadband Service Check
  This specification checks the various broadband services available from the user's location

  Scenario Outline: <case_id>: As an Internet user, I want to know which Chorus services are available to me.
    So that I can decide on the service I want to order.

    Given the user opens the "broadband-map" page
    When the user types his address "<address>"
    Then verify the list of service is displayed
    Then print the list of service available
    Then take screenshot of the page

    Examples: 
      | case_id | address                                       |
      | TC001   | 12/21 Waripori Street, Berhampore, Wellington |
     
