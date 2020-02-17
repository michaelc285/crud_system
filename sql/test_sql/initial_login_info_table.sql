CREATE TABLE login_info(
	emp_no INTEGER(11) NOT NULL,
    username VARCHAR(16)NOT NULL UNIQUE,
    password VARCHAR(16)NOT NULL ,
    status ENUM('valid','invalid') NOT NULL DEFAULT 'invalid',
    PRIMARY KEY(emp_no),
    FOREIGN KEY(emp_no) REFERENCES employees(emp_no)
);