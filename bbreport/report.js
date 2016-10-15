$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("user_validate_csv.feature");
formatter.feature({
  "line": 1,
  "name": "Validate CSV Data against individual persons case",
  "description": "",
  "id": "validate-csv-data-against-individual-persons-case",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "As an individual user I would like to make sure my case data match the data on CSV",
  "description": "",
  "id": "validate-csv-data-against-individual-persons-case;as-an-individual-user-i-would-like-to-make-sure-my-case-data-match-the-data-on-csv",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@dev"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "That I have a created a new case",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I download the csv",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I would like to make sure \u003cName\u003e field match all the names on the case",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "validate-csv-data-against-individual-persons-case;as-an-individual-user-i-would-like-to-make-sure-my-case-data-match-the-data-on-csv;",
  "rows": [
    {
      "cells": [
        "Name"
      ],
      "line": 11,
      "id": "validate-csv-data-against-individual-persons-case;as-an-individual-user-i-would-like-to-make-sure-my-case-data-match-the-data-on-csv;;1"
    },
    {
      "cells": [
        "Ahmed bala bala banak aba"
      ],
      "line": 12,
      "id": "validate-csv-data-against-individual-persons-case;as-an-individual-user-i-would-like-to-make-sure-my-case-data-match-the-data-on-csv;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "As an individual user I would like to make sure my case data match the data on CSV",
  "description": "",
  "id": "validate-csv-data-against-individual-persons-case;as-an-individual-user-i-would-like-to-make-sure-my-case-data-match-the-data-on-csv;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@dev"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "That I have a created a new case",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I download the csv",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I would like to make sure Ahmed bala bala banak aba field match all the names on the case",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ValidateCSV.scala:40"
});
formatter.result({
  "duration": 115484068,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCSV.scala:47"
});
formatter.result({
  "duration": 3178423523,
  "status": "passed"
});
formatter.match({
  "location": "ValidateCSV.scala:66"
});
formatter.result({
  "duration": 47824,
  "status": "passed"
});
});