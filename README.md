Automation It has been developed using Java ,Cucumber, Selenium and maven using Serenity BDD. 
The feature file for the test scenarios are in a feature file 
/src/test/resources/features/random_date/random_date_generator.feature

**requirements**
1. Serenity BDD uses Java 8, so make sure you have a JDK 1.8 or later installed
Also, make sure you have Maven 3.3.x or higher installed

2. Make sure the Chrome driver matches with the version of chrome that you are running.
For more info go to https://chromedriver.chromium.org/downloads

4. to run the test use mvn verify. After the test runs, a report "index.html" will be generated in 
path /target/site/serenity 

**What's included/excluded in automation**
1. Allows the automation to multiple Inputs for the calendar date options except for custom date formats 
2. Validating the date format and date validity has been done for the date formats. 
YYYY-MM-DD hh:mm:ss , YYYY-DD-MM hh:mm:ss, and MM-DD-YYYY hh:mm:ss. Other date formats are not covered by automation.
3. Date validation has been done by splitting the date format, using counts in the format string 
as well as parsing the date and comparing the parsed date with the date displayed on the browser. 
4. Check for verifying if the generated random dates fall between the start and end date has not been covered. 