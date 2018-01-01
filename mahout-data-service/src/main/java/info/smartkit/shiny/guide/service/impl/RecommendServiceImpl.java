package info.smartkit.shiny.guide.service.impl;

import info.smartkit.shiny.guide.service.RecommendService;
import info.smartkit.shiny.guide.utils.MahoutUtils;
import org.apache.mahout.cf.taste.common.TasteException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Override
    public List<RecommendedItem> userCF(DataModel model) throws TasteException, IOException {
        return  MahoutUtils.userCF(this.getDataModel());
    }

    @Override
    public List<RecommendedItem> itemCF(DataModel model) throws TasteException, IOException {
        return MahoutUtils.itemCF(this.getDataModel());
    }

    private DataModel getDataModel() throws IOException {
        DataModel dataModel = new FileDataModel(new File(KKBoxUtils.CSV_BEAN_FILE));
        return dataModel;
    }


    //TODO：
    //@see:http://mahout.apache.org/users/recommender/recommender-documentation.html
    //@see:http://h2database.com/javadoc/org/h2/jdbcx/JdbcDataSource.html
    //@see:http://mahout.apache.org/users/recommender/recommender-documentation.html
    private JDBCDataModel getJDBCDataModel() throws NamingException, SQLException {

        //Creating data model
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setServerName(dataBaseSettings.getServer());
//        dataSource.setUser(dataBaseSettings.getUsername());
//        dataSource.setPassword(dataBaseSettings.getPassword());
//        dataSource.setDatabaseName(dataBaseSettings.getDatabase());
//        JDBCDataModel datamodel = new MySQLJDBCDataModel(dataSource,
//                "user_info", "id", "item_id", "consult_id", null);

//        JdbcDataSource ds = new JdbcDataSource();
//        ds.setURL("jdbc:h2:˜/test");
//        ds.setUser("sa");
//        ds.setPassword("sa");
//        Context ctx = new InitialContext();
//        ctx.bind("jdbc/dsName", ds);
//        //
//        Connection conn = ds.getConnection();
//        //TODO:JDBCDataModel...
//        JDBCDataModel datamodel = conn.
//        return datamodel;
        return null;
    }

}
