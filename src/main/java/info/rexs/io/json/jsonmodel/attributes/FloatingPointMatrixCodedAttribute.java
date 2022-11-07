package info.rexs.io.json.jsonmodel.attributes;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import info.rexs.io.json.jsonmodel.FloatingPointMatrixCoded;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "floating_point_matrix_coded"
})

public class FloatingPointMatrixCodedAttribute extends Attribute {

    @JsonProperty("floating_point_matrix_coded")
    private FloatingPointMatrixCoded floatingPointMatrixCoded;
    

    @JsonProperty("floating_point_matrix_coded")
    public FloatingPointMatrixCoded getFloatingPointMatrixCoded() {
        return floatingPointMatrixCoded;
    }

    @JsonProperty("floating_point_matrix_coded")
    public void setFloatingPointMatrixCoded(FloatingPointMatrixCoded floatingPointMatrixCoded) {
        this.floatingPointMatrixCoded = floatingPointMatrixCoded;
    }

    public Attribute withFloatingPointMatrixCoded(FloatingPointMatrixCoded floatingPointMatrixCoded) {
        this.floatingPointMatrixCoded = floatingPointMatrixCoded;
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
        sb.append(((this.floatingPointMatrixCoded == null)?"<null>":this.floatingPointMatrixCoded.toString()));
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
        result = ((result* 31)+((this.floatingPointMatrixCoded == null)? 0 :this.floatingPointMatrixCoded.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FloatingPointMatrixCodedAttribute) == false) {
            return false;
        }
        FloatingPointMatrixCodedAttribute rhs = ((FloatingPointMatrixCodedAttribute) other);
        return (this.id.equals(rhs.getId())) 
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null) 
            && this.floatingPointMatrixCoded.equals(rhs.getFloatingPointMatrixCoded());
    }

}
