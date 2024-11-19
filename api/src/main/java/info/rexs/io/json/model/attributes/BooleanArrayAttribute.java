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
    "boolean_array"
})

public class BooleanArrayAttribute extends Attribute {

    @JsonProperty("boolean_array")
    private List<Boolean> booleanArray = new ArrayList<>();

    @JsonProperty("boolean_array")
    public List<Boolean> getBooleanArray() {
        return booleanArray;
    }

    @JsonProperty("boolean_array")
    public void setBooleanArray(List<Boolean> integerArray) {
        this.booleanArray = integerArray;
    }

    public Attribute withBooleanArray(List<Boolean> integerArray) {
        this.booleanArray = integerArray;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("boolean_array");
        sb.append('=');
        //sb.append(((this.integerArray == null)?"<null>":this.integerArray));
        appendArray(booleanArray, sb);
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
        result = ((result* 31)+((this.booleanArray == null)? 0 :this.booleanArray.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BooleanArrayAttribute) == false) {
            return false;
        }
        BooleanArrayAttribute rhs = ((BooleanArrayAttribute) other);
        return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this.booleanArray.containsAll(rhs.getBooleanArray())
            && rhs.getBooleanArray().containsAll(this.booleanArray);
    }

}
