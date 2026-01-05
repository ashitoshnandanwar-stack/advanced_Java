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

###  1. J2EE Overview (What is J2EE?)
- J2EE (Java 2 Enterprise Edition) is a platform used to build large-scale, web-based, enterprise applications.
- In simple words: J2EE is a set of rules + APIs that helps Java developers create web applications like banking, e-commerce, ERP systems.
- J2EE provides: Web application, Database connectivity, Security, Transaction management, Web services

### 2. J2EE Container
- A container is a runtime environment that runs Java web components.
- Think like this: Container = Manager who takes care of your web application
- Types of Containers: 1. Web Container → runs Servlets, JSP
 2. EJB Container → runs Enterprise Java Beans
- Container provides: Object creation, Security, Transaction handling

- Life cycle management 👉 Developer writes logic, container manages everything else

### 3. Packaging Web Applications
- Packaging means grouping all files together so they can be deployed.
#### Web application contains:
- HTML / JSP files
- Servlets
- CSS / JS
- Configuration files
- Packaged as: WAR file (Web Archive)

### 5. Deployment Tools
- Deployment tools are used to install and manage web applications on servers.

### 6. Web Application Life Cycle
- Life cycle means stages of a web application.
#### Steps:
- 1️⃣ Loading
- 2️⃣ Initialization
- 3️⃣ Request handling
- 4️⃣ Destruction
  
- J2EE is a platform for enterprise web applications. 
- Container manages web components. 
- Web apps are packaged as WAR files.
- Deployment tools install and manage apps.
- Web app life cycle includes init, service, destroy.
- J2EE supports web services for app communication.
## Servlets: Dynamic Content Generation - Comprehensive Study Guide
- Servlet is a Java class that runs on a web server and handles client requests, typically HTTP requests. Servlets are used to create dynamic web content and form the foundation of Java web applications.
### Methods:
- init(): Initialize the servlet
- service(): Handle requests
- destroy(): Clean up resources
- getServletConfig(): Get servlet configuration
- getServletInfo(): Get servlet information
###  Cookies
What are Cookies?
- Small pieces of data stored on the client side
- Sent with every HTTP request to the server
- Limited to 4KB per cookie
- 
#### Cookie Methods:
- setMaxAge(int seconds): Set expiry time (-1 for session cookie)
- setPath(String path): Set cookie path
- setDomain(String domain): Set cookie domain
- setSecure(boolean flag): HTTPS only
- setHttpOnly(boolean flag): Prevent JavaScript access

#### HttpSession Methods:
- getSession() or getSession(true): Create new session if doesn't exist
- getSession(false): Return existing session or null
- setAttribute(String name, Object value): Store data
- getAttribute(String name): Retrieve data
- removeAttribute(String name): Remove specific attribute
- invalidate(): Destroy session
- getId(): Get session ID
- isNew(): Check if session is new
- setMaxInactiveInterval(int seconds): Set timeout
- getMaxInactiveInterval(): Get timeout

| Feature              | Cookies                         | HttpSession                               |
| -------------------- | ------------------------------- | ----------------------------------------- |
| **Storage**          | Client-side (browser)           | Server-side                               |
| **Security**         | Less secure                     | More secure                               |
| **Data Size**        | Limited (≈ 4 KB)                | Practically unlimited                     |
| **Data Type**        | String only                     | Any Java object                           |
| **Performance**      | Less server load                | More server load                          |
| **Persistence**      | Can persist (stored in browser) | Session-based (expires on logout/timeout) |
| **Lifetime Control** | Controlled by expiry time       | Controlled by server                      |
| **Accessibility**    | Accessible on client            | Accessible only on server                 |
| **Use Case**         | Remember user preferences       | Login session, user data                  |

#### How to prevent sql injection in jdbc?
 - Prepared statement (best practice).
 - Input validation
 - Stored procedure
 - Least priviledge

#### What is a Transaction?
A transaction is a group of operations that must all succeed or all fail together. Think of it like a bank transfer - money must leave one account AND enter another, or neither should happen.
##### ACID Properties
A - Atomcity : All operations succeed or all fail (all-or-nothing). <br>
C - Consistency : Database moves from one valid state to another. Business rules are maintained. <br>
```
// Check constraint before transaction
if(getBalance(accountId) >= withdrawAmount) {
    // Proceed with transaction
} else {
    throw new InsufficientFundsException();
}
```
I - Isolation : Concurrent transactions don't interfere with each other. <br>
D - Durability : Once committed, changes are permanent (survive system crashes).

