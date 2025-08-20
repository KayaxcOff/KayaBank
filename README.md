# Aet Bank 🏦

A simple yet comprehensive banking application built with Java, featuring user authentication, account management, and persistent data storage using JSON.

## Features ✨

- **User Registration**: Create new bank accounts with secure password verification
- **User Authentication**: Login system with username and password validation
- **Account Management**: 
  - Deposit money to your account
  - Withdraw money from your account
  - View account information and balance
- **Data Persistence**: All user data and transactions are saved to JSON file
- **Balance Tracking**: Real-time balance updates with persistent storage
- **Input Validation**: Comprehensive error handling and input validation

## Project Structure 📁

```
src/main/java/org/example/
├── Main.java              # Application entry point and main menu
├── User.java             # User data model with getters/setters
├── LogIn.java            # Authentication and user registration
├── BankMenu.java         # Banking operations menu
└── BankTransactions.java # Core banking operations (deposit/withdraw)
```

## Technologies Used 🛠️

- **Java 8+**: Core programming language
- **Gson Library**: JSON serialization/deserialization
- **Java NIO**: File operations for data persistence
- **Scanner**: User input handling

## Getting Started 🚀

### Prerequisites

- Java 8 or higher installed
- Gson library dependency

### Maven Dependency

Add this to your `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
```

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd aet-bank
```

2. Compile the project:
```bash
javac -cp ".:gson-2.8.9.jar" src/main/java/org/example/*.java
```

3. Run the application:
```bash
java -cp ".:gson-2.8.9.jar:src/main/java" org.example.Main
```

## Usage Guide 📖

### Main Menu Options

1. **Create Account**: Register a new user account
   - Enter desired username
   - Complete temporary password verification
   - Set permanent password
   - Account created with $0 initial balance

2. **Sign In**: Access existing account
   - Enter username and password
   - Access banking operations menu

3. **Exit**: Close the application

### Banking Operations

Once logged in, users can:

- **Deposit Money**: Add funds to account balance
- **Withdraw Money**: Remove funds from account (with balance validation)
- **Display User Information**: View username and current balance
- **Exit**: Save changes and return to main menu

## Data Storage 💾

User data is stored in `users_data.json` with the following structure:

```json
[
  {
    "username": "john_doe",
    "password": "secure_password",
    "balance": 1500
  }
]
```

## Key Features Implementation 🔧

### Secure Password System
- Temporary password generation for account verification
- Password confirmation during registration
- Secure login validation

### Balance Persistence
- Real-time balance updates during transactions
- Automatic save to JSON file on exit
- Balance recovery on re-login

### Input Validation
- Positive amount validation for transactions
- Username uniqueness checking
- Comprehensive error handling

### Object-Oriented Design
- Clean separation of concerns
- Modular class structure
- Encapsulated data with proper getters/setters

## Error Handling 🛡️

The application handles various error scenarios:

- Invalid user input (negative amounts, empty fields)
- File I/O exceptions during data save/load
- User not found scenarios
- Insufficient balance for withdrawals
- Duplicate username prevention

## Future Enhancements 🔮

Potential improvements for future versions:

- [ ] Password encryption/hashing
- [ ] Transaction history logging
- [ ] Database integration (SQLite/PostgreSQL)
- [ ] Multi-currency support
- [ ] Account types (Savings/Checking)
- [ ] Interest calculation
- [ ] Transfer between accounts
- [ ] GUI implementation (JavaFX/Swing)

## Contributing 🤝

1. Fork the repository
2. Create a feature branch: `git checkout -b feature-name`
3. Commit changes: `git commit -am 'Add new feature'`
4. Push to branch: `git push origin feature-name`
5. Submit a pull request

## Author 👨‍💻

Developed as a learning project to demonstrate:
- Java OOP principles
- File I/O operations
- JSON data handling
- Console application development
- Banking system logic

## Acknowledgments 🙏

- Gson library for JSON processing
- Java community for excellent documentation
- Banking industry practices for application logic inspiration

---

**Note**: This is an educational project. For production banking applications, additional security measures, encryption, and regulatory compliance would be required.
