package info.rexs.io.json.model.attributes;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "enum"
})

public class EnumAttribute extends Attribute {

    @JsonProperty("enum")
    private String _enum;
    
    @JsonProperty("enum")
    public String getEnum() {
        return _enum;
    }

    @JsonProperty("enum")
    public void setEnum(String _enum) {
        this._enum = _enum;
    }

    public EnumAttribute withEnum(String _enum) {
        this._enum = _enum;
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
        sb.append(((this._enum == null)?"<null>":this._enum));
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
        result = ((result* 31)+((this._enum == null)? 0 :this._enum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StringAttribute) == false) {
            return false;
        }
        EnumAttribute rhs = ((EnumAttribute) other);
        return (this.id.equals(rhs.getId())) 
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null) 
            && this._enum.equals(rhs.getEnum());
    }

}
