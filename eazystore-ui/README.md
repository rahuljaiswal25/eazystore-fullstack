# EazyStore — Full-Stack E-Commerce Application

EazyStore is a full-stack e-commerce web application with a React frontend and a Spring Boot REST API. It includes product browsing, a shopping cart, customer accounts, checkout, order management, contact messages, and administrator tools.

## Features

### Customer

- Browse products and view product details.
- Add products to the cart and manage quantities.
- Register, log in, and log out.
- View and update profile information and address details.
- Complete checkout and view order confirmation.
- View order history.
- Submit contact messages.
- Toggle light/dark theme.
- Show or hide the password on the login form.

### Administrator

- View and manage orders.
- Confirm or cancel orders.
- View contact messages and close them.
- Access administrator pages through protected routes.

### Application

- REST API integration between React and Spring Boot.
- JWT-based authentication and role-based authorization.
- MySQL persistence using Spring Data JPA / Hibernate.
- Form validation and toast notifications.
- Stripe integration for the checkout flow.

## Technology Stack

**Frontend**

- React, Vite, React Router
- Tailwind CSS
- Redux Toolkit / React Redux
- Axios
- React Toastify
- React Icons and Font Awesome
- Stripe.js / React Stripe.js

**Backend**

- Java, Spring Boot
- Spring Web MVC / REST controllers
- Spring Data JPA / Hibernate
- Spring Security and JWT (`jjwt`)
- Jakarta Bean Validation
- Lombok
- MySQL Connector/J
- Springdoc OpenAPI / Swagger UI
- Stripe Java SDK

**Tools**

- Maven, npm, IntelliJ IDEA
- Docker (if using a MySQL container)

## Project Structure

The project has separate frontend and backend applications.

```text
eazystore/
├── backend (Spring Boot Maven project)
│   ├── pom.xml
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── <com.ecom.eazystore>/
│       │   │       ├── config
│       │   │       ├── constants
│       │   │       ├── controller/\
│       │   │       ├── dto
│       │   │       ├── entity/
│       │   │       ├── exception
│       │   │       ├── filter
│       │   │       ├── repository/
│       │   │       ├── scopes
│       │   │       ├── security
│       │   │       ├── service/
│       │   │       └── util
│       │   └── resources/
│       │       └── application.properties
│       └── test/
└── eazystore-ui/
    ├── package.json
    └── src/
        ├── api/apiClient.js
        ├── components/
        │   ├── admin/
        │   ├── footer/
        │   └── ...
        ├── store/
        ├── App.jsx
        ├── index.css
        └── main.jsx
```

> This is a conceptual overview, not an exact listing of every file. Keep your actual folder names and Java package name.

## Prerequisites

- Java version supported by the project's `pom.xml` (the recent local run configuration used a Java 25 JDK; confirm the compiler version).
- Maven, or the Maven wrapper if included.
- Node.js and npm.
- MySQL locally or in Docker.
- Stripe test credentials for testing checkout.

## Getting Started

### 1. Backend Setup

Open a terminal in the backend directory containing `pom.xml`.

Configure `src/main/resources/application.properties` (or your active configuration file) with your database details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
spring.datasource.username=<database_username>
spring.datasource.password=<database_password>
```

Replace the placeholders with your local values. Do not commit real database passwords. Use the schema-management setting appropriate for your environment; avoid destructive schema settings for databases containing important data.

Build the backend:

```bash
mvn clean compile
```

Run it from IntelliJ using the main Spring Boot application class, or run:

```bash
mvn spring-boot:run
```

Check the configured server port. Spring Boot commonly uses `8080`, but your configuration may differ.

### 2. Frontend Setup

Open a terminal in the `eazystore-ui` directory:

```bash
npm install
npm run dev
```

Open the local URL printed by Vite (commonly `http://localhost:5173`).

Create a production build:

```bash
npm run build
```

Optionally preview the production build:

```bash
npm run preview
```

## Configuration

### API base URL

The frontend uses `src/api/apiClient.js` for API requests. Confirm that its base URL points to the backend host and port you are running.

Example only:

```javascript
baseURL: "http://localhost:8080/api/v1";
```

Use the actual API prefix configured in your project; do not copy this example blindly.

### Stripe

The frontend uses `@stripe/stripe-js` and `@stripe/react-stripe-js`, and the backend includes the Stripe Java SDK.

- Use Stripe test-mode credentials during development.
- Keep secret keys on the backend in environment variables or local configuration.
- Do not commit secret keys to source control.
- Verify the frontend publishable key and backend secret key belong to the same Stripe account and mode.

### JWT and roles

The backend uses Spring Security and JWT. Roles referenced during development include `ROLE_USER` and `ROLE_ADMIN`. Protected API requests must use the authentication mechanism expected by the backend. Keep authorization checks on the backend even when frontend routes are protected.

## Main Frontend Routes

| Route                  | Purpose                                  |
| ---------------------- | ---------------------------------------- |
| `/`                    | Home / product listing                   |
| `/home`                | Home / product listing                   |
| `/products/:productId` | Product details                          |
| `/about`               | About page                               |
| `/contact`             | Contact form                             |
| `/login`               | Login                                    |
| `/register`            | Registration                             |
| `/cart`                | Shopping cart                            |
| `/checkout`            | Checkout (protected)                     |
| `/order-success`       | Order success page (protected)           |
| `/profile`             | Customer profile (protected)             |
| `/orders`              | Customer order history (protected)       |
| `/admin/orders`        | Administrator order management           |
| `/admin/messages`      | Administrator contact-message management |

Backend endpoint paths referenced by the frontend include `/auth/login`, `/products`, `/profile`, `/orders`, `/contacts`, `/admin/orders`, and `/admin/messages`. Full URLs depend on the API base URL configuration.

## Authentication and Authorization

- Login submits credentials to the backend and stores the returned JWT/user data through the Redux authentication flow.
- Authenticated requests use the shared Axios client.
- Customer pages are protected by a React Router `ProtectedRoute`.
- Administrator endpoints should enforce administrator permissions on the backend.
- Frontend route protection does not replace backend authorization.

## Run the Application

1. Start MySQL and confirm the configured database is available.
2. Start the Spring Boot backend.
3. Start the Vite frontend.
4. Open the Vite URL in your browser.
5. Register or log in with an account assigned the appropriate role.
6. Test customer workflows, then administrator workflows with an administrator account.
7. Use Stripe test mode for payment testing.

## Future Improvements

Depending on what is already implemented, possible next steps include:

- Add automated unit and integration tests.
- Add pagination, sorting, and filtering to product and order listings.
- Replace placeholder dashboard figures with real backend analytics if a dashboard is included.
- Improve responsive layout and accessibility.
- Add deployment instructions and CI checks.
- Document the final environment variables and API endpoints.

## License

This project is licensed under the MIT License.
