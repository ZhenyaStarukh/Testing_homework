package enums;

public enum UkraineLocations {
    LVIV("Lviv",
            "https://www.google.com/maps/place/EPAM+Systems/@49.8095285," +
            "24.0436381,17z/data=!3m1!4b1!4m5!3m4!1s0x473ae7c0f43f1bdf:0xe269177e40b0f387!8m2!" +
            "3d49.8095251!4d24.0458268?shorturl=1"),
    DNIPRO("Dnipro",
            "https://www.google.com/maps/place/Barykadna+St,+16,+Dnipropetrovs'k," +
            "+Dnipropetrovs'ka+oblast,+Ukraine,+49000/@48.4625959,35.0530123,17z/data=!3m1!4b1!" +
            "4m5!3m4!1s0x40dbe2db5d9bbbd5:0xe907ee33905e9feb!8m2!3d48.4625959!4d35.055201?hl=en&shorturl=1"),
    KHARKIV("Kharkiv",
            "https://www.google.com/maps/place/Epam%20Systems/" +
            "@50.0354614,36.2178303,17z/_data=!4m12!1m6!3m5!1s0x4127a6b4ec8de933_" +
            "0xf8300dc54356b778!2s23%20Serpnia!8m2!3d50.035458!4d36.220019!3m4!1s0x41" +
            "27a131b25962f9:0x51992032d0c2e7be!8m2!3d50.0371529!4d36.2180655"),
    VINNYTSIA("Vinnytsia",
            "https://www.google.com/maps/search/51+Kozitskogo+S" +
            "treet+Vinnytsia,+Ukraine/@49.2334869,28.4707423,17z/data=!3m1!4b1"),
    KYIV_VISITORS_OFFICE("Kyiv: Visitors office",
            "https://www.google.com/maps/place/Kudryashova" +
            "%20St,%2014b,%20Kyiv,%20Ukraine,%2003035/@50.4314743,30.4852715,17z" +
            "/_data=!3m1!4b1!4m5!3m4!1s0x40d4cee98e046ebd_0xf37a6e0bf8259abe!8m2!" +
            "3d50.4314709!4d30.4874602");

    private final String locationName;
    private final String locationURL;

    UkraineLocations (String locationName, String locationURL) {
        this.locationName = locationName;
        this.locationURL = locationURL;
    }

    public String getLocationURL() {
        return  locationURL;
    }

    public String getLocationName() {
        return locationName;
    }
}
