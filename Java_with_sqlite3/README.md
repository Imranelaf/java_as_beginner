User Management System
This project allows users to create their accounts by providing a username and password. The user data is stored in a SQLite database. The system ensures that the required fields are provided and that the user is added to the database correctly.

Features
User input for name and password.
Creates a new user in the SQLite database.
Ensures the users table exists in the database.
Handles user creation with error handling for invalid input.
Technologies Used
Java: The main programming language used for implementing the application logic.
SQLite: A lightweight database used to store user data.
Setup Instructions
Clone this repository or download the project files.

Install SQLite:

Ensure that SQLite is installed on your system. You can download it from SQLite's official site.
Database Setup:

The SQLite database (animals.db) will be automatically created if it doesn't already exist.
The application will ensure that the users table is created in the database.
Running the Application:

Compile and run the Java files using a Java IDE or the command line.
For example, you can use the command:
bash
Copy
Edit
<pre>javac -cp .:sqlite-jdbc-3.49.0.0.jar Main.java </pre>
<pre> java -cp .:sqlite-jdbc-3.49.0.0.jar Main </pre>

Create a New User:

Upon running the application, you will be prompted to enter a name and password.
The system will validate the input and store the user in the database.
Code Explanation
Main.java
The Main class handles user interaction by prompting the user for a name and password.
The input is validated to ensure that the name and password are not empty.
The user data is then passed to the Sqlite.createUser method for insertion into the database.
Sqlite.java
The Sqlite class manages database connections and interactions.
The createTableIfNotExist method ensures that the users table is created if it doesn't already exist.
The createUser method inserts a new user into the users table.
Example Output
bash
Copy
Edit
Enter the name please: John
Enter the password please: 1234
User created successfully
Error Handling
If an error occurs during user creation or database interaction, the error message will be displayed.