## Main component of hibernate
| Component         | Role                       |
| ----------------- | -------------------------- |
| Configuration     | Loads `hibernate.cfg.xml`  |
| SessionFactory    | Heavy, one per DB          |
| Session           | Lightweight, DB operations |
| Transaction       | ACID compliance            |
| Query             | Executes HQL / SQL         |
| Persistent Object | Entity class               |
```
Java App
 ↓
Configuration
 ↓
SessionFactory
 ↓
Session
 ↓
Database
```
- SessionFactory is thread-safe
- Session is not thread-safe
- Client → Servlet → DAO → Hibernate → DB


| Component      | Thread-Safe? | Reason & Design Purpose                                                 |
|----------------|--------------|-------------------------------------------------------------------------|
| SessionFactory | Yes          | Immutable and heavyweight; meant to be shared across the entire         |
|                |              | application.                                                            |
| Session        | No           | Mutable, lightweight, and tied to a single unit of work (e.g., one      |
|                |              | request or transaction).                                                |


| State          | Meaning                                 |
| -------------- | --------------------------------------- |
| **Transient**  | New object, not linked to DB or Session |
| **Persistent** | Object associated with Session & DB     |
| **Detached**   | DB has data, Session closed             |
| **Removed**    | Deleted from DB                         |
```
eg.
session.save(obj);      // Transient → Persistent
session.close();        // Persistent → Detached
session.update(obj);    // Detached → Persistent
session.delete(obj);    // Persistent → Removed
```

### Hibernate Catching
<img width="764" height="425" alt="image" src="https://github.com/user-attachments/assets/808fe9b1-f385-4830-939f-eaf4513fbb7c" />

| Cache           | Scope          | Mandatory  |
| --------------- | -------------- | ---------- |
| **First-level** | Session        |  YES       |
| Second-level    | SessionFactory |  Optional  |
| Query cache     | Query          |  Optional  |

- Hibernate ALWAYS has first-level cache (Session cache)

### Hibernate Relationships & mappedBy

| Relationship     | Join Table |
| ---------------- | ---------- |
| One-to-One       |     No     |
| One-to-Many      |     No     |   
| Many-to-One      |     No     |
| **Many-to-Many** |     YES    |

### Cascade types

| Cascade    | Meaning        |
| ---------- | -------------- |
| PERSIST    | Save child     |
| MERGE      | Merge child    |
| **REMOVE** | Delete child   |
| REFRESH    | Reload         |
| **ALL**    | All operations |

### Fetch Types

| Relationship  | Default Fetch |
| ------------- | ------------- |
| OneToMany     | LAZY          |
| ManyToMany    | LAZY          |
| **ManyToOne** | **EAGER**     |
| OneToOne      | EAGER         |

### Named Queries (SAFE & FAST)
- Why Named Queries? <br>
Defined at entity level <br>
Prevent SQL Injection <br>
Precompiled <br>


### four types of entity relationships in Hibernate/JPA
1. One to One : One entity is associated with exactly one instance of another entity. <br>
Example: User ↔ Profile (each user has one profile) <br>
```
@Entity
public class User {
    @Id
    private Long id;
    
    @OneToOne(mappedBy = "user")
    private Profile profile;
}
@Entity
public class Profile {
    @Id
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```
2. One to Many : One entity is associated with multiple instances of another entity. <br>
Example: Department → Employees (one department has many employees)
```
@Entity
public class Department {
    @Id
    private Long id;
    
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
@Entity
public class Employee {
    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
```
3. Many to One : Multiple instances of one entity are associated with one instance of another. <br>
Example: Employees → Department (many employees belong to one department)

5. Many to Many : Multiple instances of one entity are associated with multiple instances of another. <br>
Example: Students ↔ Courses (students enroll in many courses, courses have many students).
```
@Entity
public class Student {
    @Id
    private Long id;
    
    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
}

@Entity
public class Course {
    @Id
    private Long id;
    
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
```
