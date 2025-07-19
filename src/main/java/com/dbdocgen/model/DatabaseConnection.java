
package com.dbdocgen.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "database_connections")
public class DatabaseConnection {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private DatabaseType type;
    private String host;
    private int port;
    private String databaseName;
    private String schemaName;
    private String username;
    private String password;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime lastUsedAt;

    public DatabaseConnection() {}

    public String getJdbcUrl() {
        return switch (type) {
            case MYSQL -> "jdbc:mysql://" + host + ":" + port + "/" + databaseName;
            case POSTGRESQL -> "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
            case ORACLE -> "jdbc:oracle:thin:@" + host + ":" + port + ":" + databaseName;
            case SQL_SERVER -> "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + databaseName;
            case DB2 -> "jdbc:db2://" + host + ":" + port + "/" + databaseName;
            case H2 -> "jdbc:h2:file:" + databaseName;
        };
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DatabaseType getType() {
        return type;
    }

    public void setType(DatabaseType type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUsedAt() {
        return lastUsedAt;
    }

    public void setLastUsedAt(LocalDateTime lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
    }
}
