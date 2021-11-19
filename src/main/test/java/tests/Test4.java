package tests;

import Utils.SqlUtils.Query;
import Utils.SqlUtils.SqlUtils;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class Test4 {
    public final String query = Query.getBrowsersUsed();
    @Test
    public void Run() throws SQLException {
        SqlUtils.execQuery(query, "browsers");
    }
}
