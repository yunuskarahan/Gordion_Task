Feature: Succesfull Ticket Test



  Scenario: ticket test
    Given the user is on the home page
    Then the user should see "Jolly" in the title of the homepage
    And the user should see the tab for selecting a trip
    When the user click Uçak Bileti button
    Then the user sees that the Uçak Bileti option is selected
    And the user clicks on the round trip button
    Then the user should see the Dönüş Tarihi Option
    And the user clicks on the Nereden input
    And the user types From "Istanbul"
    And the user presses the down key and  tab key on the keyboard
    And the user types To "Ankara"
    And the user click Gidiş Tarihi
    And user chooses departure date June 13 th
    And user chooses return date June 20 th
    And user selects the number of passengers as adult 1
    And user click Hemen Ara Button
    Then user should see "İstanbul (IST) - Ankara (ANK) " title


