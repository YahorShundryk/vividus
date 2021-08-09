Scenario: sign in user
!--GivenStories: story/web/test2/precondition.story


Given I am on the main application page
Then the page title is equal to 'Trello'
When I click on element located `By.xpath(//nav/div/a[1])`
Then the page with the URL containing '/login' is loaded


!-- When I enter `${email_var}` in field located `By.xpath(//input[@id='user'])`
When I enter `<email>` in field located `By.xpath(//input[@id='user'])`
When I wait until element located `By.xpath(//input[@value='Log in with Atlassian'])` appears
When I click on element located `By.xpath(//input[@value='Log in with Atlassian'])`
When I wait until element located `By.xpath(//*[@id="login-submit"]/span/span)` appears
!-- When I enter `${password_var}` in field located `By.xpath(//input[@id='password'])`
When I enter `<password>` in field located `By.xpath(//input[@id='password'])`
When I click on element located `By.xpath(//*[@id="login-submit"]/span/span)`
When I wait until element located `By.xpath(//*[@id="header"]/div[1]/div[1]/button/span/span)` appears

Then the page with the URL containing 'trello' is loaded
Examples:
properties/environment/test/myUserCreds.table

Scenario: Verify user Profile
When I click on element located `By.xpath(//button[@data-test-id='header-member-menu-button'])`
When I click on element located `By.xpath(//a[@data-test-id='header-member-menu-profile'])`
Then the text '<name>' exists
Examples:
properties/environment/test/myUserCreds.table

Scenario: 1 Navigate to Profile page and visual check 
When I establish baseline with `testBaseLineProfile`
When I compare_against baseline with `testBaseLineProfile`
Examples:
properties/environment/test/pageBaseLine.table

Scenario: 2 Navigate to Boards page and visual check
	
Given I am on a page with the URL 'https://trello.com/<name>/boards'
When I establish baseline with `<testBaseLineBoards>`
When I compare_against baseline with `<testBaseLineBoards>`
Examples:
properties/environment/test/pageBaseLine.table

Scenario: 3 Navigate to Templates page and visual check
Given I am on a page with the URL 'https://trello.com/templates'
When I wait until element located `By.xpath(//div[6]/h2/button)` appears
When I establish baseline with `<testBaseLineTemplates>`
When I wait until element located `By.xpath(//div[6]/h2/button)` appears
When I compare_against baseline with `<testBaseLineTemplates>`
Examples:
properties/environment/test/pageBaseLine.table


Scenario: 4 Navigate to Home page and visual check
Given I am on a page with the URL 'https://trello.com/templates'
When I wait until element located `By.xpath(//nav/div[1]/ul/li[2]/a/span[2])` appears
When I click on element located `By.xpath(//nav/div[1]/ul/li[2]/a/span[2])`
When I establish baseline with `testBaseLineHome`
When I compare_against baseline with `testBaseLineHome`
Examples:
properties/environment/test/pageBaseLine.table

Scenario: 5 Navigate to Highlights page and visual check
Given I am on a page with the URL 'https://trello.com'
When I click on element located `By.xpath(//nav/div[2]/div/ul/li/ul/li[3]/a/span[2])`
When I establish baseline with `testBaseLineHighlights`
When I compare_against baseline with `testBaseLineHighlights`
Examples:
properties/environment/test/pageBaseLine.table
 