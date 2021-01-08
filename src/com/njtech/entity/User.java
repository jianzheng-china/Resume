package com.njtech.entity;

/**
 * @autor jianz
 * @create 2021-01-06 10:35
 * @desc 简历系统的用户类
 */
public class User {
    private Integer id;
    private String username;
    private String cellphone;
    private String education;
    private String email;
    private String address;
    private String job;
    private String school;
    private String eduDate;
    private String major;
    private String courseInfo;
    private String skillInfo;
    private String workExperience;
    private String selfEvaluation;
    private String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEduDate() {
        return eduDate;
    }

    public void setEduDate(String eduDate) {
        this.eduDate = eduDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public String getSkillInfo() {
        return skillInfo;
    }

    public void setSkillInfo(String skillInfo) {
        this.skillInfo = skillInfo;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", education='" + education + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", school='" + school + '\'' +
                ", eduDate='" + eduDate + '\'' +
                ", major='" + major + '\'' +
                ", courseInfo='" + courseInfo + '\'' +
                ", skillInfo='" + skillInfo + '\'' +
                ", workExperience='" + workExperience + '\'' +
                ", selfEvaluation='" + selfEvaluation + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
