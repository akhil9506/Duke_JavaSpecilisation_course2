
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    public String findSimpleGene(String str,String start,String end){
        //String start = "ATG";
        //String end ="TAA";
        int s,e;
        str =str.toUpperCase();
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
        String dna5 = "ataaatatgatcctacattaa";
        System.out.println(findSimpleGene(dna1,"ATG","TAA"));
        System.out.println(findSimpleGene(dna2,"ATG","TAA"));
        System.out.println(findSimpleGene(dna3,"ATG","TAA"));
        System.out.println(findSimpleGene(dna4,"ATG","TAA"));
    }
}
