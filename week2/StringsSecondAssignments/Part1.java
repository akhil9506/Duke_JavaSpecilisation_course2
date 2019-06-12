
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna,int startindex,String stop){
        int curr_index = dna.indexOf(stop,startindex);
        if(curr_index == -1){
            return dna.length();
        }
        int n;
        while(true){
             n = curr_index-startindex;
            if(n%3==0){
            return curr_index;
            }
            else{
                curr_index = dna.indexOf(stop,curr_index+1);
                if(curr_index==-1){return dna.length();}
            }
        }
    }
    public void testFindStopCodon(){
        int start_index=0;
        String dna = "ATAATAATGATATATAGCCGATAA";
        start_index = dna.indexOf("ATG");
        System.out.println(dna.substring(start_index,3+findStopCodon(dna,start_index,"TAA")));
    }
    public String findGene(String dna){
        int start_index = dna.indexOf("ATG");
        if(start_index == -1){ return "";}
        int e1 =findStopCodon(dna,start_index,"TAA");
        int e2 =findStopCodon(dna,start_index,"TAG");
        int e3 =findStopCodon(dna,start_index,"TGA");
        int temp = Math.min(e1,e2);
        int end = Math.min(temp,e3);
        if(end == dna.length()){
            return "";
        }
        
        return dna.substring(start_index,end+3);
    }
    public void testGene(){
            //             01234567891011121314151617181920
            String dna1 = "ATATATATGTTAAATTTATAAATATAG";
            System.out.println("gene is"+findGene(dna1));
            String dna2 = "GCTGCTCTCTCGTCGTCTCGTCGTCGTAGTA";
            System.out.println("Gene is"+findGene(dna2));
            String dna3 = "AGCGCCATGAGCCAGAGCGCGCAGCGCGACGCGCAGCGCCGCT";
            System.out.println("Gene is"+findGene(dna3));
    }
}
