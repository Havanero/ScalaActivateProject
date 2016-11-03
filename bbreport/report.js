$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("donwloadHMO.feature");
formatter.feature({
  "line": 1,
  "name": "Download CSV",
  "description": "",
  "id": "download-csv",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Check Values inside CSV Match",
  "description": "",
  "id": "download-csv;check-values-inside-csv-match",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@dev"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "That I have a created a new case",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I download the csv",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I would like to make sure Ahmed bala bala banak aba field match all the names on the case",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateCSV.scala:43"
});
formatter.result({
  "duration": 210777007,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCSV.scala:50"
});
formatter.result({
  "duration": 6777108358,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCSV.scala:70"
});
formatter.result({
  "duration": 50344,
  "status": "passed"
});
});