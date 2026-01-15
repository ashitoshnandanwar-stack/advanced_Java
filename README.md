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

<hr>
<hr>
<hr>

## Servlet

### *Advantages of Servlets over CGI*

| CGI                           | Servlets                        |
| ----------------------------- | ------------------------------- |
| New process for every request | Single instance, multi-threaded |
| Slow performance              | High performance                |
| Platform dependent            | Platform independent (Java)     |
| No session handling           | Built-in session support        |
| Hard to maintain              | Easy to maintain                |


### *Servlet Annotations*
```
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
}
```
- Replaces web.xml mapping.

### *Servlet Life Cycle*

Managed by the container (Tomcat). <br>
- init() – Called once when servlet is created
- service() – Called for every request
- destroy() – Called before servlet is removed


### HttpServlet, HttpServletRequest, HttpServletResponse

*1️⃣ HttpServlet*
- HttpServlet is an abstract class used to create web components that handle HTTP requests.
- It belongs to jakarta.servlet.http (or javax.servlet.http in older versions)
- You extend it to create your own servlet <br>

It provides methods like: <br>
- doGet()
- doPost()
- doPut()
- doDelete()

| Method       | HTTP Method | Purpose                |
| ------------ | ----------- | ---------------------- |
| `doGet()`    | GET         | Read / fetch data      |
| `doPost()`   | POST        | Send new data (create) |
| `doPut()`    | PUT         | Update existing data   |
| `doDelete()` | DELETE      | Remove data            |

*2️⃣ HttpServletRequest*

Represents the client’s request. <br>
Used to: <br>
- Read form data
- Read query parameters
- Read headers
- Read cookies
- Get session

*3️⃣ HttpServletResponse*

Represents the server’s response sent back to the client.
Used to: <br>
- Send data to client
- Set status codes
- Set headers
- Redirect user

### *Session Management*

Session management is used to maintain user state across multiple HTTP requests. <br>
Since HTTP is stateless, servers use cookies + session IDs to remember users. <br>

Ways to maintain state: <br>
- Cookies
- URL Rewriting
- HttpSession

### *🔁 RequestDispatcher (Servlet)*
- RequestDispatcher is used in Java web applications to forward a request from one resource to another (Servlet, JSP, HTML) on the server side.
- In RequestDispather has two main method: forward() and include()

| Feature        | `forward()`                         | `include()`                              |
| -------------- | ----------------------------------- | ---------------------------------------- |
| Control        | Transfers control completely        | Includes output of another resource      |
| Response       | Original servlet stops executing    | Original servlet continues after include |
| Output         | Only target resource output is sent | Both outputs are combined                |
| URL in browser | Remains same                        | Remains same                             |
| Use case       | Page navigation                     | Reusing common content                   |


### *PageNavigation*

Page Navigation means moving the user from one page to another in a web application. <br>
In Servlets/JSP, it is mainly done using: <br>
1. RequestDispatcher.forward() – Server-side navigation
2. response.sendRedirect() – Client-side navigation <br>

Difference between RequestDispather.forward() and response.sendRedirect()

| Feature        | `RequestDispatcher.forward()`                 | `response.sendRedirect()`                      |
| -------------- | --------------------------------------------- | ---------------------------------------------- |
| Type           | Server-side                                   | Client-side                                    |
| Request object | Same request is used                          | New request is created                         |
| URL in browser | Does **not** change                           | **Changes**                                    |
| Speed          | Faster (no extra round trip)                  | Slower (extra request)                         |
| Data sharing   | Can share data using `request.setAttribute()` | Cannot use request data                        |
| Scope          | Only inside same web application              | Can go to another application or external site |

<hr>

## JSP (Java Server Page)

### *JSP Elements*

