package com.headbook.db.model;

import java.util.Date;

public class Posts {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSTS.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSTS.creator
     *
     * @mbggenerated
     */
    private Long creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSTS.date
     *
     * @mbggenerated
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSTS.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POSTS.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTS.id
     *
     * @return the value of POSTS.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTS.id
     *
     * @param id the value for POSTS.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTS.creator
     *
     * @return the value of POSTS.creator
     *
     * @mbggenerated
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTS.creator
     *
     * @param creator the value for POSTS.creator
     *
     * @mbggenerated
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTS.date
     *
     * @return the value of POSTS.date
     *
     * @mbggenerated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTS.date
     *
     * @param date the value for POSTS.date
     *
     * @mbggenerated
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTS.title
     *
     * @return the value of POSTS.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTS.title
     *
     * @param title the value for POSTS.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POSTS.content
     *
     * @return the value of POSTS.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POSTS.content
     *
     * @param content the value for POSTS.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content;
    }
}