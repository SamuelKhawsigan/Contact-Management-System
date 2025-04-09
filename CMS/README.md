# 📗 Java Contact Management System

A simple yet functional **console-based Contact Manager** built in Java. This application allows you to manage contacts with features like add, edit, delete, and search, all while ensuring data is stored persistently between sessions using Java Serialization.

---

## 🚀 Features

- ✅ Add, view, edit, and delete contacts
- 🔍 Search contacts by name
- 🛡️ Input validation for phone numbers and email addresses
- 📀 Persistent data storage using Java serialization
- 💡 Simple and clean console-based UI

---

## 🛠️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/SamuelKhawsigan/Contact-Management-System.git
cd JavaContactManager
```

### 2. Compile the Source Code

```bash
javac *.java
```

### 3. Run the Application

```bash
java ContactManager
```

---

## 🧠 Technical Overview

- **Language:** Java
- **Data Persistence:** Object serialization (`.ser` files)
- **Validation:** Basic regex and manual input checks for contact fields
- **Modularity:** Split across classes for contacts, storage, UI, and logic

---

## 📁 Project Structure

```
JavaContactManager/
├── ContactManager.java      # Main class
├── Contact.java             # Contact object model
├── ContactStorage.java      # Handles serialization
├── Validator.java           # Input validation logic
├── README.md
└── contacts.ser             # (Generated after first run)
```

---

## 🧹 Future Improvements

- Add birthday or address fields
- Export/import contacts via CSV
- GUI version using JavaFX or Swing
- Sorting and filtering options
- Better error handling

---

## 📄 License

MIT License — free to use, modify, and distribute.

---

## 🙌 Author

Made with ☕ by **Samuel Khawsigan with Deepseek AI as reference**

---

> Feel free to contribute or suggest features via pull request or issue!