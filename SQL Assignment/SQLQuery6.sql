
GO
CREATE TRIGGER I_U_CheckPriceRise
ON Production.Product
AFTER UPDATE
AS
BEGIN
	SET NOCOUNT ON;

	IF UPDATE(ListPrice)
		BEGIN
			UPDATE Production.Product
			SET ListPrice = IIF((i.ListPrice - d.ListPrice) > d.ListPrice*0.15, d.ListPrice, i.ListPrice)
			FROM deleted AS d, Production.Product AS p
			INNER JOIN inserted AS i ON i.ProductID = p.ProductID
		END
END
GO

--select * from Production.Product;
--update Production.Product set ListPrice = 300 where ProductID = 515;
