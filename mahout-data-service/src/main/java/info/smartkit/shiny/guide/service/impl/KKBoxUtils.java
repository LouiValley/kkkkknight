package info.smartkit.shiny.guide.service.impl;

import com.mahout.rnd.customFileModel.indexGenerator;
import info.smartkit.shiny.guide.domain.dto.KKBoxPereference;
import info.smartkit.shiny.guide.domain.dto.KKBoxPerfObject;
import org.supercsv.cellprocessor.FmtBool;
import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@see:https://blogdotrichanchordotcom.wordpress.com/2015/11/12/user-based-collaborative-filtering-with-apache-mahout/
public class KKBoxUtils {

    public static final String CSV_BEAN_FILE = "target/writeWithCsvBeanWriter.csv";
    private static final long serialVersionUID = 1L;
    indexGenerator indexgenerator = new indexGenerator();

    //@see:
    public static List<KKBoxPereference> KKBoxPreferenceWeightCalculator(List<KKBoxPerfObject> kkBoxPerfObjectList){

        List<KKBoxPereference> kkBoxPereferenceList = new ArrayList<KKBoxPereference>();
        // convert the ArrayList
        for( final KKBoxPerfObject kkBoxPerfObject : kkBoxPerfObjectList ) {
            KKBoxPereference kkBoxPereference = new KKBoxPereference();
            indexGenerator indexgenerator_user_id = new indexGenerator();
            long userId = Long.parseLong(indexgenerator_user_id.toLongID(kkBoxPerfObject.getMsno())+"");
            kkBoxPereference.setUserId(userId);
            indexGenerator indexgenerator_item_id = new indexGenerator();
            long itemId = Long.parseLong(indexgenerator_item_id.toLongID(kkBoxPerfObject.getSong_id())+"");
            kkBoxPereference.setItemId(itemId);
            kkBoxPereference.setRating(kkBoxPerfObject.getTarget()*0.5);
            //
            kkBoxPereferenceList.add(kkBoxPereference);
        }

        return kkBoxPereferenceList;
    }

    //@see:http://super-csv.github.io/super-csv/examples_writing.html
    public static File getCurrentMahoutUserBehaviorFile(List<KKBoxPerfObject> kkBoxPerfObjectList) throws IOException {

        //
        List<KKBoxPereference> kkBoxPereferences = KKBoxPreferenceWeightCalculator(kkBoxPerfObjectList);

        ICsvBeanWriter beanWriter = null;
        try {
            beanWriter = new CsvBeanWriter(new FileWriter(CSV_BEAN_FILE),
                    CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the bean values to each column (names must match)
            final String[] header = new String[] { "userId", "itemId", "rating" };
            final CellProcessor[] processors = getCellProcessors();

            // write the header
//            beanWriter.writeHeader(header);

            // write the beans
            for( final KKBoxPereference kkBoxPereference : kkBoxPereferences ) {
                beanWriter.write(kkBoxPereference, header, processors);
            }

        }
        finally {
            if( beanWriter != null ) {
                beanWriter.close();
            }
        }
        return new File(CSV_BEAN_FILE);

    }

    /**
     * Sets up the processors used for the examples. There are 10 CSV columns, so 10 processors are defined. All values
     * are converted to Strings before writing (there's no need to convert them), and null values will be written as
     * empty columns (no need to convert them to "").
     * @see: http://super-csv.github.io/super-csv/examples_writing.html
     * @return the cell processors
     */
    private static CellProcessor[] getCellProcessors() {

        final CellProcessor[] processors = new CellProcessor[] {
                new UniqueHashCode(), // userId (must be unique)
                new UniqueHashCode(), // itemId (must be unique)
                new NotNull(), // rating
        };

        return processors;
    }


}
