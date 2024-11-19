package info.rexs.io.json.model.attributes;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "boolean"
})

public class BooleanAttribute extends Attribute {

    @JsonProperty("boolean")
    private Boolean _boolean;

    @JsonProperty("boolean")
    public Boolean getBoolean() {
        return _boolean;
    }

    @JsonProperty("boolean")
    public void setBoolean(Boolean _boolean) {
        this._boolean = _boolean;
    }

    public Attribute withBoolean(Boolean _boolean) {
        this._boolean = _boolean;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("string");
        sb.append('=');
        sb.append(((this._boolean == null)?"<null>":this._boolean));
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
        result = ((result* 31)+((this._boolean == null)? 0 :this._boolean.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof BooleanAttribute)) {
            return false;
        }
        BooleanAttribute rhs = ((BooleanAttribute) other);
        return (this.id.equals(rhs.getId()))
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null)
            && this._boolean.equals(rhs.getBoolean());
    }

}
