# Create Schema

CREATE SCHEMA 'employees';

# Create Tables

# Create departments
create table departments(
	dept_no CHAR(4) NOT NULL,
    dept_name VARCHAR(40) UNIQUE NOT NULL,
    PRIMARY KEY(dept_no)
);
# Create employees
create table employees(
	emp_no	integer(11) auto_increment NOT NULL, 
	birth_date	DATE NOT NULL,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    gender ENUM('M','F') NOT NULL,
    hire_date DATE NOT NULL,
    PRIMARY KEY(emp_no)
);

# Create dept_emp
CREATE TABLE dept_emp(
	emp_no INTEGER(11) NOT NULL,
	dept_no CHAR(4) NOT NULL,
	from_date DATE NOT NULL,
    to_date DATE NOT NULL,
    PRIMARY KEY(emp_no),
    FOREIGN KEY(emp_no) REFERENCES employees(emp_no),
    FOREIGN KEY(dept_no) REFERENCES departments(dept_no)
);

# Create dept_manager
CREATE TABLE dept_manager(
	emp_no INTEGER(11) NOT NULL,
	dept_no CHAR(4) NOT NULL,
	from_date DATE NOT NULL,
    to_date DATE NOT NULL,
    PRIMARY KEY(emp_no),
    FOREIGN KEY(emp_no) REFERENCES dept_emp(emp_no),
    FOREIGN KEY(dept_no) REFERENCES departments(dept_no)
);

# Create titles
CREATE TABLE titles(
	emp_no INTEGER(11) NOT NULL,
    title VARCHAR(50) NOT NULL,
    from_date DATE NOT NULL,
    to_date DATE DEFAULT '9999-01-01',
    PRIMARY KEY(emp_no, title, from_date),
    FOREIGN KEY (emp_no) REFERENCES employees(emp_no)
);

# CREATE TABLE login_info
CREATE TABLE login_info(
	emp_no INTEGER(11) NOT NULL,
    username VARCHAR(16)NOT NULL UNIQUE,
    password VARCHAR(16)NOT NULL ,
    status ENUM('valid','invalid') NOT NULL DEFAULT 'invalid',
    PRIMARY KEY(emp_no),
    FOREIGN KEY(emp_no) REFERENCES employees(emp_no)
);

#CREATE TABLE project
CREATE TABLE project(
	project_id INTEGER(11) auto_increment NOT NULL UNIQUE,
    project_leader INTEGER(11) NOT NULL,
    project_name VARCHAR(45) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    duration INTEGER(11),
    description VARCHAR(256),
    PRIMARY KEY(project_id),
    FOREIGN KEY (project_leader) REFERENCES dept_manager(emp_no)
);

#CREATE Table project_partake
CREATE TABLE project_partake(
	task_id INTEGER(11) UNIQUE NOT NULL AUTO_INCREMENT,
    project_id INTEGER(11) NOT NULL,
    emp_no INTEGER(11) NOT NULL,
    description VARCHAR(256) ,
    PRIMARY KEY(task_id),
    FOREIGN KEY (project_id) REFERENCES project(project_id),
    FOREIGN KEY (emp_no) REFERENCES employees(emp_no)
);

# INSERT DATA

# INSERT data of department
INSERT INTO departments(dept_no, dept_name) VALUES('d000', 'System Admin');
INSERT INTO departments(dept_no, dept_name) VALUES('d001', 'Marketing');
INSERT INTO departments(dept_no, dept_name) VALUES('d002', 'Finance');
INSERT INTO departments(dept_no, dept_name) VALUES('d003', 'Production');
INSERT INTO departments(dept_no, dept_name) VALUES('d004', 'Development');
INSERT INTO departments(dept_no, dept_name) VALUES('d005', 'Sales');

#INSERT data of employee
ALTER TABLE employees AUTO_INCREMENT=1001;
INSERT INTO employees (first_name, last_name , gender, birth_date, hire_date) Values('System','Admin','M','1960-01-01','1960-01-01');  # Admin
INSERT INTO employees (first_name, last_name , gender, birth_date, hire_date) Values('Test','Manager','M','1960-01-01','1960-01-01'); # Manager
INSERT INTO employees (first_name, last_name , gender, birth_date, hire_date) Values('Test','Staff','M','1960-01-01','1960-01-01'); # Staff

#INSERT data of dept_emp
INSERT INTO dept_manager(emp_no, dept_no, from_date, to_date) VALUES(1001, 'd000', '1960-01-01', '9999-01-01'); #Admin
INSERT INTO dept_manager(emp_no, dept_no, from_date, to_date) VALUES(1002, 'd004', '1960-01-01', '9999-01-01'); #Manager
INSERT INTO dept_manager(emp_no, dept_no, from_date, to_date) VALUES(1003, 'd004', '1960-01-01', '9999-01-01'); #Staff

#INSERT data of dept_manager
INSERT INTO dept_manager(emp_no, dept_no, from_date, to_date) VALUES(1002, 'd004', '1960-01-01', '9999-01-01'); # Manager

#INSERT data of titles
INSERT INTO titles(emp_no, title, from_date) VALUES(1001, 'System Admin', '1960-01-01');
INSERT INTO titles(emp_no, title, from_date) VALUES(1002, 'Manager', '1960-01-01');
INSERT INTO titles(emp_no, title, from_date) VALUES(1003, 'Staff', '1960-01-01');

#INSERT data of login_info
INSERT INTO login_info(emp_no,username,password,status) VALUES(1001, 'systemAdmin', 'Aa123456','valid');
INSERT INTO login_info(emp_no,username,password,status) VALUES(1002, 'testManager', 'Aa123456','valid');
INSERT INTO login_info(emp_no,username,password,status) VALUES(1003, 'testStaff', 'Aa123456','valid');

#INSERT data of project
INSERT INTO project(project_id, project_leader, project_name, start_date, description) VALUES (1, 1002, 'Test Project 1', '2020-02-16', 'Test');
INSERT INTO project(project_id, project_leader, project_name, start_date, end_date, duration, description) VALUES (2, 1002, 'Test Project 2', '2020-02-15', '2020-02-17',2,'Test');

#INSERT data of project_partake
INSERT INTO project_partake(task_id, project_id, emp_no, description) VALUES(1,1,1003,'Test Task');
INSERT INTO project_partake(task_id, project_id, emp_no, description) VALUES(2,2,1003,'Test Task 2');

