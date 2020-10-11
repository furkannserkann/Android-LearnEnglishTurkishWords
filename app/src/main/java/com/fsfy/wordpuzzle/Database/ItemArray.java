package com.fsfy.wordpuzzle.Database;

public class ItemArray {

    private int id;
    private int index;
    private boolean select;
    private String name;
    private int beginWord;
    private int endWord;
    private boolean allWord;


    public static String Sid = "mid";
    public static String Sindex = "mindex";
    public static String Sselect = "mselect";
    public static String Sname = "mname";
    public static String SbeginWord = "mbeginWord";
    public static String SendWord = "mendWord";
    public static String SallWord = "mallWord";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(Integer select) {
        if (select == null) {
            this.select = false;
        } else {
            if (select == 1) {
                this.select = true;
            } else {
                this.select = false;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBeginWord() {
        return beginWord;
    }

    public void setBeginWord(int beginWord) {
        this.beginWord = beginWord;
    }

    public int getEndWord() {
        return endWord;
    }

    public void setEndWord(int endWord) {
        this.endWord = endWord;
    }

    public boolean isAllWord() {
        return allWord;
    }

    public void setAllWord(Integer allWord) {
        if (allWord == null) {
            this.allWord = false;
        } else {
            if (allWord == 1) {
                this.allWord = true;
            } else {
                this.allWord = false;
            }
        }
    }
}
