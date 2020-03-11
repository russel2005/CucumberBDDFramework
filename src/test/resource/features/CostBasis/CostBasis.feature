@EndToEndTest
Feature: This is to verify cost basis functionality test cases

  ######## TS71972#Test set: Unrealized Gain / Loss Tab#############
  @TC201956 @TS71972 @IntegrationTest @HNWTest
  Scenario: Verify Trade ETFs or Stocks page displayed when we click Buy link from cost basis page for VTA account
    Given I login as "VTA_Account_ETF_User"
    And I am in cost basis page
    When I Buy a vanguard ETF "tradeeftName" for account "VTA_Account_ETF"
    Then I should be in trade an etf or stock page

  @TC200719 @TS71972 @IntegrationTest @OEDTest
  Scenario: Verify Change Cost Basis Methods page is displayed by clicking View/change cost basis method link of TA account
    Given I search for client with "TA_POID"
    And I am in cost basis page internally via Balances & Holdings page from "TA_Account" account
    When I click View/change cost basis method link of "TA_Account" account
    Then I should be in Change cost basis methods page

  @TC201143 @TS71972 @IntegrationTest @HNWTest
  Scenario: Verify Exchange Non vanguards Mutul funds page displayed when we click exchange link from cost basis page for VTA account
    Given I login as "NonVGMutulFund_VTA_User"
    And I am in cost basis page
    When I exchange non-vanguard fund "NonVanguardHolding" from account "VTA-JointAccount"
    Then I should be in Trade non-Vanguard funds via FundAccess

  @TC201117 @TS71972 @IntegrationTest @HNWTest
  Scenario: Verify Trade Non vanguards Mutual funds page displayed when we click Buy link from cost basis page for VTA account
    Given I login as "vtaBondUser"
    And I am in cost basis page
    When I Buy a Non vanguard Fund "nvFundName" for account "LegacyBrokerageAccount"
    Then I should be in trade non vanguard funds via fundAccess page

  @TC202042A @TS71972 @IntegrationTest @HNWTest
  Scenario: Verify Bonds Trading page displayed when we click Buy link from cost basis page for VTA account
    Given I login as "vtaBondUser_tradeBondName_BuyLink"
    And I am in cost basis page
    When I Buy a bond "tradeBondName" for account "LegacyBrokerageAccount"
    Then I should be in bonds and cds trading page

  @TC202042B @TS71972 @IntegrationTest @HNWTest
  Scenario: Verify Bonds Trading page displayed when we click Sell link from cost basis page for VTA account
    Given I login as "vtaBondUser_tradeBondName_SellLink"
    And I am in cost basis page
    When I Sell a bond "tradeBondName" for account "LegacyBrokerageAccount"
    Then I should be in bonds and cds trading page

  @TS71972 @TC201964A @IntegrationTest @OEDTest @abc
  Scenario: Verify Sell Options page displayed when we click Sell link from cost basis page for Option in Legacy VBS account
    Given I search for client with "legacy_vbs_POID_SellLink"
    And I am in cost basis page internally via Balances & Holdings page from "legacy_vbs_account" account
    When I sell trade option "legacy_vbs_option"
    # Then I should be in Sell Options page

  @TS71972 @TC201964B @IntegrationTest @OEDTest @abc
  Scenario: Verify Buy Options page displayed when we click Buy link from cost basis page for Option in Legacy VBS account
    Given I search for client with "legacy_vbs_POID_BuyLink"
    And I am in cost basis internal page
    When I buy trade option "legacy_vbs_option" from account "legacy_vbs_account"
    # Then I should be in Buy Options page

  @TS71972 @TC201961A @IntegrationTest @OEDTest
  Scenario: Verify Sell ETFs or Stocks page displayed when we click Sell link from cost basis page for Legacy Brokerage Account
    Given I search for client with "Legacy_BrokerageAccount_Selllink"
    And I am in cost basis internal page
    When I sell vanguard ETF "VG_ETF" for account "Legacy_Brokerage_Acct"
    Then I should be in Sell ETFs or stocks page

  @TS71972 @TC201961trust @IntegrationTest @OEDTest
  Scenario: Verify Sell ETFs or Stocks page displayed when we click Sell link from cost basis page for VTA trust account
    Given I search for client with "Legacy_BrokerageTrustAccount_Selllink"
    And I am in cost basis internal page
    When I sell stock "stock" for account "Legacy_Brokerage_Acct"
    Then I should be in Sell ETFs or stocks page

  @TS71972 @TC201130 @IntegrationTest @OEDTest
  Scenario: Verify Sell link page is displayed  when we click Sell  link from cost basis page for Non Vangaurd Mutual Funds for VTA account
    Given I search for client with "NonVGFunds_VTAAccount_Selllink"
    And I am in cost basis internal page
    When I Sell non vanguard fund "NonVGFund" for account "VTA_NonVGFunds"
    Then I should be in Sell non-vanguard funds page

  @TS71972 @TC200734 @IntegrationTest @OEDTest
  Scenario: Verify buy Funds page displayed when we click buy link from cost basis page for TA account
    Given I search for client with "TAAccount_BuyFundspageVerificaton"
    And I am in cost basis internal page
    When I buy vanguard VMF "Vanguard_Mutual_Fund" for account "TA_Acct"
    Then I should be in buy VMF page

  @TC200981 @TS71972 @IntegrationTest @HNWTest
  Scenario: Verify exchange vanguards page displayed when we click exchange link from cost basis page for TA account
    Given I login as "TAAccount_ExchangeVGFundsPageVerification"
    And I am in cost basis page via Balances & Holdings page for "TAAccnt" account
    When I exchange vanguard mutual fund "VGMFund"
    Then I should be in Exchange vanguard funds page

  @TC200902 @TS71972 @IntegrationTest @HNWTest
  Scenario: Verify sell vanguards page displayed when we click Sell link from cost basis page for TA account
    Given I login as "TAAccount_SellVGFundsPageVerification"
    And I am in cost basis page via Balances & Holdings page for "TAAccnt" account
    When I sell vanguard mutual fund "VGMFund"
    Then I should be in sell vanguard funds page

  @TC200986 @TS71972 @IntegrationTest @OEDTest
  Scenario: Verify Buy vanguards Mutul funds page displayed when we click Buy link from cost basis page for VTA account
    Given I search for client with "VTAAccount_BuyVGMutualFundsPageVerification"
    And I am in cost basis internal page
    When I Buy vanguard Mutual fund "VG_MFund" for account "VTA_Accnt"
    Then I should be in Buy Vanguard mutual fund page

  @TC201065 @TS71972 @IntegrationTest @OEDTest
  Scenario: Verify Exchange vanguards page displayed when we click exchange link from cost basis page for VTA account
    Given I search for client with "VTAAccount_VGMFund_ExchangeVGFundsVerification"
    And I am in cost basis internal page
    When I Exchange vanguard fund "VanguardHolding" for account "VTA-JointAccount"
    Then I should be in Exchange vanguard funds page

  @TS71972 @TC201063 @IntegrationTest @HNWTest
  Scenario: Verify Sell link page is displayed  when we click Sell link from cost basis page for VTA account
    Given I login as "VTAAccount_SelllinkVerification"
    And I am in cost basis page
    When I Sell vanguard fund "VG_MFund" for account "VTA_Accnt"
    Then I should be in sell vanguard funds page

  ######## TS71973#Test set: View / Maintain LRM - All Test Cases#############
  @TS71973 @TC192231 @EndToEndTest @TC192244VBS @TC192256VIAInd @TC192256VIAJoint @HNWTest
  Scenario Outline: View/change the Cost Basis Method for VIA/TA/VBS Account
    Given I login as "<user>"
    And I am on cost basis methods page
    And verify "<from_cost_basis_method>" is already selected in changecostbasis page
    When I change cost basis method from "<from_cost_basis_method>" to "<to_Cost_Basis_method>" for "<Fund>" from "<Accnt>"
    And I submit the change
    Then I should see the cost basis method as "<to_Cost_Basis_method>" on cost basis methods page

    Examples: 
      | user           | Accnt               | Fund            | from_cost_basis_method | to_Cost_Basis_method |
      | TA_User        | TAIndividual_Accnt  | VGMutualFund    | FIFO                   | AvgCost              |
      | VBS_User       | VBSIndividual_Accnt | NonVGMutualFund | FIFO                   | AvgCost              |
      | VIA_User       | VIAIndividual_Accnt | VIAEquity       | SpecID                 | FIFO                 |
      | VIAJoint_Accnt | VIAJoint_Accnt      | VIA_VGMFund     | AvgCost                | SpecID               |

  @TS71973 @TC221571 @EndToEndTest @OEDTest
  Scenario: Change all cost basis method in Phone channel
    Given I search for client with "VTA_Joint_ChangeCBAllFunds"
    And I am in change cost basis methods page for joint account "VTA_Joint_Accnt"
    Then I verify default costbasis configured as "HIFO"
    When I change cost Basis method from "HIFO" to "SpecID" for all funds
    And I submit the changes
    Then I should see the cost basis method as "SpecID" for all funds

  @TS71973 @TC221580 @EndToEndTest @HNWTest
  Scenario: Change all cost basis method in web channel
    Given I login as "TA_Account_ChangeCBAllFunds"
    And I am in change cost basis methods page for individual account "TAAccount" with "Fund_num"
    Then I verify default costbasis configured as "FIFO"
    When I change cost Basis method from "FIFO" to "AvgCost" for all funds
    And I submit the changes
    Then I should see the cost basis method as "AvgCost" for all funds
