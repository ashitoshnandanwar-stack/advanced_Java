# advanced_Java
lab problems

## JDBC Drivers type

| Type   | Name        | Speed     | Extra Software | Usage          |
| ------ | ----------- | --------- | -------------- | -------------  |
| Type 1 | JDBC-ODBC   | Very Slow | ODBC required  | ❌ Not used    |
| Type 2 | Native API  | Medium    | Native DB lib  | ⚠️ Rare        |
| Type 3 | Network     | Medium    | Middleware     | ⚠️ Rare        |
| Type 4 | Thin Driver | Fastest   | None           | ✅ Mostly used |

- Type 4 JDBC driver is the most commonly used because it is fast, platform independent, and pure Java-based.

## Architecture of JDBC
<img width="400" height="350" alt="image" src="https://github.com/user-attachments/assets/8710aaf1-5a37-49ba-846c-f7596839f4ad" />

### JDBC Architecture Layers (Top to Bottom)
MCQ Memory Trick
- A-J-D-D-D
- Application → JDBC API → DriverManager → Driver → Database

1️⃣ Application Layer (Java Program)
- This is your Java code
- Uses JDBC API classes & interfaces
- (Connection, Statement, PreparedStatement, ResultSet)

2️⃣ JDBC API Layer
- Provided by Java (JDK)
- Contains JDBC interfaces
- Acts as a bridge between Java app and driver
- 📌 Important interfaces:
DriverManager,
Connection,
Statement,
PreparedStatement,
ResultSet
- 👉 Converts Java calls into driver-understandable calls

3️⃣ Driver Manager Layer
- Manages JDBC drivers
- Finds the correct driver
- Establishes connection with database

4️⃣ JDBC Driver Layer
- Database-specific driver
- Converts JDBC calls into database protocol
- Communicates directly with DB
- 📌 Example:
MySQL Driver,
Oracle Driver
- 👉 Most used: Type 4 (Thin Driver)

5️⃣ Database Layer
- Actual database
- Stores data
- Executes SQL queries
- 📌 Examples:
MySQL,
Oracle,
PostgreSQL,

## 🔹 What is DAO Pattern?
- DAO Pattern separates database access logic from business logic.
- It provides a clean structure to interact with the database using JDBC (or Hibernate).
- Application → JDBC API → DAO → Database
Layers in DAO Pattern

1️⃣ Application / Service Layer
- Contains business logic
- Calls DAO methods
- ❌ No SQL here

2️⃣ DAO Layer (Main part)
- Contains all JDBC code
- SQL queries (SELECT, INSERT, UPDATE)
- Uses JDBC API

3️⃣ Database Layer
- Actual database (MySQL, Oracle, etc.)

## J2EE

<img width="800" height="267" alt="image" src="https://github.com/user-attachments/assets/5206acb6-d48b-42cd-9b67-1a3e6880e193" />


