$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LogIn_Test.feature");
formatter.feature({
  "line": 1,
  "name": "Login Action",
  "description": "",
  "id": "login-action",
  "keyword": "Feature"
});
formatter.before({
  "duration": 7069518600,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User Navigate to LogIn Page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User enters UserName and Password",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Message displayed Login Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "LogIn_TestStepDefinition.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 14341504800,
  "status": "passed"
});
formatter.match({
  "location": "LogIn_TestStepDefinition.user_Navigate_to_LogIn_Page()"
});
formatter.result({
  "duration": 69310800,
  "status": "passed"
});
formatter.match({
  "location": "LogIn_TestStepDefinition.user_enters_UserName_and_Password()"
});
formatter.result({
  "duration": 5367964900,
  "status": "passed"
});
formatter.match({
  "location": "LogIn_TestStepDefinition.message_displayed_Login_Successfully()"
});
formatter.result({
  "duration": 6898985800,
  "status": "passed"
});
formatter.after({
  "duration": 135900,
  "status": "passed"
});
formatter.after({
  "duration": 722145600,
  "status": "passed"
});
formatter.uri("Register_Test.feature");
formatter.feature({
  "line": 2,
  "name": "New User Register",
  "description": "",
  "id": "new-user-register",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6267180300,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "New User Successfully Register to Liferay-DXP",
  "description": "",
  "id": "new-user-register;new-user-successfully-register-to-liferay-dxp",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User Navigate to register page",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User enter  details",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Click on Submit",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I validate the outcomes",
  "keyword": "Then "
});
formatter.match({
  "location": "LogIn_TestStepDefinition.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 18244796300,
  "status": "passed"
});
formatter.match({
  "location": "Register_TestStepDefinition.user_Navigate_to_register_page()"
});
formatter.result({
  "duration": 122747300,
  "status": "passed"
});
formatter.match({
  "location": "Register_TestStepDefinition.user_enter_details()"
});
formatter.result({
  "duration": 3540248900,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat stepDefinitions.Register_TestStepDefinition.user_enter_details(Register_TestStepDefinition.java:79)\r\n\tat ✽.When User enter  details(Register_Test.feature:7)\r\n",
  "status": "pending"
});
formatter.match({
  "location": "Register_TestStepDefinition.click_on_Submit()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Register_TestStepDefinition.i_validate_the_outcomes()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 19700,
  "status": "passed"
});
formatter.after({
  "duration": 708520300,
  "status": "passed"
});
});