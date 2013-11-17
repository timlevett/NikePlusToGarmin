package com.timlevett.nptg.transformer;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.joda.time.DateTime;
import org.joda.time.Duration;

import com.timlevett.nptg.model.Activity;
import com.timlevett.nptg.model.Coordinate;
import com.timlevett.nptg.model.GPSData;
import com.topografix.gpx._1._0.Gpx;
import com.topografix.gpx._1._0.Gpx.Trk;
import com.topografix.gpx._1._0.Gpx.Trk.Trkseg;
import com.topografix.gpx._1._0.Gpx.Trk.Trkseg.Trkpt;
import com.topografix.gpx._1._0.ObjectFactory;

public class TransformNikePlusToGPX {
	public Gpx toGPX(Activity npActivity, GPSData npGPSData) throws DatatypeConfigurationException {
		DateTime startDate = new DateTime(npActivity.getStartTime());
		Gpx gpx = new Gpx();		
		//metadata
		gpx.setAuthor("TimTim");
		gpx.setCreator("Tim Tim");
		gpx.setTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(startDate.toGregorianCalendar()));
		
		String dur = npActivity.getMetricSummary().getDuration();
		
		String hour = dur.substring(0,1);
		String minute = dur.substring(2,4);
		String second = dur.substring(5,7);
		
		long totalDuration = ((Integer.parseInt(hour))*60*60) +  ((Integer.parseInt(minute))*60) +  ((Integer.parseInt(second)));
		
		long size = npGPSData.getWaypoints().size();
		
		int milliseconds = Math.round((totalDuration / (float) size) * 1000);
		
		//waypoint data
		DateTime intervalTime = startDate;
		ObjectFactory of = new ObjectFactory();
		Trk trk = new Trk();
		Trkseg ts = of.createGpxTrkTrkseg();
		for(Coordinate wp : npGPSData.getWaypoints()) {
			Trkpt trkpt = of.createGpxTrkTrksegTrkpt();
			
			trkpt.setLat(wp.getLatitude());
			trkpt.setLon(wp.getLongitude());
			trkpt.setTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(intervalTime.toGregorianCalendar()));
			ts.getTrkpt().add(trkpt);
			intervalTime = intervalTime.plusMillis(milliseconds);
		}
		
		trk.getTrkseg().add(ts);
		gpx.getTrk().add(trk);
				
		return gpx;
	}
}
