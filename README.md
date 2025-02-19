# Project Title

Automation test for Nanox AI

## Table of Contents
- [Overview](#overview)
- [Installation](#installation)
- [Driver Preparation](#driver-preparation)
- [Execution](#execution)


## Overview

This project automates the testing of an e-commerce web application, focusing on validating the product catalog and shopping cart functionality. The tests are implemented using **Selenium WebDriver**, **Cucumber (BDD framework)**, and **Java**.

## Features Tested

### Main Page
- Ensuring the main page loads correctly.
- Validating the title of the main page.
- Checking if the product table is displayed and contains data.

### Product Categories
- Navigating to different product categories: `Phones`, `Laptops`, and `Monitors`.
- Fetching and verifying product details (name, price, description).
- Ensuring the product table updates according to the selected category.

### Shopping Cart
- Selecting a random product from a category.
- Validating product details after selection.
- Adding the selected product to the shopping cart.
- Handling and confirming popup messages.
- Navigating to the cart and verifying that the product was added successfully.


## Installation

1. Clone the repository
2. Install dependencies: ```mvn clean install```


## Driver Preparation 
### Option 1: Download the Relevant Chrome Driver

1. Download ChromeDriver from [here](https://googlechromelabs.github.io/chrome-for-testing/).
2. Move it to the following location:
    ```bash
    mv chromedriver /path/to/automation_nanox_ai/src/main/java/utils
    ```

### Option 2: Use Selenium Hub via Docker

1. Install Docker Desktop (if not already installed).
2. Create a new `docker-compose.yml` file in your project and paste the following code:
    ```yaml
    # To execute this docker compose yml file use `docker compose -f docker-compose-v3.yml up`
    # Add the `-d` flag at the end for detached execution
    # To stop the execution, hit Ctrl+C, and then `docker compose -f docker-compose-v3.yml down`
    
    version: "3"
    services:
      chrome:
        platform: linux/amd64
        image: selenium/node-chrome:4.27.0-20241204
        shm_size: 2gb
        depends_on:
          - selenium-hub
        environment:
          - SE_EVENT_BUS_HOST=selenium-hub
          - SE_EVENT_BUS_PUBLISH_PORT=4442
          - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
          - SE_ENABLE_TRACING=false

      selenium-hub:
        platform: linux/amd64
        image: selenium/hub:4.27.0-20241204
        container_name: selenium-hub
        environment:
          - SE_ENABLE_TRACING=false
        ports:
          - "4442:4442"
          - "4443:4443"
          - "4444:4444"
    ```

3. To start the Selenium Hub and Chrome node, run:
    ```bash
    docker compose -f docker-compose-v3.yml up
    ```

4. To stop the containers, use:
    ```bash
    docker compose -f docker-compose-v3.yml down
    ```

## Execution

1. ```mvn test```
2. example for spesific tag: ```mvn test -Dcucumber.options="--tags @sanity"```


### Prerequisites

- Java Development Kit (JDK)
  
Example:
```bash
# Install Java (if not already installed)
sudo apt-get install openjdk-11-jdk
