package com.jack.concurrent.semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jack on 7/27/2018 10:50 AM
 * Semaphore are often used to limit the number of thread that acquire resource.
 */
public class SemaphoreDemo {
    static class Student implements Runnable {
        private int num;
        private Playground playground;
        public Student(int num,Playground playground) {
            this.num = num;
            this.playground = playground;
        }
        public void run() {
            try {
                Playground.Track track = playground.getTrack();
                if (track != null) {
                    System.out.println("student " + num + " are running " + track.toString());
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("student " + num + " release " + track.toString());
                    playground.releaseTrack(track);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        Playground playground = new Playground();
        for (int i=0;i<100;i++) {
            executor.execute(new Student(i+1,playground));
        }
    }
}
