
GO
CREATE FUNCTION Sales.uf_getSales(@SalesOrderID int, @CurrencyCode nchar(3) ,@CurrencyRateDate datetime)
	RETURNS TABLE 
as
	RETURN
	with Products
	as (
		select *
		from Sales.SalesOrderDetail as sale
		where sale.SalesOrderID = @SalesOrderID
	)
	select p.ProductID, p.OrderQty, p.UnitPrice, p.UnitPrice*cr.EndOfDayRate as 'Converted Price'
	from Products as p, Sales.CurrencyRate as cr
	where cr.ToCurrencyCode = @CurrencyCode
		and cr.CurrencyRateDate = @CurrencyRateDate
GO

select * from Sales.uf_getSales(43659, 'CNY', '2005-07-01 00:00:00.000');
--select * from Sales.SalesOrderHeader;