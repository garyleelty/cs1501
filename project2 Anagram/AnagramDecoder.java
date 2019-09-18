import StringTable.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


public class AnagramDecoder {
    


    public static void main(String[] args) {
		StringTable x = new StringTable();
        if(args.length<2) {
            System.out.println("Error");
        }else {

            String dic = args[0];
            String word = args[1];
            //System.out.println(dic);
            //System.out.println(word);

            BufferedReader br = null;
            FileReader fr = null;
            try {
                fr = new FileReader(dic);
                br = new BufferedReader(fr);
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    x.insert(sCurrentLine);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
			//System.out.println(word);
			x.read(word);
        }

    }

    //insert dictionary and prefix



}