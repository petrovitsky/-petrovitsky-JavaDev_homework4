package org.petrovitsky.dbservice;

import org.petrovitsky.dao.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args) {
        String initDbUrl = "C:/Users/epetr/eclipse-workspace/JavaDev/Homework4/JavaDev_homework4/sql/init_db.sql";
        try {
            String sql = Files.readString(Path.of(initDbUrl));
            Connection connection = Database.getInstance().getConnection();
            connection.createStatement().executeUpdate(sql);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

}
