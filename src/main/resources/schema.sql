create table if not exists customer(
Customer_Id bigint not null primary key,
firstName  varchar(32) not null,
lastName varchar(32) not null
);

create table if not exists transactions(
transaction_Id bigint not null primary key,
Customer_Id bigint not null,
Date DATE not null,
amount Double not null
);


