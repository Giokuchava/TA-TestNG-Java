# 🧪 TestNG Practical Project — Giorgi Kuchava

This project was developed as part of the **TestNG Practical Homework Assignment**, demonstrating a basic automation testing framework using **Java**, **Selenium WebDriver**, and **TestNG**.  
It includes two automated test classes covering form interactions and alert handling with **parallel execution**.

---

## 📘 Project Overview

### Initial Version
The initial version of the project included:
- Basic Selenium + TestNG tests
- Form interactions and alert handling
- Parallel execution using `testng.xml`

### Updated Version (Current)
The project was **refactored and improved** with:
- ✅ Page Object Model (POM)
- ✅ Explicit waits for stable test execution
- ✅ Allure Reporting integration
- ✅ Cleaner and more maintainable project structure

---

## 🧱 Key Features

- Alerts and popups handling
- Forms interaction (inputs, dropdowns, scrolling)
- Explicit waits (`WebDriverWait`)
- Parallel execution using `testng.xml`
- Page Object Model (POM)
- Allure annotations and detailed reports

---

## ⚙️ Tech Stack

| Tool / Library | Version / Description |
|----------------|-----------------------|
| **Java** | 17+ |
| **Selenium WebDriver** | Latest |
| **TestNG** | 7.x+ |
| **Maven** | Project Build Tool |
| **ChromeDriver** | For browser automation |

---

## 📂 Project Structure

src
├── main
│   └── java
│       ├── base        # Base test setup and driver configuration
│       └── pages       # Page Object classes
└── test
└── java
└── tests       # Test classes

---

## 🏗️ Project Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Giokuchava/TA-TestNG-Java.git
   cd TA-TestNG-Java
   git checkout HomeWork2

---

## 🚀 Running the Tests

### Prerequisites

- Java 17+
- Maven installed
- Chrome browser
- ChromeDriver configured

---

### ▶️ Run Tests with Maven

```bash
mvn clean test

📊 Allure Reporting

Install Allure CLI

macOS
brew install allure

Windows
scoop install allure

Verify installation:
allure --version

Test Execution Output

After running tests, Maven generates the following directory:
target/allure-results

This folder contains:
	•	Raw JSON test results
	•	Attachments such as screenshots (if configured)

Generate and View Report
allure serve target/allure-results