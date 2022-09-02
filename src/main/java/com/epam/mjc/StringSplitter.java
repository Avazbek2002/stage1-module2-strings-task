package com.epam.mjc;

import java.util.Collection;
import java.util.List;
import java.util.Arrays;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String[] delimeter = delimiters.toArray(new String[0]);
        String regex ="[";
        for (String del : delimeter) {
            regex += del;
        }
        regex += "]";
        String[] tokens = source.split(regex);
        return Arrays.asList(tokens);
    }
}
