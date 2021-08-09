Scenario: 	API for Trello Board creation

When I issue a HTTP POST request for a resource with the URL 'https://api.trello.com/1/boards/?key=${key}&token=${token}&name=NewBoar'
Then `${responseCode}` is equal to `200`