CREATE TABLE dept_manager(
	emp_no INTEGER(11) NOT NULL,
	dept_no CHAR(4) NOT NULL,
	from_date DATE NOT NULL,
    to_date DATE NOT NULL,
    PRIMARY KEY(emp_no),
    FOREIGN KEY(emp_no) REFERENCES employees(emp_no),
    FOREIGN KEY(dept_no) REFERENCES departments(dept_no)
);