package org.patata.android.xarine.pojo;

public class Audio {
    private String title;
    private String album;
    private String artist;
    private String path;

    public Audio(String path, String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.path = path;
    }

    public String getTitle() { return this.title; }
    public String getAlbum() { return this.album; }
    public String getArtist() { return this.artist; }
    public String getPath() { return this.path; }
}
