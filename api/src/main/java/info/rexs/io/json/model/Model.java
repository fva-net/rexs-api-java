package info.rexs.io.json.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "version",
    "applicationId",
    "applicationVersion",
    "date",
    "applicationLanguage",
    "relations",
    "components",
    "load_spectrum"
})
public class Model {

    @JsonProperty("version")
    private String version;
    @JsonProperty("applicationId")
    private String applicationId;
    @JsonProperty("applicationVersion")
    private String applicationVersion;
    @JsonProperty("date")
    private String date;
    @JsonProperty("applicationLanguage")
    private String applicationLanguage;
    @JsonProperty("relations")
    private List<Relation> relations = new ArrayList<>();
    @JsonProperty("components")
    private List<Component> components = new ArrayList<>();
    @JsonProperty("load_spectrum")
    private LoadSpectrum loadSpectrum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Model withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("applicationId")
    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty("applicationId")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Model withApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    @JsonProperty("applicationVersion")
    public String getApplicationVersion() {
        return applicationVersion;
    }

    @JsonProperty("applicationVersion")
    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public Model withApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
        return this;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public Model withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonProperty("applicationLanguage")
    public String getApplicationLanguage() {
        return applicationLanguage;
    }

    @JsonProperty("applicationLanguage")
    public void setApplicationLanguage(String applicationLanguage) {
        this.applicationLanguage = applicationLanguage;
    }

    public Model withApplicationLanguage(String applicationLanguage) {
        this.applicationLanguage = applicationLanguage;
        return this;
    }

    @JsonProperty("relations")
    public List<Relation> getRelations() {
        return relations;
    }

    @JsonProperty("relations")
    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public Model withRelations(List<Relation> relations) {
        this.relations = relations;
        return this;
    }

    @JsonProperty("components")
    public List<Component> getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Model withComponents(List<Component> components) {
        this.components = components;
        return this;
    }

    @JsonProperty("load_spectrum")
    public LoadSpectrum getLoadSpectrum() {
        return loadSpectrum;
    }

    @JsonProperty("load_spectrum")
    public void setLoadSpectrum(LoadSpectrum loadSpectrum) {
        this.loadSpectrum = loadSpectrum;
    }

    public Model withLoadSpectrum(LoadSpectrum loadSpectrum) {
        this.loadSpectrum = loadSpectrum;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Model withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Model.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("applicationId");
        sb.append('=');
        sb.append(((this.applicationId == null)?"<null>":this.applicationId));
        sb.append(',');
        sb.append("applicationVersion");
        sb.append('=');
        sb.append(((this.applicationVersion == null)?"<null>":this.applicationVersion));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("applicationLanguage");
        sb.append('=');
        sb.append(((this.applicationLanguage == null)?"<null>":this.applicationLanguage));
        sb.append(',');
        sb.append("relations");
        sb.append('=');
        sb.append(((this.relations == null)?"<null>":this.relations));
        sb.append(',');
        sb.append("components");
        sb.append('=');
        sb.append(((this.components == null)?"<null>":this.components));
        sb.append(',');
        sb.append("loadSpectrum");
        sb.append('=');
        sb.append(((this.loadSpectrum == null)?"<null>":this.loadSpectrum));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.applicationVersion == null)? 0 :this.applicationVersion.hashCode()));
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.components == null)? 0 :this.components.hashCode()));
        result = ((result* 31)+((this.applicationLanguage == null)? 0 :this.applicationLanguage.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.applicationId == null)? 0 :this.applicationId.hashCode()));
        result = ((result* 31)+((this.relations == null)? 0 :this.relations.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.loadSpectrum == null)? 0 :this.loadSpectrum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Model) == false) {
            return false;
        }
        Model rhs = ((Model) other);
        return ((((((((((this.applicationVersion == rhs.applicationVersion)||((this.applicationVersion!= null)&&this.applicationVersion.equals(rhs.applicationVersion)))&&((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date))))&&((this.components == rhs.components)||((this.components!= null)&&this.components.equals(rhs.components))))&&((this.applicationLanguage == rhs.applicationLanguage)||((this.applicationLanguage!= null)&&this.applicationLanguage.equals(rhs.applicationLanguage))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.applicationId == rhs.applicationId)||((this.applicationId!= null)&&this.applicationId.equals(rhs.applicationId))))&&((this.relations == rhs.relations)||((this.relations!= null)&&this.relations.equals(rhs.relations))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.loadSpectrum == rhs.loadSpectrum)||((this.loadSpectrum!= null)&&this.loadSpectrum.equals(rhs.loadSpectrum))));
    }

}
