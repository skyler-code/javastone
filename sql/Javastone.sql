-- *****************************************************************************
-- Create the data base and set it as the current database
-- *****************************************************************************

-- Database for Javastone
DROP DATABASE IF EXISTS Javastone;

CREATE DATABASE Javastone;

USE Javastone;




CREATE TABLE Caller (
	Caller_Phone VARCHAR(10) PRIMARY KEY COMMENT 'The caller record primary key / Phone number'
    , Caller_Notes VARCHAR(1000) COMMENT 'A description of the caller'
    , First_Name VARCHAR(100) COMMENT 'The first name of the caller'
    , Last_Name VARCHAR(100) COMMENT 'The last name of the caller'
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

CREATE TABLE Incoming_Call(
	Phone_Number VARCHAR(10) PRIMARY KEY COMMENT 'The number calling the call center'
) COMMENT 'A CALL'
;

INSERT INTO Incoming_Call (Phone_Number)
VALUES
("3191112316"),
("5512345695"),
("9915623455"),
("3192203056")
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
    Service_Category_Name VARCHAR(100) PRIMARY KEY COMMENT 'The name of the service category'
    , Description VARCHAR(500) NOT NULL COMMENT 'Description of the service category'
) COMMENT 'A service category'
;

INSERT INTO Service_Category (Service_Category_Name, Description)
VALUES
("Suicide","If a caller is feeling suicidal"),
("Homeless Shelter", "Caller needs a place to stay"),
("Domestic Abuse", "Caller feels unsafe at home with significant other"),
("Natural Disaster", "Caller is unsafe due to weather disaster"),
("Medical Emergency","Caller needs immediate medical attention")
;

CREATE TABLE Service_Provider (
	Service_Provider_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The service provider primary key'
    , Service_Category_Name VARCHAR(100) NOT NULL COMMENT 'The category for the service provider'
	, Service_Provider_Name VARCHAR(100) NOT NULL COMMENT 'Service provider name'
	, Service_Provider_Phone_Number VARCHAR(10) COMMENT 'Service provider phone number'
    , FOREIGN KEY (Service_Category_Name) REFERENCES Service_Category(Service_Category_Name)
) COMMENT 'A service provider'
;

INSERT INTO Service_Provider (Service_Category_Name, Service_Provider_Name, Service_Provider_Phone_Number)
VALUES
("Suicide", "Suicide Prevention Lifeline", "8002738255"),
("Homeless Shelter", "Willis Dady Shelter", "3193627555"),
("Homeless Shelter", "Cedar House Shelter", "3193642630"),
("Domestic Abuse", "National Domestic Violence Hotline", "8007997233"),
("Domestic Abuse", "Waypoint", "3193632093"),
("Natural Disaster", "Disaster Distress Helpline", "8009855990"),
("Natural Disaster", "Iowa Red Cross", "5152437681"),
("Medical Emergency", "911", "911"),
("Medical Emergency", "Linn County Emergency Medicine", "3193694505")
;

CREATE TABLE Call_Record (
	Call_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The call record primary key'
    , User_ID INT NOT NULL COMMENT 'The id of the user associated with the call'
    , Call_Description VARCHAR(1000) NOT NULL COMMENT 'A description of the call'
    , Call_Type_Name VARCHAR(50) NOT NULL COMMENT 'The id of the type of call'
    , Caller_Phone VARCHAR(10) NOT NULL COMMENT 'The caller record primary key / Phone number'
    , Start_Time DATETIME NOT NULL COMMENT 'The start time of the call'
    , End_Time DATETIME NOT NULL COMMENT 'The end time of the call'
    , FOREIGN KEY (Call_Type_Name) REFERENCES Call_Type(Call_Type_Name)
    , FOREIGN KEY (Caller_Phone) REFERENCES Caller(Caller_Phone)
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
    IN p_caller_phone VARCHAR(10),
    IN p_start_time DATETIME
)
COMMENT 'Adds a new call record to the database'
BEGIN
	SET @end_time = NOW();
	INSERT INTO Call_Record(User_ID, Call_Description, Call_Type_Name, Caller_Phone, Start_Time, End_Time)
    VALUES
    (p_user_id, p_call_description, p_call_type_name, p_caller_phone, p_start_time, @end_time);
	SELECT row_count();
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_create_new_user$$
CREATE PROCEDURE sp_create_new_user(
    IN p_username VARCHAR(50),
    IN p_password_hash VARCHAR(500),
    IN p_first_name VARCHAR(50),
    IN p_last_name VARCHAR(100),
    IN p_phone_number VARCHAR(20),
    IN p_address VARCHAR(100),
    IN p_city VARCHAR(100),
    IN p_state VARCHAR(2),
    IN p_zip_code VARCHAR(10)
)
COMMENT 'Adds a new user to the database'
BEGIN
	INSERT INTO App_User(USERNAME, Password_Hash, First_Name, Last_Name, Phone_Number, Address, City, State, Zip_Code)
    VALUES
    (p_username, p_password_hash, p_first_name, p_last_name, p_phone_number, p_address, p_city, p_state, p_zip_code);
    SELECT row_count() as affected;
