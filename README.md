 Summary of Changes

 1. Database Configuration
 Configured MySQL connection in application.properties with database client on port `3306`.
 Auto-created `students` table via Hibernate JPA schema updates.

 2. Service Layer
 Created `StudentService` interface in `jar.service`.
 Created `StudentServiceImpl` in `jar.service.impl` using Spring constructor injection and proper null handling.
3. Controller Refactoring
 Cleaned up `StudentController.java`, `Update.java`, and `Delete.java` to delegate business logic to `StudentService`.
 Renamed methods to descriptive REST standards (`getAllStudents`, `createStudent`, `updateStudent`, `deleteStudent`).
 Added support for `/api/v1/update/{id}` endpoint paths.
