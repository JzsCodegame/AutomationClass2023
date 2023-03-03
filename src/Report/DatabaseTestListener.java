package Report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;


import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import com.datastax.oss.driver.api.core.auth.Authenticator;


public class DatabaseTestListener extends TestListenerAdapter {

    private static final String DB_URL = "jdbc:ncluster://<your-asterdb-hostname>:2406/<your-asterdb-database-name>";
    private static final String LOG_TABLE = "logging.";
    private static final String TOKEN_FILE = "<path-to-token-file>";

    private CqlSession session;

    @Override
    public void onStart(ITestContext testContext) {
    	try (CqlSession session = CqlSession.builder()
                .withCloudSecureConnectBundle(Paths.get(TOKEN_FILE))
                .withAuthCredentials("MyFIeCnsiUpUXKcjZIGIsflP","6lOLhc-4CScUZDnm.5K6hEx.x1sZ5pDxx5XXOi-Sv7vxMzrClZI7xFrQacz0TTulosw5Jx+PfnuWrraBDX.Fwrnn4nUkTF,4Mb0hCvBuZ0D_ZxM2pYz,xH6afDQ06ee")
                .build()) {
            // your code goes here
        }
    }
    @Override
    public void onFinish(ITestContext testContext) {
        session.close(); ;
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        insertLog(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        insertLog(tr);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        insertLog(tr);
    }

    private void insertLog(ITestResult tr) {
        try {
            PreparedStatement pstmt = (PreparedStatement) session.prepare("INSERT INTO " + LOG_TABLE + " (test_name, status, log_file) VALUES (?, ?, ?)");
            pstmt.setString(1, tr.getName());
            pstmt.setString(2, getStatus(tr.getStatus()));
            pstmt.setString(3, getLogFile(tr));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getStatus(int status) {
        switch (status) {
            case ITestResult.SUCCESS:
                return "PASS";
            case ITestResult.FAILURE:
                return "FAIL";
            case ITestResult.SKIP:
                return "SKIP";
            default:
                return "UNKNOWN";
        }
    }

    private String getLogFile(ITestResult tr) {
        File logFile = new File(tr.getTestContext().getOutputDirectory(), tr.getName() + ".txt");
        try {
            return logFile.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
