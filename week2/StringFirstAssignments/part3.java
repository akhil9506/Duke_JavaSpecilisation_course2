
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part3 {
    public boolean twoOccurences(String a, String b){
        int s,e;
        s = b.indexOf(a);
        
        if(s<0){return false;}
        //System.out.println(s);
        e = b.indexOf(a,s+a.length());
        if(e<0){return false;}
        return true;
    }
    public String lastpart(String a,String b){
        int s = b.indexOf(a);
        if(s>=0){
        return b.substring(s+a.length());
        }
        return b;
    }
    public void testing(){
    String s1="by";
    String s2 = "hellobyby";
    String s3 = "A by b";
    String s4 = "byby";
    String s5 = "alekhya";
    System.out.println(twoOccurences(s1,s2));
    System.out.println(twoOccurences(s1,s3));
    System.out.println(twoOccurences(s1,s4));
    System.out.println(twoOccurences(s1,s5));
    System.out.println(lastpart(s1,s2));
    System.out.println(lastpart(s1,s3));
    System.out.println(lastpart(s1,s4));
    System.out.println(lastpart(s1,s5));
    }
}
