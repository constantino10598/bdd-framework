$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/cucumber/features/service_check.feature");
formatter.feature({
  "line": 1,
  "name": "Broadband Service Check",
  "description": "This specification checks the various broadband services available from the user\u0027s location",
  "id": "broadband-service-check",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "\u003ccase_id\u003e: As an Internet user, I want to know which Chorus services are available to me.",
  "description": "So that I can decide on the service I want to order.",
  "id": "broadband-service-check;\u003ccase-id\u003e:-as-an-internet-user,-i-want-to-know-which-chorus-services-are-available-to-me.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "the user opens the \"broadband-map\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "the user types his address \"\u003caddress\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "verify the list of service is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "print the list of service available",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "take screenshot of the page",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "broadband-service-check;\u003ccase-id\u003e:-as-an-internet-user,-i-want-to-know-which-chorus-services-are-available-to-me.;",
  "rows": [
    {
      "cells": [
        "case_id",
        "address"
      ],
      "line": 14,
      "id": "broadband-service-check;\u003ccase-id\u003e:-as-an-internet-user,-i-want-to-know-which-chorus-services-are-available-to-me.;;1"
    },
    {
      "cells": [
        "TC001",
        "12/21 Waripori Street, Berhampore, Wellington"
      ],
      "line": 15,
      "id": "broadband-service-check;\u003ccase-id\u003e:-as-an-internet-user,-i-want-to-know-which-chorus-services-are-available-to-me.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 63653000,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "TC001: As an Internet user, I want to know which Chorus services are available to me.",
  "description": "So that I can decide on the service I want to order.",
  "id": "broadband-service-check;\u003ccase-id\u003e:-as-an-internet-user,-i-want-to-know-which-chorus-services-are-available-to-me.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "the user opens the \"broadband-map\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "the user types his address \"12/21 Waripori Street, Berhampore, Wellington\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "verify the list of service is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "print the list of service available",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "take screenshot of the page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "broadband-map",
      "offset": 20
    }
  ],
  "location": "BasePageSteps.openHomePage(String)"
});
formatter.result({
  "duration": 7538803100,
  "error_message": "org.openqa.selenium.SessionNotCreatedException: session not created: This version of ChromeDriver only supports Chrome version 81\nBuild info: version: \u00273.7.0\u0027, revision: \u00272321c73\u0027, time: \u00272017-11-02T22:22:35.584Z\u0027\nSystem info: host: \u0027CPX-6FXNFMZVKVJ\u0027, ip: \u002710.0.105.112\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_191\u0027\nDriver info: driver.version: ChromeDriver\nremote stacktrace: Backtrace:\n\tOrdinal0 [0x008F5D53+2448723]\n\tOrdinal0 [0x00828131+1605937]\n\tOrdinal0 [0x0071F879+522361]\n\tOrdinal0 [0x006B05F3+67059]\n\tOrdinal0 [0x006ACD92+52626]\n\tOrdinal0 [0x006CC127+180519]\n\tOrdinal0 [0x006CBF2D+180013]\n\tOrdinal0 [0x006C9E5B+171611]\n\tOrdinal0 [0x006B1DD8+73176]\n\tOrdinal0 [0x006B2E50+77392]\n\tOrdinal0 [0x006B2DE9+77289]\n\tOrdinal0 [0x0083D6A7+1693351]\n\tGetHandleVerifier [0x00993E16+522726]\n\tGetHandleVerifier [0x00993B54+522020]\n\tGetHandleVerifier [0x009A8F67+609079]\n\tGetHandleVerifier [0x00994686+524886]\n\tOrdinal0 [0x00835A8C+1661580]\n\tOrdinal0 [0x0083F00B+1699851]\n\tOrdinal0 [0x0083F173+1700211]\n\tOrdinal0 [0x00854FE5+1789925]\n\tBaseThreadInitThunk [0x74806359+25]\n\tRtlGetAppContainerNamedObjectPath [0x76F37B74+228]\n\tRtlGetAppContainerNamedObjectPath [0x76F37B44+180]\n\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.W3CHandshakeResponse.lambda$new$0(W3CHandshakeResponse.java:57)\r\n\tat org.openqa.selenium.remote.W3CHandshakeResponse.lambda$getResponseFunction$2(W3CHandshakeResponse.java:104)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$0(ProtocolHandshake.java:123)\r\n\tat java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)\r\n\tat java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)\r\n\tat java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)\r\n\tat java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:498)\r\n\tat java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)\r\n\tat java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)\r\n\tat java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)\r\n\tat java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)\r\n\tat java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:126)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:73)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:142)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:600)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:219)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:142)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:181)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:168)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:123)\r\n\tat com.cucumber.pages.BasePage.open(BasePage.java:53)\r\n\tat com.cucumber.steps.BasePageSteps.openHomePage(BasePageSteps.java:48)\r\n\tat ✽.Given the user opens the \"broadband-map\" page(src/test/java/com/cucumber/features/service_check.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "12/21 Waripori Street, Berhampore, Wellington",
      "offset": 28
    }
  ],
  "location": "BroadbandMapPageSteps.verifyAddress(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BroadbandMapPageSteps.verifyServices(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BroadbandMapPageSteps.printServices()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BasePageSteps.takePageScreenShot()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 2505600,
  "error_message": "java.lang.NullPointerException\r\n\tat com.cucumber.pages.BasePage.takeScreenshot(BasePage.java:186)\r\n\tat com.cucumber.steps.BasePageSteps.close_browser(BasePageSteps.java:74)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:206)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.model.CucumberScenarioOutline.run(CucumberScenarioOutline.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat cucumber.api.testng.AbstractTestNGCucumberTests.feature(AbstractTestNGCucumberTests.java:21)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner.feature(ExtendedTestNGRunner.java:69)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:86)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:643)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:820)\r\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1128)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:782)\r\n\tat org.testng.TestRunner.run(TestRunner.java:632)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:366)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:361)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:319)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:268)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1244)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1169)\r\n\tat org.testng.TestNG.run(TestNG.java:1064)\r\n\tat org.apache.maven.surefire.testng.TestNGExecutor.run(TestNGExecutor.java:77)\r\n\tat org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.executeMulti(TestNGDirectoryTestSuite.java:159)\r\n\tat org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.execute(TestNGDirectoryTestSuite.java:99)\r\n\tat org.apache.maven.surefire.testng.TestNGProvider.invoke(TestNGProvider.java:106)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)\r\n\tat org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)\r\n\tat org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)\r\n",
  "status": "failed"
});
});