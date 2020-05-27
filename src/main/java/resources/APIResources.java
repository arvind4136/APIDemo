package resources;
//enum is a special class collection of constatns and methods

public enum APIResources {

	

	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	APIResources(String r){
		resource=r;
	}
	
	public String getresource(){
		return resource;
	}
}
