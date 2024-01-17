INSERT INTO USER_DETAIL(id,USER_NAME, email) VALUES (1,'John','john.test@gmail.com');
INSERT INTO USER_DETAIL(id,USER_NAME, email) VALUES (2,'Albert','albert.test@gmail.com');
INSERT INTO USER_DETAIL(id,USER_NAME, email) VALUES (3,'Ravi','ravi.test@gmail.com');
INSERT INTO USER_DETAIL(id,USER_NAME, email) VALUES (4,'Janny','janny.test@gmail.com');
INSERT INTO USER_DETAIL(id,USER_NAME, email) VALUES (5,'Gilbert','gilbert.test@gmail.com');

---------------------------
--ALTER TABLE TICKET MODIDY CONSTRAINT  FOREIGN KEY (ASSIGNEE_ID) REFERENCES USER_DETAIL(ID);
--ALTER TABLE TICKET ADD CONSTRAINT tutorials_tbl_pk PRIMARYKEY(ID); 
--CREATE TABLE TICKET(id IDENTITY PRIMARY KEY, StringFieldName VARCHAR(255))