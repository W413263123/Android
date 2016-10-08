package com.example.jesophwen.josephwenandroidtext.ListViewFiles.CustomList;

/**
 * Created by wenkui on 16/9/20.
 */
public class ColorDescribe {
    private String englishName;   // 颜色英文名
    private String chineseName;   // 颜色中文名
    private int imageId;    // 颜色图片的ID

    public ColorDescribe(String englishName, String chineseName, int imageId) {
        this.englishName = englishName;
        this.imageId = imageId;
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public int getImageId() {
        return imageId;
    }

    public String getChineseName() {
        return chineseName;
    }
}
