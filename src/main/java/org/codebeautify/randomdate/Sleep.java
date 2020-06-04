package org.codebeautify.randomdate;

public class Sleep {
    public static void sleepfor(long millseconds) {
        try {
            Thread.sleep(millseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
