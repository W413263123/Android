package com.example.jesophwen.josephwenandroidtext.FragmentFiles;

/**
 * Created by wenkui on 16/9/26.
 */

public class News {

    public String newsTitle;    // 显示新闻标题
    public String newsContent;  // 显示新闻内容

    /** 新闻实例化方法 */
    public News(String newsTitle, String newsContent) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    /** 获取新闻的标题的方法 */
    public String getNewsTitle() {
        return newsTitle;
    }

    /** 获取新闻内容方法 */
    public String getNewsContent() {
        return newsContent;
    }

    /** 设置新闻标题 */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /** 设置新闻内容 */
    public void setNewsContent(String newscontent) {
        this.newsContent = newsContent;
    }

}
