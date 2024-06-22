# Hotel Review System Microservice
Welcome to the Microservice Application! This project demonstrates a microservice architecture using five distinct services, all orchestrated through a central API Gateway. The services are registered dynamically using Netflix Eureka, ensuring seamless communication and scalability.

## Overview

This microservice application is designed to demonstrate how various services can interact with each other through a centralized **API Gateway**. Each service operates independently, allowing for isolated development and deployment. The services are:

1. **Service Registry** - Registers all the services using **Netflix Eureka**.
2. **API Gateway** - Centralized entry point for all requests, routing them to the appropriate service.
3. **User Service** - Manages CRUD operations for users.
4. **Hotel Service** - Manages CRUD operations for hotels.
5. **Rating Service** - Manages CRUD operations for ratings.

With this setup, users can perform CRUD operations across all services via a single **API Gateway**, eliminating the need to interact with each service individually.

## Services

### **Service Registry**

- **Role**: Registers and keeps track of all services.
- **Technology**: **Netflix Eureka**

### **API Gateway**

- **Role**: Centralized routing for all service requests.
- **Technology**: **Spring Cloud Gateway**

### **User Service**

- **Role**: Handles CRUD operations for user data.
- **Endpoints**:
  - `**GET micro/users**`
  - `**POST micro/users**`
  - `**PUT micro/users/{id}**`
  - `**DELETE micro/users/{id}**`

### **Hotel Service**

- **Role**: Manages CRUD operations for hotel data.
- **Endpoints**:
  - `**GET micro/hotels**`
  - `**POST micro/hotels**`
  - `**PUT micro/hotels/{id}**`
  - `**DELETE micro/hotels/{id}**`

### **Rating Service**

- **Role**: Manages CRUD operations for rating data.
- **Endpoints**:
  - `**GET micro/ratings**`
  - `**POST micro/ratings**`
  - `**PUT micro/ratings/{id}**`
  - `**DELETE micro/ratings/{id}**`

## Getting Started

### Prerequisites

- **JDK 17** or higher
- **Maven**
- **MySQL**
- **PostgreSQL**
- **MongoDB**

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/microservice-application.git
    cd microservice-application
    ```

2. **Start the Service Registry**:
    ```bash
    cd serviceRegistry
    mvn spring-boot:run
    ```

3. **Start the API Gateway**:
    ```bash
    cd APIGateway
    mvn spring-boot:run
    ```

4. **Start the User Service**:
    ```bash
    cd userService
    mvn spring-boot:run
    ```

5. **Start the Hotel Service**:
    ```bash
    cd HotelService
    mvn spring-boot:run
    ```

6. **Start the Rating Service**:
    ```bash
    cd RatingService
    mvn spring-boot:run
    ```

Each service will register itself with the **Service Registry** and be accessible through the **API Gateway** and also can access them individually.

## Accessing the Services
Once all services are up and running, you can interact with the application through the API Gateway:

- API Gateway URL: `http://localhost:9001`

You can use tools like Postman or curl to make requests to the API Gateway, which will then route them to the appropriate service.

## Examples

### User Service

- **Create User**:
    ```sh
    POST /micro/users/
    {
        "name": "Prabhu",
        "email": "prabhu@mail.com",
        "phone": "8849337894"
    }
    ```

- **Get User**:
    ```sh
    GET /micro/users/{userId}/
    ```
    
- **Get All Users**:
    ```sh
    GET /micro/users/
    ```

### Hotel Service

- **Create Hotel**:
    ```sh
    POST /micro/hotels/
    {
        "name": "Prabhu Hotel Services",
        "location": "Mumbai, Maharashtra",
        "about": "good hotel"
    }
    ```

- **Get Hotel**:
    ```sh
    GET /micro/hotels/{hotelId}/
    ```

- **Get All Hotels**:
    ```sh
    GET /micro/hotels/
    ```

### Rating Service

- **Create Rating**:
    ```sh
    POST /micro/ratings
    {
        "userId": "2b4755e0-be7a-4817-a33a-b5e53d76b40d",
        "hotelId": "62b499f4-d588-4717-82ac-3a6ea38b0b6a",
        "rating": 4,
        "feedback": "good hotel, service is good at a decent price."
    }
    ```

- **Get All Ratings**:
    ```sh
    GET /micro/ratings/
    ```

- **Get Ratings of User**:
    ```sh
    GET micro/ratings/users/{userId}/
    ```

- **Get Ratings of Hotel**:
    ```sh
    GET micro/ratings/hotels/{hotelId}/
    ```

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

## Authors

- [Gaurav Ganguly](https://github.com/Gaurav000001)

## Contact Me

[![portfolio](https://img.shields.io/badge/my_portfolio-A020F0?style=for-the-badge&logo=ko-fi&logoColor=white)](https://Gaurav000001.github.io/)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gaurav-ganguly-bb7ba9246/)
