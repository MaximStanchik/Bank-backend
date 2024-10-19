create table User (ID number(10) generated by default on null as identity,
                   LOGIN nvarchar2(255) not null,
                   PASSWORD nvarchar2(255) not null,
                   constraint User_PK primary key (ID)
);

create table Account (ID number(10) generated by default on null as identity,
                      NAME nvarchar2(50) not null,
                      CURRENCY varchar2(4) not null,
                      AMOUNT number(15,2) default 0.0,
                      USER_ID number(10) not null,
                      constraint FK_User foreign key (USER_ID) references User (ID)
);

create table User_Profile (ID number(10) generated by default on null as identity,
                           USER_ID number(10) not null,
                           FIRST_NAME nvarchar2(50) not null,
                           LAST_NAME nvarchar2(50) not null,
                           MIDDLE_NAME nvarchar2(50),
                           ADDRESS nvarchar2(255),
                           BIRTH_DATE date,
                           EMAIL nvarchar2(100),
                           PASSPORT_NUM nvarchar2(50) not null,
                           PHONE_NUMBER nvarchar2(50),
                           constraint PK_User_Profile primary key (ID),
                           constraint FK_User_Profile_User foreign key (USER_ID) references User (ID)
);

create table User_Support_Request (ID number(10) generated by default on null as identity,
                                   TYPE nvarchar2(50),
                                   CONTENT clob,
                                   DATE_TIME timestamp,
                                   ACCOUNT_ID number(10) not null,
                                   constraint PK_User_Support_Request primary key (ID),
                                   constraint FK_User_Support_Request_Account foreign key (ACCOUNT_ID) references Account(ID)
);

create table Currency (ID number(10) generated by default on null as identity,
                       NAME varchar2(100) not null,
                       CODE varchar2(3) not null,
                       constraint PK_Currency primary key (ID)
);

create table Currency_Exchange_Rate (ID	number(10) generated by default on null as identity,
                                     SOURCE_CURR_ID number(10) not null,
                                     TARGET_CURR_ID number(10) not null,
                                     RATE number(15, 2) not null,
                                     DATE date not null,
                                     constraint PK_Currency_Exchange_Rate primary key (ID),
                                     constraint FK_Currency_Exchange_Rate_Source foreign key (SOURCE_CURR_ID) references Currency(ID),
                                     constraint FK_Currency_Exchange_Rate_Target foreign key (TARGET_CURR_ID) references Currency(ID)
);

create table Transaction (ID number(10) generated by default on null as identity,
        ACCOUNT_ID_FROM	number(10) not null,
        ACCOUNT_ID_TO number(10) not null,
        AMOUNT number(15, 2) not null,
        DATE_TIME timestamp not null,
        constraint PK_Transaction primary key (ID),
        constraint FK_Transaction_Account_From foreign key (ACCOUNT_ID_FROM) references Account(ID),
        constraint FK_Transaction_Account_To foreign key (ACCOUNT_ID_TO) references Account(ID)
);

create table Credits (ID number(10) generated by default on null as identity,
    CREDIT_TYPE_ID number(10) not null,
    ACCOUNT_ID number(10) not null,
    AMOUNT number(15, 2) not null,
    constraint PK_Credits primary key (ID),
    constraint FK_Credits_CreditType foreign key (CREDIT_TYPE_ID) references Credit_Type(ID),
    constraint FK_Credits_Account foreign key (ACCOUNT_ID) references Account(ID)
);

create table Card (ID number(10) generated by default on null as identity,
    TYPE nvarchar2(50) not null,
    ACCOUNT_ID number(10) not null,
    CARD_NAME nvarchar2(100),
    DESCRIPTION	nvarchar2(255),
    STATUS nvarchar2(20),
    constraint PK_Card primary key (ID),
    constraint FK_Card_Account foreign key (ACCOUNT_ID) references Account(ID)
);

create table Credit_Type (ID number(10) generated by default on null as identity,
    TYPE nvarchar2(50) not null,
    CREDIT_NAME	nvarchar2(100) not null,
    DESCRIPTION	nvarchar2(255) not null,
    constraint PK_Credit_Type primary key (ID)
);

create table Payment_Service (ID number(10) generated by default on null as identity,
    NAME nvarchar2(100) not null,
    TYPE nvarchar2(50) not null ,
    TRANSACTION_ID	number(10) not null,
    constraint PK_Payment_Service primary key (ID),
    constraint FK_Payment_Service_Transaction foreign key (TRANSACTION_ID) references Transaction(ID)
);