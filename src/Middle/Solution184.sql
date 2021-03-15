select
    d.name as Department,
    e1.name as Employee,
    e1.salary as Salary
from
    Employee e1
join
    Department d
on
    e1.departmentid = d.id
where
    (e1.departmentid, e1.salary)
in
    (
        select
            departmentid, max(salary)
        from
            Employee
        group by
            departmentid
    );
