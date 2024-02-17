Feature: End OTP to user for the sake of registration to the app


Scenario:Verify error message when user enters invalid phone nuumber
 Given Browser is opened and url is launched completely
 When User enters invalid phone number
 Then User should get error message

