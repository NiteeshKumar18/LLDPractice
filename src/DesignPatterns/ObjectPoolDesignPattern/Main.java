package DesignPatterns.ObjectPoolDesignPattern;

public class Main {
    public static void main(String[] args) {
        DbConnectionPoolManager dbConnectionPoolManager = DbConnectionPoolManager.getInstance();
        DbConnection dbConnection1 = dbConnectionPoolManager.getDbCOnnection();
        DbConnection dbConnection2 = dbConnectionPoolManager.getDbCOnnection();
        DbConnection dbConnection3 = dbConnectionPoolManager.getDbCOnnection();
        DbConnection dbConnection4 = dbConnectionPoolManager.getDbCOnnection();
        DbConnection dbConnection5 = dbConnectionPoolManager.getDbCOnnection();
        dbConnectionPoolManager.releaseConnection(dbConnection5);

    }
}
