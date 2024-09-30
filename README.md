# Currency Converter

A web-based currency converter application built with Java Servlets, Ajax, and Java Applets.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Overview

This project is a web application that allows users to convert amounts from one currency to another in real-time. It fetches live exchange rates from an external API and provides up-to-date conversion results.

## Features

- Convert amounts between multiple currencies.
- Fetch live exchange rates using an external API.
- Responsive and user-friendly interface.
- Real-time conversion without page reloads using Ajax.

## Technologies Used

- **Java Programming Language**
- **Java Servlets** for backend logic.
- **Ajax** for asynchronous requests.
- **HTML/CSS/JavaScript** for frontend.
- **Java Applets** (Note: Modern browsers have deprecated support for Applets; consider using alternatives like JSP or JSF).

## Setup and Installation

### Prerequisites

- Java Development Kit (JDK) installed.
- Apache Tomcat server or any other servlet container.
- An IDE like Eclipse or IntelliJ IDEA.
- An API key from [ExchangeRate-API](https://www.exchangerate-api.com/).

### Steps

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/CurrencyConverter.git

2. **Import the Project into Your IDE**

Open your IDE
Import the project as an existing Maven/Gradle project or as a Dynamic Web Project.

3. **Add Your API Key**

Navigate to src/com/currencyconverter/util/CurrencyApi.java.
Replace "YOUR_API_KEY" with your actual API key.
private static final String API_KEY = "YOUR_ACTUAL_API_KEY";

4. **Build the Project**

Ensure all dependencies are resolved.
If using Maven or Gradle, run the build command.

5. **Run the Application**

Deploy the application to your Apache Tomcat server.
Access the app at http://localhost:8080/CurrencyConverter/WebContent/index.html.
