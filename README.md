# Automated Testing Framework for [automationexercise.com]

Automated testing framework for the website automationexercise.com built with Java, Selenium WebDriver, TestNG, and the Page Object Model (POM) framework. Allure is used for generating comprehensive test reports.

**Key Features:**

__Page Object Model (POM) Framework:__

- Updated POM framework implementation.
- Dynamically generated page classes from JSON file containing page elements.
- Improved maintainability and readability.

__Automated Actions:__

- AutomatedActions class for common web actions (clicking, typing, validation).
- Reusable methods for interacting with web elements.

__Navigation Management:__

- Dedicated class for seamless page navigation.
- Centralized logic for page transitions.

### How to Use:

**Dependencies:**

- Ensure Java is installed on your machine.
- Install required dependencies specified in pom.xml using Maven.

**Configuration:**

- Modify config.properties for browser configurations and other parameters.

**Executing Tests:**

- Run tests using TestNG runner.
- Allure reports offer detailed insights into test execution.

### Structure:

1. **src/main/java/base:**
    - Contains framework core base class and navigation class.

2. **src/main/java/pages:**
    - Contains dynamically generated POM page classes for each page web element.

3. **src/main/java/pagesElements:**
    - Contains JSON files holding web elements used to generate pages' Java classes.

4. **src/main/java/utils:**
    - Contains utility classes like AutomatedActions, Browsers, Element, GeneratePages, PageUtils, TestCaseData.

5. **src/main/java/resources:**
    - Contains config file and test data JSON file for test case information.

6. **src/test/java/testCases:**
    - Contains test case classes and test base class.

7. **src/test/java/screenshots:**
    - Contains screenshots taken after each test.

Contributions are welcome! Submit issues, feature requests, or pull requests.
