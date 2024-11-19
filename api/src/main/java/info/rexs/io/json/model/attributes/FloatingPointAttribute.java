package info.rexs.io.json.model.attributes;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "floating_point"
})

public class FloatingPointAttribute extends Attribute{

    @JsonProperty("floating_point")
    private Double floatingPoint;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("floating_point")
    public Double getFloatingPoint() {
        return floatingPoint;
    }

    @JsonProperty("floating_point")
    public void setFloatingPoint(Double floatingPoint) {
        this.floatingPoint = floatingPoint;
    }

    public FloatingPointAttribute withFloatingPoint(Double floatingPoint) {
        this.floatingPoint = floatingPoint;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("floatingPoint");
        sb.append('=');
        sb.append(((this.floatingPoint == null)?"<null>":this.floatingPoint));
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
        result = ((result* 31)+((this.floatingPoint == null)? 0 :this.floatingPoint.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FloatingPointAttribute) == false) {
            return false;
        }
        FloatingPointAttribute rhs = ((FloatingPointAttribute) other);
        return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this.floatingPoint.equals(rhs.getFloatingPoint());
    }

}
