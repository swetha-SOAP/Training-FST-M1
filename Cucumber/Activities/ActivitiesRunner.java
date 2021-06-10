package cucumberTest; 
2 
 
3 import org.junit.runner.RunWith; 
4 
 
5 import cucumber.api.CucumberOptions; 
6 import cucumber.api.junit.Cucumber; 
7 
 
8  /* 
9 @RunWith(Cucumber.class) 
10 @CucumberOptions( 
11     features = "Features", 
12     glue = {"stepDefinitions"}, 
13     tags = "@activity1_5", 
14     plugin = { "pretty", "html:target/cucumber-reports/reports" }, 
15     monochrome = true 
16 ) 
17 */ 
18 
 
19 
 
20 @RunWith(Cucumber.class) 
21 @CucumberOptions( 
22     features = "Features", 
23     glue = {"stepDefinitions"}, 
24     tags = "@SimpleAlert", 
25     plugin = {"html: test-reports"}, 
26     monochrome = true 
27 ) 
28 
 
29 
 
30 public class ActivitiesRunner { 
31 
 
32 } 
