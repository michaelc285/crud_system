CREATE TABLE titles(
	emp_no INTEGER(11) NOT NULL,
    title VARCHAR(50) NOT NULL,
    from_date DATE NOT NULL,
    to_date DATE DEFAULT '9999-01-01',
    PRIMARY KEY(emp_no, title, from_date),
    FOREIGN KEY (emp_no) REFERENCES employees(emp_no)
);