END $$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS sp_retrieve_call_records_by_userId$$
CREATE PROCEDURE sp_retrieve_call_records_by_userId(
	IN p_user_id INT
)
COMMENT 'Retrieves all call records submitted by a specific userId' 
BEGIN
	SELECT Call_ID, Call_Description, Call_Type_Name, Caller_Phone, Start_Time, End_Time
	FROM Call_Record
	WHERE User_ID = p_user_id;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_retrieve_calls$$
CREATE PROCEDURE sp_retrieve_calls(
)
COMMENT 'Retrieves all incoming calls' 
BEGIN
	SELECT Phone_Number
	FROM Incoming_Call;
END$$
DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS sp_update_caller$$
CREATE PROCEDURE sp_update_caller(
	IN p_caller_phone VARCHAR(10),
	IN p_caller_notes VARCHAR(1000),
	IN p_caller_first VARCHAR(100),
	IN p_caller_last  VARCHAR(100)
)
COMMENT 'Updates existing caller record'
BEGIN
	UPDATE Caller
	SET Caller_Phone = p_caller_phone, Caller_Notes = p_caller_notes, First_Name = p_caller_first, Last_Name = p_caller_last	
	WHERE Caller_Phone = p_caller_phone;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_create_caller$$
CREATE PROCEDURE sp_create_caller(
	IN p_caller_phone VARCHAR(10)
)
COMMENT 'Adds a new caller to the database'
BEGIN
	INSERT INTO Caller(Caller_Phone)
	VALUES
	(p_caller_phone);
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_retrieve_caller_by_phone$$
CREATE PROCEDURE sp_retrieve_caller_by_phone(
	IN p_caller_phone VARCHAR(10)
)
COMMENT 'Gets a caller record using a phone number'
BEGIN
	Select Caller_Phone, Caller_Notes, First_Name, Last_Name
	FROM Caller
	WHERE Caller_Phone = p_caller_phone;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_retrieve_service_providers$$
CREATE PROCEDURE sp_retrieve_service_providers(
)
COMMENT 'Retrieves a list of service providers.'
BEGIN
	SELECT Service_Provider_ID, Service_Category_Name, Service_Provider_Name, Service_Provider_Phone_Number
	FROM Service_Provider;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_retrieve_service_categories$$
CREATE PROCEDURE sp_retrieve_service_categories(
)
COMMENT 'Retrieves a list of service categories.'
BEGIN
	SELECT Service_Category_Name, Description
	FROM Service_Category;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_remove_incoming_call$$
CREATE PROCEDURE sp_remove_incoming_call(
	IN p_phone_number varchar(10)
)
COMMENT 'Removes an entry from the incoming call table'
BEGIN
	DELETE FROM incoming_call
    WHERE Phone_Number = p_phone_number;
END$$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_update_user_password$$
CREATE PROCEDURE sp_update_user_password(
	IN p_user_id INT,
	IN p_old_password VARCHAR(256),
    IN p_new_password VARCHAR(256)
)
COMMENT 'Updates existing users password'
BEGIN
	UPDATE App_User
	SET Password_Hash = aes_encrypt(p_new_password, '123FED')	
	WHERE User_ID = p_user_id
    AND Password_Hash = aes_encrypt(p_old_password, '123FED');
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
GRANT EXECUTE ON PROCEDURE Javastone.sp_retrieve_call_records_by_userId
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_retrieve_calls
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_update_caller
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_create_caller
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_retrieve_caller_by_phone
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_retrieve_service_providers
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_retrieve_service_categories
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_remove_incoming_call
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_update_user_password
TO 'systemuser'@'%'
;
GRANT EXECUTE ON PROCEDURE Javastone.sp_create_new_user
TO 'systemuser'@'%'
;