Feature: Scenarios to cover filter functionality for Lease Plan website

Scenario: User should be able to view car details from Best Deals 
    Given User is on Lease Plan Business website
    When User views car from best deal popular filter
    Then User should see Car details