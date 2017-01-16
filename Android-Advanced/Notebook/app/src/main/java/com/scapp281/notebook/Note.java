package com.scapp281.notebook;


public class Note {
    private String title,message;
    private long noteid,dateCreatedMilli;
    private Category category;

    public enum Category {
        BATTERY, CAR, CONNECTIVITY, GRAPHICS, MAP,
        MULTIMEIDA, NETWORK, NETWORK_DATA, SHARING,
        SIGNIN, STORAGE, SYNC_DOWNLOAD, TV, WATCH,
        WIRELESS
    }

    public Note(String title,String message,Category category){

        this.title = title;
        this.message = message;
        this.category = category;
        this.noteid = 0;
        this.dateCreatedMilli = 0;
    }

    public Note(String title,String message,Category category,long noteid,long dateCreatedMilli){

        this.title = title;
        this.message = message;
        this.category = category;
        this.noteid = noteid;
        this.dateCreatedMilli = dateCreatedMilli;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public long getNoteid() {
        return noteid;
    }

    public long getDateCreatedMilli() {
        return dateCreatedMilli;
    }


    public int getAssociatedDrawable() {
        return categoryToDrawable(category);
    }


    public String toString(){
        return "ID: " + noteid +
                "\nIconID: " + category.name() +
                "\nTitle: " + title +
                "\nMessage: " + message +
                "\nDate: "+ dateCreatedMilli;
    }

    public static int categoryToDrawable(Category noteCategory) {
        switch (noteCategory) {
            case BATTERY:
                return R.drawable.battery_efficient;
            case CAR:
                return R.drawable.car;
            case CONNECTIVITY:
                return R.drawable.connectivity_cloud;
            case GRAPHICS:
                return R.drawable.graphics;
            case MAP:
                return R.drawable.map;
            case MULTIMEIDA:
                return R.drawable.multimedia;
            case NETWORK:
                return R.drawable.network;
            case NETWORK_DATA:
                return R.drawable.networkdata;
            case SHARING:
                return R.drawable.sharing;
            case SIGNIN:
                return R.drawable.signin;
            case STORAGE:
                return R.drawable.storage;
            case SYNC_DOWNLOAD:
                return R.drawable.sync_download;
            case TV:
                return R.drawable.tv;
            case WATCH:
                return R.drawable.watch;
            case WIRELESS:
                return R.drawable.wireless;
        }

        return R.drawable._clip;
    }
}
