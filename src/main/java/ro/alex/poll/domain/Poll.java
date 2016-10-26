package ro.alex.poll.domain;

import ro.alex.poll.constants.SecurityType;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Alex P on 10/26/16.
 */
public class Poll {

    @NotNull
    private Integer id;

    private String question;

    private SecurityType securityType;


    // lazy load
    private List<Answer> answers;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public SecurityType getSecurityType() {
        return securityType;
    }

    public void setSecurityType(SecurityType securityType) {
        this.securityType = securityType;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