1. Directives
```
Provide instructions to the container.
Types:
1️⃣ page Directive
Used to configure page-level settings.
<%@ page contentType="text/html" import="java.util.*" %>

2️⃣ include Directive
Used to include another file statically (at compile time).
<%@ include file="header.jsp" %>

3️⃣ taglib Directive
Used to enable JSTL or custom tags.
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

2. Implicit Objects
Automatically available in JSP:

| Object        | Purpose             |
| ------------- | ------------------- |
| `request`     | Client request data |
| `response`    | Response to client  |
| `session`     | User session        |
| `application` | App-wide data       |
| `out`         | Output writer       |
| `config`      | Servlet config      |
| `pageContext` | Access all scopes   |
| `page`        | Current JSP object  |
| `exception`   | Error pages only    |

3. Scriptlets, Expressions & Declarations
```
<% int a = 10; %>              <!-- Scriptlet -->
<%= a %>                       <!-- Expression -->
<%! int b = 20; %>             <!-- Declaration -->
```
⚠️ Modern JSP avoids scriptlets—use EL & JSTL instead.

4. Expression Language (EL)
Used to access data simply:
```
${user.name}
${sessionScope.cart}
${param.id}

Benefits:
No Java code in JSP
Clean & readable
Auto null handling
```
| HTML                               | JSP                                                     |
| ---------------------------------- | ------------------------------------------------------- |
| Used to display **static content** | Used to generate **dynamic content**                    |
| Cannot contain Java logic          | Can contain Java code, EL, JSTL                         |
| Browser requests `.html` directly  | `.jsp` is converted into a **Servlet** by the container |
| Same output for every user         | Output can change based on user, data, session          |
| No server-side processing          | Server-side processing supported                        |

### Scope in JSP

| Scope         | Lifetime         |
| ------------- | ---------------- |
| `page`        | Current JSP only |
| `request`     | Single request   |
| `session`     | User session     |
| `application` | Entire app       |

### JSP Error Page Handling

JSP provides a built-in mechanism to handle runtime errors gracefully by redirecting the user to a custom error page instead of showing a server error. <br>

It is done using two attributes of the page directive:
```
errorPage – used in the main JSP
isErrorPage – used in the error JSP
```

### JSTL (JSP Standard Tag Library)

JSTL is a collection of ready-made JSP tags used to perform common tasks like
looping, conditions, formatting, and database operations—without writing Java code in JSP. <br>

It helps keep JSP clean, readable, and MVC-compliant. <br>

To use JSTL in JSP <br>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <br>

Main JSTL Tag Libraries
| Library   | Prefix | Purpose                      |
| --------- | ------ | ---------------------------- |
| Core      | `c`    | Conditions, loops, variables |
| Format    | `fmt`  | Date & number formatting     |
| SQL       | `sql`  | Database operations          |
| XML       | `x`    | XML processing               |
| Functions | `fn`   | String functions             |

<hr>

## Hibernate Framework

Hibernate is a Java ORM (Object–Relational Mapping) framework that maps Java objects to database tables and handles: <br>
- CRUD operations
- SQL generation
- Transaction management
- Caching
- Relationship handling

It removes boilerplate JDBC code and makes applications database-independent. <br>

### Hibernate Architecture
```
Application
    |
SessionFactory
    |
 Session  --->  Persistent Objects (Entities)
    |
Transaction
    |
   JDBC
    |
 Database
