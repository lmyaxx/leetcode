```mysql
select A.id as id, A.visit_date as visit_date,  A.people as people
from stadium as A , stadium as B , stadium as C
where (
    (A.id +1 = B.id and A.id + 2 = C.id) or
    (A.id = B.id + 1 and  A.id + 1 = C.id ) or
    (A.id = B.id + 2 and A.id = C.id + 1)
      ) and (A.people>=100 and B.people >= 100 and C.people >=100)
      
group by A.id 
order by A.id
```