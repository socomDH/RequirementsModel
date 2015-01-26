package pl.edu.agh.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdResponse {
    
    @JsonProperty
    private final long id;

    public IdResponse(long id) {
        this.id = id;
    }
    
}
