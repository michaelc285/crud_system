create table employees(
	emp_no	integer(11) auto_increment NOT NULL, 
	birth_date	DATE NOT NULL,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    gender ENUM('M','F') NOT NULL,
    hire_date DATE NOT NULL,
    PRIMARY KEY(emp_no)
);
