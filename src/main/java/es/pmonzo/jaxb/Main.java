package es.pmonzo.jaxb;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.xmlbeans.XmlObject;

import es.pmonzo.jaxb.data.Demo10MB;

public class Main {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			JAXBContext jc = JAXBContext.newInstance(Demo10MB.class);
			Object element = new Demo10MB();
			Marshaller m = jc.createMarshaller();

			Writer writer = new Writer() {

				@Override
				public void write(char[] cbuf, int off, int len) throws IOException {
					// TODO Auto-generated method stub
					System.out.println("writer output");
				}

				@Override
				public void flush() throws IOException {
					// TODO Auto-generated method stub
					System.out.println("writer flush");
				}

				@Override
				public void close() throws IOException {
					// TODO Auto-generated method stub
					System.out.println("writer close");
				}
			};
			m.marshal(element, writer);
			m.toString();
			Reader readerCustom = new Reader() {

				@Override
				public int read(char[] cbuf, int off, int len) throws IOException {
					System.out.println("Reader read");
					return -1;
				}

				@Override
				public void close() throws IOException {
					// TODO Auto-generated method stub
					System.out.println("Reader close");
				}
			};
			XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(readerCustom);

			XmlObject object = XmlObject.Factory.parse(reader);
			System.out.println(object.xmlText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
