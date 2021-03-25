select o.product_name
from orders o
         join (select *
               from customers
               where upper(name) = :name) c
              on o.customer_id = c.id;