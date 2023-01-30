package org.petrovitsky.dbservice;

import org.petrovitsky.dao.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private Database db = Database.getInstance();

    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException, IOException {
        String queryUrl = "C:/Users/epetr/eclipse-workspace/JavaDev/Homework4/JavaDev_homework4/sql/find_max_projects_client.sql";
        String sql = Files.readString(Path.of(queryUrl));
        Statement statement = db.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<MaxProjectCountClient> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new MaxProjectCountClient(
                    resultSet.getNString("name"),
                    resultSet.getInt("project_count")
            ));
        }
        db.close();
        return result;
    }


    public List<LongestProject> findlongestProject() throws IOException, SQLException {
        String queryUrl = "C:/Users/epetr/eclipse-workspace/JavaDev/Homework4/JavaDev_homework4/sql/find_longest_project.sql";
        String sql = Files.readString(Path.of(queryUrl));
        Statement statement = db.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<LongestProject> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new LongestProject(
                    resultSet.getNString("name"),
                    resultSet.getInt("month_count")
            ));
        }
        db.close();
        return result;
    }


    public List<MaxSalary> finaMaxSalary() throws IOException, SQLException {
        String queryUrl = "C:/Users/epetr/eclipse-workspace/JavaDev/Homework4/JavaDev_homework4/sql/find_max_salary_worker.sql";
        String sql = Files.readString(Path.of(queryUrl));
        Statement statement = db.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<MaxSalary> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new MaxSalary(
                    resultSet.getNString("name"),
                    resultSet.getInt("salary")
            ));
        }
        db.close();
        return result;
    }

    public List<YoungestOldestWorker> findYoungestOldestWorker() throws IOException, SQLException {
        String queryUrl = "C:/Users/epetr/eclipse-workspace/JavaDev/Homework4/JavaDev_homework4/sql/find_youngest_eldest_workers.sql";
        String sql = Files.readString(Path.of(queryUrl));
        Statement statement = db.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<YoungestOldestWorker> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new YoungestOldestWorker(
                    YoungestOldestWorker.Type.valueOf(resultSet.getString("type")),
                    resultSet.getNString("name"),
                    LocalDate.parse(resultSet.getNString("birthday"))
            ));
        }
        db.close();
        return result;
    }

    public List<ProjectCosts> getAllProjectswithCosts() throws IOException, SQLException {
        String queryUrl = "C:/Users/epetr/eclipse-workspace/JavaDev/Homework4/JavaDev_homework4/sql/print_project_prices.sql";
        String sql = Files.readString(Path.of(queryUrl));
        Statement statement = db.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<ProjectCosts> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new ProjectCosts(
                    resultSet.getNString("name"),
                    resultSet.getInt("price")
            ));
        }
        db.close();
        return result;
    }

}
