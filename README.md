# Real-Time Chat Application

## Overview
This project is a **Real-Time Chat Application** built using **Spring Boot** for the backend and **React.js** for the frontend. It enables seamless real-time messaging using **WebSocket, STOMP, and SockJS** while ensuring secure and efficient data handling with **MongoDB** and **JWT-based authentication**.

## Features
- **Real-Time Messaging:** Uses WebSocket and STOMP for instant communication.
- **Multiple Chat Rooms:** Supports 50+ simultaneous chat rooms.
- **User Authentication & Authorization:** Secure JWT-based authentication.
- **Scalable Message Storage:** Utilizes MongoDB for efficient data management.
- **RESTful APIs:** API endpoints for user and chat management.
- **Encryption & Security:** Ensures secure message exchange and authorization.
- **Responsive UI:** Built with React.js for an enhanced user experience.

## Technology Stack
### Backend:
- **Spring Boot** (Microservices architecture)
- **Spring JPA** (Data persistence)
- **MongoDB** (NoSQL database for message storage)
- **Maven** (Build automation & dependency management)
- **Lombok** (Reducing boilerplate code)
- **Spring Security & JWT** (Authentication & Authorization)
- **WebSocket, STOMP, SockJS** (Real-time messaging)
- **Postman** (API testing & documentation)

### Frontend:
- **React.js** (Frontend development)
- **Redux** (State management)
- **Axios** (API requests handling)
- **Material UI & Bootstrap** (UI components)

## Installation & Setup
### Prerequisites:
- Java 11+
- Node.js & npm
- MongoDB
- Maven

### Backend Setup:
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/chat-application.git
   cd chat-application/backend
   ```
2. Configure MongoDB database in `application.properties`.
3. Install dependencies & build the project:
   ```sh
   mvn clean install
   ```
4. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```

### Frontend Setup:
1. Navigate to the frontend directory:
   ```sh
   cd ../frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the React development server:
   ```sh
   npm run dev
   ```
4. Open `http://localhost:3000` to access the frontend.

## API Documentation
Use **Postman** to test API endpoints. API documentation is available at `/swagger-ui` when the backend is running.

## Contribution
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -m "Added new feature"`).
4. Push the branch (`git push origin feature-name`).
5. Open a pull request.
