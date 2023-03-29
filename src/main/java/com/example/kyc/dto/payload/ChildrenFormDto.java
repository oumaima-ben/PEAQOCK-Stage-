package com.example.kyc.dto.payload;
import lombok.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChildrenFormDto {
    private String documentName;
    private String documentDescription;

    //@JsonIgnore
   // private ParentFormDto parentForm;
    private List<QuestionDto> question;

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }



    public List<QuestionDto> getQuestion() {
        return question;
    }

    public void setQuestion(List<QuestionDto> question) {
        this.question = question;
    }
}
