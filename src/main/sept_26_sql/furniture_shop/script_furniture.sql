create table items
(
    id          integer primary key,
    name        varchar(80),
    description varchar(200),
    producer_id integer,
    amount      integer
);

create table producers
(
    id      integer primary key,
    name    varchar(100),
    address varchar(200)
);

create table customers
(
    id      integer primary key,
    name    varchar(50),
    surname varchar(100)
);

create table shipping_addresses
(
    id          integer primary key,
    customer_id integer,
    city        varchar(100),
    street      varchar(100),
    building    varchar(5)
);

create table orders
(
    id          integer primary key,
    customer_id integer,
    address_id  integer
);

create table orders_content
(
    order_id integer,
    item_id  integer,
    amount   integer
);

insert into producers (id, name, address)
values (1, 'Мир мебели', 'Москва');
insert into producers (id, name, address)
values (2, 'Great Chair', 'Польша');
insert into producers (id, name, address)
values (3, '1000 диванов', 'Новороссийск');

insert into items (id, name, description, producer_id, amount)
values (1, 'Стол письменный "Салют"', 'Большой удобный письменный стол', 1, 10);
insert into items (id, name, description, producer_id, amount)
values (2, 'Шкаф для одежды', 'Простой шкаф с тремя полками', 1, 8);
insert into items (id, name, description, producer_id, amount)
values (3, 'Кресло-качалка базовое', 'Кресло-качалка с деревянной базой и тканевой обивкой', 2, 12);
insert into items (id, name, description, producer_id, amount)
values (4, 'Диван односпальный база', NULL, 3, 84);
insert into items (id, name, description, producer_id, amount)
values (5, 'Диван "Люкс"', 'Диван повышенной комфортности для ценителей', 3, 6);

insert into customers(id, name, surname)
values (1, 'Дмитрий', 'Сергеев');
insert into customers(id, name, surname)
values (2, 'Ирина', 'Максимова');
insert into customers(id, name, surname)
values (3, 'Вячеслав', 'Феоктистов');

insert into shipping_addresses (id, customer_id, city, street, building)
values (1, 1, 'Москва', 'Ленинский проспект', '19');
insert into shipping_addresses (id, customer_id, city, street, building)
values (2, 2, 'Москва', 'Кутузовский проспект', '24');
insert into shipping_addresses (id, customer_id, city, street, building)
values (3, 2, 'Москва', 'ул. Беговая', '12');
insert into shipping_addresses (id, customer_id, city, street, building)
values (4, 3, 'Санкт-Петербург', 'Литейный проспект', '42');

insert into orders (id, customer_id, address_id)
values (1, 1, 1);
insert into orders (id, customer_id, address_id)
values (2, 1, 1);
insert into orders (id, customer_id, address_id)
values (3, 1, 1);
insert into orders (id, customer_id, address_id)
values (4, 2, 2);
insert into orders (id, customer_id, address_id)
values (5, 2, 3);
insert into orders (id, customer_id, address_id)
values (6, 2, 2);
insert into orders (id, customer_id, address_id)
values (7, 3, 4);
insert into orders (id, customer_id, address_id)
values (8, 3, 4);

insert into orders_content (order_id, item_id, amount)
values (1, 2, 1);
insert into orders_content (order_id, item_id, amount)
values (2, 4, 1);
insert into orders_content (order_id, item_id, amount)
values (2, 5, 1);
insert into orders_content (order_id, item_id, amount)
values (3, 1, 2);
insert into orders_content (order_id, item_id, amount)
values (4, 1, 1);
insert into orders_content (order_id, item_id, amount)
values (4, 2, 1);
insert into orders_content (order_id, item_id, amount)
values (4, 3, 1);
insert into orders_content (order_id, item_id, amount)
values (5, 4, 1);
insert into orders_content (order_id, item_id, amount)
values (6, 4, 1);
insert into orders_content (order_id, item_id, amount)
values (6, 5, 1);
insert into orders_content (order_id, item_id, amount)
values (7, 1, 1);
insert into orders_content (order_id, item_id, amount)
values (8, 3, 1);
insert into orders_content (order_id, item_id, amount)
values (8, 4, 1);

--1--
select name, surname
from customers;

--2-- -To sort the records in descending order, use the DESC keyword.-
select name, description
from items
order by amount DESC;

