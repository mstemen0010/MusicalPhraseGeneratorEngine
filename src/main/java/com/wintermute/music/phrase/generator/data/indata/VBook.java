package com.wintermute.music.phrase.generator.data.indata;


import com.wintermute.music.generator.grammar.PageStack;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 173510
 */
public class VBook {

    private PageStack ps = null;
    private Librarian libr = null;
    static private Map<String, Long> freqMap = new HashMap<>();

    public VBook( Librarian libr, PageStack ps  ) {
        this.ps = ps;
        this.libr = libr;
    }

}

