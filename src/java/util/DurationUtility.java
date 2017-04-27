/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.Duration;

/**
 *
 * @author Ethan Jorgensen
 */
public class DurationUtility {
    /**
     * Formats a Duration. Code modified from http://stackoverflow.com/a/266846
     * @param duration a duration of time
     * @return String in MM:SS format
    */
    public static String formatDuration(Duration duration) {
    long seconds = duration.getSeconds();
    long absSeconds = Math.abs(seconds);
    String positive = String.format(
        "%02d:%02d",
        // absSeconds / 3600,
        (absSeconds /*% 3600*/) / 60,
        absSeconds % 60);
    return seconds < 0 ? "-" + positive : positive;
    }
}
