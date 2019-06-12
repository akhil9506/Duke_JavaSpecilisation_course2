
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part1 {
    public String findSimpleGene(String str){
        String start = "ATG";
        String end ="TAA";
        int s,e;
        s = str.indexOf(start);
        if(s<0){return "";}
        e = str.indexOf(end,s+3);
        if(e<0){return "";}
        if((e-s)%3==0){
        return str.substring(s,e+3);
        }
        return "";
    }
    public void testSimpleGene(){
        String dna1 = "ATCGATCGC";
        String dna2 = "ATATGATTATATAT";
        String dna3 = "ATTATAATGATCACCCCCCCTATAA";
        String dna4 = "ATAAATATGATCCTACATTAA";
        System.out.println(findSimpleGene(dna1));
        System.out.println(findSimpleGene(dna2));
        System.out.println(findSimpleGene(dna3));
        System.out.println(findSimpleGene(dna4));
    }
}
