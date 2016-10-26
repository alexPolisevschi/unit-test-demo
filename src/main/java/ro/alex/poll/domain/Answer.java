package ro.alex.poll.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by Alex P on 10/26/16.
 */
public class Answer {

    @NotNull
    private Integer id;

    private String text;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
