import java.io.IOException;
import java.nio.charset.Charset;

import csvreader.CsvWriter;

public class simulation {
	public static void main(String[] args) throws IOException {
		CsvWriter wr =new CsvWriter("info.csv",',',Charset.forName("utf8"));
		String[] contents = {"Program","Number of seeded faults",
		"Number of test cases","Number of detected fault ","Coverage rate",
		"Number of test cases","Number of detected fault  (delete 20%)","Coverage rate",
		"Number of test cases","Number of detected fault  (delete 40%)","Coverage rate",
		"Number of test cases","Number of detected fault  (delete 60%)","Coverage rate",
		"Number of test cases","Number of detected fault  (delete 80%)","Coverage rate",
		};                    
		wr.writeRecord(contents);
		
		for(int i = 0; i < 5; i++){
			program1.generateData(wr);
		}
		wr.writeRecord(new String[]{""});
		for(int i = 0; i < 5; i++){
			program2.generateData(wr);
		}
		wr.writeRecord(new String[]{""});
		for(int i = 0; i < 5; i++){
			program3.generateData(wr);
		}
		wr.writeRecord(new String[]{""});
		for(int i = 0; i < 5; i++){
			program4.generateData(wr);
		}
		
//		wr.writeRecord(contents1);
		wr.close();
		System.out.println("generate success in the Find1");
	}
}
