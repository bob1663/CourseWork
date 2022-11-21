package sample.coursework.database;

public class Configs {
    protected static String dbHost = "GARRY";
    protected static String dbPassword = "1308";
    protected static String dbPort = "1433";
    protected static String dbName = "gameroom";
    protected static String dbUser = "Vitalik";

}

/*
*
 use gameroom
go
create table gameroom (
	idGameroom int primary key identity(1,1) not null,
	type nvarchar(50) not null,
	size nvarchar(50) not null,
	price money not null
);
* */
