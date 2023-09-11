package es.pmonzo.jaxb.reader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CustomReader extends Reader{

	private Writer writer;
	private Object obj;
	
	
	public CustomReader(Writer writer, Object obj) {
		super();
		this.writer = writer;
		this.obj = obj;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		writer.write(cbuf, off, len);
		return 0;
	}

	@Override
	public void close() throws IOException {
		
		
	}

}
