package info.smartkit.shiny.guide.service;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface RecommendService {
    List<RecommendedItem> userCF(JDBCDataModel model) throws TasteException, SQLException, NamingException;
    List<RecommendedItem> itemCF(JDBCDataModel model) throws TasteException, SQLException, NamingException;
}
