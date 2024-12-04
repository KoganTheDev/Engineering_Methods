# 🐬 MySQL Basics and Best Practices 💾  

![MySQL](https://img.shields.io/badge/MySQL-DatabaseManagement-blue?style=flat-square)  
![Best Practices](https://img.shields.io/badge/Best%20Practices-Essential-green?style=flat-square)  

## 📋 Overview  
This guide provides an introduction to **MySQL**, a powerful relational database management system. Whether you're just getting started or looking to refine your skills, this README will cover key concepts, essential commands, and best practices for database management.  

---

## 📂 Table of Contents   
1. [Basic Commands](#-basic-commands)  
2. [Database Management](#-database-management)  
3. [Best Practices](#-best-practices)  
4. [Resources](#-resources)  

---

## 🛠️ Basic Commands  
| **Command**                              | **Description**                            |  
|------------------------------------------|--------------------------------------------|  
| `CREATE DATABASE <name>;`               | Create a new database                      |  
| `SHOW DATABASES;`                       | List all databases                         |  
| `USE <database_name>;`                  | Select a database for use                  |  
| `CREATE TABLE <name> (...);`            | Create a new table                         |  
| `SHOW TABLES;`                          | List all tables in the current database    |  
| `INSERT INTO <table> VALUES (...);`     | Insert a new record                        |  
| `SELECT * FROM <table>;`                | Retrieve data from a table                 |  
| `UPDATE <table> SET ... WHERE ...;`     | Update existing records                    |  
| `DELETE FROM <table> WHERE ...;`        | Delete records                             |  
| `DROP DATABASE <name>;`                 | Delete a database                          |  
| `DROP TABLE <name>;`                    | Delete a table                             |  

---

## 📋 Database Management  

### Creating a Table  
```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    name VARCHAR(100),  
    email VARCHAR(100),  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  
);
```  

### Inserting Data  
```sql
INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@example.com');  
```  

### Querying Data  
```sql
SELECT * FROM users;  
```  

### Updating Data  
```sql
UPDATE users SET email = 'new.email@example.com' WHERE id = 1;  
```  

### Deleting Data  
```sql
DELETE FROM users WHERE id = 1;  
```  

---

## ✅ Best Practices  
1. **Normalize Your Data**: Design tables to reduce redundancy and improve efficiency.  
2. **Use Primary Keys**: Ensure each record has a unique identifier.  
3. **Backup Regularly**: Avoid data loss by creating routine backups.  
4. **Secure Your Database**:  
   - Use strong passwords for users.  
   - Restrict user permissions.  
   - Enable SSL for secure connections.  
5. **Index Columns**: Optimize query performance by indexing frequently queried columns.  

---

## 🌐 Resources  
- [MySQL Documentation](https://dev.mysql.com/doc/)  
- [SQL Tutorial](https://www.w3schools.com/sql/)  
- [MySQL Cheat Sheet (PDF)](https://cheatography.com/davechild/cheat-sheets/mysql/)  

---

## ✍️ Author  
**Yuval Kogan**    
🌐 [GitHub Profile](https://github.com/KoganTheDev)  
📇 [LinkedIn](https://www.linkedin.com/in/yuval-kogan)  
