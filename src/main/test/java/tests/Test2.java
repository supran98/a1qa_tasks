package tests;

import Utils.SqlUtils.Query;
import Utils.SqlUtils.SqlUtils;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class Test2 {
    String query = Query.getUniqueTestsCount();

    @Test
    public void Run() throws SQLException {
        SqlUtils.execQuery(query, "project", "tests_count");
    }
}
