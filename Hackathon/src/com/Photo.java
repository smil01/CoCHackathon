package com;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.google.gson.JsonObject;

public class Photo {
	public static JsonObject getInfo(String addr) {
		JsonObject map = new JsonObject();
		try {

			Metadata metadata = ImageMetadataReader.readMetadata(new File(addr));

			String Make = null, Model = null, time = null, x = null, y = null;

			for (Directory directory : metadata.getDirectories()) {
				for (Tag tag : directory.getTags()) {
					if (tag.getTagName().equals("Make")) {
						Make = tag.getDescription();
					} else if (tag.getTagName().equals("Model")) {
						Model = tag.getDescription();
					} else if (tag.getTagName().equals("Date/Time")) {
						time = tag.getDescription();
					} else if (tag.getTagName().equals("GPS Latitude")) {
						x = tag.getDescription().replaceAll(" ", "");
					} else if (tag.getTagName().equals("GPS Longitude")) {
						y = tag.getDescription().replaceAll(" ", "");
					}
				}
			}

			String xx = Double
					.toString((Double.parseDouble(x.substring(0, x.indexOf('°'))))
							+ (Double.parseDouble(x.substring(x.indexOf('°') + 1, x.indexOf('\''))) / 60)
							+ (Double.parseDouble(x.substring(x.indexOf('\'') + 1, x.indexOf('\"'))) / 3600));
			String yy = Double.toString((Double.parseDouble(y.substring(0, y.indexOf('°'))))
							+ (Double.parseDouble(y.substring(y.indexOf('°') + 1, y.indexOf('\''))) / 60)
							+ (Double.parseDouble(y.substring(y.indexOf('\'') + 1, y.indexOf('\"'))) / 3600));
			String machine = Model + "(" + Make + ")";
			
			String times = "";
			String[] arr = {"년", "월", "일  ", "시", "분", "초"};
			int temp = 0;
			for(int i = 0; i< time.length(); i++) {
				if(time.charAt(i)==':' || time.charAt(i)==' ') {
					times+=arr[temp++];
				} else {
					times+=time.charAt(i);
				}
			}
			times+=arr[temp++];
			
			map.addProperty("x", xx);
			map.addProperty("y", yy);
			map.addProperty("machine", machine);
			map.addProperty("time", times);

		} catch (Exception e) {
			map = null;
		}

		return map;
	}
}
