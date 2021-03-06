package ch.heigvd.res.lab01.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

    private static final Logger LOG = Logger.getLogger(Utils.class.getName());

    /**
     * This method looks for the next new line separators (\r, \n, \r\n) to
     * extract the next line in the string passed in arguments.
     *
     * @param lines a string that may contain 0, 1 or more lines
     * @return an array with 2 elements; the first element is the next line with
     * the line separator, the second element is the remaining text. If the
     * argument does not contain any line separator, then the first element is
     * an empty string.
     */
    public static String[] getNextLine(String lines) {
        String[] strings = new String[2];

        int i = 0;
        //Loop to check each char in the line
        for (; i < lines.length(); ++i) {
            //If the char is \r or \n
            if (lines.charAt(i) == '\r' || lines.charAt(i) == '\n') {
                //if the char is \r\n
                if (i + 1 < lines.length() && lines.charAt(i) == '\r' && lines.charAt(i + 1) == '\n') {
                    ++i;
                }
                break;
            }

        }

        //if the lines length is diffrent of i.
        //that means we are in the middle of the string
        if (lines.length() != i) {
            //First element with the line separator
            strings[0] = lines.substring(0, i + 1);
            //the rest of the line
            strings[1] = lines.substring(i + 1);
        } else {// if it's equals that means we are in the last of the string
            // and we don't find any separator
            
            //first element is empty
            strings[0] = "";
            strings[1] = lines;
        }

        return strings;
    }

}
