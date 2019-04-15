Feature: Book hotel,flights and tours in phptravel


  Scenario: Book Hotel

    Given I am logged in to the application
    When  I search hotel "Rendezvous Hotels"
    And  I enter checkindate "02062019" and checkoutdate"05062019" and click search
    And  I confirm room booking and payment
    Then I verify hotel room is booked

  Scenario: Book Flights

    Given I am logged in to the application
    When  I enter city "Sydney" to find flight
    And   I enter checkinDate "02062019" to find flight and click Search button
    And   I confirm flight booking and payment
    Then  I verify flight is booked

  Scenario: Book Tours

    Given I am logged in to the application
    When  I enter trip "Sheraton Trip" to find tour
    And   I enter date "02062019" to find tour and click Search button
    And   I confirm tour booking and payment
    Then  I verify tour is booked







