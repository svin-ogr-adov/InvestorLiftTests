package Potroha;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Read_Property_File {
	Read_Property_File() throws IOException{
		reader= new FileInputStream("config.properties");
		props = new Properties();
		props.load(reader);
	}

	Properties props;
	FileInputStream reader;
}
