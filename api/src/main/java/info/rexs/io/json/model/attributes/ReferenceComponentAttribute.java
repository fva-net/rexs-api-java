package info.rexs.io.json.model.attributes;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "reference_component"
})

public class ReferenceComponentAttribute extends Attribute {

    @JsonProperty("reference_component")
    private Integer referenceComponent;

    @JsonProperty("reference_component")
    public Integer getReferenceComponent() {
        return referenceComponent;
    }

    @JsonProperty("reference_component")
    public void setReferenceComponent(Integer referenceComponent) {
        this.referenceComponent = referenceComponent;
    }

    public Attribute withReferenceComponent(Integer referenceComponent) {
        this.referenceComponent = referenceComponent;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("reference_component");
        sb.append('=');
        sb.append(((this.referenceComponent == null)?"<null>":this.referenceComponent));
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
        result = ((result* 31)+((this.referenceComponent == null)? 0 :this.referenceComponent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ReferenceComponentAttribute rhs)) {
            return false;
        }
		return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this.referenceComponent.equals(rhs.getReferenceComponent());
    }

}
