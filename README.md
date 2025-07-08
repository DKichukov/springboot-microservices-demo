# Spring Boot Microservices Demo

This repository demonstrates a microservices architecture using Spring Boot, Spring Cloud, Eureka Service Registry, and an API Gateway. The system is composed of three main services: Department Service, Employee Service, and an API Gateway, all registered with a Service Registry (Eureka).

## Table of Contents

- [Architecture](#architecture)
- [Services](#services)
- [Tech Stack](#tech-stack)
- [API Endpoints](#api-endpoints)

---

## Architecture

- **API Gateway**: Entry point for all client requests, routes to appropriate services.
- **Service Registry (Eureka)**: Registers all services for discovery.
- **Employee Service**: Manages employee data.
- **Department Service**: Manages department data.

---

## Services

- **api-gateway**: Handles routing and load balancing.
- **service-registry**: Eureka server for service discovery.
- **department-service**: CRUD operations for departments.
- **employee-service**: CRUD operations for employees, fetches department info.

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Cloud (Eureka, Gateway)
- Spring Data JPA
- Mysql
- Maven

---

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Docker (optional, for containerization)

### Running the Services

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/springboot-microservices-demo.git
   cd springboot-microservices-demo
   ```

2. **Start the Service Registry:**
   ```sh
   cd service-registry
   ./mvnw spring-boot:run
   ```

3. **Start the Department Service:**
   ```sh
   cd ../department-service
   ./mvnw spring-boot:run
   ```

4. **Start the Employee Service:**
   ```sh
   cd ../employee-service
   ./mvnw spring-boot:run
   ```

5. **Start the API Gateway:**
   ```sh
   cd ../api-gateway
   ./mvnw spring-boot:run
   ```

6. **Access Eureka Dashboard:**  
   Visit [http://localhost:8761](http://localhost:8761) to see registered services.

---

## API Endpoints

### Department Service

- `POST /api/departments/save`  
  Create a new department.

- `GET /api/departments/findbyid/{deptId}`  
  Get department details by ID.

### Employee Service

- `POST /api/employees/save`  
  Create a new employee.

- `GET /api/employees/findbyid/{empId}`  
  Get employee details by ID.

### API Gateway

- All requests are routed via the gateway (e.g., `/employee-service/api/employees/...`).

---
