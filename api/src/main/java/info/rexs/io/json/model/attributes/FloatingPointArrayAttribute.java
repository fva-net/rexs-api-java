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
    "floating_point_array"
})

public class FloatingPointArrayAttribute extends Attribute {

    @JsonProperty("floating_point_array")
    private List<Double> floatingPointArray = new ArrayList<Double>();

    @JsonProperty("floating_point_array")
    public List<Double> getFloatingPointArray() {
        return floatingPointArray;
    }

    @JsonProperty("floating_point_array")
    public void setFloatingPointArray(List<Double> floatingPointArray) {
        this.floatingPointArray = floatingPointArray;
    }

    public FloatingPointArrayAttribute withFloatingPointArray(List<Double> floatingPointArray) {
        this.floatingPointArray = floatingPointArray;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("floating_point_array");
        sb.append('=');
        sb.append(((this.floatingPointArray == null)?"<null>":this.floatingPointArray));
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
        result = ((result* 31)+((this.floatingPointArray == null)? 0 :this.floatingPointArray.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FloatingPointArrayAttribute) == false) {
            return false;
        }
        FloatingPointArrayAttribute rhs = ((FloatingPointArrayAttribute) other);
        return (this.id.equals(rhs.getId())) 
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null) 
            && this.floatingPointArray.containsAll(rhs.getFloatingPointArray()) 
            && rhs.getFloatingPointArray().containsAll(this.floatingPointArray);
    }

}
