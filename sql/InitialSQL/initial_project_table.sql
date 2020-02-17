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

ALTER TABLE project AUTO_INCREMENT=100001;