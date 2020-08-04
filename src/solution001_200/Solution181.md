```mysql
select aa.name Employee
from employee aa, employee bb
where bb.id = aa.managerId and aa.salary > bb.salary;
```