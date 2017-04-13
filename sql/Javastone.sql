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

CREATE TABLE Agent (
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
) COMMENT 'An agent user'
;

INSERT INTO Agent (Username, Password_Hash, First_Name, Last_Name, Phone_Number, Address, City, State, Zip_Code)
VALUES ('user', aes_encrypt('password', '123FED') , 'FirstName', 'LastName', '1234567890', '123 Street', 'Cityton', 'IA', '12345')
;


CREATE TABLE Role (
	Role_ID INT PRIMARY KEY COMMENT 'The role primary key '
    , Description VARCHAR(250) NOT NULL COMMENT 'Description of the role'
) COMMENT 'A role'
;

CREATE TABLE User_Role (
	User_ID INT NOT NULL COMMENT 'The user id '
    , Role_ID INT NOT NULL COMMENT 'The role id '
    , PRIMARY KEY (User_ID, Role_ID)
    , FOREIGN KEY (User_ID) REFERENCES Agent(User_ID)
    , FOREIGN KEY (Role_ID) REFERENCES Role(Role_ID)
) COMMENT 'A user role'
;

CREATE TABLE Service_Category (
	Service_Category_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The service category primary key '
    , Description VARCHAR(500) NOT NULL COMMENT 'Description of the service category'
) COMMENT 'A service category'
;

CREATE TABLE Service_Provider (
	Service_Provider_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The service provider primary key '
    , Service_Category_ID INT NOT NULL COMMENT 'The category for the service provider'
    , FOREIGN KEY (Service_Category_ID) REFERENCES Service_Category(Service_Category_ID)
) COMMENT 'A service provider'
;

CREATE TABLE Call_Record (
	Call_ID INT PRIMARY KEY AUTO_INCREMENT COMMENT 'The call record primary key'
    , Agent_ID INT NOT NULL COMMENT 'The id of the agent associated with the call'
    , Call_Description VARCHAR(1000) NOT NULL COMMENT 'A description of the call'
    , Call_Type_Name VARCHAR(50) NOT NULL COMMENT 'The id of the type of call'
    , Caller_ID INT NOT NULL COMMENT 'The id of the caller associated with the call'
    , Start_Time DATETIME NOT NULL COMMENT 'The start time of the call'
    , End_Time DATETIME NOT NULL COMMENT 'The end time of the call'
    , FOREIGN KEY (Call_Type_Name) REFERENCES Call_Type(Call_Type_Name)
    , FOREIGN KEY (Caller_ID) REFERENCES Caller(Caller_ID)
    , FOREIGN KEY (Agent_ID) REFERENCES Agent(User_ID)
) COMMENT 'A record for a single call'
;



-- Stored Procedures

DELIMITER $$
DROP PROCEDURE IF EXISTS sp_authenticate_user$$
CREATE PROCEDURE sp_authenticate_user(
	IN p_username VARCHAR(256)
    , IN p_password VARCHAR(256)
)
COMMENT 'Looks for an agent with the supplied login and password.  Returns that employee is matched, otherwise raises an error.'
BEGIN

	DECLARE var_user_id INT;
    
    SET var_user_id = (
		SELECT User_ID 
        FROM Agent
        WHERE Username = p_username
        AND Password_Hash = aes_encrypt(p_password, '123FED')
    ) ; 
	
    IF var_user_id is null THEN 
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid username or password.';
    END IF;
    
    SELECT User_ID, Username, First_Name, Last_Name, Phone_Number, Address, City, State, Zip_Code
    FROM Agent
    WHERE User_ID = var_user_id;
END$$
DELIMITER ;



DROP USER IF EXISTS 'systemuser'@'%';
CREATE USER 'systemuser'@'%' 
IDENTIFIED BY 'password' 
;


GRANT EXECUTE ON PROCEDURE Javastone.sp_authenticate_user 
TO 'systemuser'@'%'
;
