package Leaseplan.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ObjectReader {
	private Properties property = new Properties();

	public final Properties getObjectRepository(String filename) throws IOException {
		// Read object repository file
		File propertiesFile = new File(ConstantPath.PROPERTIES_FOLDER_PATH + filename + ".properties");		
		InputStream stream;
		if (propertiesFile.exists()) {
			stream = new FileInputStream(propertiesFile);
		} else {
			stream = ObjectReader.class.getClassLoader().getResourceAsStream("properties/" + filename + ".properties");
		}

		// load all objects
		property.load(stream);
		return property;
	}
}