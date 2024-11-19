package info.rexs.io.json.model.attributes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "string_array"
})

public class StringArrayAttribute extends Attribute {

    @JsonProperty("string_array")
    private List<String> stringArray = new ArrayList<>();

    @JsonProperty("string_array")
    public List<String> getStringArray() {
        return stringArray;
    }

    @JsonProperty("string_array")
    public void setStringArray(List<String> stringArray) {
        this.stringArray = stringArray;
    }

    public Attribute withStringArray(List<String> stringArray) {
        this.stringArray = stringArray;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("string_array");
        sb.append('=');
        //sb.append(((this.integerArray == null)?"<null>":this.integerArray));
        appendArray(stringArray, sb);
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
        result = ((result* 31)+((this.stringArray == null)? 0 :this.stringArray.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StringArrayAttribute) == false) {
            return false;
        }
        StringArrayAttribute rhs = ((StringArrayAttribute) other);
        return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this.stringArray.containsAll(rhs.getStringArray())
            && rhs.getStringArray().containsAll(this.stringArray);
    }

}
