
select top 5 SalesOrderID, AccountNumber, OrderDate
from Sales.SalesOrderHeader
where AccountNumber 
IN (select AccountNumber
    from Sales.SalesOrderHeader
    group by AccountNumber
    having SUM(SubTotal) > 70000)
order by OrderDate DESC;