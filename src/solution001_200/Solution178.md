```mysql
select Score , (select count(distinct score) from scores where score >= s.score ) Rank
from scores s
order by score desc
```

```mysql
select Score, (select count(*) from (select distinct score s from scores ) temp where score <= s)  Rank
from scores 
order by score desc
```