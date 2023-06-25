package Ex3;

import java.util.List;

public class Movie {
    private final String Title;
    private final int Year;
    private final Person Director;
    private final Person Writer;
    private final String Series;
    private final List<Person> Cast;
    private final List<Place> Locations;
    private final List<String> Languages;
    private final List<String> Genres;
    private final boolean television;
    private final boolean netflix;
    private final boolean independent;

    public static class Builder {

        private final String Title ;
        private final int Year;
        private final Person Director;
        private final Person Writer;

        private String Series = null;
        private List<Person> Cast = null;
        private List<Place> Locations = null;
        private List<String> Languages = null;
        private List<String> Genres = null;
        private boolean television = false;
        private boolean netflix = false;
        private boolean independent = false;

        public Builder(String Title,int Year,Person Director,Person Writer) {
                this.Title = Title;
                this.Year = Year;
                this.Director = Director;
                this.Writer = Writer;
        }

        public Builder series(String Series) {
            this.Series = Series;
            return this;
        }

        public Builder cast( List<Person> Cast) {
            this.Cast = Cast;
            return this;
        }

        public Builder locations(List<Place> Locations) {
            this.Locations = Locations;
            return this;
        }

        public Builder languages( List<String> Languages) {
            this.Languages = Languages;
            return this;
        }

        public Builder genres( List<String> Genres) {
            this.Genres = Genres;
            return this;
        }

        public Builder television( boolean television) {
            this.television = television;
            return this;
        }

        public Builder netflix( boolean netflix) {
            this.netflix = netflix;
            return this;
        }

        public Builder independent( boolean independent) {
            this.independent = independent;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    private Movie(Builder builder) {
        Title = builder.Title;
        Year = builder.Year;
        Director = builder.Director;
        Writer = builder.Writer;
        Series = builder.Series;
        Cast = builder.Cast;
        Locations = builder.Locations;
        Languages = builder.Languages;
        Genres = builder.Genres;
        television = builder.television;
        netflix = builder.netflix;
        independent = builder.independent;  
    }
}