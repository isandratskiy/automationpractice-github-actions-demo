# automationpractice-demo
##### project stack :
- **Gradle project** 
- **Selenide as Web automation framework** 
- **JUnit5 as test runner xUnit framework** 
- **Allure as test reporting** 
- **JavaOwner for example parameterizing test data** 
- **Flogger as logger with fluent interface** 


## Required environment

- Docker (is optional for remote running)
- Java 8

### Setup Selonoid

- run selenoid_start.sh
- Windows :
```
 selenoid_start.sh
```
- MacOS :
```
 ./selenoid_start.sh
```
- or run docker-compose file (not recommended for Windows) :
```
 docker-compose up
```
- **You can open Selenoid UI as localhost:8081 in browser** 
## Import project (is optional)
- should be imported as Gradle project with using Gradle wrapper
- for run tests from IDEA You need to enable Annotation Processing
```
 Settings > Build > Compiler > Annotation Processors
```

## Run tests from cli

commands syntax:
- **local run example (Chrome browser as default and without parallelism)** 
- Windows :
```
 gradlew clean test
```
- MacOS :
```
 ./gradlew clean test
```
- **local run with specific browser and parallelism** 
- Windows :
```
 gradlew clean -Pthread=2 testChrome
```
```
 gradlew clean -Pthread=2 testFirefox
```
- MacOS :  
```
 ./gradlew clean -Pthread=2 testChrome
```
```
 ./gradlew clean -Pthread=2 testFirefox
```
- **remote run with specific browser and parallelism** 
- Windows :
```
 gradlew clean -Pthread=2 -Plaunch=remote testChrome
```
```
 gradlew clean -Pthread=2 -Plaunch=remote testFirefox
```
- MacOS :
```
 ./gradlew clean -Pthread=2 -Plaunch=remote testChrome
```
```
 ./gradlew clean -Pthread=2 -Plaunch=remote testFirefox
```
## Generate Allure report
- **generate report after full test run** 
- Windows :
```
 gradlew allureReport
```
- MacOS :
```
 ./gradlew allureReport
```
- **than run Allure web service** 
- Windows :
```
 gradlew allureServe
```
- MacOS :
```
 ./gradlew allureServe
```