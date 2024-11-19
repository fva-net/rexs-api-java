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
    "integer_matrix"
})

public class IntegerMatrixAttribute extends Attribute {


    @JsonProperty("integer_matrix")
    private List<List<Integer>> integerMatrix = new ArrayList<>();

    @JsonProperty("integer_matrix")
    public List<List<Integer>> getIntegerMatrix() {
        return integerMatrix;
    }

    @JsonProperty("integer_matrix")
    public void setIntegerMatrix(List<List<Integer>> integerMatrix) {
        this.integerMatrix = integerMatrix;
    }

    public Attribute withIntegerMatrix(List<List<Integer>> integerMatrix) {
        this.integerMatrix = integerMatrix;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("integer_matrix");
        sb.append('=');
        //sb.append(((this.integerArray == null)?"<null>":this.integerArray));
        appendMatrix(integerMatrix, sb);
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
        result = ((result* 31)+((this.integerMatrix == null)? 0 :this.integerMatrix.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof IntegerMatrixAttribute rhs)) {
            return false;
        }
		return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this.integerMatrix.containsAll(rhs.getIntegerMatrix())
            && rhs.getIntegerMatrix().containsAll(this.integerMatrix);
    }

}
