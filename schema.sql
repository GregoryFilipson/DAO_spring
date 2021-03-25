CREATE TABLE customers
(
    id           serial primary key,
    name         varchar(255),
    surname      varchar(255),
    age          int,
    phone_number VARCHAR(15)
);

create table orders
(
    id           serial primary key,
    date         timestamp not null default now(),
    customer_id  int not null ,
    product_name varchar(255) not null ,
    amount       int,
    foreign key (customer_id) references customers (id)
);

select o.product_name
from orders o
         join (select *
               from customers
               where upper(name) = NOT NULL) c
              on o.customer_id = c.id;