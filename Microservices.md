# Microserives

## 1️⃣ Introduction to Microservices
- Microservices is an architectural style where an application is built as a collection of small, independent services. <br>
Each service:
- Performs a single business function
- Runs independently
- Communicates via REST / HTTP / Messaging
- Can be developed, deployed, and scaled separately <br>

Example:
```
In an E-commerce system:
User Service
Product Service
Order Service
Payment Service
```

How do Microservices work? <br>
- Each microservice handles a particular business feature, like user authentication or product management, allowing for specialized development.
- Services interact via APIs, facilitating standardized information exchange and integration.
- Different technologies can be used for each service, enabling teams to select the best tools for their needs.
- Microservices can be updated independently, reducing risks during changes and enhancing system resilience.

<img width="801" height="401" alt="image" src="https://github.com/user-attachments/assets/b10c4993-ae08-42ed-8676-5d5d031dc0b1" />

<hr>

## Microservices Architecture 

### *Main components of Microservices Architecture*

1. Microservices: Small, loosely coupled services that handle specific business functions, <br>
each focusing on a distinct capability.
2. API Gateway: Acts as a central entry point for external clients also they manage requests, <br>
authentication and route the requests to the appropriate microservice.
3. Service Registry and Discovery: Keeps track of the locations and addresses of all microservices, <br>
enabling them to locate and communicate with each other dynamically.
4. Load Balancer: Distributes incoming traffic across multiple service instances and <br>
prevent any of the microservice from being overwhelmed.
5. Containerization: Docker encapsulate microservices and their dependencies and <br>
orchestration tools like Kubernetes manage their deployment and scaling.
6. Event Bus/Message Broker: Facilitates communication between microservices, <br>
allowing pub/sub asynchronous interaction of events between components/microservices.
7. Database per Microservice: Each microservice usually has its own database, promoting data autonomy <br>
and allowing for independent management and scaling.
8. Caching: Cache stores frequently accessed data close to the microservice which <br>
improved performance by reducing the repetitive queries.
9. Fault Tolerance and Resilience Components: Components like circuit breakers and <br>
retry mechanisms ensure that the system can handle failures gracefully, maintaining overall functionality.

### *Design Patterns for Microservices Architecture*

- Below are the main design pattern of microservices:

1. API Gateway Pattern
- API Gateway pattern simplifies the client’s experience by hiding the complexities of multiple services behind one interface. <br>
  It can also handle tasks like authentication, logging, and rate limiting, making it a crucial part of microservices architecture.

2. Service Registry Pattern
- Service Registery pattern is like a phone book for microservices.<br>
It maintains a list of all active services and their locations (network addresses). <br>
When a service starts, it registers itself with the registry.
- Other services can then look up the registry to find and communicate with it. <br>
This dynamic discovery enables flexibility and helps services interact without hardcoding their locations.

3. Circuit Breaker Pattern
- In circuit breaker pattern If a service fails repeatedly, the circuit breaker trips, preventing further requests to that service. <br>
After a timeout period, it allows limited requests to test if the service is back online. <br>
This reduces the load on failing services and enhances system resilience.

4. Saga Pattern
- Saga pattern is useful for managing complex business processes that span multiple services. <br>
Instead of treating the process as a single transaction, the saga breaks it down into smaller steps, each handled by different services.
- If one step fails, compensating actions are taken to reverse the previous steps. <br>
This way, you maintain data consistency across the system, even in the face of failures.

5. Event Sourcing Pattern
- In Event Sourcing Pattern, Each event describes a change that occurred,<br>
allowing services to reconstruct the current state by replaying the event history.<br>
This provides a clear audit trail and simplifies data recovery in case of errors.

6. Strangler Pattern
- Strangler pattern allows for a gradual transition from a monolithic application to microservices. <br>
New features are developed as microservices while the old system remains in use.
- Over time, as more functionality is moved to microservices, <br>
the old system is gradually "strangled" until it can be fully retired. <br>
This approach minimizes risk and allows for a smoother migration.

7. Bulkhead Pattern
- Similar to compartments in a ship, the bulkhead pattern isolates different services to prevent <br>
failures from affecting the entire system.
- If one service encounters an issue, it won’t compromise others. By creating boundaries,<br>
this pattern enhances the resilience of the system, ensuring that a failure in one area doesn’t lead to a total system breakdown.

8. API Composition Pattern
- When you need to gather data from multiple microservices, the API composition pattern helps you do so efficiently.
- A separate service (the composition service) collects responses from various services and <br>
combines them into a single response for the client. <br>
This reduces the need for clients to make multiple requests and simplifies their interaction with the system.

