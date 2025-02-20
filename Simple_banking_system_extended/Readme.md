# Simple Banking System Extended

## 📌 Overview
**Simple Banking System Extended** is an enhanced version of a basic Java-based banking system that allows users to manage their accounts securely. The system supports multiple users, including an admin role for managing accounts.

## 🚀 Features
- ✅ **User Login & Authentication**
- ✅ **View Account Balance**
- ✅ **Deposit & Withdraw Money**
- ✅ **Admin Panel for User Management**
- ✅ **SQLite Database Integration**
- ✅ **Error Handling for Invalid Inputs**

## 🛠 Technologies Used
- **Java** - Core logic and application structure
- **SQLite** - Database for storing user data
- **JDBC** - Java Database Connectivity for interacting with SQLite
- **Scanner** - Handling user input in the console

## 📂 Project Structure
```
Simple_banking_system_extended/
├── Main.java               # Entry point of the application
├── User.java               # Handles user interactions
├── Login.java              # Manages user authentication
├── Admin.java              # Admin panel for user management
├── AdminRole.java          # Admin-specific operations
├── HandleUser.java         # Handles balance updates and transactions
├── Sqlite.java             # Manages database operations
```

## 🏗️ Installation & Setup
1️⃣ **Clone the repository:**
```sh
git clone https://github.com/Imranelaf/java_as_beginner.git
```

2️⃣ **Navigate to the project folder:**
```sh
cd Simple_banking_system_extended
```

3️⃣ **Compile and run the project:**
```sh
javac Main.java && java Main
```

## 🏦 How to Use
### User Mode
1. Log in with your credentials.
2. Choose an option:
   - **View balance**
   - **Deposit money**
   - **Withdraw money**
   - **Exit**

### Admin Mode
1. Log in as **Admin**.
2. Manage users:
   - **Create new users**
   - **View user details**
   - **Delete users**
   - **Exit**

## ⚠️ Error Handling
- Prevents negative deposits and withdrawals.
- Handles incorrect login attempts.
- Validates numeric inputs for transactions.

## 📌 Future Enhancements
🔹 GUI for a better user experience
🔹 More security features (hashed passwords, JWT authentication)
🔹 API integration for online transactions

---
📌 **Author:** [Imrane ALI LAFKIH](https://github.com/Imranelaf)


