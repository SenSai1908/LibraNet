# LibraNet: Online Library Management System

A robust, extensible, and well-structured Java application that models the backend for an online library platform. This project demonstrates core Object-Oriented Programming (OOP) principles and a clean, service-oriented architecture.

---

## 🚀 Key Features

* **Object-Oriented by Design:** Uses abstraction, inheritance, and polymorphism to manage different library item types (`Book`, `Audiobook`, `EMagazine`).
* **Clean Architecture:** Implements a **Service Layer** (`LibraryService`) to separate business logic (borrowing, fines) from the data models, making the code cleaner and more maintainable.
* **Extensible:** The structure makes it easy to add new item types (e.g., `DVD`, `Newspaper`) with minimal changes to existing code.
* **Robust Data Handling:** Includes error handling for parsing data, such as audiobook durations.
* **Specialized Behaviors:** Utilizes interfaces (`Playable`) to assign unique capabilities to specific item types.

---

## 📂 Project Structure

The project is organized into a single package, `activity2`, which contains all the necessary classes.
LibraNet/
└── activity2/
├── LibraryItem.java     // Abstract base class for all items
├── Book.java            // Concrete class for books
├── Audiobook.java       // Concrete class for audiobooks
├── EMagazine.java       // Concrete class for e-magazines
├── Playable.java        // Interface for items that can be played
├── Library.java         // Manages the collection of all items
├── LibraryService.java  // Handles all business logic (borrowing, returning, fines)
└── Main.java            // The entry point for the application


---

## ⚙️ Getting Started

### Prerequisites

You need to have a Java Development Kit (JDK) installed on your system (e.g., OpenJDK 11 or later).

### Compilation & Execution

1.  **Clone the repository:**

    ```sh
    git clone [https://github.com/your-username/LibraNet.git](https://github.com/your-username/LibraNet.git)
    cd LibraNet
    ```

2.  **Compile the code:**
    From the root `LibraNet` directory, run the following command. This compiles all `.java` files within the `activity2` package.

    * On macOS/Linux:
        ```sh
        javac activity2/*.java
        ```
    * On Windows:
        ```sh
        javac activity2\*.java
        ```

3.  **Run the application:**
    Execute the program by calling the fully qualified name of the main class.

    ```sh
    java activity2.Main
    ```

You will see the output in your terminal demonstrating the library's functionality.

---

## ✨ Core Concepts Illustrated

### 1. Class Diagram

*(Include your Class Diagram image here, e.g., using `![Class Diagram](docs/class-diagram.png)`)*

### 2. User Workflow

*(Include your User Workflow image here, e.g., using `![User Workflow](docs/user-workflow.png)`)*

### 3. Separation of Concerns

The design intentionally separates responsibilities:

* **Data Models** (`LibraryItem`, `Book`, etc.): Simple POJOs that hold data and state.
* **Service Layer** (`LibraryService`): A stateless class that contains all the business logic. It operates *on* the data models.
* **Repository** (`Library`): Manages the in-memory collection of library items.
* **Application/UI Layer** (`Main`): Simulates user interaction and orchestrates calls to the service layer.

---
