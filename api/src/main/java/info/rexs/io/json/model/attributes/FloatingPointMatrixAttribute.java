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
    "floating_point_matrix"
})

public class FloatingPointMatrixAttribute extends Attribute {


    @JsonProperty("floating_point_matrix")
    private List<List<Double>> floatingPointMatrix = new ArrayList<>();

    @JsonProperty("floating_point_matrix")
    public List<List<Double>> getFloatingPointMatrix() {
        return floatingPointMatrix;
    }

    @JsonProperty("floating_point_matrix")
    public void setFloatingPointMatrix(List<List<Double>> floatingPointMatrix) {
        this.floatingPointMatrix = floatingPointMatrix;
    }

    public Attribute withFloatingPointMatrix(List<List<Double>> floatingPointMatrix) {
        this.floatingPointMatrix = floatingPointMatrix;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("floating_point_matrix");
        sb.append('=');
        //sb.append(((this.integerArray == null)?"<null>":this.integerArray));
        appendMatrix(floatingPointMatrix, sb);
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
        result = ((result* 31)+((this.floatingPointMatrix == null)? 0 :this.floatingPointMatrix.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FloatingPointMatrixAttribute) == false) {
            return false;
        }
        FloatingPointMatrixAttribute rhs = ((FloatingPointMatrixAttribute) other);
        return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this.floatingPointMatrix.containsAll(rhs.getFloatingPointMatrix())
            && rhs.getFloatingPointMatrix().containsAll(this.floatingPointMatrix);
    }

}
