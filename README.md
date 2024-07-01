# CabConnect

CabConnect is a Spring Boot backend system designed for a cab booking service. 
This application provides various features, including user and driver registration, ride booking, real-time email notifications, and coupon application.

## Features

**1) User and Driver Registration:** Users and drivers can create and manage their accounts.

**2) Booking Functionality:** Users can book cabs by locating nearby available (unbooked) drivers. 
If a driver is available, the ride is assigned randomly. The SMTP protocol sends A real-time email notification to users with fare and driver details.

**3) Coupon Application:** Users can apply optional coupon codes to adjust the trip's price.

**4) Ride Tracking:** The system can track the number of rides a driver has completed in a day. If a driver has fewer than three rides, an email notification is sent to the driver.

## Technology Stack

- **Java**
  
- **Spring Boot**
- **SQL**
- **JPA & Hibernate**
- **REST API**
- **SMTP**
- **Swagger**
- **Postman**

## Database Schema

- The SQL database schema stores user, driver, and booking information.

## API Documentation

- Swagger is used for API testing and documentation, ensuring the system's reliability and maintainability.

## Usage

- Register as a user or driver.
  
- Book a ride by searching for nearby available drivers.
  
- Apply a coupon code if available.
  
- Receive real-time email notifications for successful bookings.
  
- Monitor the number of rides completed by each driver.

  
CabConnect aims to provide a seamless and efficient cab booking experience with enhanced communication through real-time notifications.
