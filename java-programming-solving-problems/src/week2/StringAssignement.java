package week2;


public class StringAssignement {
	public boolean twoOccurrences (String stringa, String stringb) {
        int occurrence = stringb.indexOf(stringa);
        if (occurrence == -1) {
            return false;
   
        }
        else {
            System.out.println("occurrence= "+occurrence);
            return true;
        }
        
    }
    
    public String lastPart(String stringa, String stringb){
        int occurrence = stringb.indexOf(stringa); 
        int startFrom = stringa.length(); 
        String finalPart = stringb.substring(startFrom+occurrence); 
        if (occurrence == -1){
            return stringb;
        }
        else {
            return finalPart;
        }
       
    }
    
    public void testing(){
        String stringa = "by";
        String stringb = "A story by Abby Long";
        System.out.println("stringa = "+stringa + " and stringb = " + stringb);
        System.out.println(twoOccurrences(stringa, stringb));
        
        stringa = "a";
        stringb = "banana";
        System.out.println("stringa = "+stringa + " and stringb = " + stringb);
        System.out.println(twoOccurrences(stringa, stringb));
        
        stringa = "a";
        stringb = "melocoton";
        System.out.println("stringa = "+stringa + " and stringb = " + stringb);
        System.out.println(twoOccurrences(stringa, stringb));
    }
    
    public void testingLastPart(){
        String stringa = "an";
        String stringb = "banana";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));
        
        stringa = "rest";
        stringb = "deforestacion";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));
        
        stringa = "cio";
        stringb = "deforestacion";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));
        
        stringa = "zoo";
        stringb = "forest";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));
    }
}
