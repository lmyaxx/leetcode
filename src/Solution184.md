```mysql

select Department,Employee.name Employee,Employee.Salary Salary
from  
(select Salary, temp.DepartmentId DepartmentId, Department.name Department from
(select max(Salary) Salary, DepartmentId
 from Employee
 group by DepartmentId
) temp inner join Department on Department.id = temp.DepartmentId) temp2 inner join Employee on Employee.DepartmentId = temp2.DepartmentId and Employee.Salary = temp2.Salary;
```