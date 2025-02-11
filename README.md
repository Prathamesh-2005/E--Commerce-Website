# E-Commerce Website

## Overview
This is a simple e-commerce website built using **Spring Boot, React, JPA, and MySQL**. The project provides basic e-commerce functionalities.

## Features
- Browse products
- Add products to cart
- View product details
- Manage inventory (Admin)
- Responsive UI with React

## Tech Stack
- **Frontend**: React.js
- **Backend**: Spring Boot
- **Database**: MySQL
- **ORM**: JPA (Java Persistence API)

## Installation & Setup
### Prerequisites
- Java 17+
- Node.js & npm
- MySQL Server

### Backend Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/Prathamesh-2005/E--Commerce-Website.git
   ```
2. Navigate to the backend directory:
   ```sh
   cd backend
   ```
3. Configure database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```
4. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to the frontend directory:
   ```sh
   cd frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the React app:
   ```sh
   npm start
   ```

## Usage
- Open `http://localhost:3000` in your browser.
- Browse products, add to cart, and explore functionalities.


## Contact
For any queries, reach out to [Prathamesh Jadhav](https://github.com/Prathamesh-2005).

