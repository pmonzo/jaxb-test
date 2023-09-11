package es.pmonzo.jaxb.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Demo10MB {

	private String data;
	
	public Demo10MB() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< 10000; i++) {
			sb.append(i);
		}
		data = sb.toString();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
