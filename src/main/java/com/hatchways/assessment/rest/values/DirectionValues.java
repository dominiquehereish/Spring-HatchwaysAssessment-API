package com.hatchways.assessment.rest.values;

public enum DirectionValues {

    ASC("asc"),
    DESC("desc");

    private String value;

    DirectionValues(String value) {
        this.value = value;
    }

    public static DirectionValues fromString(String value){
        for (DirectionValues v : DirectionValues.values()) {
            if (v.value.equalsIgnoreCase(value)) {
                return v;
            }
        }
        return null;
    }
}
