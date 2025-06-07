package DesignPatterns.ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DbConnectionPoolManager {

    private List<DbConnection> freeConnections = new ArrayList<>();

    private List<DbConnection> currentlyInUseConnections = new ArrayList<>();

    private static final int MIN_POOL_SIZE = 3;

    private static final int MAX_POOL_SIZE = 6;

    public static DbConnectionPoolManager dbConnectionPoolManager = null;

    private DbConnectionPoolManager() {
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            freeConnections.add(new DbConnection());
        }
    }

    public static DbConnectionPoolManager getInstance() {
        if (dbConnectionPoolManager == null) {
            synchronized (DbConnectionPoolManager.class) {
                if (dbConnectionPoolManager == null) {
                    dbConnectionPoolManager = new DbConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManager;
    }

    public synchronized DbConnection getDbCOnnection() {
        if (freeConnections.isEmpty() && currentlyInUseConnections.size() >= MAX_POOL_SIZE) {
            return null;
        } else if (freeConnections.isEmpty()) {
            DbConnection dbConnection = new DbConnection();
            currentlyInUseConnections.add(dbConnection);
            return dbConnection;
        }

        DbConnection dbConnection = freeConnections.get(freeConnections.size() - 1);
        currentlyInUseConnections.add(dbConnection);
        return dbConnection;
    }


    public synchronized void releaseConnection(DbConnection dbConnection) {
        if (dbConnection != null) {
            currentlyInUseConnections.remove(dbConnection);
            freeConnections.add(dbConnection);
        }
    }
}
