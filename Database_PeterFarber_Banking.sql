--------------------------------------------------------
--  File created - Wednesday-March-14-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ACCOUNTS_STATUS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."ACCOUNTS_STATUS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_CUST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."DEMO_CUST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORDER_ITEMS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."DEMO_ORDER_ITEMS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."DEMO_ORD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 11 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_PROD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."DEMO_PROD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."DEMO_USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence LOGS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."LOGS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TEST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."TEST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 7 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence USERS_SEQ1
--------------------------------------------------------

   CREATE SEQUENCE  "PETERFARBER"."USERS_SEQ1"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table ACCOUNTS
--------------------------------------------------------

  CREATE TABLE "PETERFARBER"."ACCOUNTS" 
   (	"ACCOUNTS_NUMBER" VARCHAR2(96 BYTE), 
	"ACCOUNTS_STATUS_ID" NUMBER, 
	"ACCOUNTS_OWNER_ID" VARCHAR2(128 BYTE), 
	"ACCOUNTS_BALANCE" FLOAT(126)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ACCOUNTS_STATUS
--------------------------------------------------------

  CREATE TABLE "PETERFARBER"."ACCOUNTS_STATUS" 
   (	"ACCOUNTS_STATUS_ID" NUMBER(*,0), 
	"ACCOUNTS_STATUS_STATUS" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ACCOUNTS_USERS
--------------------------------------------------------

  CREATE TABLE "PETERFARBER"."ACCOUNTS_USERS" 
   (	"USERS_ID" VARCHAR2(96 BYTE), 
	"ACCOUNTS_ID" VARCHAR2(96 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOGS
--------------------------------------------------------

  CREATE TABLE "PETERFARBER"."LOGS" 
   (	"LOGS_ID" NUMBER, 
	"LOGS_TIME" TIMESTAMP (6), 
	"LOGS_MESSAGE" VARCHAR2(256 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "PETERFARBER"."USERS" 
   (	"USERS_NAME" VARCHAR2(96 BYTE), 
	"USERS_USERNAME" VARCHAR2(96 BYTE), 
	"USERS_PASSWORD" VARCHAR2(96 BYTE), 
	"USERS_TYPE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into PETERFARBER.ACCOUNTS
SET DEFINE OFF;
Insert into PETERFARBER.ACCOUNTS (ACCOUNTS_NUMBER,ACCOUNTS_STATUS_ID,ACCOUNTS_OWNER_ID,ACCOUNTS_BALANCE) values ('424478526',2,'password',20);
Insert into PETERFARBER.ACCOUNTS (ACCOUNTS_NUMBER,ACCOUNTS_STATUS_ID,ACCOUNTS_OWNER_ID,ACCOUNTS_BALANCE) values ('234498496',2,'Wizkid',70);
Insert into PETERFARBER.ACCOUNTS (ACCOUNTS_NUMBER,ACCOUNTS_STATUS_ID,ACCOUNTS_OWNER_ID,ACCOUNTS_BALANCE) values ('808275736',2,'Peter',0);
REM INSERTING into PETERFARBER.ACCOUNTS_STATUS
SET DEFINE OFF;
Insert into PETERFARBER.ACCOUNTS_STATUS (ACCOUNTS_STATUS_ID,ACCOUNTS_STATUS_STATUS) values (1,'PENDING');
Insert into PETERFARBER.ACCOUNTS_STATUS (ACCOUNTS_STATUS_ID,ACCOUNTS_STATUS_STATUS) values (2,'ACTIVE');
Insert into PETERFARBER.ACCOUNTS_STATUS (ACCOUNTS_STATUS_ID,ACCOUNTS_STATUS_STATUS) values (3,'DENIED');
REM INSERTING into PETERFARBER.ACCOUNTS_USERS
SET DEFINE OFF;
Insert into PETERFARBER.ACCOUNTS_USERS (USERS_ID,ACCOUNTS_ID) values ('Peter','808275736');
Insert into PETERFARBER.ACCOUNTS_USERS (USERS_ID,ACCOUNTS_ID) values ('Wizkid','234498496');
Insert into PETERFARBER.ACCOUNTS_USERS (USERS_ID,ACCOUNTS_ID) values ('password','424478526');
REM INSERTING into PETERFARBER.LOGS
SET DEFINE OFF;
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (7,to_timestamp('11-MAR-18 11.21.26.220000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Admin: Deposited 100.0 from 950557033 account!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (8,to_timestamp('12-MAR-18 10.30.44.808000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (21,to_timestamp('12-MAR-18 12.27.56.475000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (23,to_timestamp('12-MAR-18 12.28.08.641000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: is accessing 234498496.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (25,to_timestamp('12-MAR-18 03.36.37.241000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (26,to_timestamp('12-MAR-18 03.45.33.765000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (27,to_timestamp('12-MAR-18 03.48.36.623000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (32,to_timestamp('13-MAR-18 11.49.52.355000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Peter: applied for an account 808275736.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (34,to_timestamp('13-MAR-18 11.50.13.871000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Admin: approved account 808275736.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (2,to_timestamp('11-MAR-18 11.21.08.820000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Customer: Withdrew 100.0 from 20239685 account!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (5,to_timestamp('11-MAR-18 11.21.26.118000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Customer: Withdrew 100.0 from 566845203 account!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (12,to_timestamp('12-MAR-18 10.31.05.505000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Admin: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (24,to_timestamp('12-MAR-18 12.28.08.658000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Transferred 10.0 from 234498496 to 424478526.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (31,to_timestamp('13-MAR-18 11.49.47.932000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Peter: User Created!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (3,to_timestamp('11-MAR-18 11.21.08.848000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Customer: Deleted 694505151.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (4,to_timestamp('11-MAR-18 11.21.09.037000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Admin: Deposited 100.0 from 422328546 account!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (6,to_timestamp('11-MAR-18 11.21.26.144000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Customer: Deleted 435938896.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (9,to_timestamp('12-MAR-18 10.30.48.841000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: is accessing 842007415.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (14,to_timestamp('12-MAR-18 10.31.46.840000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Admin: is accessing 234498496.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (17,to_timestamp('12-MAR-18 12.26.15.364000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: is accessing 234498496.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (22,to_timestamp('12-MAR-18 12.27.58.434000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: is accessing 234498496.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (28,to_timestamp('12-MAR-18 03.48.40.317000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: is accessing 234498496.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (1,to_timestamp('11-MAR-18 11.00.46.733000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (10,to_timestamp('12-MAR-18 10.30.50.718000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Deleted 842007415.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (18,to_timestamp('12-MAR-18 12.26.35.013000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'password: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (19,to_timestamp('12-MAR-18 12.26.37.015000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'password: is accessing 424478526.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (30,to_timestamp('13-MAR-18 10.00.37.101000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (33,to_timestamp('13-MAR-18 11.50.07.458000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Admin: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (35,to_timestamp('13-MAR-18 11.50.21.211000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Peter: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (36,to_timestamp('13-MAR-18 11.50.23.914000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Peter: is accessing 808275736.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (11,to_timestamp('12-MAR-18 10.30.54.016000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: applied for an account 234498496.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (13,to_timestamp('12-MAR-18 10.31.41.008000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Admin: printed account 234498496.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (15,to_timestamp('12-MAR-18 10.31.55.040000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Admin: approved account 234498496.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (16,to_timestamp('12-MAR-18 12.25.25.050000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Logged In!');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (20,to_timestamp('12-MAR-18 12.26.54.757000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'password: Transferred 90.0 from 424478526 to 234498496.');
Insert into PETERFARBER.LOGS (LOGS_ID,LOGS_TIME,LOGS_MESSAGE) values (29,to_timestamp('12-MAR-18 03.48.43.377000000 PM','DD-MON-RR HH.MI.SSXFF AM'),'Wizkid: Withdrew 10.0 from 234498496 account!');
REM INSERTING into PETERFARBER.USERS
SET DEFINE OFF;
Insert into PETERFARBER.USERS (USERS_NAME,USERS_USERNAME,USERS_PASSWORD,USERS_TYPE) values ('uesr','password','password',1);
Insert into PETERFARBER.USERS (USERS_NAME,USERS_USERNAME,USERS_PASSWORD,USERS_TYPE) values ('Employee','Employee','password',2);
Insert into PETERFARBER.USERS (USERS_NAME,USERS_USERNAME,USERS_PASSWORD,USERS_TYPE) values ('Peter','Wizkid','12345',1);
Insert into PETERFARBER.USERS (USERS_NAME,USERS_USERNAME,USERS_PASSWORD,USERS_TYPE) values ('Admin','Admin','password',3);
Insert into PETERFARBER.USERS (USERS_NAME,USERS_USERNAME,USERS_PASSWORD,USERS_TYPE) values ('Peter','Peter','12345',1);
--------------------------------------------------------
--  DDL for Index ACCOUNT_STATUS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PETERFARBER"."ACCOUNT_STATUS_PK" ON "PETERFARBER"."ACCOUNTS_STATUS" ("ACCOUNTS_STATUS_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PETERFARBER"."USERS_PK" ON "PETERFARBER"."USERS" ("USERS_USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ACCOUNT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PETERFARBER"."ACCOUNT_PK" ON "PETERFARBER"."ACCOUNTS" ("ACCOUNTS_NUMBER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ACCOUNTS_USERS_PK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "PETERFARBER"."ACCOUNTS_USERS_PK1" ON "PETERFARBER"."ACCOUNTS_USERS" ("USERS_ID", "ACCOUNTS_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index LOGS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PETERFARBER"."LOGS_PK" ON "PETERFARBER"."LOGS" ("LOGS_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger ACCOUNTS_STATUS_AUTOINCREMENT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PETERFARBER"."ACCOUNTS_STATUS_AUTOINCREMENT" 
BEFORE INSERT ON ACCOUNTS_STATUS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ACCOUNTS_STATUS_ID IS NULL THEN
      SELECT ACCOUNTS_STATUS_SEQ.NEXTVAL INTO :NEW.ACCOUNTS_STATUS_ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "PETERFARBER"."ACCOUNTS_STATUS_AUTOINCREMENT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger LOGS__AUTOINCREMENT_TRIG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PETERFARBER"."LOGS__AUTOINCREMENT_TRIG" 
BEFORE INSERT ON LOGS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.LOGS_ID IS NULL THEN
      SELECT LOGS_SEQ.NEXTVAL INTO :NEW.LOGS_ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "PETERFARBER"."LOGS__AUTOINCREMENT_TRIG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USERS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PETERFARBER"."USERS_TRG" 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "PETERFARBER"."USERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USERS__AUTOINCREMENT_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PETERFARBER"."USERS__AUTOINCREMENT_TRIGGER" 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "PETERFARBER"."USERS__AUTOINCREMENT_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Procedure TRANSFERFUNDS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "PETERFARBER"."TRANSFERFUNDS" ( 
    ac_a VARCHAR2,
    ac_b VARCHAR2,
    ammount FLOAT
) AS
BEGIN
    UPDATE ACCOUNTS SET ACCOUNTS_BALANCE = ACCOUNTS_BALANCE - ammount WHERE ACCOUNTS_NUMBER = ac_a;
    UPDATE ACCOUNTS SET ACCOUNTS_BALANCE = ACCOUNTS_BALANCE + ammount WHERE ACCOUNTS_NUMBER = ac_b;
    COMMIT;
END;

/
--------------------------------------------------------
--  DDL for Function CUSTOM_AUTH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "PETERFARBER"."CUSTOM_AUTH" (p_username in VARCHAR2, p_password in VARCHAR2)
return BOOLEAN
is
  l_password varchar2(4000);
  l_stored_password varchar2(4000);
  l_expires_on date;
  l_count number;
begin
-- First, check to see if the user is in the user table
select count(*) into l_count from demo_users where user_name = p_username;
if l_count > 0 then
  -- First, we fetch the stored hashed password & expire date
  select password, expires_on into l_stored_password, l_expires_on
   from demo_users where user_name = p_username;

  -- Next, we check to see if the user's account is expired
  -- If it is, return FALSE
  if l_expires_on > sysdate or l_expires_on is null then

    -- If the account is not expired, we have to apply the custom hash
    -- function to the password
    l_password := custom_hash(p_username, p_password);

    -- Finally, we compare them to see if they are the same and return
    -- either TRUE or FALSE
    if l_password = l_stored_password then
      return true;
    else
      return false;
    end if;
  else
    return false;
  end if;
else
  -- The username provided is not in the DEMO_USERS table
  return false;
end if;
end;

/
--------------------------------------------------------
--  DDL for Function CUSTOM_HASH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "PETERFARBER"."CUSTOM_HASH" (p_username in varchar2, p_password in varchar2)
return varchar2
is
  l_password varchar2(4000);
  l_salt varchar2(4000) := 'RPDO0Q3ISKMXONDKN0J6WWZB37B9YI';
begin

-- This function should be wrapped, as the hash algorhythm is exposed here.
-- You can change the value of l_salt or the method of which to call the
-- DBMS_OBFUSCATOIN toolkit, but you much reset all of your passwords
-- if you choose to do this.

l_password := utl_raw.cast_to_raw(dbms_obfuscation_toolkit.md5
  (input_string => p_password || substr(l_salt,10,13) || p_username ||
    substr(l_salt, 4,10)));
return l_password;
end;

/
--------------------------------------------------------
--  Constraints for Table ACCOUNTS_USERS
--------------------------------------------------------

  ALTER TABLE "PETERFARBER"."ACCOUNTS_USERS" ADD CONSTRAINT "ACCOUNTS_USERS_PK" PRIMARY KEY ("USERS_ID", "ACCOUNTS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PETERFARBER"."ACCOUNTS_USERS" MODIFY ("ACCOUNTS_ID" NOT NULL ENABLE);
  ALTER TABLE "PETERFARBER"."ACCOUNTS_USERS" MODIFY ("USERS_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "PETERFARBER"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("USERS_USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PETERFARBER"."USERS" MODIFY ("USERS_USERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOGS
--------------------------------------------------------

  ALTER TABLE "PETERFARBER"."LOGS" ADD CONSTRAINT "LOGS_PK" PRIMARY KEY ("LOGS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PETERFARBER"."LOGS" MODIFY ("LOGS_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ACCOUNTS
--------------------------------------------------------

  ALTER TABLE "PETERFARBER"."ACCOUNTS" MODIFY ("ACCOUNTS_STATUS_ID" NOT NULL ENABLE);
  ALTER TABLE "PETERFARBER"."ACCOUNTS" MODIFY ("ACCOUNTS_BALANCE" NOT NULL ENABLE);
  ALTER TABLE "PETERFARBER"."ACCOUNTS" MODIFY ("ACCOUNTS_OWNER_ID" NOT NULL ENABLE);
  ALTER TABLE "PETERFARBER"."ACCOUNTS" ADD CONSTRAINT "ACCOUNT_PK" PRIMARY KEY ("ACCOUNTS_NUMBER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PETERFARBER"."ACCOUNTS" MODIFY ("ACCOUNTS_NUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ACCOUNTS_STATUS
--------------------------------------------------------

  ALTER TABLE "PETERFARBER"."ACCOUNTS_STATUS" ADD CONSTRAINT "ACCOUNT_STATUS_PK" PRIMARY KEY ("ACCOUNTS_STATUS_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PETERFARBER"."ACCOUNTS_STATUS" MODIFY ("ACCOUNTS_STATUS_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ACCOUNTS
--------------------------------------------------------

  ALTER TABLE "PETERFARBER"."ACCOUNTS" ADD CONSTRAINT "FK_ACCOUNTS_STATUS_ID" FOREIGN KEY ("ACCOUNTS_STATUS_ID")
	  REFERENCES "PETERFARBER"."ACCOUNTS_STATUS" ("ACCOUNTS_STATUS_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ACCOUNTS_USERS
--------------------------------------------------------

  ALTER TABLE "PETERFARBER"."ACCOUNTS_USERS" ADD CONSTRAINT "FK_ACCOUNTS_USERS_ACCOUNTS" FOREIGN KEY ("ACCOUNTS_ID")
	  REFERENCES "PETERFARBER"."ACCOUNTS" ("ACCOUNTS_NUMBER") ON DELETE CASCADE ENABLE;
  ALTER TABLE "PETERFARBER"."ACCOUNTS_USERS" ADD CONSTRAINT "FK_ACCOUNTS_USERS_USERS" FOREIGN KEY ("USERS_ID")
	  REFERENCES "PETERFARBER"."USERS" ("USERS_USERNAME") ON DELETE CASCADE ENABLE;
