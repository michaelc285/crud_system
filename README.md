# My first java crud system
<img src="https://github.com/michaelc285/crud_system/blob/master/image/image1.PNG?raw=true" width="400">
<img src="https://github.com/michaelc285/crud_system/blob/master/image/image2.JPG?raw=true" width="400">


## Getting Started
1. Run initial.sql in `/crud_system/sql/initial.sql` with MySQL
2. You may need to modify database config<br/> `/crud_system/empsystem/src/com/empsystem/resources/DB_Config.cfg`
```
# Database config
username = < Your DB login username >
password = < Your DB login password >
database_url = jdbc:mysql://< Your DB address >/< Schema >?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false
```

## About this app
This project is to demonstrate company's employees and projects management system.
In this application there are divided into three types of system users: Admin, Manager and Staff.\
The function differences between these users:
```
 - Admin
	 - Register new employees
	 - Revoke employees
	 - Activate accounts
 - Manager
	 - Projects Create/Read/Update/Delete
	 - Tasks Create/Read/Update/Delete
	 - Search Related department's employees
 - Staff
	 - Task read only
	 
They all can change password on their own panel
```


## FAQ 
- Objective ?
	- The objective of creating this project is let me pick up java, oop and sql again
- What have you learned in this project ?
	- MySQL, OOP, Java Swing, JDBC etc...
