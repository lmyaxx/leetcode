```mysql

select Department.Name Department, Employee.name Employee, Salary  
from Employee, Department
where Employee.DepartmentId = Department.id and (select count(distinct salary ) from Employee as E where E.DepartmentId = Employee.DepartmentId and E.salary > employee.salary  ) < 3 
order by Employee.DepartmentId, Salary desc;
```