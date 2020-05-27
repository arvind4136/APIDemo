package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.addplace;

public class TestDataBuild {
	
	public pojo.addplace addplacepayload(String name,String lan,String address){
		addplace ap = new addplace();
		
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setLanguage(lan);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("http://google.com");
		
		List<String> al= new ArrayList<String>();
		al.add("shoe park");
		al.add("shop");
		ap.setTypes(al);
		
		
Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		ap.setLocation(l);
		
		return ap;
	}

	public String deleteplace(String placeid){
		System.out.println(placeid+" value is ");
		return "{\r\n       \"place_id\": \""+placeid+"\"\r\n}";
	//	return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}
