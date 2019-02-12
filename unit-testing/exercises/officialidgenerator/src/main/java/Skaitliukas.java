public class Skaitliukas {
 public final static String PRADINE="000";
  public static String n=PRADINE;
  public static void didintiVienetu() {
       try {
           int foo = Integer.parseInt(n);
           n=String.format("%1$03d", foo+1);
           //n = "000"+String.valueOf((foo + 1));
           if (foo==999) nustatytiNumatytajareiksme();
           else
           n= n.substring(n.length()-3);
       } catch (NumberFormatException e) {
           System.out.println(" pasitaike ne skaitmenu");
           System.exit(-1);
       }
   }

  private static void nustatytiNumatytajareiksme()
   { n=PRADINE;}
}
