package TrialPackage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ahmed on 3/17/17.
 */
public class Thread3 extends Thread{
    private ArrayList<Integer> test = new ArrayList<Integer>();
    private Random rand = new Random(System.currentTimeMillis());
    public void run()  {
        for(int j=0 ; j <= 10000 ;j+=1) {
            test.add(rand.nextInt()*12 + 3);
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("/home/ahmed/Desktop/tester.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(test);

        writer.close();

    }
}
