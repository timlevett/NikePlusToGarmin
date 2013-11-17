package com.timlevett.nptg.util;

import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import com.topografix.gpx._1._0.Gpx;

public class GpxToOutputStream {
	public void getOutputstream(Gpx gpx, OutputStream os) throws Exception {
		try {
			JAXBContext jc10 = JAXBContext.newInstance("com.topografix.gpx._1._0");
			Marshaller marshaller = jc10.createMarshaller();
			
			marshaller.marshal(gpx, os);
			return;
		} catch(Exception e) {
			// Ignore.
		}
		
		// Try 1.1
		try {
			JAXBContext jc11 = JAXBContext.newInstance("com.topografix.gpx._1._1");
			Marshaller marshaller = jc11.createMarshaller();
			marshaller.marshal(gpx, os);
		} catch(Exception e) {
			throw new Exception("Unable to marshall gpx object", e);
		}
	}
}
