package com.termoncs.flowmovies.models;

public enum Genre {
    UNKNOWN,
    ACTION,
    CHILDREN,
    COMEDY,
    HORROR,
    ROMANCE,
    SCI_FI,
    THRILLER,
    WESTERN
}

// Doesnt work with mybatis EnumOrdinalTypeHandler​ which is turned on in application.properties
//public enum Genre {
//    UNKNOWN("Unknown"),
//    ACTION("Action"),
//    CHILDREN("Children"),
//    COMEDY("Comedy"),
//    HORROR("Horror"),
//    ROMANCE("Romance"),
//    SCI_FI("Sci-Fi"),
//    THRILLER("Thriller"),
//    WESTERN("Western");
//
//    private final String displayValue;
//
//    private Genre(String displayValue) { this.displayValue = displayValue; }
//    //public String getDisplayValue() { return displayValue; }
//    @Override
//    public String toString() { return displayValue; }
//}