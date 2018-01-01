package info.smartkit.shiny.guide.service;

import info.smartkit.shiny.guide.domain.dto.KKBoxPerfObject;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RecommendService {
    List<RecommendedItem> userCF(DataModel model)throws TasteException,IOException;
    List<RecommendedItem> itemCF(DataModel model)throws TasteException,IOException;
    //
    List<KKBoxPerfObject> getKkBoxPerfObjectsFromSQL(String whereBy,String uid);
    DataModel getDataModel(List<KKBoxPerfObject> kkBoxPerfObjectList) throws IOException;
}
