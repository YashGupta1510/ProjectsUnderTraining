--using joins
select c.CustomerID
from Sales.SalesOrderHeader soh
	right join Sales.Customer c ON soh.CustomerID = c.CustomerID
where SalesOrderID is NULL;


--using sub queries
select c.CustomerID from Sales.Customer c
where c.CustomerID not in (select CustomerID from Sales.SalesOrderHeader);


--using CTE
WITH NoOrderCustomers (CustmerID) 
AS 
(
	select c.CustomerID
	from Sales.SalesOrderHeader soh
	right join Sales.Customer c ON soh.CustomerID = c.CustomerID
	where SalesOrderID is NULL
)
select * from NoOrderCustomers;
	

--using exists   
select c.CustomerID from Sales.Customer c
where not exists (select s.CustomerID from Sales.SalesOrderHeader AS s
				where s.CustomerID = c.CustomerID);