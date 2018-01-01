package info.smartkit.shiny.guide.service.impl;

import info.smartkit.shiny.guide.domain.dto.KKBoxPerfObject;
import info.smartkit.shiny.guide.service.RecommendService;
import info.smartkit.shiny.guide.utils.MahoutUtils;
import org.apache.mahout.cf.taste.common.TasteException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<RecommendedItem> userCF(DataModel model) throws TasteException, IOException {
        return  MahoutUtils.userCF(this.getDataModel());
    }

    @Override
    public List<RecommendedItem> itemCF(DataModel model) throws TasteException, IOException {
        return MahoutUtils.itemCF(this.getDataModel());
    }

    @Override
    public List<KKBoxPerfObject> getKkBoxPerfObjectsFromSQL(String whereBy,String uid) {
        //
        String SQL_member_song_target = "SELECT msno,song_id,target FROM train WHERE "+whereBy+" ='"+uid+"'";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(SQL_member_song_target);
        List<KKBoxPerfObject> kkBoxPerfObjectArrayList = new ArrayList<KKBoxPerfObject>();
        //
        while (rows.next()) {
            //
            int colCount = rows.getMetaData().getColumnCount();
            KKBoxPerfObject kkBoxPerfObject = new KKBoxPerfObject();
            for (int i = 1; i <= colCount; i++) {
                kkBoxPerfObject.setMsno(rows.getString("msno"));
                kkBoxPerfObject.setSong_id(rows.getString("song_id"));
                kkBoxPerfObject.setTarget(rows.getInt("target"));
            }
            kkBoxPerfObjectArrayList.add(kkBoxPerfObject);
        }
        return kkBoxPerfObjectArrayList;
    }

    @Override
    public DataModel getDataModel(List<KKBoxPerfObject> kkBoxPerfObjectList) throws IOException {
        File dataFile = KKBoxUtils.getCurrentMahoutUserBehaviorFile(kkBoxPerfObjectList);
        //
        DataModel dataModel  = new FileDataModel(dataFile);
        return dataModel;
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
