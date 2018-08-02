package com.jack.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by Jack on 7/27/2018 10:50 AM
 */
public class Playground {
    static class Track {
        private int num;
        public Track(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "Track[num= " + num + "]";
        }
    }
    private  Track [] tracks = {new Track(1),new Track(2),new Track(3),new Track(4),new Track(5)};
    private volatile boolean[] used = new boolean[5];
    private Semaphore semaphore = new Semaphore(5,true);
    public Track getTrack() throws InterruptedException {
        semaphore.acquire(1);
        return getNextAvailableTrack();
    }
    public void releaseTrack(Track track) {
        if (makeAsUsed(track)) {
            semaphore.release(1);
        }
    }
    private Track getNextAvailableTrack() {
        for (int i=0;i<used.length;i++) {
            if (!used[i]) {
                used[i] = true;
                return tracks[i];
            }
        }
        return null;
    }
    private boolean makeAsUsed(Track track) {
        for (int i=0;i<used.length;i++) {
            if (tracks[i] == track) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

}
