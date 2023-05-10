package org.mvnsearch.testcontainers.demo;

import com.github.database.rider.core.api.dataset.DataSet;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.io.FileOutputStream;

/**
 * database basic test: generate database.dtd
 *
 * @author linux_china
 */
public class DataBaseTest extends TestcontainersBaseTest {
    @Autowired
    private DataSource dataSource;

    /**
     * Database Rider and JUnit5
     * test if database is ready
     */
    @Test
    @DataSet("db/datasets/users.xml")
    public void testLoadDataset() {
        Assertions.assertTrue(true);
    }

    /**
     * Database Rider and JUnit5
     * generate database.dtd to detect database changes
     */
    @Test
    public void testDTDGeneration() throws Exception {
        DatabaseConnection databaseConnection = new DatabaseConnection(dataSource.getConnection());
        final IDataSet dataSet = databaseConnection.createDataSet();
        FlatDtdDataSet.write(dataSet, new FileOutputStream("database.dtd"));
        FlatDtdDataSet.write(dataSet, new FileOutputStream("src/test/resources/db/datasets/database.dtd"));
    }
}
