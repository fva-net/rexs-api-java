package info.rexs.io.json.model.attributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
    @JsonSubTypes.Type(value = BooleanAttribute.class, name = "boolean"),
    @JsonSubTypes.Type(value = EnumAttribute.class, name = "enum"),
    @JsonSubTypes.Type(value = FloatingPointAttribute.class, name = "FloatingPointAttribute"),
    @JsonSubTypes.Type(value = IntegerAttribute.class, name = "IntegerAttribute"),
    @JsonSubTypes.Type(value = StringAttribute.class, name = "StringAttribute"),
    @JsonSubTypes.Type(value = DateTimeAttribute.class, name = "DateTimeAttribute"),

    @JsonSubTypes.Type(value = BooleanArrayAttribute.class, name = "BooleanArrayAttribute"),
    @JsonSubTypes.Type(value = EnumArrayAttribute.class, name = "EnumArrayAttribute"),
    @JsonSubTypes.Type(value = FloatingPointArrayAttribute.class, name = "FloatingPointArrayAttribute"),
    @JsonSubTypes.Type(value = IntegerArrayAttribute.class, name = "IntegerArrayAttribute"),
    @JsonSubTypes.Type(value = StringArrayAttribute.class, name = "StringArrayAttribute"),

    @JsonSubTypes.Type(value = BooleanMatrixAttribute.class, name = "BooleanMatrixAttribute"),
    @JsonSubTypes.Type(value = FloatingPointMatrixAttribute.class, name = "FloatingPointMatrixAttribute"),
    @JsonSubTypes.Type(value = IntegerMatrixAttribute.class, name = "IntegerMatrixAttribute"),
    @JsonSubTypes.Type(value = StringMatrixAttribute.class, name = "StringMatrixAttribute"),
    
    @JsonSubTypes.Type(value = ArrayOfIntegerArraysAttribute.class, name = "ArrayOfIntegerArraysAttribute"),
    

    @JsonSubTypes.Type(value = FileReferenceAttribute.class, name = "FileReferenceAttribute"),
    @JsonSubTypes.Type(value = ReferenceComponentAttribute.class, name = "ReferenceComponentAttribute")
 }
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id", "unit"
})
public abstract class Attribute {

    @JsonProperty("id")
    protected String id;

    @JsonProperty("unit")
    protected String unit;
    
    @JsonIgnore
    protected Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Attribute withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Attribute withUnit(String unit) {
        this.unit = unit;
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

    public Attribute withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.unit == null)? 0 :this.unit.hashCode()));
        return result;
    }

    protected void appendId(StringBuilder sb){
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
    }

    protected void appendUnit(StringBuilder sb){
        if(unit != null){
            sb.append("unit");
            sb.append('=');
            sb.append(((this.unit == null)?"<null>":this.unit));
            sb.append(',');
        }
    }

    protected <T> void appendArray(List<T> list, StringBuilder sb){
        sb.append('[');
        for(T t: list){
            sb.append(t.toString());
            sb.append(',');
        }
        sb.setCharAt(sb.length()-1,']');
    }

    protected <T> void appendMatrix(List<List<T>> list, StringBuilder sb){
        sb.append('[');
        for(List<T> t: list){
            appendArray(list, sb);
            sb.append(',');
        }
        sb.setCharAt(sb.length()-1,']');
    }
}
