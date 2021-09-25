
/* CREATION OF DEPARTMENT TABLE*/
-----------------------------------------------------
create table department(dept_id integer primary key,
		        dept_name varchar(50) ,
			dept_code varchar(15));

/* CREATION OF EMPLOYEE TABLE*/
-----------------------------------------------------
create table employee(emp_id varchar(30) primary key,
		      emp_firstname varchar(50) ,
	              emp_middlename varchar(50),
                      emp_lastname varchar(40),
		      emp_phoneno integer,
		      emp_email varchar(50),
		      emp_ctc integer,
		      emp_address1 varchar(70),
		      emp_locality varchar(20),
		      emp_city varchar(30),
		      emp_doj varchar(40),
		      emp_dob varchar(40),
		      emp_gender varchar(10),
		      emp_job varchar(20),
		      employment_type varchar(20),
		      dept_id integer references department(dept_id),
		      loc_id integer references location(loc_id));
					  
/* CREATION OF LOCATION TABLE*/
-----------------------------------------------------
create table location(loc_id integer primary key,
		      loc_code varchar(10),
		      loc_name varchar(50),
		      loc_address varchar(40),
		      loc_city varchar(30),
		      loc_state varchar(30),
		      loc_country varchar(20),
		      loc_zip integer,
		      contact_phone integer,
		      contact_email varchar(40),
		      contact_name varchar(30));
					  