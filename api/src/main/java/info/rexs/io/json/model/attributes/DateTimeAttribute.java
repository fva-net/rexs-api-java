package info.rexs.io.json.model.attributes;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "date_time"
})

/** ISO 8601 encoded date-time attribute */
public class DateTimeAttribute extends Attribute {

    @JsonProperty("date_time")
    private String date_time;
    
    @JsonProperty("date_time")
    public String getTime() {
        return date_time;
    }

    @JsonProperty("date_time")
    public void setTime(String time) {
        this.date_time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        super.appendId(sb);
        super.appendUnit(sb);
        sb.append("date_time");
        sb.append('=');
        sb.append(((this.date_time == null)?"<null>":this.date_time));
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
        return Objects.hash(super.hashCode(), this.date_time);
    }

    @Override
    public boolean equals(Object other) {
    	if (other == this) {
    		return true;
    	}
    	if (other instanceof DateTimeAttribute) {
    		DateTimeAttribute rhs = ((DateTimeAttribute) other);
    		return Objects.equals(this.id, rhs.id) && Objects.equals(this.unit, rhs.unit) && Objects.equals(this.date_time, rhs.date_time);
    	}
    	return false;
    }

}
