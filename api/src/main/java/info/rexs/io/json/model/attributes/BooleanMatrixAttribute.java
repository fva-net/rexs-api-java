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
    "boolean_matrix"
})

public class BooleanMatrixAttribute extends Attribute {

    
    @JsonProperty("boolean_matrix")
    private List<List<Boolean>> booleanMatrix = new ArrayList<List<Boolean>>();

    @JsonProperty("boolean_matrix")
    public List<List<Boolean>> getBooleanMatrix() {
        return booleanMatrix;
    }

    @JsonProperty("boolean_matrix")
    public void setBooleanMatrix(List<List<Boolean>> booleanMatrix) {
        this.booleanMatrix = booleanMatrix;
    }

    public Attribute withBooleanMatrix(List<List<Boolean>> booleanMatrix) {
        this.booleanMatrix = booleanMatrix;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("boolean_matrix");
        sb.append('=');
        //sb.append(((this.integerArray == null)?"<null>":this.integerArray));
        appendMatrix(booleanMatrix, sb);
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
        result = ((result* 31)+((this.booleanMatrix == null)? 0 :this.booleanMatrix.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BooleanMatrixAttribute) == false) {
            return false;
        }
        BooleanMatrixAttribute rhs = ((BooleanMatrixAttribute) other);
        return (this.id.equals(rhs.getId())) 
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null) 
            && this.booleanMatrix.containsAll(rhs.getBooleanMatrix()) 
            && rhs.getBooleanMatrix().containsAll(this.booleanMatrix);
    }

}
