Feature: Flight feature of Kayak.com

Scenario Outline: TC1_Flight search
    Given Launch the chrome browser
    When Click on flight button
    Then Enter origin "<Origin>", destination "<Destination>", select from date, to date and click on search button
    When Select one search option
    Then Verify and Validate origin and destination cities
    Then Quit the browser
    
Examples: 
      | Origin  						| Destination 			| 
      | San Francisco (SFO) | Las Vegas (LAS) 	|
      | Chicago (CHI) 			| Atlanta (ATL) 		| 
      | New York (NYC)			| Los Angeles (LAX)	|