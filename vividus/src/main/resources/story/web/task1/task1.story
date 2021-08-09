Scenario: sign up user

Given I am on the main application page


When I click on element located `By.xpath(//div/a[2])`


When I enter `<email>` in field located `By.xpath(//input[@id='email'])`
When I click on element located `By.xpath(//*[@id="signup-submit"])`
When I wait until element located `By.xpath(//*[@id="displayName"])` appears
When I enter `<password>` in field located `By.xpath(//*[@id='password'])`
When I enter `<name>` in field located `By.xpath(//*[@id='displayName'])`

When I click on element located `By.xpath(//*[@id='signup-submit']/span/span)`

When I wait until element located `By.xpath(//div[1]/div/form/button)` appears
Then the page with the URL 'https://trello.com/create-first-team' is loaded


Examples:
|email										|name								|password|
|#{generate(regexify '[a-z]{5}')}@mail.test |#{generate(regexify '[A-Z]{1}[a-z]{5}')}|#{generate(regexify '[0-9]{5}[a-z]{5}')}|	
|#{generate(regexify '[a-z]{5}')}@mail.test	|#{generate(regexify '[A-Z]{1}[a-z]{5}')}|#{generate(regexify '[0-9]{5}[a-z]{5}')}|
