drop table customer,Transactions;
create table customer(
Customer_Id bigint not null primary key,
firstName  varchar(32) not null,
lastName varchar(32) not null
);

create table transactions(
transaction_Id bigint not null primary key,
Customer_Id bigint not null,
Date DATE not null,
amount Double not null
);


