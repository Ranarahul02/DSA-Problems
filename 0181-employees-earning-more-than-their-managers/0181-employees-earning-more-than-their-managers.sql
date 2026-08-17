# Write your MySQL query statement below
SELECT e.name AS Employee FROM employee e 
JOIN employee m ON  
e.managerid=m.id AND
 e.salary>m.salary;