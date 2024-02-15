package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._6SOLID._1Lab._02OpenClosedPrinciple._01FileStream;

public class MusicFile extends File{
    private int length;

    private int sent;

    private String Artist;

    private String Album;

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSent() {
        return this.sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }

    public String getArtist() {
        return this.Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getAlbum() {
        return this.Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }
}
