# Write your MySQL query statement below
SELECT MAX(num) AS Num FROM (SELECT num FROM MyNumbers GROUP BY num HAVING COUNT(num) = 1) AS unique_numbers;