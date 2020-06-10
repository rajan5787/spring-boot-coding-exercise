# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As a developer i want to know if my spring boot application is running

  Scenario: Is the health uri available and status=UP
    Given url microserviceUrl
    And path '/actuator/health'
    When method GET
    Then status 200
    And match response == { "status" : "UP" }

  Scenario: Get hottest repositories
    Given url microserviceUrl
    And path '/repositories/hottest/2'
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation
    * def repositorySchema = { url : '#string', watchers_count : '#string',  language : '##string', description : '#string', name : '#string' }
    And match response == '#[] repositorySchema'
