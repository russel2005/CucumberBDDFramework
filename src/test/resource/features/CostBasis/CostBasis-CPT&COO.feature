Feature: Cost basis-Cross Platform Transaction(CPT) and Change of Ownership(COO)
  
  Business Rules: 
  - A Cross Platform Transaction (CPT) is the movement of money from a VBA to a TA or from a TA to VBA.
  
  - For a VBA to TA transfer, here's the time line
  a.) Day 1 - we send the outgoing VBA RAD to MAXIT Brokerage
  b.) Day 2 - MAXIT Brokerage sends us the outgoing basis and we send it to DTCC that same day before 4:00 PM (4:00 PM is the cutoff to get anything into the DTCC CBRS system for that day)
  c.) Day 2 - DTCC CBRS system sends the corresponding TA incoming basis to us that we send to MAXIT TA that same day and they then allocate it that night in their cycle
  d.) Day 3 - you can see the incoming basis allocated in MAXIT TA
  
  - However, for basis leaving TA (TA to VBA) we don't send the outgoing basis to DTCC before 4 PM.  We purposely wait until after 4:00 (this was an agreed upon industry standard - because it gave brokerage firms that extra day to set up their expectancy of receiving the basis).  Here is the time line :
  a.) Day 1 - we send the outgoing TA RAD to MAXIT TA
  b.) Day 2 - MAXIT TA sends us the outgoing basis and we send it to DTCC that after 4:00 PM (thus missing the cutoff for that day)
  c.) Day 3 - DTCC CBRS system sends the corresponding VBA incoming basis to us that we send to MAXIT Brokerage that same day and they then allocate it that night in their cycle
  d.) Day 4 - you can see the incoming basis allocated in MAXIT Brokerage
  
  - The Cost Basis CBRS process in Test can often take an additional day or two to complete. For example, if odd behavior is seen, wait until Day 5 for a VBA to TA transfer or Day 6 for a TA to VBA transfer to confirm the issue persists.
  - AWD tag line to perform COO: OPS COO   - VBA COO - INDEXED
  - Secondary Account/Client = an account with a different primary TIN than the from account and the from account client can access the secondary client's account (Ex. Joint account)

  @TS112219 @TC281072 @OEDTest @Day1 @EndToEndTest
  Scenario: Process associate with full access performs an exchange transaction from a fund(that has SPEC ID as cost basis) in TA to the same fund in VBA of different SSN
    Given Process associate searches for a TA client who can access VBA account of secondary client
      | fromAccount  | toAccount                                             | fromFund | toFund |
      | Dale Griffin | Kelly Lorenz, Dale Griffinâ€”Brokerage Accountâ€”58909833 | VEXPX    | VEXPX  |
    And pre-check cost basis set up on the fund in TA is SPEC id
    When they navigate to Exchange Vanguard funds page
    And process an exchange from a fund in TA to the same fund in VBA
    Then they should receive confirmation for the exchange transaction

  @TS112219 @TC281072 @OEDTest @Day2 @AdHoc
  Scenario: Process associate with full access verifies MAXIT DMI screen for CPT from TA to VBA of secondary client
    Given Process associate searches for a TA client who had done a CPT to VBA
    When they navigate to Database Management Interface screen in MAXIT for TA
    Then they verify the details of the transaction for TA account
    When they navigate to Database Management Interface screen in MAXIT for VBA
    Then they verify the details of the transaction for VBA account

  @TS112219 @TC281072 @OEDTest @Day4 @AdHoc
  Scenario: Process associate with full access verifies MAXIT ledger screen for CPT from TA to VBA of secondary client
    Given Process associate searches for a VBA client on which a CPT transaction had processed
    When they navigate to Cost basis summary page
    Then they verify the lot information for VBA in UNREALIZED GAIN/LOSS tab
    When they navigate to MAXIT VBS ledger screen
    Then they verify lot information mathces with that of Day1

  @TS112219 @TC281074 @Day1 @EndToEndTest
  Scenario: Client performs an exchange transaction from a fund (that has AVG cost as default cost basis) in VBA to the same fund in TA
    Given VBA client who also has a TA account logs in
      | fromAccount                               | toAccount      | fromFund | toFund |
      | Robert Griffinâ€”Brokerage Accountâ€”87372320 | Robert Griffin | VEXPX    | VEXPX  |
    And pre-check cost basis set up on the fund in VBA is Average cost method
    When they navigate to Exchange Vanguard funds page
    And process an exchange from a fund in VBA to the same fund in TA
    Then they should receive Confirmation for the exchange transaction

  @TS112219 @TC281074 @OEDTest @Day2 @AdHoc
  Scenario: Process associate with full access verifies MAXIT DMI screen for CPT from VBA to TA
    Given Process associate searches for a VBA client who had done a CPT to TA
    When they navigate to Database Management Interface screen in MAXIT for VBA
    Then they verify the details of the CPT transaction for VBA account
    When they navigate to Database Management Interface screen in MAXIT for TA
    Then they verify the details of the CPT transaction for TA account

  @TS112219 @TC281074 @OEDTest @Day3 @AdHoc
  Scenario: Process associate with full access verifies MAXIT ledger screen for CPT from VBA to TA
    Given Process associate searches for a TA client on which a CPT transaction had processed
    When they navigate to Cost basis summary page
    Then they verify the lot information for TA in UNREALIZED GAIN/LOSS tab
    When they navigate to MAXIT mutual fund ledger screen
    Then they verify lot information mathces with that of Day1

  @TS112219 @TC281078 @AWDTest @Day1 @AdHoc
  Scenario: Process Associate with full access performs a share transfer in COO application from TA to VBA of different SSN
    Given Process associate searches for a TA client
      | fromAccount    | toAccount | fromFund | toFund |
      | Timothy Cooper | 71814837  | VEXPX    | VEXPX  |
    When associate creates AWD work object for Change of Ownership
    And selects line of business to perform share transfer
    Then COO application should be launched
    When they choose to gift by SPEC id from TA to VBA of secondary client
    Then they should receive confirmation for the change of ownership

  @TS112219 @TC281078 @OEDTest @Day2 @AdHoc
  Scenario: Process associate with full access verifies MAXIT DMI screen for COO transaction from TA to VBA of secondary client
    Given Process associate searches for a TA client who had done a COO to VBA
    When they navigate to Database Management Interface screen in MAXIT for TA
    Then they verify the details of the COO transaction for TA account
    When they navigate to Database Management Interface screen in MAXIT for VBA
    Then they verify the details of the COO transaction for VBA account

  @TS112219 @TC281078 @OEDTest @Day4 @AdHoc
  Scenario: Process associate with full access verifies MAXIT ledger screen for COO transaction from TA to VBA of secondary client
    Given Process associate searches for a VBA client on which a COO transaction had processed
    When they navigate to Cost basis summary page
    Then they verify the lot information for VBA in UNREALIZED GAIN/LOSS tab
    When they navigate to MAXIT VBS ledger screen
    Then they verify lot information mathces with that of Day1
