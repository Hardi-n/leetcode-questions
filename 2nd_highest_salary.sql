/*176. Second Highest Salary
Medium
Topics
Companies
SQL Schema
Pandas Schema
Table: Employee

+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id is the primary key (column with unique values) for this table.
Each row of this table contains information about the salary of an employee.


Write a solution to find the second highest salary from the Employee table. If there is no second highest salary, return null (return None in Pandas).

The result format is in the following example.



Example 1:

Input: 
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
Output: 
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
Example 2:

Input: 
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+
Output: 
+---------------------+
| SecondHighestSalary |
+---------------------+
| null                |
+---------------------+*/


# Write your MySQL query statement below
SELECT 
    IFNULL(
        (SELECT DISTINCT salary 
         FROM Employee 
         ORDER BY salary DESC 
         LIMIT 1 OFFSET 1),
        NULL
    ) AS SecondHighestSalary;



/*
Explanation:
Subquery: The subquery SELECT DISTINCT salary FROM Employee ORDER BY salary DESC LIMIT 1 OFFSET 1 fetches the second highest salary.
IFNULL: The IFNULL() function is used to return NULL if the subquery doesn't find a second highest salary (i.e., if the subquery returns NULL).
Alias: The result is aliased as SecondHighestSalary.
This query will return NULL if there's no second highest salary found, otherwise, it will return the actual second highest salary.
*/