package tests;

import Utils.SqlUtils.Query;
import Utils.SqlUtils.SqlUtils;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class Test1 {
    private final String query = Query.getMinWorkingTime();
    @Test
    public void Run() throws SQLException {
        SqlUtils.execQuery(query, "project", "test", "min_working_time");
    }
}
