# Write your MySQL query statement below
SELECT class FROM Courses GROUP BY Class HAVING COUNT(student) >= 5;