# 🎓 Student Management System (Java Swing + MySQL)

A desktop application built with Java Swing that lets you add and view student records (Name, Roll Number, Grade), backed by a MySQL database.

## 🛠️ Tech Stack
- Java Swing (GUI)
- JDBC (Java Database Connectivity)
- MySQL

## ✨ Features
- Add a new student record (Name, Roll No., Grade) through a form
- Records are saved to a MySQL database (`student_management` DB, `student` table)
- All existing student records load automatically into a scrollable list when the app starts
- UI includes Sort By (Name / Roll Number / Grade) and Ascending/Descending options
  *(note: currently these are UI controls only — the sorting logic isn't wired up yet, this would be a good next feature to add)*

## 🚀 How to Run
1. Clone the repository:
   ```
   git clone https://github.com/Sandip678/StudentManagement.git
   ```
2. Set up MySQL:
   - Create a database named `student_management`
   - Create a `student` table with columns: `name` (VARCHAR), `roll_number` (INT), `grade` (DOUBLE)
3. Update the database credentials in `StudentManagement.java` (`getConnection()` method) to match your local MySQL setup.
4. Open the project in IntelliJ IDEA / Eclipse, add the MySQL JDBC driver to your classpath.
5. Run `StudentManagement.java` (has the `main()` method).

## 📁 Project Structure
```
StudentManagement/
├── StudentManagement.java   # Main application (UI + DB logic)
└── .idea/                   # IDE config
```

## ⚠️ Note on Security
The current version has database credentials hardcoded directly in the source file. For any real/production use, move these to environment variables or a separate config file that's excluded via `.gitignore` — never commit real database passwords to a public repository.

## 📌 About
This project was built to practice Java Swing GUI development combined with JDBC database operations — form handling, event listeners, and CRUD-style database interaction.

## 👤 Author
**Sandeep Dhore**
[LinkedIn](https://www.linkedin.com/in/sandeep-dhore) · [GitHub](https://github.com/Sandip678)
