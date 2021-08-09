Scenario: Sign Up scenario as precondition

Given I am on the main application page
When I click on element located `By.xpath(//div/a[2])`
When I initialize the STORY variable `email_var` with value `<email>`
When I initialize the STORY variable `name_var` with value `<name>`
When I initialize the STORY variable `password_var` with value `<password>`

When I enter `${email_var}` in field located `By.xpath(//input[@id='email'])`

When I click on element located `By.xpath(//*[@id="signup-submit"])`
When I wait until element located `By.xpath(//*[@id="displayName"])` appears
When I enter `${password_var}` in field located `By.xpath(//*[@id='password'])`
When I enter `${name_var}` in field located `By.xpath(//*[@id='displayName'])`

When I click on element located `By.xpath(//*[@id='signup-submit']/span/span)`

When I wait until element located `By.xpath//div[1]/div/form/button)` appears
Then the page with the URL 'https://trello.com/create-first-team' is loaded

When I click on element located `By.xpath(//div[@class='verify-button-holder'])`
Examples:
properties/environment/test/newUserCreds.table