package info.rexs.io.json.model.attributes;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import info.rexs.io.json.model.FloatingPointArrayCoded;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "floating_point_array_coded"
})

public class FloatingPointArrayCodedAttribute extends Attribute {

    @JsonProperty("floating_point_array_coded")
    private FloatingPointArrayCoded floatingPointArrayCoded;
    

    @JsonProperty("floating_point_array_coded")
    public FloatingPointArrayCoded getFloatingPointArrayCoded() {
        return floatingPointArrayCoded;
    }

    @JsonProperty("floating_point_array_coded")
    public void setFloatingPointArrayCoded(FloatingPointArrayCoded floatingPointArrayCoded) {
        this.floatingPointArrayCoded = floatingPointArrayCoded;
    }

    public FloatingPointArrayCodedAttribute withFloatingPointArrayCoded(FloatingPointArrayCoded floatingPointArrayCoded) {
        this.floatingPointArrayCoded = floatingPointArrayCoded;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("floating_point_array_coded");
        sb.append('=');
        sb.append(((this.floatingPointArrayCoded == null)?"<null>":this.floatingPointArrayCoded.toString()));
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
        result = ((result* 31)+((this.floatingPointArrayCoded == null)? 0 :this.floatingPointArrayCoded.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FloatingPointArrayCodedAttribute) == false) {
            return false;
        }
        FloatingPointArrayCodedAttribute rhs = ((FloatingPointArrayCodedAttribute) other);
        return (this.id.equals(rhs.getId())) 
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null) 
            && this.floatingPointArrayCoded.equals(rhs.getFloatingPointArrayCoded());
    }

}
