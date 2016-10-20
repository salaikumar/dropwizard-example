package me.salai.framework;

import org.hibernate.validator.constraints.Length;

/**
 * Representation Class
 */
public class Saying {
    private Long id;

    @Length(max = 3)
    private String content;

    // Default Constructor
    public Saying(){

    }

    public Saying(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
