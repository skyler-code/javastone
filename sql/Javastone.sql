-- *****************************************************************************
-- Create the data base and set it as the current database
-- *****************************************************************************

-- Database for Javastone
DROP DATABASE IF EXISTS Javastone;

CREATE DATABASE Javastone;

USE Javastone;




CREATE TABLE Caller (
	Caller_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The caller record primary key'
    , Caller_Notes VARCHAR(1000) NOT NULL COMMENT 'A description of the caller'
    , First_Name VARCHAR(100) NOT NULL COMMENT 'The first name of the caller'
    , Last_Name VARCHAR(100) NOT NULL COMMENT 'The last name of the caller'
    , PhoneNumber VARCHAR(10) NOT NULL COMMENT 'The phone number of the caller'
) COMMENT 'A caller record'
;

CREATE TABLE Call_Type (
	Call_Type_Name VARCHAR(50) PRIMARY KEY COMMENT 'The call type primary key'
    , Description VARCHAR(1000) NOT NULL COMMENT 'A description of the call type'
) COMMENT 'A call type'
;

INSERT INTO Call_Type (Call_Type_Name, Description)
VALUES
("Self Harm Threat (high)","The caller is in imminent threat of self harm"),
("Self Harm Threat (Medium)","The caller is in potential threat of self harm"),
("Self Harm Threat (low)","The caller is thinking about potential self harm"),
("Drug Abuse","The caller is calling in regards to first hand drug abuse issues, not including alcohol"),
("Alcohol Abuse","The caller is calling in regards to first hand alcohol abuse issues"),
("Domestic Violence","The call is in regards to first hand violence within her household")
;


CREATE TABLE App_User (
	User_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The agent primary key'
    , Username VARCHAR(50) NOT NULL COMMENT 'The username of the agent'
    , Password_Hash VARBINARY(500) NOT NULL COMMENT 'The hash of the password for the agent'
    , First_Name VARCHAR(50) NOT NULL COMMENT 'The first name of the agent'
    , Last_Name VARCHAR(100) NOT NULL COMMENT 'The last name of the agent'
    , Phone_Number VARCHAR(20) NOT NULL COMMENT 'The phone number of the agent'
    , Address VARCHAR(100) NOT NULL COMMENT 'The Address of the agent'
    , City VARCHAR(100) NOT NULL COMMENT 'The city of the agent'
    , State VARCHAR(2) NOT NULL COMMENT 'The 2 character code for the state of the agent'
    , Zip_Code VARCHAR(10) NOT NULL COMMENT 'The zip code of the agent'
) COMMENT 'The app_user'
;

INSERT INTO App_User (Username, Password_Hash, First_Name, Last_Name, Phone_Number, Address, City, State, Zip_Code)
VALUES
('user', aes_encrypt('password', '123FED'), 'Susie', 'Test', '1234567890', '123 Street', 'Cityton', 'IA', '12345'),
('testclerk', aes_encrypt('password', '123FED'), 'Data', 'Clerk', '1234567890', '123 Street', 'Cityton', 'IA', '12345'),
('testagent', aes_encrypt('password', '123FED'), 'Test', 'Agent', '1234567890', '123 Street', 'Cityton', 'IA', '12345')
;


CREATE TABLE Role (
	Role_Name VARCHAR(50) PRIMARY KEY COMMENT 'The role primary key '
    , Description VARCHAR(250) NOT NULL COMMENT 'Description of the role'
) COMMENT 'A role'
;

INSERT INTO Role (Role_Name, Description)
VALUES
("DataClerk", "Management"),
("Agent", "Takes calls."),
("Administrator", "A system administrator."),
("Test", "Test")
;

CREATE TABLE User_Role (
	User_ID INT NOT NULL COMMENT 'The user id'
    , Role_Name VARCHAR(50) NOT NULL COMMENT 'The role id'
    , PRIMARY KEY (User_ID, Role_Name)
    , FOREIGN KEY (User_ID) REFERENCES App_User(User_ID)
    , FOREIGN KEY (Role_Name) REFERENCES Role(Role_Name)
) COMMENT 'A user role'
;

INSERT INTO User_Role(User_ID, Role_Name)
VALUES
(1, "Administrator"),
(1, "DataClerk"),
(1, "Agent"),
(2, "DataClerk"),
(2, "Agent"),
(3, "Agent")
;

