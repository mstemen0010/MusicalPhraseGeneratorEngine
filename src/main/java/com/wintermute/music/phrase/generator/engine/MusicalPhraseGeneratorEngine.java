package com.wintermute.music.phrase.generator.engine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.wintermute.music.generator.grammar.PageStack;
import com.wintermute.music.phrase.generator.data.indata.Librarian;
import com.wintermute.music.phrase.generator.data.indata.VBook;
import com.wintermute.music.phrase.generator.musicmapping.MidiFile;
import com.wintermute.music.phrase.generator.musicmapping.MusicalPhrase;
import com.wintermute.music.phrase.generator.musicmapping.Note;
import nl.siegmann.epublib.domain.Book;


import java.io.*;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusicalPhraseGeneratorEngine {


    /**
     * @author 173510
     */
    // FileInputStream fs = null;
    private final String libraryPathName = "/Users/matthewstemen/ebooks/";
    private final String bookName = "pg8492.epub";
    private Path currentPath;
    private File ebookFile;
    private int maxPages = 0;
    private int pageNumber = 1;
    private Librarian myLibrarian;

    public MusicalPhraseGeneratorEngine(String filePath) {

        InputStream epubStream = null;
        ebookFile = new File(libraryPathName + bookName);
        PageStack ps = null;


        try {
            // fs = new FileInputStream(ebookFile);
            epubStream = new FileInputStream(ebookFile);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MusicalPhraseGeneratorEngine.class.getName()).log(Level.SEVERE, null, ex);
        }

        myLibrarian = null;
        if (epubStream != null) {
            // Book book = (new EpubReader()).readEpub(new FileInputStream(selectedFile));\

            try {
                myLibrarian = Librarian.getWordLibrarian(ebookFile);
            } catch (IOException ex) {
                Logger.getLogger(MusicalPhraseGeneratorEngine.class.getName()).log(Level.SEVERE, null, ex);
            }
            // List<String> pages = myLibrarian.getPagesAsText();
        }
    }

    Librarian getLibrarian() {
        return this.myLibrarian;
    }

    public static void main(String[] args) {

        String pathName = "C:\\alt_dev\\\\ebooks\\";

        pathName = "/Users/matthewstemen/ebooks/";
        String bookName = "pg8492.epub";

        MusicalPhrase myPhrase = new MusicalPhrase();
        myPhrase.printStack();
        System.out.println("Musical Phrase contains: " + myPhrase.size() + " notes");
        MidiFile newMidiFile = new MidiFile();
        Iterator<Note> notes = myPhrase.iterator();
        Book bookForMusic = null;

        MusicalPhraseGeneratorEngine myEngine = new MusicalPhraseGeneratorEngine(pathName + bookName);
        bookForMusic = myEngine.getLibrarian().getBook(new File(pathName + bookName));
        Librarian libr = myEngine.getLibrarian();
        VBook vbookForMusic = new VBook(libr, libr.getPageStack());
        // List<Resource> resources = bookForMusic.getContents();
        System.out.println("test");
    }


}

