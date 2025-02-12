# Market CRUD API

This project provides a backend API for managing a marketplace, allowing users to perform CRUD (Create, Read, Update, Delete) operations on items. The API is built using Java, adhering to a service-repository-controller architecture, with SQL as the database.

- **Add Items:** Allows users to add new items to the marketplace, including attributes such as name and quantity.
- **Read Items:** Users can fetch a list of all items or retrieve a specific item by its unique ID.
- **Update Items:** Supports updating existing items with new data like changes to name or quantity.
- **Delete Items:** Provides functionality to delete items from the marketplace, including the ability to remove all items at once.

## Technologies
The following tools and frameworks were used in the construction of the project:<br>
<p> 
    <img style='margin: 5px;' src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" height="40" alt="Java logo" /> 
    <img style='margin: 5px;' src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" height="40" alt="Spring Boot logo" /> 
    <img style='margin: 5px;' src="https://img.shields.io/badge/SQL-003B57?style=for-the-badge&logo=postgresql&logoColor=white" height="40" alt="SQL logo" /> 
</p>

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/truds99/market-backend-java
cd api
```

### 2. Install Project Dependencies

Make sure you have Java and Maven installed. Install any necessary dependencies using:

```bash
mvn install
```

### 3. Running the Application

To run the API locally, use the following command:

```bash
mvn spring-boot:run
```

## Contributing

- Fork the repository.
- Create a new branch (git checkout -b feature-branch).
- Make your changes and commit them (git commit -am 'Add new feature').
- Push to the branch (git push origin feature-branch).
- Create a pull request.
