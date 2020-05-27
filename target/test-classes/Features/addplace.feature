Feature: Add place validations
@Addplace  @Regression
Scenario Outline: verify if place is added sucessfully

Given  Add place payload with "<name>" "<language>" "<address>"
When user calls"AddPlaceAPI" using "POST" request
Then  Response should be have status code is 200
And "status" in response body  is "OK"
And verify placeid created  matches to "<name>" using "getPlaceAPI"


Examples:

| name | language  | address |
|sindhu   | telugu    |hyderabad telangana       |


@Deleteplace @Regression
Scenario: verify delete place api functionality

Given DeletePlace payload
When user calls"DeletePlaceAPI" using "POST" request
Then  Response should be have status code is 200
And "status" in response body  is "OK"

