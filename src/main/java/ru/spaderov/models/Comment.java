package ru.spaderov.models;

import java.util.*;

public class Comment extends Item {

    public String comment;
    public Comment(String name,String desc,String comments){
        this.name = name;
        this.description = desc;
        this.comment = comments;
    }
    public String getComment(){return this.comment;}
	
}