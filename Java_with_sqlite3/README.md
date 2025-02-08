# User Management System
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

## Install SQLite:

the sqlite are aleardy provide in this folder "sqlite-jdbc-3.49.0.0.jar" .
Database Setup:

  The SQLite database (users.db) will be automatically created if it doesn't already exist.
  The application will ensure that the users table is created in the database.

## Running the Application:

Compile and run the Java files using a Java IDE or the command line.
For example, you can use the command:

<pre>javac -cp .:sqlite-jdbc-3.49.0.0.jar Main.java </pre>
<pre> java -cp .:sqlite-jdbc-3.49.0.0.jar Main </pre>

###Create a New User:

Upon running the application, you will be prompted to enter a name and password.
The system will validate the input and store the user in the database.

### Example Output
<pres>
Enter the name please: John
Enter the password please: 1234
User created successfully</pres>
Error Handling
If an error occurs during user creation or database interaction, the error message will be displayed.
