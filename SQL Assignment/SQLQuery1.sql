--Q1 1
select Count(*) from Sales.SalesPerson;


--Q1 2
select FirstName, LastName from Person.Person where FirstName LIKE 'B%';


--Q1 3
select p.FirstName, p.LastName from Person.Person as p,
HumanResources.Employee as e where e.BusinessEntityID = p.BusinessEntityID 
    and e.JobTitle IN ('Design Engineer','Tool Designer','Marketing Assistant');


--Q1 4
select Name, Color from Production.Product 
where Weight = (select MAX([Weight]) from Production.Product);


--Q1 5
select Description, COALESCE(MaxQty, 0.00) from Sales.SpecialOffer;


--Q1 6
select AVG(AverageRate) as 'Average Rate'
from Sales.CurrencyRate
where FromCurrencyCode = 'USD' 
	and ToCurrencyCode = 'GBP' 
	and YEAR(CurrencyRateDate) = 2005;


--Q1 7
select ROW_NUMBER() OVER(ORDER BY FirstName, LastName) as 'Sr. No.', FirstName, LastName
from Person.Person
where FirstName LIKE '%ss%';


--Q1 8
select BusinessEntityID as 'SalesPersonID',
	case
		WHEN CommissionPct = 0.0 then 'BAND 0'
		WHEN CommissionPct > 0.0 and CommissionPct <=0.01 then 'BAND 1'
		WHEN CommissionPct > 0.01 and CommissionPct <=0.015 then 'BAND 2'
		WHEN CommissionPct > 0.015 then 'BAND 3'
		END as 'Commission Band'
from Sales.SalesPerson;


--Q1 9
DECLARE @ID int;
select @ID = BusinessEntityID 
from Person.Person 
where FirstName = 'Ruth' 
	and LastName = 'Ellerbrock'
	and PersonType = 'EM';
EXEC dbo.uspGetEmployeeManagers @BusinessEntityID = @ID;


--Q1 10
select MAX(dbo.ufnGetStock(ProductID)) from Production.Product;