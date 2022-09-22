Feature: loading film from starswars graphql api
  Background:
    * url starWarsUrl
    * def query = read('film.graphql')
    * def variables = read('variables.json')


  Scenario: Find "The Phantom Menace"
    Given request { query: '#(query)', variables: '#(variables)' }
    When method post
    Then status 200

    Then match response.data.film.title == "The Phantom Menace"
    Then match response.errors == '#notpresent'
