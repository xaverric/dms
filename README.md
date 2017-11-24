# DMS (Document Management System)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/809ddaa3a7694611ba9cd9be4d9ed20c)](https://www.codacy.com/app/jilek.daniel/dms?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=xaverric/dms&amp;utm_campaign=Badge_Grade)

Simple tool for storing and administrating your documents.

## Requirements
* Each file consist of the content and metadata stored in the database (Author, version, last modified date, category, ...).
* Users have roles and each role is able to see files for these roles.
* Files can be secure - visible only to the author.
* Files are versioned - it is possible to get back to the any previous version of the file. It is possible thanks to the parrent_id in the metadata.
* Files has to be acknowledged by someone with higher privileges. (Role)

## Screens
* Login screen
* User profile screen
* Files overview

## Technologies
* Spring boot
* Hibernate
* MySQL
* Java

# TODOs
1. Dokončit entity pro DB
2. Udělat pro entity DAO
3. Vytvořit services pro ziskávání DAO
4. Vytvořit InitialDataSet pro základní naplnění databáze (Role, Category, Users --> admin + testovací uživatelé)
