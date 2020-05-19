package com.api.paycaratula.domain.viafirma;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "text",
        "detail",
        "sharedLink"
})
public class Notification {

    @JsonProperty("text")
    private String text;
    @JsonProperty("detail")
    private String detail;
    @JsonProperty("sharedLink")
    private SharedLink sharedLink;

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    @JsonProperty("detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @JsonProperty("sharedLink")
    public SharedLink getSharedLink() {
        return sharedLink;
    }

    @JsonProperty("sharedLink")
    public void setSharedLink(SharedLink sharedLink) {
        this.sharedLink = sharedLink;
    }

}
