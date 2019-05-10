Feature: Caculator app
Scenario Outline: Add two intergers
Given I am staying caculator app
When I add <number1> and <number2>
Then I have <result>
Examples:
|number1|number2|result|
|4      |5      |9     |