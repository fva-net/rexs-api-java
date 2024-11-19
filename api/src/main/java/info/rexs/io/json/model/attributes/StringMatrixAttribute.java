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
    "string_matrix"
})

public class StringMatrixAttribute extends Attribute {


    @JsonProperty("string_matrix")
    private List<List<String>> stringMatrix = new ArrayList<>();

    @JsonProperty("string_matrix")
    public List<List<String>> getStringMatrix() {
        return stringMatrix;
    }

    @JsonProperty("string_matrix")
    public void setStringMatrix(List<List<String>> stringMatrix) {
        this.stringMatrix = stringMatrix;
    }

    public Attribute withStringMatrix(List<List<String>> stringMatrix) {
        this.stringMatrix = stringMatrix;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("string_matrix");
        sb.append('=');
        //sb.append(((this.integerArray == null)?"<null>":this.integerArray));
        appendMatrix(stringMatrix, sb);
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
        result = ((result* 31)+((this.stringMatrix == null)? 0 :this.stringMatrix.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StringMatrixAttribute) == false) {
            return false;
        }
        StringMatrixAttribute rhs = ((StringMatrixAttribute) other);
        return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this.stringMatrix.containsAll(rhs.getStringMatrix())
            && rhs.getStringMatrix().containsAll(this.stringMatrix);
    }

}
