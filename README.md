# Simple_SES_CRUD_OP_Rivera_Mervin_John
# 🎓 Student Enrollment System (v2)

## System Overview
This project is a Java Swing-based Student Enrollment System that allows administrative users to manage academic data records. The application interfaces directly with a local MySQL server instance to provide persistent storage using an Object-Relational Mapping (ORM) design model. 

Through this system, users can:
* Register and update student personal information profiles.
* Add and manage academic course tracks in the master catalog.
* Enroll students into courses, tracking specific enrollment IDs and transaction timestamps.
* View and audit separate real-time record matrices via interactive tabular sheets.
* Dynamically lookup and route actions via contextual interface states.

The application isolates backend queries, data transfer objects, core connection pipelines, and front-end interface containers into distinct modules inside the `student_enrollment_system_v2` package directory.

---

## 💻 Component Responsibilities

The system consists of specialized structural layers grouped by functional objectives: Data Models, CRUD Persistence Operations, Core Utility, and Swing UI components.

### 1. Presentation Layer (Java Swing Interfaces)

#### A. Main Dashboard Frame (`StudentGUI.java`)
The primary execution window (`JFrame`) that serves as the entry point and foundational layout wrapper for the user interface environment.
* **Responsibilities:**
  * Coordinates primary application layout configurations and acts as the structural container for sub-windows.
  * Launches application background procedures.
  * Controls a dedicated interface workflow engine driven by a `javax.swing.Timer` alongside sequential step index values (`step`) to run smooth front-end window state updates.
* **Main Features:**
  * Main window entry vector.
  * Asynchronous UI lifecycle coordination.
  * Core step execution animation loops.

#### B. Data Input Manager (`Registry.java`)
A specialized data capture modal panel (`JDialog`) mapped to receive and format direct record fields entered by the operator.
* **Responsibilities:**
  * Displays user form configurations to ingest names, descriptions, credits, or registration sequences.
  * Automatically coordinates programmatic drop-down lookup procedures (`StudentComboBox()`, `CourseComboBox()`).
  * Extracts inputs and packages data properties securely into model classes before firing persistence pipelines.
* **Main Features:**
  * Automated entity mapping dropdown lists.
  * Conversions of raw user text into model values.
  * Transaction safety validations.

#### C. Contextual Access & Lookup Frame (`StudentID.java`)
A state-controlled lookup sub-window (`JDialog`) tasked with locating existing records or validating IDs.
* **Responsibilities:**
  * Implements an adaptive `CardLayout` architecture layer matrix switcher.
  * Interrogates interface navigation flags (`con == 1` or `con == 2`) to dynamically swap and project distinct view panels (such as `card3`) depending on user focus.
  * Validates contextual data identifiers before routing actions to CRUD engines.
* **Main Features:**
  * State-pattern visual layer routing.
  * Context-aware interface switching via a unified layout manager.
  * Target element matching parameters.

#### D. Consolidated Tabular Report Console (`list.java`)
The visual auditing desk of the system, responsible for grouping database records into multi-tab grid panels.
* **Responsibilities:**
  * Builds three separate data table instances (`jTable1`, `jTable2`, `jTable3`) inside scrolling viewports (`JScrollPane`).
  * Fires sequential table assembly routines (`table()`, `table2()`, `table3()`) right at window startup.
  * Pulls complete entity arrays via persistence hooks and writes records down to visible user spreadsheets via structural `DefaultTableModel` controls.
* **Main Features:**
  * Multi-entity dashboard matrix.
  * Automatic synchronization of grids on view invocation.
  * Tabbed viewport separation.

### 2. Persistence Layer (Data Access Framework)

#### A. Central Connectivity Engine (`DBConnection.java`)
The core structural utility pipeline responsible for database connection handling.
* **Responsibilities:**
  * Programmatically invokes runtime loading for the modern native driver class (`com.mysql.cj.jdbc.Driver`).
  * Securely maps network variables (Server Endpoint, User Credentials, Passwords).
  * Serves as a static factory endpoint (`getConnection()`) that dispatches operational connection links while managing catch exceptions.
* **Main Features:**
  * Centralized credentials encapsulation.
  * Driver verification routing.
  * Graceful connection-fault isolation.

#### B. Entity Data Managers (`StudentCRUD.java`, `CourseCRUD.java`, `EnrollmentCRUD.java`)
The analytical query processing blocks running transactional calculations directly against relational database tables.
* **Responsibilities:**
  * Transform high-level data blueprints into concrete MySQL execution rows.
  * Inject parameter boundaries strictly through safe compiled `PreparedStatement` interfaces to prevent query vulnerability exposure.
  * Wrap resource streams within `try-with-resources` control containment structures to guarantee that connection pipelines, execution engines, and data returned from query tables are completely closed out, completely avoiding memory or pipeline allocation leaks.
* **Main Features:**
  * `StudentCRUD.java`: Governs profile generation updates (`addStudent`), full list processing (`getAllStudents`), targeted data modifications (`updateStudent`), and direct key records deletion lines (`deleteStudent`).
  * `CourseCRUD.java`: Directs course addition, reading, track updates, and item removal actions across the course catalog metrics.
  * `EnrollmentCRUD.java`: Directs complex cross-table data tracking and maps validation constraints before creating, retrieving, or removing relational associations.

### 3. Model Layer (Data Transfer Containers)

#### A. Data Blueprints (`StudentInfo.java`, `CourseInfo.java`, `EnrollmentInfo.java`)
Plain Old Java Objects (POJOs) engineered to serve as decoupled, memory-isolated data boxes throughout the application runtime.
* **Responsibilities:**
  * `StudentInfo`: Enforces strict variable encapsulation over personal identification parameters (`Student_ID`, `First_Name`, `Last_Name`, `Age`, `Email`).
  * `CourseInfo`: Wraps information blocks tracking tracking ids, name strings, descriptive text blocks, and instructional weights (`courseid`, `CourseName`, `courseDetails`, `credits`).
  * `EnrollmentInfo`: Holds junction mapping data elements (`enrollID`, `studentID`, `courseID`) alongside temporal registration timestamp fields (`date`).
* **Main Features:**
  * Total state privacy boundaries.
  * Unified `getter` and `setter` access routing channels.
  * Memory-isolated object modeling.

---

## 🗄️ How Data Models and Databases Are Used

Rather than managing ephemeral local data collections, this architecture bridges internal Data Models with external database schema layouts using the core JDBC API.

### Entity and Table Mappings
Every single model class directly corresponds to an exact relational matrix structural layout maintained within the database. 

#### 1. Student Mapping Framework
* Model Tracker: `StudentInfo.java`
* Target Database Matrix: `mydb.`student table``
```text
Object Properties (Java)   ⇄   Column Scheme (MySQL)
---------------------------     ----------------------------
private int Student_ID          `Student ID` (INT, AUTO_INCREMENT, PK)
private String First_Name       `First_Name` (VARCHAR)
private String Last_Name        `Last_Name` (VARCHAR)
private int Age                 `Age` (INT)
private String Email            `Email` (VARCHAR)
