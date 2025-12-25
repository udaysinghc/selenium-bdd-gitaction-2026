# Selenium BDD Automation Framework 2026

A lightweight Selenium BDD automation framework built using Java, Selenium WebDriver, Cucumber, TestNG, and Allure, with GitHub Actions CI integration for automated test execution.

## Framework Structure

```
selenium-bdd-automation-2026/
|.github/workflows/bdd_demo.yml
├── src/
│   ├── main/
│   │   ├── java/org/example/
│   │   │   ├── base/
│   │   │   │   └── BaseTest.java
│   │   │   ├── config/
│   │   │   │   └── ConfigReader.java
│   │   │   ├── pages/
│   │   │   │   ├── BasePage.java
│   │   │   │   └── LoginPage.java
│   │   │   ├── retryanalyzer/
│   │   │   │   └── RetryAnalyzer.java
│   │   │   └── utils/
│   │   │       ├── Constants.java
│   │   │       ├── JavascriptUtils.java
│   │   │       └── WaitUtils.java
│   │   └── resources/
│   │       ├── log4j2.xml
│   │       ├── qa.properties
│   │       └── stage.properties
│   └── test/
│       └── java/org/example/
│           ├── features/
│           │   └── Login.feature
│           ├── stepdefinitions/
│           │   ├── Hooks.java
│           │   └── LoginStepDefinitions.java
│           └── runners/
│               └── TestRunner.java
├── pom.xml
└── testng.xml
```

## Technologies Used

- **Java 17** - Programming Language
- **Selenium WebDriver 4.16.1** - Browser Automation
- **Cucumber 7.15.0** - BDD Framework
- **TestNG 7.8.0** - Test Execution Framework
- **Allure 2.25.0** - Test Reporting
- **Log4j2 2.22.0** - Logging Framework
- **Maven** - Build Tool

## Prerequisites

Before running the tests, ensure you have the following installed:

1. **Java JDK 17 or higher**
   - Download from: https://www.oracle.com/java/technologies/javase-downloads.html
   - Verify installation: `java -version`

2. **Maven 3.6 or higher**
   - Download from: https://maven.apache.org/download.cgi
   - Verify installation: `mvn -version`

3. **Allure Command Line** (for generating reports)
   - Install via Homebrew (Mac): `brew install allure`
   - Install via Scoop (Windows): `scoop install allure`
   - Or download from: https://github.com/allure-framework/allure2/releases

4. **Web Browsers**
   - Chrome, Firefox, or Edge browser installed

## Setup Instructions

### 1. Clone or Download the Project

```bash
git clone <repository-url>
cd selenium-bdd-automation-2026
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Configure Environment

Edit the properties files in `src/main/resources/`:

**qa.properties** - QA Environment Configuration
```properties
browser=chrome
url=https://www.example.com
headless=false
implicit.wait=10
explicit.wait=20
page.load.timeout=30
```

**stage.properties** - Stage Environment Configuration
```properties
browser=chrome
url=https://stage.example.com
headless=false
implicit.wait=10
explicit.wait=20
page.load.timeout=30
```

## Running Tests

### Run All Tests (Default: QA Environment)

```bash
mvn clean test
```

### Run Tests on Specific Environment

```bash
mvn clean test -Denv=qa
mvn clean test -Denv=stage
```

### Run Tests with Specific Tags

```bash
mvn clean test '-Dcucumber.filter.tags=@smoke'
mvn clean test -Dcucumber.filter.tags="@regression"
mvn clean test -Dcucumber.filter.tags="@smoke and @regression"
```

### Run Tests in Headless Mode

Update the properties file:
```properties
headless=true
```

### Run Tests with Different Browser

Update the properties file:
```properties
browser=chrome    # or firefox, edge
```

## Generating Allure Reports

### Generate and Open Allure Report

After running tests, generate the Allure report:

```bash
mvn allure:serve
```

This will automatically open the report in your default browser.

### Generate Allure Report (without opening)

```bash
mvn allure:report
```

The report will be generated in `target/allure-reports/` directory.

### View Existing Report

```bash
allure open target/allure-reports
```
### GitHub Actions CI

- Tests run automatically on push and pull request

- Uses Ubuntu runner with JDK 17

- Executes Maven test suite

- Generates Allure results

### Workflow file: .github/workflows/*.yml

### Reports

Allure results generated under target/allure-results

Allure report can be generated locally using: mvn allure:serve

Happy Automating 🚀
