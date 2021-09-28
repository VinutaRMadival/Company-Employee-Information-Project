
/* CREATION OF DEPARTMENT TABLE*/
-----------------------------------------------------
create table department(dept_id integer primary key,
		        dept_name varchar(150) ,
			dept_code varchar(150));
			
			
/* CREATION OF COMPANY TABLE*/
-----------------------------------------------------
create table company(company_id integer primary key,
                     company_name varchar(80),
                     company_phoneno integer ,
                     company_address varchar(150),
                     company_email varchar(150))
                   

/* CREATION OF EMPLOYEE TABLE*/
-----------------------------------------------------
create table employee(emp_id serial primary key,
		      emp_firstname varchar(150) ,
	              emp_middlename varchar(150),
                      emp_lastname varchar(140),
		      emp_phoneno integer not null unique,
		      emp_email varchar(150),
		      emp_ctc integer,
		      emp_address varchar(170),
		      emp_locality varchar(120),
		      emp_city varchar(130),
		      emp_doj date,
		      emp_dob date,
		      emp_gender varchar(15),
		      emp_job varchar(20),
		      employment_type varchar(20),
		      department_id integer references department(department_id),
                      pro_id integer references project(pro_id),
		      loc_id integer references location(loc_id),
                      company_id integer references company(company_id));
                     
					  
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
		      
		      
 /* CREATION OF PROJECT TABLE*/
-----------------------------------------------------					  
create table project(pro_id integer primary key,
		      pro_code varchar(50) ,
	              pro_name varchar(50),
                      pro_client_name varchar(40),
		      pro_industry varchar(50),
		      pro_startdate varchar(50),
		      pro_enddate varchar(50),
		      pro_budget integer,
		      pro_primarytechnology varchar(60),
		      pro_secondarytechnology varchar(60))
					  
