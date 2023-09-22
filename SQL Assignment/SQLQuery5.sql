
GO
CREATE PROCEDURE Person.up_getFilteredNames
@Filter nchar(2 ) = 'EM'
as
select FirstName from Person.Person where PersonType = @Filter
GO

EXEC Person.up_getFilteredNames @Filter = 'SC';