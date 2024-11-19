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
    "integer_array"
})

public class IntegerArrayAttribute extends Attribute {

    @JsonProperty("integer_array")
    private List<Integer> integerArray = new ArrayList<>();

    @JsonProperty("integer_array")
    public List<Integer> getIntegerArray() {
        return integerArray;
    }

    @JsonProperty("integer_array")
    public void setIntegerArray(List<Integer> integerArray) {
        this.integerArray = integerArray;
    }

    public Attribute withIntegerArray(List<Integer> integerArray) {
        this.integerArray = integerArray;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("integer_array");
        sb.append('=');
        //sb.append(((this.integerArray == null)?"<null>":this.integerArray));
        appendArray(integerArray, sb);
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
        result = ((result* 31)+((this.integerArray == null)? 0 :this.integerArray.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof IntegerArrayAttribute)) {
            return false;
        }
        IntegerArrayAttribute rhs = ((IntegerArrayAttribute) other);
        return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this.integerArray.containsAll(rhs.getIntegerArray())
            && rhs.getIntegerArray().containsAll(this.integerArray);
    }

}
