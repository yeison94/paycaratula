package com.api.paycaratula.domain.viafirma;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "appCode",
        "email",
        "subject"
})
public class SharedLink {

    @JsonProperty("appCode")
    private String appCode;
    @JsonProperty("email")
    private String email;
    @JsonProperty("subject")
    private String subject;

    @JsonProperty("appCode")
    public String getAppCode() {
        return appCode;
    }

    @JsonProperty("appCode")
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

}
