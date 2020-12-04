package week2;

public class DnaGene {
	private static final String ATG = "ATG";
	private static final String TAA = "TAA";
	
	public String findSimpleGene(String dna) {
        String result = "";
        int atg = dna.indexOf(this.ATG);
        int taa = dna.indexOf(this.TAA, atg +3);
        
        if (atg == -1 && taa == -1){
            return "There is no "+ this.ATG + " or "+ this.TAA +" strand)";
        }
        if (atg == -1) {
            return "There is no "+ this.ATG + " strand";
        }
        if (taa == -1) {
            return "There is no "+ this.TAA +" strand";
        }
        else {
            result = dna.substring(atg,taa+3);
            int compare = result.length()% 3;
            if (compare == 0) {
                return result;
            }
            else {
                return "no mames wey, no multiplo";
            }
        }
    }
	
	public String findSimpleGene(String dna, String StartCodon, String StopCodon) {
        String resultTemp = "";
        int atg = dna.indexOf(this.ATG);
        int taa = dna.indexOf(this.TAA, atg +3);
        
        if (atg == -1 && taa == -1){
            return "There is no "+ this.ATG + " or TAA strand)";
        }
        if (atg == -1) {
            return "There is no "+ this.ATG + " strand";
        }
        if (taa == -1) {
            return "There is no "+ this.TAA +" strand";
        }
        else {
            resultTemp = dna.substring(atg,taa+3);
            String result= resultTemp.toLowerCase();
            int compare = result.length()% 3;
            if (compare == 0) {
                return result;
            }
            else {
                return "no mames wey, no multiplo";
            }
        }
    }
	
	public int findStopCodon(String dna, int startIndex, String stopCodon) {
        startIndex = dna.indexOf(this.ATG);
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = (currIndex - startIndex) % 3;
            if (diff == 0) {
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex +1);
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna){
        int atgCodon = dna.indexOf(this.ATG);
        
        if (atgCodon == -1) {
            return "NO "+ this.ATG + " CODON FOUND";
        }
        int taaCodon = findStopCodon(dna, atgCodon, this.TAA);
        int tagCodon = findStopCodon(dna, atgCodon, "TAG");
        int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
        int tempCodon = Math.min(taaCodon, tagCodon);
        int dnaFin = Math.min(tempCodon, tgaCodon);
        if (dnaFin == dna.length()) {
            return "NO GENE FOUND";
        }
        return dna.substring(atgCodon, dnaFin+3);
    }
    
    public void testFindSimpleGenePart1() {
      String gene = "";
      
      String dna = "AAATGCCCTAACTAGATTAAGAAACC";
      System.out.println("DNA Strand is = " + dna);
      gene = findSimpleGene(dna);
      System.out.println("Gene is = " + gene);

    }
    
    public void testFindSimpleGenePart2() {
        String gene = "";
        String dna = "AAAATACCAGTACCACTAAGGA";
        String StartCodon = this.ATG;
        String StopCodon = this.TAA;
        System.out.println("DNA Strand is = " + dna);
        gene = findSimpleGene(dna,StartCodon,StopCodon);
        System.out.println("Gene is = " + gene);
    }
    
    public void testFindGene(){
        String dna= "AGDEGAASZZATAAAAA";
        System.out.println("The dna string is :" + dna);
        String gene = findGene(dna);
        System.out.println("Gene found is :" + gene);
    }
    
    public void prrintAllGenes(){
        String dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaa"; 
        dna= "aaaaaaATGaaaaaaaaaTAGaaaa";
        dna = "AGDEGAASZZATAAAAA";
        while (true) {
            System.out.println("printing genes" + findGene(dna));
            if (findGene(dna).length() == -1) {
                break;
            }
        }
    }
    
    public static void main (String[] args) {
        DnaGene dnaGene = new DnaGene();
        dnaGene.testFindSimpleGenePart1();
    }

}
