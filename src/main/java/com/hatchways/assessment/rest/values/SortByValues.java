package com.hatchways.assessment.rest.values;

public enum SortByValues {

    ID("id"),
    READS("reads"),
    LIKES("likes"),
    POPULARITY("popularity");

    private final String value;

    SortByValues(String value) {
        this.value = value;
    }

    public static SortByValues fromString(String value){
        for (SortByValues v : SortByValues.values()) {
            if (v.value.equalsIgnoreCase(value)) {
                return v;
            }
        }
        return null;
    }
}
