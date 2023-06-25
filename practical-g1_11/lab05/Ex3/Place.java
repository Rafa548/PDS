package Ex3;

public class Place {
    private final String name;
    private final String address;
    private final String city;
    private final String state;
    private final String country;
    private final String zipCode;

    public Place(
        final String placeName,
        final String placeAddress,
        final String placeCity,
        final String placeState,
        final String placeCountry,
        final String placeZipCode) {
            this.name = placeName;
            this.address = placeAddress;
            this.city = placeCity;
            this.state = placeState;
            this.country = placeCountry;
            this.zipCode = placeZipCode;
    }

}
