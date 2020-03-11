Feature: Cost Basis Gifted Shares
  Data needed is a client with Cost basis selected and has funds that have Gifted shares data populated
  - Data prep is to have recently processed a Change of Ownership.   That process can only be done via AWD
  - Data prep is to already have clients that processed Change of Ownership 
  - Cost basis summary page links are: cost basis rescouce center, personal performance and taxes and income
  - Client with multiple acounts will show a drop down select an account option.   
  - Gifted Shares will show on the From Account. The show details link shows date, and amount of shares, and name of of the to acct 
  - Column headings are Name/Account Number, Cost basis method, Quantity, Total Cost, Gift value, and Recipient

  @EndToEndTest @HNWTest
  Scenario: VTA Client verifies the Cost basis Gifted Shares tab shows correct data on the Cost Basis Summary page
    Given Client logs in and selects Cost basis from My Accounts
    And They verify Cost basis Summary page shows with all the valid links
    When They select the Gifted shares tab of the From account
    Then They verify the default of current year to date
    And They verify the correct data populates in the correct columns
   # And They select Show Details link to verify the date and number of shares matches Transaction History page

  @EndToEndTest @HNWTest
  Scenario: VTA Client that has NOT selected the Cost Basis method for a Mutal Fund verifies the Cost basis Gifted Shares tab
    Given Client logs in and selects Cost basis from My Accounts for a Mutal Fund
    And verify "Not established" is already selected in changecostbasispage
    And They verify Cost basis Summary page shows with all the valid links
    When They select the Gifted shares tab of the From account
    Then They verify the Mutual Fund with no Cost Basis selected is not showing on Gifted Shares tab
