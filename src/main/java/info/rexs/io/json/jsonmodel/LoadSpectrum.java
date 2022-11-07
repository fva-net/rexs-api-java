package info.rexs.io.json.jsonmodel;
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
    "id",
    "load_cases",
    "accumulation"
})

public class LoadSpectrum {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("load_cases")
    private List<LoadCase> loadCases = new ArrayList<>();
    @JsonProperty("accumulation")
    private Accumulation accumulation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public LoadSpectrum withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("load_cases")
    public List<LoadCase> getLoadCases() {
        return loadCases;
    }

    @JsonProperty("load_cases")
    public void setLoadCases(List<LoadCase> loadCases) {
        this.loadCases = loadCases;
    }

    public LoadSpectrum withLoadCases(List<LoadCase> loadCases) {
        this.loadCases = loadCases;
        return this;
    }

    @JsonProperty("accumulation")
    public Accumulation getAccumulation() {
        return accumulation;
    }

    @JsonProperty("accumulation")
    public void setAccumulation(Accumulation accumulation) {
        this.accumulation = accumulation;
    }

    public LoadSpectrum withAccumulation(Accumulation accumulation) {
        this.accumulation = accumulation;
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

    public LoadSpectrum withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        final String nullConstant = "<null>";
        StringBuilder sb = new StringBuilder();
        sb.append(LoadSpectrum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?nullConstant:this.id));
        sb.append(',');
        sb.append("loadCases");
        sb.append('=');
        sb.append(((this.loadCases == null)?nullConstant:this.loadCases));
        sb.append(',');
        sb.append("accumulation");
        sb.append('=');
        sb.append(((this.accumulation == null)?nullConstant:this.accumulation));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?nullConstant:this.additionalProperties));
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
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.loadCases == null)? 0 :this.loadCases.hashCode()));
        result = ((result* 31)+((this.accumulation == null)? 0 :this.accumulation.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof LoadSpectrum)) {
            return false;
        }
        LoadSpectrum rhs = ((LoadSpectrum) other);
        return (((((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.loadCases == rhs.loadCases)||((this.loadCases!= null)&&this.loadCases.equals(rhs.loadCases))))&&((this.accumulation == rhs.accumulation)||((this.accumulation!= null)&&this.accumulation.equals(rhs.accumulation))));
    }

}
