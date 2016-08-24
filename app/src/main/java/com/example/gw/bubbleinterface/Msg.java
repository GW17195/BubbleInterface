package com.example.gw.bubbleinterface;

/**
 * Created by GW on 2016/8/20.
 */
public class Msg {
    public static  final int TYPE_RECEIVED=0;
    public  static final int TYPE_SEND=1;
    private String content;
    private int imageId;
    private int type;
    public Msg(int imageId ,String content,int type){
        this.imageId=imageId;
        this.content=content;
        this.type=type;
    }

    public int getImageId() {
        return imageId;
    }
    public String getContent(){
        return content;
    }
    public int getType() {
        return type;
    }
}
