CREATE TABLE project_partake(
	task_id INTEGER(11) UNIQUE NOT NULL AUTO_INCREMENT,
    project_id INTEGER(11) NOT NULL,
    emp_no INTEGER(11) NOT NULL,
    description VARCHAR(256) ,
    PRIMARY KEY(task_id),
    FOREIGN KEY (project_id) REFERENCES project(project_id),
    FOREIGN KEY (emp_no) REFERENCES employees(emp_no)
);

ALTER TABLE project_partake AUTO_INCREMENT=1000001;