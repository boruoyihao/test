package com.extend;

/**
 * Created by zhaolizhen on 17-11-30.
 */
public class Children extends Parent{
    private int like=0;

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
        this.name="";
    }
}
