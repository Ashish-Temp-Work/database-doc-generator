
package com.dbdocgen.service;

import com.dbdocgen.model.*;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Connection.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

@Service
public class MetadataExtractorService {
    public List<String> listTables(DatabaseConnection conn) throws Exception {
        Class.forName(conn.getType().getDriverClassName());
        try (Connection c = DriverManager.getConnection(conn.getJdbcUrl(), conn.getUsername(), conn.getPassword())) {
            ResultSet rs = c.getMetaData().getTables(null, conn.getSchemaName(), "%", new String[]{"TABLE"});
            List<String> tables = new ArrayList<>();
            while (rs.next()) { tables.add(rs.getString("TABLE_NAME")); }
            return tables;
        }
    }
}
