package com.api.paycaratula.domain.viafirma;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "groupCode",
        "workflow",
        "notification",
        "document",
        "callbackMails",
        "callbackURL"
})
public class Body {

    @JsonProperty("groupCode")
    private String groupCode;
    @JsonProperty("workflow")
    private Workflow workflow;
    @JsonProperty("notification")
    private Notification notification;
    @JsonProperty("document")
    private Document document;
    @JsonProperty("callbackMails")
    private String callbackMails;
    @JsonProperty("callbackURL")
    private String callbackURL;

    @JsonProperty("groupCode")
    public String getGroupCode() {
        return groupCode;
    }

    @JsonProperty("groupCode")
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @JsonProperty("workflow")
    public Workflow getWorkflow() {
        return workflow;
    }

    @JsonProperty("workflow")
    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    @JsonProperty("notification")
    public Notification getNotification() {
        return notification;
    }

    @JsonProperty("notification")
    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    @JsonProperty("document")
    public Document getDocument() {
        return document;
    }

    @JsonProperty("document")
    public void setDocument(Document document) {
        this.document = document;
    }

    @JsonProperty("callbackMails")
    public String getCallbackMails() {
        return callbackMails;
    }

    @JsonProperty("callbackMails")
    public void setCallbackMails(String callbackMails) {
        this.callbackMails = callbackMails;
    }

    @JsonProperty("callbackURL")
    public String getCallbackURL() {
        return callbackURL;
    }

    @JsonProperty("callbackURL")
    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

}