CREATE TABLE Service_Category (
	Service_Category_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The service category primary key'
    , Description VARCHAR(500) NOT NULL COMMENT 'Description of the service category'
) COMMENT 'A service category'
;

CREATE TABLE Service_Provider (
	Service_Provider_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The service provider primary key'
    , Service_Category_ID INT NOT NULL COMMENT 'The category for the service provider'
    , FOREIGN KEY (Service_Category_ID) REFERENCES Service_Category(Service_Category_ID)
) COMMENT 'A service provider'
;

CREATE TABLE Call_Record (
	Call_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The call record primary key'
    , User_ID INT NOT NULL COMMENT 'The id of the user associated with the call'
    , Call_Description VARCHAR(1000) NOT NULL COMMENT 'A description of the call'
    , Call_Type_Name VARCHAR(50) NOT NULL COMMENT 'The id of the type of call'
    , Caller_ID INT NOT NULL COMMENT 'The id of the caller associated with the call'
    , Start_Time DATETIME NOT NULL COMMENT 'The start time of the call'
    , End_Time DATETIME NOT NULL COMMENT 'The end time of the call'
    , FOREIGN KEY (Call_Type_Name) REFERENCES Call_Type(Call_Type_Name)
    , FOREIGN KEY (Caller_ID) REFERENCES Caller(Caller_ID)
    , FOREIGN KEY (User_ID) REFERENCES App_User(User_ID)
) COMMENT 'A record for a single call'
;



-- Stored Procedures

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_authenticate_user$$
CREATE PROCEDURE sp_authenticate_user(
	IN p_username VARCHAR(256)
    , IN p_password VARCHAR(256)
)
COMMENT 'Looks for a user with the supplied login and password.  Returns that employee is matched, otherwise raises an error.'
BEGIN

	DECLARE var_user_id INT;
    
    SET var_user_id = (
		SELECT User_ID 
        FROM App_User
        WHERE Username = p_username
        AND Password_Hash = aes_encrypt(p_password, '123FED')
    ) ; 
	
    IF var_user_id is null THEN 
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid username or password.';
    END IF;
    
    SELECT User_ID, Username, First_Name, Last_Name, Phone_Number, Address, City, State, Zip_Code
    FROM App_User
    WHERE User_ID = var_user_id;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_retrieve_users_roles$$
CREATE PROCEDURE sp_retrieve_users_roles(
	IN p_userid INT
)
COMMENT 'Retrieves a user''s list of roles.'
BEGIN
	SELECT Role_Name
	FROM User_Role
	WHERE User_ID = p_userid;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_retrieve_call_type_list$$
CREATE PROCEDURE sp_retrieve_call_type_list(

)
COMMENT 'Retrieves a list of all call types.'
BEGIN
	SELECT Call_Type_Name, Description
	FROM Call_type;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_retrieve_call_type_description_by_name$$
CREATE PROCEDURE sp_retrieve_call_type_description_by_name(
	IN p_call_type_name VARCHAR(50)
)
COMMENT 'Retrieves a call type description by the call type name.'
BEGIN
	SELECT Description
	FROM Call_type
    WHERE Call_Type_Name = p_call_type_name;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_create_call_record$$
CREATE PROCEDURE sp_create_call_record(
    IN p_user_id INT,
    IN p_call_description VARCHAR(1000),
    IN p_call_type_name VARCHAR(50),
    IN p_caller_id INT,
    IN p_start_time DATETIME
)
COMMENT 'Adds a new call record to the database'
BEGIN
	SET @end_time = CURRENT_TIME();
	INSERT INTO Call_Record(User_ID, Call_Description, Call_Type_Name, Caller_ID, Start_Time, End_Time)
    VALUES
    (p_user_id, p_call_description, p_call_type_name, p_caller_id, p_start_time, end_time);
END$$
DELIMITER ;


DROP USER IF EXISTS 'systemuser'@'%';
CREATE USER 'systemuser'@'%' 
IDENTIFIED BY 'password' 
;



GRANT EXECUTE ON PROCEDURE Javastone.sp_authenticate_user 
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_retrieve_users_roles 
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_retrieve_call_type_list
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_retrieve_call_type_description_by_name
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_create_call_record
TO 'systemuser'@'%'
;