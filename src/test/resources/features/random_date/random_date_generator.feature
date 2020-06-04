Feature: Generate random dates

  Scenario Outline: Generating random dates successfully
    Given User is on the RandomDateGenerator home page
    And he wants to generate <count> random dates
    And he selects the output date format "<date_format>"
    And he sets the start date as "<start_date>"
    And he sets the end date as "<end_date>"
    When he clicks generate random dates
    Then the random dates are generated successfully

  Examples:
    | count | date_format         | start_date          | end_date            |
    | 5     | YYYY-DD-MM hh:mm:ss | 2018-01-01 00:00:00 | 2019-10-06 15:23:05 |
    | 10    | YYYY-MM-DD hh:mm:ss | 2019-08-06 12:10:14 | 2019-11-01 00:00:00 |
    | 15    | MM-DD-YYYY hh:mm:ss | 2020-05-03 19:59:59 | 2020-12-01 00:00:00 |