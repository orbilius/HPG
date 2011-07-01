package se.orbilius.datagetter;

import java.io.File;
import java.io.IOException;

public abstract class DataFileGetter implements DataGetter {

	protected File file;

	public DataFileGetter() {
		super();
	}

	public DataFileGetter(String fileName) throws IOException {
		this.file = new File(fileName);
		if(!this.file.exists()){
			throw new IOException("Can't find file " + file);
		}
	}
}