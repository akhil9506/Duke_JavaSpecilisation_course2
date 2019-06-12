
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howmany(String stra,String strb){
        int counter=0;//counts the number of occurences
        int n = strb.indexOf(stra);
        if(n ==-1){
            return 0;
        }
        while(true){
        if(n != -1)
        {
            counter++;
            n = strb.indexOf(stra,n+stra.length());
        }
        else{
            return counter;
        }
        }
    }
    public void testhowmany(){
        System.out.println(howmany("GAA","ATGAACGAATTGAATC"));
        System.out.println(howmany("AA", "ATAAAA"));
    }
}
