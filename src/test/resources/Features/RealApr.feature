Feature: Real Apr


  @CalculateAPR

  Scenario: Calculate RealAPR rate
    Given user is in mortgage calculator home page
    And user is navigated to Real Apr page
    When user click on calculate button upon entering the data
    |HomePrice|DownPayment|InterestRate|
    |900000   |200000     |3.5         |
    Then the real apr rate is "3.595%"