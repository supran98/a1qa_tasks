package tests;

import Utils.SqlUtils.Query;
import Utils.SqlUtils.SqlUtils;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class Test3 {
    private final String datetime = "2015-11-07 00:00:00";
    private final String query = Query.getTestsLaterThan(datetime);
    @Test
    public void Run() throws SQLException {
        SqlUtils.execQuery(query, "project", "test", "date");
    }
}
