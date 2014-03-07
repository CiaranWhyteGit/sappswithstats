import com.sapps.lolstats.Sapp;

/**
 * Created by ciaranwhyte on 07/03/2014.
 */
public class SappPrinter {
    public static void main(String args[]){
        Sapp mordo = new Sapp("mordo");
        mordo.printDetailsToLog();
        Sapp theWiggler = new Sapp("thewiggler");
        theWiggler.printDetailsToLog();
        Sapp burpeeStarjump = new Sapp("burpeestarjump");
        burpeeStarjump.printDetailsToLog();
    }
}
