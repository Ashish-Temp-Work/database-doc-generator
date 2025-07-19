
package com.dbdocgen.model;

public enum DatabaseType {
    MYSQL("MySQL", "com.mysql.cj.jdbc.Driver", 3306),
    POSTGRESQL("PostgreSQL", "org.postgresql.Driver", 5432),
    ORACLE("Oracle", "oracle.jdbc.driver.OracleDriver", 1521),
    SQL_SERVER("SQL Server", "com.microsoft.sqlserver.jdbc.SQLServerDriver", 1433),
    DB2("IBM DB2", "com.ibm.db2.jcc.DB2Driver", 50000),
    H2("H2 Database", "org.h2.Driver", 9092);

    private final String displayName;
    private final String driverClassName;
    private final int defaultPort;

    DatabaseType(String displayName, String driverClassName, int defaultPort) {
        this.displayName = displayName;
        this.driverClassName = driverClassName;
        this.defaultPort = defaultPort;
    }

    public String getDisplayName() { return displayName; }
    public String getDriverClassName() { return driverClassName; }
    public int getDefaultPort() { return defaultPort; }
}
