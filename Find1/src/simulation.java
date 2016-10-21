import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import csvreader.CsvReader;
import csvreader.CsvWriter;

public class simulation {
	public static void wtiteHead(CsvWriter wr) throws IOException{
		String[] contents = {"Program","Number of seeded faults",
		"Number of test cases","Number of detected fault ","Coverage rate",
		"Number of test cases(delete 20%)","Number of detected fault(delete 20%)","Coverage rate",
		"Number of test cases(delete 60%)","Number of detected fault(delete 60%)","Coverage rate",
		"Number of test cases(delete 60%)","Number of detected fault(delete 60%)","Coverage rate",
		"Number of test cases(delete 80%)","Number of detected fault(delete 80%)","Coverage rate",
		};                    
		wr.writeRecord(contents);
	}
	
	public static void generateAnotherTable(String filename) throws IOException{
		
        CsvReader r = new CsvReader(filename+".csv", ',',Charset.forName("utf8"));
        CsvWriter w1 = new CsvWriter(filename+"_path.csv",',',Charset.forName("utf8"));
        CsvWriter w2 = new CsvWriter(filename+"_multi.csv",',',Charset.forName("utf8"));
        
        String[] secondLine = {"NTC","NDF1"	,"NDF2"	,"NDF3","NDF4",	"NDF5"	,"Average NDF"};
        
        String[] contents = {filename+"(path)"};
        w1.writeRecord(contents);
        w1.writeRecord(secondLine);
        
        String[] contents1 = {filename+"(multiple)"};
        w2.writeRecord(contents1);
        w2.writeRecord(secondLine);
        
        String[][] table_path = new String[5][];
        for(int i = 0; i < table_path.length; i++){
        	table_path[i] = new String[]{};
        }
        
        String[][] table_multiple = new String[5][];
        for(int i = 0; i < table_multiple.length; i++){
        	table_multiple[i] = new String[]{};
        }
        
        boolean first = true;
        boolean second = true;
        r.readHeaders();
        while (r.readRecord()) {
        	if(r.get(0).equals( filename+"(path)")){
        		if(first){
        			first = false;
        			table_path[0] = Tool.add(table_path[0], r.get(2));
        			table_path[1] = Tool.add(table_path[1], r.get(5));
        			table_path[2] = Tool.add(table_path[2], r.get(8));
        			table_path[3] = Tool.add(table_path[3], r.get(11));
        			table_path[4] = Tool.add(table_path[4], r.get(14));
        		}
    			table_path[0] = Tool.add(table_path[0], r.get(3));
    			table_path[1] = Tool.add(table_path[1], r.get(6));
    			table_path[2] = Tool.add(table_path[2], r.get(9));
    			table_path[3] = Tool.add(table_path[3], r.get(12));
    			table_path[4] = Tool.add(table_path[4], r.get(15));
    			
        		//Program1(path),10,36,5,100.0%,28,5,80.0%,20,5,60.0%,12,5,40.0%,4,4,20.0%
//        		System.out.println(r.getRawRecord());
        	}else{
        		if(second){
        			second = false;
        			table_multiple[0] = Tool.add(table_multiple[0], r.get(2));
        			table_multiple[1] = Tool.add(table_multiple[1], r.get(5));
        			table_multiple[2] = Tool.add(table_multiple[2], r.get(8));
        			table_multiple[3] = Tool.add(table_multiple[3], r.get(11));
        			table_multiple[4] = Tool.add(table_multiple[4], r.get(14));
        		}
        		table_multiple[0] = Tool.add(table_multiple[0], r.get(3));
        		table_multiple[1] = Tool.add(table_multiple[1], r.get(6));
        		table_multiple[2] = Tool.add(table_multiple[2], r.get(9));
        		table_multiple[3] = Tool.add(table_multiple[3], r.get(12));
        		table_multiple[4] = Tool.add(table_multiple[4], r.get(15));
        	}
        }
        
        
        for(int i = 0; i < table_path.length; i++){
        	double sum = 0f;
        	for(int j = 1; j < table_path[i].length; j++){
        		sum += Double.parseDouble(table_path[i][j]);
        	}
        	table_path[i] = Tool.add(table_path[i] , sum / (table_path[i].length-1)+"");
        	w1.writeRecord(table_path[i]);
        }
        
        for(int i = 0; i < table_multiple.length; i++){
        	double sum = 0f;
        	for(int j = 1; j < table_multiple[i].length; j++){
        		sum += Double.parseDouble(table_multiple[i][j]);
        	}
        	table_multiple[i] = Tool.add(table_multiple[i] , sum / (table_multiple[i].length-1)+"");
        	w2.writeRecord(table_multiple[i]);
//        	w2.writeRecord(table_multiple[i]);
        }
        
        
        w1.close();
        w2.close();
        r.close();
	}
	public static void main(String[] args) throws IOException {
		int programnum = 4;
//		CsvWriter
		CsvWriter wr1 = new CsvWriter("Program1.csv",',',Charset.forName("utf8"));
		CsvWriter wr2 = new CsvWriter("Program2.csv",',',Charset.forName("utf8"));
		CsvWriter wr3 = new CsvWriter("Program3.csv",',',Charset.forName("utf8"));
		CsvWriter wr4 = new CsvWriter("Program4.csv",',',Charset.forName("utf8"));
		
		simulation.wtiteHead(wr1);
		simulation.wtiteHead(wr2);
		simulation.wtiteHead(wr3);
		simulation.wtiteHead(wr4);
	
		int num = 5;
		for(int i = 0; i < num; i++){
			program1.generateData(wr1);
		}
		wr1.close();
//		wr.writeRecord(new String[]{""});
		for(int i = 0; i < num; i++){
			program2.generateData(wr2);
		}
		wr2.close();
//		wr.writeRecord(new String[]{""});
		for(int i = 0; i < num; i++){
			program3.generateData(wr3);
		}
		wr3.close();
//		wr.writeRecord(new String[]{""});
		for(int i = 0; i < num; i++){
			program4.generateData(wr4);
		}
		wr4.close();
		
		simulation.generateAnotherTable("Program1");
		simulation.generateAnotherTable("Program2");
		simulation.generateAnotherTable("Program3");
		simulation.generateAnotherTable("Program4");
		System.out.println("generate success in the Find1");
	}
}
