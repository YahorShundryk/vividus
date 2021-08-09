Scenario: Nested steps. New boards

Given I am on the main application page
Then the page title is equal to 'Trello'
When I sign in as <email> with <password>
Then the page with the URL containing 'trello' is loaded

When I find = '1' elements by By.xpath(//nav/div[2]/div/ul/div/button/span/span/span) and for each element do
|step
|When I click on element located `By.xpath(//nav/div[2]/div/ul/div/button/span/span/span)`
|When I wait until element located `By.xpath(//*[@id="layer-manager-overlay"]/div/div/div/div[1]/form/span[1])` appears
|When I click on element located `By.xpath(//form/div/div/div/div/div[1]/div)`
|When I click on element located `By.xpath(//*[text()='Other'])`
|When I enter `#{generate(regexify '[a-z]{8}')}` in field located `By.xpath(//div[3]/div/div/div/div[1]/form/input)`
|When I click on element located `By.xpath(//footer/button)`
|When I wait until element located `By.xpath(//*[@id="layer-manager-overlay"]/div/div/div/div[1]/a)` appears
|When I click on element located `By.xpath(//*[@id="layer-manager-overlay"]/div/div/div/div[1]/a)`
|Then the page with the URL containing 'trello' is loaded
Examples:
properties/environment/test/myUserCreds.table 

Scenario: Nested steps. Closed boards

Given I am on a page with the URL 'https://trello.com/nastya_test/boards'
When I find = `1` elements by `By.xpath(//button[@class="view-all-closed-boards-button voB8NatlbuEme5"])` and for each element do
|step                                                                                                       
|When I click on element located `By.xpath(//button[@class="view-all-closed-boards-button voB8NatlbuEme5"])`
|Then an element with the name 'boards' does not exist                                                              
Examples:
properties/environment/test/myUserCreds.table 