```

Core Components 

| Component        | Role                              |
| ---------------- | --------------------------------- |
| `Configuration`  | Loads Hibernate config & mappings |
| `SessionFactory` | Heavy object; creates Sessions    |
| `Session`        | Represents DB connection          |
| `Transaction`    | Manages atomic operations         |
| `Query`          | Executes HQL/Criteria/SQL         |
| `Entity`         | POJO mapped to a table            |

### Lifecycle of Hibernate Entities
A Hibernate entity passes through different states during its life in an application. <br>
These states describe how the object is related to the database and the Hibernate Session. <br>

| State          | Description                               |
| -------------- | ----------------------------------------- |
| **Transient**  | New object, not associated with Hibernate |
| **Persistent** | Associated with a Session                 |
| **Detached**   | Session closed, object still exists       |
| **Removed**    | Marked for deletion                       |

Example:
```
Student s = new Student();      // Transient
session.save(s);               // Persistent
session.close();               // Detached
session.delete(s);             // Removed
```

*1️⃣ Transient State*
Object is created using new <br>
Not associated with Hibernate Session <br>
Not stored in the database
```
Student s = new Student(); // Transient
s.setName("Amit");
```
Characteristics: <br>
No primary key value (or not managed)
Hibernate doesn’t know about it

*2️⃣ Persistent State*
Object is associated with a Hibernate Session <br>
Represented in the database
```
Session session = factory.openSession();
Transaction tx = session.beginTransaction();
session.save(s);  // Becomes Persistent
tx.commit();
```
Characteristics:
- Managed by Hibernate
- Any change is automatically synchronized with DB
- Inside Session cache

*3️⃣ Detached State*
Session is closed, but object still exists <br>
No longer managed by Hibernate
```
session.close();  // s becomes Detached
s.setName("Rahul");  // Change not auto-saved
```
Characteristics: <br>
- Has DB identity (primary key exists) 
- Changes are not reflected unless reattached

To reattach: <br>
session.update(s);   // Detached → Persistent

*4️⃣ Removed (Deleted) State*
Object is marked for deletion
```
session.delete(s);
```
Characteristics:
```
Will be removed from DB on commit
No longer persistent after deletion
```

### Hibernate Mappings & Relationships

| Relationship | Annotation    |
| ------------ | ------------- |
| One-to-One   | `@OneToOne`   |
| One-to-Many  | `@OneToMany`  |
| Many-to-One  | `@ManyToOne`  |
| Many-to-Many | `@ManyToMany` |


### Collection & Component Mapping
Collection Mapping
```
@ElementCollection
private List<String> skills;
```
Component (Embedded Object)
```
@Embeddable
class Address {
    String city;
    String pin;
}

@Embedded
private Address address;
```

### HQL, Named Queries & Criteria

HQL (Hibernate Query Language)
```
Query q = session.createQuery("from Student where age > 18");
List<Student> list = q.list();
```

Named Queries
```
A Named Query is a predefined, reusable query identified by a name.
It is written once (in entity class or XML) and used anywhere in the application.

They improve:
Readability
Reusability
Performance (parsed at startup)
Maintainability

Defining a Named Query (Annotation)
@Entity
@NamedQuery(
    name = "Student.findAll",
    query = "FROM Student"
)
public class Student {
    @Id
    private int id;
    private String name;
}


You can also define multiple queries:

@NamedQueries({
    @NamedQuery(name = "Student.byName",
                query = "FROM Student s WHERE s.name = :name"),
    @NamedQuery(name = "Student.byId",
                query = "FROM Student s WHERE s.id = :id")
})

Using a Named Query:
Query q = session.createNamedQuery("Student.byName");
q.setParameter("name", "Amit");

List<Student> list = q.list();
```
```
Types of Named Queries
1.HQL Named Query
@NamedQuery(name="findAll", query="FROM Student")

2.Native SQL Named Query
@NamedNativeQuery(
    name = "Student.nativeAll",
    query = "SELECT * FROM student",
    resultClass = Student.class
)
```
Criteria Query (Type-safe) – Hibernate / JPA
```
The Criteria API provides a type-safe way to build queries using Java objects instead of writing HQL/SQL strings.
Errors are caught at compile time, not at runtime.

