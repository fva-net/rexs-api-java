package info.rexs.io.json.jsonmodel.attributes;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "enum_array"
})

public class EnumArrayAttribute extends Attribute {

    @JsonProperty("enum_array")
    private List<String> enumArray = new ArrayList<>();

    @JsonProperty("enum_array")
    public List<String> getEnumArray() {
        return enumArray;
    }

    @JsonProperty("enum_array")
    public void setEnumArray(List<String> enumArray) {
        this.enumArray = enumArray;
    }

    public Attribute withEnumArray(List<String> enumArray) {
        this.enumArray = enumArray;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("enum_array");
        sb.append('=');
        
        appendArray(enumArray, sb);
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
        int result = super.hashCode();
        result = ((result* 31)+((this.enumArray == null)? 0 :this.enumArray.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof EnumArrayAttribute)) {
            return false;
        }
        EnumArrayAttribute rhs = ((EnumArrayAttribute) other);
        return (this.id.equals(rhs.getId())) 
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null) 
            && this.enumArray.containsAll(rhs.getEnumArray()) 
            && rhs.getEnumArray().containsAll(this.enumArray);
    }

}
