```mysql
select Email 
from person
group by email
having count(*) > 1;
```