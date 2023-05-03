package info.rexs.io.json.model.attributes;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "unit",
    "file_reference"
})

public class FileReferenceAttribute extends Attribute {

    @JsonProperty("file_reference")
    private String fileReference;
    
    @JsonProperty("file_reference")
    public String getFileReference() {
        return fileReference;
    }

    @JsonProperty("file_reference")
    public void setFileReference(String fileReference) {
        this.fileReference = fileReference;
    }

    public Attribute withFileReference(String fileReference) {
        this.fileReference = fileReference;
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
        sb.append(((this.fileReference == null)?"<null>":this.fileReference));
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
        result = ((result* 31)+((this.fileReference == null)? 0 :this.fileReference.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FileReferenceAttribute) == false) {
            return false;
        }
        FileReferenceAttribute rhs = ((FileReferenceAttribute) other);
        return (this.id.equals(rhs.getId())) 
            && (this.unit != null && rhs.unit != null && this.unit.equals(rhs.getUnit())|| this.unit == null || rhs.unit == null) 
            && this.fileReference.equals(rhs.getFileReference());
    }

}