--3--
-- The IS NOT NULL condition is used in SQL to test for a non-NULL value.
-- It returns TRUE if a non-NULL value is found, otherwise it returns FALSE.
-- It can be used in a SELECT, INSERT, UPDATE, or DELETE statement. --
select name, description
from items
where description is not null;

--4
--The SELECT DISTINCT statement is used to return only distinct (different) values.
-- Inside a table, a column often contains many duplicate values
select distinct o.customer_id customers
from orders o;

--5
--The LIKE operator is used in a WHERE clause to search for a specified pattern in a column
--% The percent sign (%) represents zero, one, or multiple characters
--The underscore sign (_) represents one, single character
--The UPPER() function converts a string to upper-case.
select i.name, i.description
from items i
where upper(i.name) like upper('%диван%');

--6
-- A JOIN clause is used to combine rows from two or more tables, based on a related column between them.
select i.name, i.description
from items i
         join producers p on i.producer_id = p.id
where p.name = '1000 диванов';

--7
-- Joins can be combined in a queue
select o.id, i.name, oc.amount, c.name, c.surname, sa.city, sa.street
from orders o
         join orders_content oc on o.id = oc.order_id
         join items i on oc.item_id = i.id
         join customers c on o.customer_id = c.id
         join shipping_addresses sa on o.address_id = sa.id;

--8
select c.name, c.surname, sa.city, sa.street, sa.building
from customers c
         join shipping_addresses sa on c.id = sa.customer_id;

--9
-- the UNION operator is used to combine the result-set of two or more SELECT statements.
SELECT sa.city
FROM shipping_addresses sa
UNION
SELECT p.address
FROM producers p;

--9.2
-- + добавить результат - столбец, в котором будет результат - поставщик или покупатель
SELECT sa.city, 'Customer city'
FROM shipping_addresses sa
UNION
SELECT p.address, 'Producer city'
FROM producers p;

--10
insert into customers(id, name, surname)
values (4, 'Ivan', 'Ivanovich');

--11
-- The use of COUNT() function in conjunction with GROUP BY is useful for characterizing our data under various groupings. A combination of same values (on a column) will be treated as an individual group.
-- left join works for null values too (surprise!), unlike just 'join'
select c.surname, COUNT(oc.amount)
from customers c
         left join orders o on c.id = o.customer_id
         left join orders_content oc on o.id = oc.order_id
group by c.surname;

--12
-- The SUM() function returns the total sum of a numeric column (compare with count)
select i.name, SUM(oc.amount)
from orders_content oc
         left join items i on oc.item_id = i.id
group by i.name;

--13
-- ???
select c.name, c.surname, sa.city
from customers c
         join shipping_addresses sa on c.id = sa.customer_id
where UPPER(sa.city) like UPPER('%москва')
group by c.name, c.surname, sa.city;

--14
select sa.city, sa.street, sa.building, COUNT(o.id)
from shipping_addresses sa
         join customers c on sa.customer_id = c.id
         join orders o on sa.id = o.address_id
group by sa.city, sa.street, sa.building;

--15 (right)
-- SUM([ALL | DISTINCT ] expression)
-- ALL instructs the SUM() function to return the sum of all values including duplicates. ALL is used by default.
-- DISTINCT instructs the SUM() function to calculate the sum of the only distinct values.
-- expression is any valid expression that returns an exact or approximate numeric value.
-- Note that aggregate functions or subqueries are not accepted in the expression.
-- when we use the DISTINCT modifier, the SUM() function returns the sum of only unique values
select p.name producers, sum(oc.amount) sold_qnt, sum(distinct i.amount) available_acc
from producers p
         join items i on p.id = i.producer_id
         join orders_content oc on i.id = oc.item_id
group by p.name;

--15 (wrong!( (with repeats in producers)
select p.name producers, oc.amount sold_qnt, i.amount available_acc
from producers p
         join items i on p.id = i.producer_id
         join orders_content oc on i.id = oc.item_id;

--15 (right, but hard one)
select s.p_name, t.total, s.sold
from (
         select p.id as producer, sum(i.amount) as total
         from producers p
                  join items i on p.id = i.producer_id
         group by p.id, p.name
     ) t,
     (
         select p.id as producer, p.name as p_name, sum(oc.amount) as sold
         from producers p
                  join items i on i.producer_id = p.id
                  join orders_content oc on oc.item_id = i.id
         group by p.id, p.name
     ) s
where t.producer = s.producer;



