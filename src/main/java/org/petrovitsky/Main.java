package org.petrovitsky;

import org.petrovitsky.dbservice.DatabaseInitService;
import org.petrovitsky.dbservice.DatabasePopulateService;
import org.petrovitsky.dbservice.DatabaseQueryService;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        DatabaseInitService.main(new String[] {"InitDB"});
        DatabasePopulateService.main(new String[] {"PopulateDB"});

        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        System.out.println(databaseQueryService.getAllProjectswithCosts());
        System.out.println("--------- -------- ------- --------");
        System.out.println(databaseQueryService.findMaxProjectsClient());
        System.out.println("--------- -------- ------- --------");
        System.out.println(databaseQueryService.findYoungestOldestWorker());
        System.out.println("--------- -------- ------- --------");
        System.out.println(databaseQueryService.findlongestProject());
        System.out.println("--------- -------- ------- --------");
        System.out.println(databaseQueryService.finaMaxSalary());
    }


}