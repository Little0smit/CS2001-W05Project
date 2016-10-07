import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputReader {
	private BufferedReader reader;
	InputReader(){
		reader = null;
	}
	public void openFile(String fileName) {
		if (fileName!= null) try {
            reader = new BufferedReader(new FileReader(fileName));
            System.out.println("File " + fileName + " opened");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file:" + fileName + ", ensure name is correct.");
        }
	}

	public String readLine() {
		String line = null;
		if (reader != null){
			try {
				line = reader.readLine();
			} catch (IOException e) {
				System.out.println("Unable to read from the file");
			}
		}
		return line;
	}

	public Boolean endOfFile(){
		if (reader != null){
			try {
				return !reader.ready();
			} catch (IOException e) {
				System.out.println("Unable to read from the file");
			}
		}
		return true;
	}

	public void closeFile(){
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Unable to close the file");
            }
        }
	}

}
