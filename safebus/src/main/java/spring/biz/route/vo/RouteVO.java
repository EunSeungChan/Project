package spring.biz.route.vo;

public class RouteVO {
	
	private String route;
	private String station;
	private String route_img;
	private double station_latitude;
	private double station_longitude;
	private int count;
	private int absent;
	private String description;
	private String car_number;
	
	
	public RouteVO() {
		super();
	}


	public RouteVO(String route, String station, String route_img, double station_latitude, double station_longitude,
			int count, int absent, String description, String car_number) {
		super();
		this.route = route;
		this.station = station;
		this.route_img = route_img;
		this.station_latitude = station_latitude;
		this.station_longitude = station_longitude;
		this.count = count;
		this.absent = absent;
		this.description = description;
		this.car_number = car_number;
	}


	public String getRoute() {
		return route;
	}


	public void setRoute(String route) {
		this.route = route;
	}


	public String getStation() {
		return station;
	}


	public void setStation(String station) {
		this.station = station;
	}


	public String getRoute_img() {
		return route_img;
	}


	public void setRoute_img(String route_img) {
		this.route_img = route_img;
	}


	public double getStation_latitude() {
		return station_latitude;
	}


	public void setStation_latitude(double station_latitude) {
		this.station_latitude = station_latitude;
	}


	public double getStation_longitude() {
		return station_longitude;
	}


	public void setStation_longitude(double station_longitude) {
		this.station_longitude = station_longitude;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getAbsent() {
		return absent;
	}


	public void setAbsent(int absent) {
		this.absent = absent;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCar_number() {
		return car_number;
	}


	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}


	@Override
	public String toString() {
		return "RouteVO [route=" + route + ", station=" + station + ", route_img=" + route_img + ", station_latitude="
				+ station_latitude + ", station_longitude=" + station_longitude + ", count=" + count + ", absent="
				+ absent + ", description=" + description + ", car_number=" + car_number + "]";
	}
	
	
	
}
