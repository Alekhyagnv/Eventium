package com.andro.myappyy;

public class Events {

    String date,eventname,image,info,students,uid,link,club,link1;

    public  Events()
    {

    }

    public Events(String date, String eventname, String image, String info, String students,String link,String uid, String club,String link1) {
        this.date = date;
        this.eventname = eventname;
        this.image = image;
        this.info = info;
        this.students = students;
       this.uid=uid;
        this.link=link;
        this.club=club;
        this.link1=link1;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }
}
