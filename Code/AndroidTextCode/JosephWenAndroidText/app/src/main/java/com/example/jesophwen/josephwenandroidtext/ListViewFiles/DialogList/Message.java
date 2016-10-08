package com.example.jesophwen.josephwenandroidtext.ListViewFiles.DialogList;

/**
 * Created by wenkui on 16/9/21.
 */

public class Message {
    public static final int  TYPE_SEND = 0;
    public static final int TYPE_RECIVED = 1;

    private String content;  // 消息的内容
    private int type;  // 消息的类型

    public Message(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
