Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check login page fields
    Given User opens '<homePage>'
    When User clicks on profile icon
    Then User checks profile popup visibility
    And User checks 'Sign In' button visibility in profile popup
    Then User clicks on 'Sign In' button on profile page
    And User checks email address field visibility
    And User checks password field visibility
    And User checks 'Forgot password?' button visibility
    And User checks 'Sign In' button visibility on login page

    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |

  Scenario Outline: Check add item to wishlist and delete from wishlist
    Given User opens '<homePage>'
    And User checks search field visibility
    When User enter '<keyword>'
    And User clicks on 'Search' button
    And User adds first product to wishlist
    Then User clicks on wishlist icon
    And User checks that amount of elements in wishlist is <amountOfElementsInWishlist>
    And User clicks on 'Remove from wishlist' button
    Then User checks '<Text>' presense

    Examples:
      | keyword  | homePage                  | amountOfElementsInWishlist | Text                    |
      | Sneakers | https://www.asos.com/men/ | 1                          | You have no Saved Items |

  Scenario Outline: Check add to cart and delete from cart
    Given User opens '<homePage>'
    When User enter '<keyword>'
    And User clicks on 'Search' button
    And User checks size drop list visibility
    And User clicks on size drop list
    And User choose product size
    Then User checks 'Add to bag' button visibility
    And User clicks 'Add to bag' button
    And User check cart popup visibility
    And User clicks 'View bag' button
    And User checks that amount of products in cart is <amountOfProductsInCart>
    And User clicks 'Remove item' button
    Then User checks '<Text>' message

    Examples:
      | homePage                  | keyword | amountOfProductsInCart | Text              |
      | https://www.asos.com/men/ | 2037373 | 1                      | Your bag is empty |

  Scenario Outline: Check incorrect search result
    Given User opens '<homePage>'
    When User enter '<keyword>'
    And User clicks on 'Search' button
    Then User checks '<Text>' on search result page

    Examples:
      | homePage                  | keyword  | Text                        |
      | https://www.asos.com/men/ | ###$!#%% | NOTHING MATCHES YOUR SEARCH |

  Scenario Outline: Check login with empty fields
    Given User opens '<homePage>'
    When User clicks on profile icon
    Then User checks profile popup visibility
    Then User clicks on 'Sign In' button on profile page
    And User checks 'Sign In' button visibility on login page
    And User clicks on 'Sign In' button on login page
    Then User checks email and password errors visibility

    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |

  Scenario Outline: Check amount of elements on search page
    Given User opens '<homePage>'
    When User enter '<keyword>'
    And User clicks on 'Search' button
    And User checks that amount of products on page is <amountOfProducts>

    Examples:
      | homePage                  | keyword  | amountOfProducts |
      | https://www.asos.com/men/ | trousers | 72               |

  Scenario Outline: Check sort price high to low
    Given User opens '<homePage>'
    When User enter '<keyword>'
    And User clicks on 'Search' button
    And User checks 'Sort' button visibility
    And User clicks 'Sort' button
    Then User checks 'Price high to low' button visibility
    And User clicks 'Price high to low' button
    And User checks that sort order is correct

    Examples:
      | homePage                  | keyword |
      | https://www.asos.com/men/ | shirt   |

  Scenario Outline: Check swap between men and women clothes websites
    Given User opens '<homePage>'
    And User checks 'Women' button visibility
    When User clicks on 'Women' button
    Then User checks '<URL>'

    Examples:
      | homePage                  | URL                         |
      | https://www.asos.com/men/ | https://www.asos.com/women/ |

  Scenario Outline: Check FAQs page search field
    Given User opens '<homePage>'
    When User clicks on 'Help & FAQs' button
    Then User checks Search for help field visibility

    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |

  Scenario Outline: Check link under Asos logo
    Given User opens '<homePage>'
    When User clicks on Asos logo
    Then User checks '<URL>'

    Examples:
      | homePage                  | URL                       |
      | https://www.asos.com/men/ | https://www.asos.com/men/ |
