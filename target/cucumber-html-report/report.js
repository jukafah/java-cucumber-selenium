$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/homepage.feature");
formatter.feature({
  "line": 1,
  "name": "Homepage",
  "description": "",
  "id": "homepage",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3407048904,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Homepage displays header \"We test software\"",
  "description": "",
  "id": "homepage;homepage-displays-header-\"we-test-software\"",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@C001"
    },
    {
      "line": 3,
      "name": "@smoke-test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on \"http://tapqa.com\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I see the header",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 7,
    "value": "We test software"
  }
});
formatter.match({
  "arguments": [
    {
      "val": "http://tapqa.com",
      "offset": 9
    }
  ],
  "location": "HomepageSteps.i_am_on(String)"
});
formatter.result({
  "duration": 104119516,
  "error_message": "cucumber.runtime.CucumberException: class com.cucumber.steps.HomepageSteps doesn\u0027t have an empty constructor. If you need DI, put cucumber-picocontainer on the classpath\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:42)\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.getInstance(DefaultJavaObjectFactory.java:30)\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:35)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:297)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:48)\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:83)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:89)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:40)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:94)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\nCaused by: java.lang.NoSuchMethodException: com.cucumber.steps.HomepageSteps.\u003cinit\u003e()\n\tat java.lang.Class.getConstructor0(Class.java:3082)\n\tat java.lang.Class.getConstructor(Class.java:1825)\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:37)\n\t... 32 more\n",
  "status": "failed"
});
formatter.match({
  "location": "HomepageSteps.i_see_the_header(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 74602,
  "status": "passed"
});
});