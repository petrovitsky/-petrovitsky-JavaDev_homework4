package org.petrovitsky;

import org.petrovitsky.dao.Database;
import org.petrovitsky.dao.MaxProjectCountClient;
import org.petrovitsky.dbservice.DatabaseQueryService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
//        DatabaseInitService.main(new String[] {"1","1"});
//
//        DatabasePopulateService.main(new String[] {"1","1"});
        System.out.println(new DatabaseQueryService().getAllProjectswithCosts());
    }


}