It is mainly used for:
Dynamic queries
Type safety
Complex filtering
```

<hr>

## 🌱 Spring Framework

🔹 What is Spring Framework?
Spring is a lightweight, open-source Java framework used to build enterprise applications. <br>
It provides: <br>
- Loose coupling
- Easy configuration
- Built-in support for MVC, Security, ORM, Transactions, etc.
- Faster development with less boilerplate code
- Core idea: Dependency Injection + Inversion of Control <br>

Flow
```
Client → DispatcherServlet → Controller → Model → ViewResolver → View
```

### 🔹 Spring Modules Overview
| Module  | Purpose                     |
| ------- | --------------------------- |
| Core    | IoC, DI                     |
| Beans   | Bean management             |
| Context | Application context         |
| AOP     | Aspect-Oriented Programming |
| JDBC    | DB access                   |
| ORM     | Hibernate/JPA               |
| Web     | Web support                 |
| Web MVC | Spring MVC                  |
| Test    | Testing support             |

### 🔹 Spring 4 Annotations (Basic)
```
@Component – Generic bean
@Service – Business layer
@Repository – DAO layer
@Controller – MVC controller
@Autowired – Inject dependency
@Configuration – Config class
@Bean – Define bean
@RequestMapping – URL mapping
```

### IoC (Inversion of Control)

IoC means the control of creating and managing objects is transferred from the programmer to a container/framework (like Spring). <br>
Instead of you creating objects, the container creates and provides them. <br>
```
Using Spring

@Component
class Car {
    public void drive() {
        System.out.println("Car is running");
    }
}


Spring creates the object internally using new.
You receive it like this:

@Component
class Showroom {

    @Autowired
    private Car car;

    public void test() {
        car.drive();
    }
}

Here:
You never wrote new Car()
Spring did: new Car() internally
Spring injected that object into Showroom
```

### DI (Dependency Injection)

Dependency Injection is a technique used in IoC where the container injects the required object (dependency) into another object instead of that object creating it. <br>

In simple words: An object gets its required objects from outside. <br>

### 🔹 Spring Beans
- A Bean is an object managed by Spring.
```
How to Create a Spring Bean
Using Annotations (Most common)
@Component
public class Car {
    public void drive() {
        System.out.println("Car running...");
    }
}

Other stereotype annotations:
@Service – Service layer
@Repository – DAO layer
@Controller / @RestController – Web layer

Spring automatically scans and creates these as beans.
```

### Autowiring Beans in Spring
Autowiring means Spring automatically injects one bean into another bean without you manually writing configuration.<br>
It is part of Dependency Injection (DI). <br>
```
Example
@Component
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

@Component
class Car {

    @Autowired
    private Engine engine;   // Automatically injected

    public void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}
Here:
Spring creates Engine and Car
Spring finds that Car needs Engine
Spring injects the Engine object into Car
You never write new Engine().
```

### 🔹 Bean Scopes
| Scope               | Meaning                  |
| ------------------- | ------------------------ |
| singleton (default) | One object per container |
| prototype           | New object every time    |
| request             | Per HTTP request         |
| session             | Per session              |
| application         | Per app                  |


### Thymeleaf

- Thymeleaf is a modern server-side Java template engine used with Spring / Spring Boot to create dynamic web pages.
- It replaces JSP in Spring Boot applications and follows MVC architecture:
```
Controller → sends data
Thymeleaf View → displays data
Model → carries data
```
Why Thymeleaf?
```
Natural templates (works as normal HTML in browser)
No JSP configuration in Spring Boot
Clean syntax
Tight integration with Spring
Supports HTML5
```

### 🌍 Spring i18n & Localization
- i18n (Internationalization) in Spring allows your application to support multiple languages based on user locale (country/language).
Localization means showing content in the user’s preferred language.
- Spring uses message properties files to store translations.

🔹 File Upload Example
```
<form method="post" enctype="multipart/form-data">
  <input type="file" name="file"/>
</form>

Controller:
@PostMapping("/upload")
public String upload(@RequestParam MultipartFile file) {
    file.transferTo(new File("D:/"+file.getOriginalFilename()));
    return "success";
}
```

<hr>

## 🚀 Spring Boot Essentials
