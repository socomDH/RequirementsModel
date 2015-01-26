package pl.edu.agh;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ZTBApplicationConfiguration extends Configuration {
//    @NotEmpty
//    private String template;
//
//    @NotEmpty
//    private String defaultName = "Stranger";
//
//    @JsonProperty
//    public String getTemplate() {
//        return template;
//    }
//
//    @JsonProperty
//    public void setTemplate(String template) {
//        this.template = template;
//    }
//
//    @JsonProperty
//    public String getDefaultName() {
//        return defaultName;
//    }
//
//    @JsonProperty
//    public void setDefaultName(String defaultName) {
//        this.defaultName = defaultName;
//    }
    
    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();
    
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

}
