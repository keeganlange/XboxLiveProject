package yahoo.testcase.account;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.Factory;

public class YahooEditAccountDataLoader {
	
	public static List<List<CSVRecord>> records;

	//@Factory
	public Object[] dataLoader() throws IOException {
		ArrayList<Reader> csvData = new ArrayList<Reader>();
		csvData.add(new FileReader("./testdata/yahoo/test_home_address.csv")); 
		csvData.add(new FileReader("./testdata/yahoo/test_home_fax.csv")); 
		csvData.add(new FileReader("./testdata/yahoo/test_home_phone.csv")); 
		csvData.add(new FileReader("./testdata/yahoo/test_mobile.csv")); 
		csvData.add(new FileReader("./testdata/yahoo/test_name.csv")); 
		//csvData.add(new FileReader("testdata/yahoo/test_success.csv")); 
		csvData.add(new FileReader("./testdata/yahoo/test_work_address.csv")); 
		csvData.add(new FileReader("./testdata/yahoo/test_work_fax.csv")); 
		csvData.add(new FileReader("./testdata/yahoo/test_work_phone.csv")); 
		
		records.add(CSVFormat.EXCEL.withHeader().parse(csvData.get(4)).getRecords());
		records.add(CSVFormat.EXCEL.withHeader().parse(csvData.get(0)).getRecords());
		records.add(CSVFormat.EXCEL.withHeader().parse(csvData.get(5)).getRecords());
		//records.add(CSVFormat.EXCEL.withHeader().parse(csvData.get(1)).getRecords());
		//records.add(CSVFormat.EXCEL.withHeader().parse(csvData.get(2)).getRecords());
		//records.add(CSVFormat.EXCEL.withHeader().parse(csvData.get(3)).getRecords());
		//records.add(CSVFormat.EXCEL.withHeader().parse(csvData.get(6)).getRecords());
		//records.add(CSVFormat.EXCEL.withHeader().parse(csvData.get(7)).getRecords());
		//records.add(CSVFormat.EXCEL.withHeader().parse(csvData.get(5)).getRecords());
		
		Object[] data = new Object[records.get(0).size()];
		
		//for (CSVRecord record : records.get(0))
		for (int i = 0; i < records.size(); i++)
		{
			//There is probably a better way to do this with the iterator
			//data[(int) records.get(0).get(i).getRecordNumber()-1] = new YahooEditAccountInfoMult(records,i);
			//System.out.println(records.get(0).get(i).get(0));
		}
		
		//Returns array of testResult objects
		return data;
	}
	

}
