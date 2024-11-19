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
    "array_of_integer_arrays"
})
public class ArrayOfIntegerArraysAttribute extends Attribute {

    @JsonProperty("array_of_integer_arrays")
    private List<List<Integer>> arrayOfIntegerArrays = new ArrayList<>();

    @JsonProperty("array_of_integer_arrays")
    public List<List<Integer>> getArrayOfIntegerArrays() {
        return arrayOfIntegerArrays;
    }

    @JsonProperty("array_of_integer_arrays")
    public void setArrayOfIntegerArrays(List<List<Integer>> arrayOfIntegerArrays) {
        this.arrayOfIntegerArrays = arrayOfIntegerArrays;
    }

    public ArrayOfIntegerArraysAttribute withArrayOfIntegerArrays(List<List<Integer>> arrayOfIntegerArrays) {
        this.arrayOfIntegerArrays = arrayOfIntegerArrays;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("array_of_integer_arrays");
        sb.append('=');
        //sb.append(((this.arrayOfIntegerArrays == null)?"<null>":this.arrayOfIntegerArrays));
        appendArray(arrayOfIntegerArrays, sb);
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
        result = ((result* 31)+((this.arrayOfIntegerArrays == null)? 0 :this.arrayOfIntegerArrays.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ArrayOfIntegerArraysAttribute)) {
            return false;
        }
        ArrayOfIntegerArraysAttribute rhs = ((ArrayOfIntegerArraysAttribute) other);
        return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this.arrayOfIntegerArrays.containsAll(rhs.getArrayOfIntegerArrays())
            && rhs.getArrayOfIntegerArrays().containsAll(this.arrayOfIntegerArrays);
    }

}
