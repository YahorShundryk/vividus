Scenario: sign up user with composite steps 

Given I am on the main application page
When I click on element located `By.xpath(//div/a[2])`
When I enter <email>, <name> and <password> in the registration form
When I click on element located `By.xpath(//*[@id='signup-submit']/span/span)`

Examples:
|email										|name								|password|
|#{generate(regexify '[a-z]{5}')}@mail.test |#{generate(regexify '[A-Z]{1}[a-z]{5}')}|#{generate(regexify '[0-9]{5}[a-z]{5}')}|	
|#{generate(regexify '[a-z]{5}')}@mail.test	|#{generate(regexify '[A-Z]{1}[a-z]{5}')}|#{generate(regexify '[0-9]{5}[a-z]{5}')}|
