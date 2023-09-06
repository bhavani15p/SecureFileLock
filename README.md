# SecureFileLock

SecureFileLock is a Java-based application for securing and managing files within a MySQL database. It allows you to securely store and effectively hide the files using unique ID. Retrieving these files is straightforward, simply provide the corresponding ID to access and decrypt the content. 

## Features

- **File Encryption**: SecureFileLock encrypts files before storing them in the MySQL database, ensuring data confidentiality.

- **User Authentication**: Users can create accounts and securely log in to access their encrypted files.

- **MySQL Database**: Utilizes MySQL to store encrypted files and user account information.

- **JDBC Integration**: JDBC (Java Database Connectivity) drivers are used for seamless database interactions.

- **Cross-Platform**: Compatible with Windows, macOS, and Linux.

## Prerequisites

Before you can use SecureFileLock, ensure you have the following prerequisites:

- Java Development Kit (JDK) 8 or higher installed on your system.

- MySQL Database Server installed and running. Make sure you have the necessary database credentials.

- MySQL JDBC driver (usually included in most Java development environments).

## Installation

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/bhavani15p/SecureFileLock.git

2. Create a MySQL database and configure the connection parameters in the `config.properties` file.

## Configuration

Edit the `config.properties` file to configure your MySQL database connection:

```properties
db.url=jdbc:mysql://localhost:3306/securefilelock
db.username=your_username
db.password=your_password

