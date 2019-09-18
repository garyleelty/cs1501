package StringTable;

import java.util.*;

public class StringTable {

    Hashtable prefix;
    Hashtable table;
	ArrayList checkRepeat;

    public StringTable() {
        prefix= new Hashtable();
        table = new Hashtable();
		checkRepeat = new ArrayList<String>();
    }
    //insert the word in hash table
    public void insert(String s) {
        table.put(s.hashCode(), s);
        String temp = "";
        for (int n=0; n < s.length()-1; n++) {
            temp =temp+ s.charAt(n);
			prefix.put(temp.hashCode(),temp);
        }
    }
    //check word in prefix
    public boolean prefixContain(String s) {
        return prefix.containsKey(s.hashCode());
    }
    //check word in dic
    public boolean contain(String s) {
        return table.containsKey(s.hashCode());
    }
    //pass word in the rec
    public void read(String s) {
		ArrayList<String> stringsString = new ArrayList<String>();
        int x=0;
        while (x<s.length()) {
            String c ="";
            c = c + s.charAt(x);
            stringsString.add(c);
			//System.out.println(c);
            x++;
        }
        int n = 0;
        while (n < stringsString.size()) {
            String a=  stringsString.remove(n);
            res(a,stringsString,new String());
            stringsString.add(n, a);
            n++;
        }
    }

    public void res(String s,ArrayList<String> a,String result) {
        if(prefixContain(s)||s.length() == 0) {
            for(int n=0; n<a.size();n++) {
                String temp =  a.get(n);
				s += a.remove(n);
				//System.out.println(s);
                res(s,a, result);
				s =s.substring(0,s.length()-1);
                a.add(n, temp);
            }
        }
            if(contain(s)) {
                result= result+s+" ";
				//System.out.println(result);
                if(a.isEmpty()&&!checkRepeat.contains(result)) {
					checkRepeat.add(result);
					//check if repeat or not
                    System.out.println(result);
                }else {
                    res("",a,result);
                    //renew the string
                }
            }
    }

}