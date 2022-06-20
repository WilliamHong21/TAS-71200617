package com.rplbo.musicplaylist;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) {
        Playlist one = new Playlist();
        one.setPlayListName("Favorite");
        Song song1 = new Song("Gravity", "John Mayer", "Try!", 349);
        Song song2 = new Song("LDR", "Raisa", "Heart to Heart", 294);
        Song song3 = new Song("Hati-Hati di Jalan", "Tulus", "Manusia", 242);
        Song song4 = new Song("Easy On Me", "Adele", "30", 224);
        Song song5 = new Song("One Call Away", "Charlie Puth", "Nine Track Mind", 192);
        Song song6 = new Song("Unconditionally", "Katy Perry", "Prism", 229);
        Song song7 = new Song("Here's Your Perfect", "Jamie Miller", "Broken Memories", 98);
        one.add(song1);
        one.add(song2);
        one.add(song3);
        one.add(song4);
        one.add(song5);
        one.add(song6);
        one.add(song7);
        System.out.println("Lagu dalam playlist favorite:");
        one.print();
        one.remove("Unconditionally");
        one.remove("One Call Away");
        System.out.println("");
        System.out.println("Jumlah lagu playlist favorite sekarang: "+one.size());
        System.out.println("");
        System.out.println("Playlist favorite setelah penghapusan:");
        one.print();
        System.out.println(one.totalTime());
    }
}

