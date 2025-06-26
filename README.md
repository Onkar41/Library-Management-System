# 📚 Library Management System (Java + Hibernate)

## 🧠 Introduction

The **Library Management System** is a simple command-line Java application built using **Hibernate ORM**. It is designed to help users interact with a library database to perform common operations like viewing available books, borrowing books, and returning them.
This version focuses **only on the User Module**, excluding admin functionality.

---

## 🎯 Features

* 📖 **View Available Books**
* 🆕 **Borrow a Book**
* 🔁 **Return a Book**
* 🔍 **Search Book by Title or Author**
* 👤 **User Registration/Login (optional)**

---

## 🧰 Technology Stack

| Category      | Technology                   |
| ------------- | ---------------------------- |
| Language      | Java                         |
| ORM Framework | Hibernate                    |
| Database      | MySQL / H2 (based on setup)  |
| Build Tool    | Maven (recommended)          |
| IDE           | IntelliJ IDEA / Eclipse      |
| UI            | Command Line Interface (CLI) |

---

## 🛠️ System Requirements

### 💻 Software

* Java JDK 11 or above
* Maven or any Java build tool
* MySQL database (or use H2 for local testing)
* IDE: IntelliJ IDEA / Eclipse / VS Code

---

## 🧪 Sample Commands (within CLI)

* `1` → View all books
* `2` → Search for a book
* `3` → Borrow a book
* `4` → Return a book
* `5` → Exit

---

## 📌 Limitations

* No Admin or Librarian module
* Command-line interface only (no GUI)
* Basic validation only

---

## 🔮 Future Enhancements

* 🛡️ Admin module (Add/Delete books, track returns)
* 🖥️ GUI interface using JavaFX or Spring Boot
* 📅 Due date alerts via email/SMS
* 📊 Reporting system (borrowed books, top users)

