```mysql
select name Customers
from customers
where id not in (select distinct CustomerId from orders);
```