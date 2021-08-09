Scenario: Verify user Profile

Given I am on the main application page
Then the page title is equal to 'Trello'

When I sign in as <email> with <password>
Then the page with the URL containing 'trello' is loaded

When I click on element located `By.xpath(//button[@data-test-id='header-member-menu-button'])`
When I click on element located `By.xpath(//a[@data-test-id='header-member-menu-profile'])`
Then the text '<name>' exists
Examples:
properties/environment/test/myUserCreds.table 