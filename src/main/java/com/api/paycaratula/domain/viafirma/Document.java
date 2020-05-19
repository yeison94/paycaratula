package com.api.paycaratula.domain.viafirma;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "templateType",
        "templateReference",
        "policyCode",
        "readRequired",
        "watermarkText"
})
public class Document {

    @JsonProperty("templateType")
    private String templateType;
    @JsonProperty("templateReference")
    private String templateReference;
    @JsonProperty("policyCode")
    private String policyCode;
    @JsonProperty("readRequired")
    private Boolean readRequired;
    @JsonProperty("watermarkText")
    private String watermarkText;

    @JsonProperty("templateType")
    public String getTemplateType() {
        return templateType;
    }

    @JsonProperty("templateType")
    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    @JsonProperty("templateReference")
    public String getTemplateReference() {
        return templateReference;
    }

    @JsonProperty("templateReference")
    public void setTemplateReference(String templateReference) {
        this.templateReference = templateReference;
    }

    @JsonProperty("policyCode")
    public String getPolicyCode() {
        return policyCode;
    }

    @JsonProperty("policyCode")
    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    @JsonProperty("readRequired")
    public Boolean getReadRequired() {
        return readRequired;
    }

    @JsonProperty("readRequired")
    public void setReadRequired(Boolean readRequired) {
        this.readRequired = readRequired;
    }

    @JsonProperty("watermarkText")
    public String getWatermarkText() {
        return watermarkText;
    }

    @JsonProperty("watermarkText")
    public void setWatermarkText(String watermarkText) {
        this.watermarkText = watermarkText;
    }

}
