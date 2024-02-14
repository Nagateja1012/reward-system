# Reward System

## Setup and Configuration Instructions

1. Clone or download the project.
2. Open the project in your Integrated Development Environment (IDE), preferably IntelliJ IDEA.
3. IntelliJ IDEA will automatically install the dependencies. Alternatively, open the terminal in the project directory and run the command `mvn dependency:resolve`.
4. After the dependencies are installed, navigate to `src\main\java\com.charter.teja.rewards\RewardsApplication.class`.
5. Run the project from that class.
6. Once the server has started, check the console tab for the port number, which should be 8080.
7. Once you have confirmed the port number, open `localhost:8080` in your browser to access the Reward Point API page.
8. If your port is not 8080, you can update the port number in two ways:
   - Edit the `application.properties` file and add the statement `server.port=8080`.
   - Open `index.html` from `src\main\resources\public\` and replace all instances of port number 8080 with your desired port number using the replace.

## Project Demo

Upon launching the application, you will find:
1. **Fetch Transaction Data**
2. **Fetch Customer Data**
3. Input box with a submit button

Clicking "Fetch Transactions" will display all transaction data along with the corresponding points earned by the customer. The data includes transaction ID, date, customer ID, first name of the customer, last name of the customer, transaction amount, and total points.

Clicking "Fetch Customer Data" will display all customer data along with their respective points earned in three different months and the total points earned. The displayed data includes customer ID, first name, last name, points for each of the three months, and total points.

The input box allows users to input a customer ID to retrieve points data similar to the customer data but only for the requested customer ID.

## Note
Upon the first click on the button, the content will be displayed, and a secondary click will hide the tables. Clicking on both buttons will display two tables. As the tables may be long, you may need to scroll down to see the entire content.

Currently, the Fetch Customer Data API and CustomerByID API will only pull data for the months of January, February, and March of 2024 from the frontend UI.

To fetch data for other months and to test the API, you can update the values in the following URLs:
- To view all customer data: `http://localhost:8080/rewards/2024-01/2024-02/2024-03`
- To view customer data by ID: `http://localhost:8080/rewards/9/2024-01/2024-02/2024-03`

Update the port, month, year, and ID depending on your requirements.

## Data

- The data is randomly generated, so customer IDs may not start from 1.
- Each customer can have multiple transactions in a month and also customer can have only one transaction in 3 months
- The sum of points for all three months may not equal the total points, as customers may have transactions in December 2023, which are included in the total but not shown in the months (which only display January, February, and March of 2024).

## Project Overview

- `rewardsController`: Contains all API mappings. Depending on the API path and variables, the respective service is called.
- `rewardService`: Based on the service triggered from the `rewardsController`, the service will trigger the repository function to pull data from the database.
- `rewardRepo`: Utilizes JDBC template and SQL to pull data from the database, calculate points, and set the rewards and transaction models.
- `Rewards` and `Transaction` models: Define the fields and their respective setters and getters.
- `schema.sql`: Initializes the tables in the H2 database.
- `Data.sql`: Inserts data into the database.
- `Index.html`: Utilizes JavaScript to trigger APIs based on user selections and fetch JSON data from the APIs, inserting it into the UI table view.
- `Tests`: Services, repositories, and controllers are unit-tested using the concept of mocking.
