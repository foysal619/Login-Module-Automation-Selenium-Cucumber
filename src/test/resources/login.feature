Feature: Login Functionality

  Scenario Outline: User login with valid credentials
    Given user visits the websites
    When user enter username "<username>" and password "<password>"
    Then user can view the product page
    And browser closes
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  Scenario Outline: User login with invalid credentials
    Given user visits the websites
    When user enter username "<username>" and password "<password>"
    Then user can't view the product page
    And browser closes
    Examples:
      | username      | password     |
      | standar_user | secret_sauce |
      | proble_user  | secret_sauce |

