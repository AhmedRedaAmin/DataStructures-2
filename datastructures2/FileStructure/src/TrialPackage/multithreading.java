package TrialPackage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ahmed on 3/17/17.
 */
public class multithreading {
    public static void main (String args[]){

        Thread2 app2 = new Thread2();
        Thread3 app3 = new Thread3();
        app2.start();
        app3.start();
        try {
            app2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            app3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