9. CQRS Design Pattern
CQRS Design Pattern divides the way data is handled into two parts: commands and queries. <br>
Commands are used to change data, like creating or updating records, while queries are used just to fetch data.<br>
This separation allows you to tailor each part for its specific purpose.

<hr>

## *Fragmentation of business requirement*

- Fragmentation of Business Requirement means breaking a large, complex business requirement into smaller, independent functional parts based on business capabilities.

- This concept is mainly used in Microservices Architecture.

- Instead of building one big application (monolith), we divide the business into small services, where each service handles one specific responsibility. <br>

Example: E-Commerce Application
```
Single business requirement: “Build an online shopping system”

Fragmented into:
| Microservice     | Responsibility               |
| ---------------- | ---------------------------- |
| User Service     | Registration, login, profile |
| Product Service  | Product catalog, search      |
| Cart Service     | Add/remove items             |
| Order Service    | Place and track orders       |
| Payment Service  | Payment processing           |
| Delivery Service | Shipping & tracking          |

Each service:
Has its own logic
Can be developed independently
Can be deployed separately
Can use its own database

Benefits:
Faster development
Easy maintenance
Independent scaling
Fault isolation
Better team ownership
```
- Fragmentation of business requirement = Dividing a big business problem into small, manageable, independent services based on business functionality.

<hr>

## *Deployment Pattern*

- A Deployment Pattern defines how applications or services are packaged, deployed, and run in an environment.
- In Microservices, deployment patterns decide how each service is released and managed. <br>

Common Microservices Deployment Patterns:

| Pattern                        | Description                                     | Example                           |
| ------------------------------ | ----------------------------------------------- | --------------------------------- |
| **Single Service per Host**    | One microservice runs on one VM/host            | One VM = Order Service            |
| **Multiple Services per Host** | Many services share one host                    | User + Cart on same VM            |
| **Container per Service**      | Each service runs in its own container          | Docker container for each service |
| **Serverless Deployment**      | Services run as functions                       | AWS Lambda for Payment            |
| **Blue-Green Deployment**      | Two environments (Blue & Green); switch traffic | Zero-downtime updates             |
| **Canary Deployment**          | New version released to small users first       | 10% users get new version         |
| **Rolling Deployment**         | Update services one by one                      | Gradual update in Kubernetes      |

## *API Gateway*
- An API Gateway is a single entry point for all client requests in a Microservices architecture.
- Instead of the client calling multiple microservices directly, it calls the API Gateway, and the gateway routes the request to the correct service.

<img width="1000" height="503" alt="image" src="https://github.com/user-attachments/assets/afe1d1f9-7043-4cfe-823a-f5b87aa90b52" />

- Responsibilities of API Gateway
```
Request routing
Authentication & Authorization
Load balancing
Rate limiting
Logging & monitoring
Response aggregation (combine multiple service responses)
```

- Example
```
Example
Client wants order details:

Without API Gateway:
Client calls User Service
Client calls Order Service
Client calls Payment Service

With API Gateway:
Client sends one request to API Gateway
Gateway forwards to required services
Gateway returns a single response

Benefits
Simplifies client-side logic
Improves security (services are hidden)
Centralized controd
Easier versioning and monitoring
```
- So, API Gateway = A central access point that manages, secures, and routes requests from clients to microservices.

<hr>
## *Service Discovery
- Service Discovery is a mechanism that helps microservices find and communicate with each other automatically without hard-coding IP addresses or ports.

- In Microservices, services are:
 ```
Deployed dynamically
Scaled up/down
Moved across servers
```
- Types of Service Discovery
| Type                      | Description                                                                   |
| ------------------------- | ----------------------------------------------------------------------------- |
| **Client-Side Discovery** | Client asks registry and chooses service instance (e.g., Eureka + Ribbon)     |
| **Server-Side Discovery** | Load balancer queries registry and routes request (e.g., Kubernetes, AWS ELB) |

Example
```
Order Service needs Payment Service:
Order Service → asks Registry: “Where is Payment Service?”
Registry → returns IP & port
Order Service → calls Payment Service
- So their IP/port keeps changing. Service Discovery solves this problem.
```

<hr>

##  *Database Management for Microservices*

- Each microservice must own its own database.
- This is called Database per Service pattern.
- In microservices, sharing a single database creates tight coupling.
- So, every service manages its own data and schema.

Key Rules
```
No other service can directly access another service’s database
Data is shared only through APIs or events
Each service can use a different DB type (SQL, NoSQL, etc.)
```
Benefits
```
Loose coupling
Independent scaling
Independent deployment
Technology freedom
Better fault isolation
```
Challenges
```
No cross-service joins
Data consistency becomes complex
Requires patterns like:
    Saga Pattern
    Event-driven communication
    Eventual consistency
```
