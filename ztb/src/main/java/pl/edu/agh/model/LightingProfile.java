package pl.edu.agh.model;

public class LightingProfile {

    private long id;
    
    private String name;
    
    private double value;
    
    public LightingProfile(long id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
    
}
