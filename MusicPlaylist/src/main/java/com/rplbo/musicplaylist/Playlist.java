package com.rplbo.musicplaylist;
import java.util.*;

public class Playlist {
    private String playlistName;
    private final static ArrayList<Song> songs = new ArrayList<Song>(6);
    private static int count = 0;

    public Playlist(){

    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlayListName(String playlistName) {
        this.playlistName = playlistName;
    }

    public static void print(){
        System.out.println("Jumlah Lagu = "+songs.size() + " / Kapasitas Playlist = 6");
        int bnyk = count;

        for(Song i : songs){
            int tmp = count-bnyk;
            System.out.println("ListSong["+tmp+"] : "+i.getName()+" - "+i.getArtist());
            bnyk -= 1;
        }
        System.out.println();
    }

    public String totalTime(){
        int total = 0;

        for (Song i : songs){
            total += i.getLength();
        }

        String out = "Total waktu["+getPlaylistName()+"] = " + Integer.toString(total);
        return out;
    }

    public void add(Song song){
        if(songs.size() == 6){
            System.out.println("Playlist Favorite penuh!. Tidak bisa menambahkan lagu lagi.");
            return;
        }
        this.songs.add(song);
    }

    public void remove(String songName){
        for (Song i : songs){
            if (i.getName().equalsIgnoreCase(songName)){
                songs.remove(i);
                System.out.println(i.getName() + " terhapus...");
                count -= 1;
                break;
            }
        }
    }

    public int size(){
        return songs.size();
    }
}
