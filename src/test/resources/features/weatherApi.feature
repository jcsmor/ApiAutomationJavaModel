#Feature: Get Current weather data
#
#  Scenario Outline: User calls current weather data using city name <name>
#    When Call current weather data for one location by city name <name>
#    Then the status response code is 200
#    And the response content type is JSON
#    And the response name equals searched city name <name>
#    And the response has a valid temperature
#    And the response min temperature is below or equal max temperature
#
#    Examples:
#      | name       |
#      | London     |
#      | Lisbon     |
#      | Cairns     |
#
#  Scenario Outline: User calls current weather data using city ID <id>
#    When Call current weather data for one location by city id <id>
#    Then the status response code is 200
#    And the response content type is JSON
#    And the body id equals searched city id <id>
#    And the response has a valid temperature
#    And the response min temperature is below or equal max temperature
#
#    Examples:
#      | id          |
#      | 2643743     |
#      | 2267057     |
#      | 2172797     |
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
##    And response matches the Json schema
#
##  Scenario: User calls web service to get a book by its ISBN
##    Given a book exists with an isbn of 9781451648546
##    When a user retrieves the book by isbn
##    Then the status code is 200
##    And response includes the following
##      | totalItems 	 	| 1 				|
##      | kind				| books#volumes		|
##    And response includes the following in any order
##      | items.volumeInfo.title 		| Steve Jobs		  |
##      | items.volumeInfo.publisher 	| Simon and Schuster  |
##      | items.volumeInfo.pageCount 	| 630			      |
