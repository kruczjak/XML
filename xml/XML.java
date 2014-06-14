package xml;

/**
 * Created by kruczjak on 02.06.2014.
 */
public class XML {
    public static void main(String[] args) {
        long stime = System.currentTimeMillis();
        long sfree = Runtime.getRuntime().freeMemory();
        int nodes = XMLSAXParser.run("big.xml");
        long eTotal = Runtime.getRuntime().totalMemory();
        long eTime = System.currentTimeMillis();
        System.out.println("SAX: " + nodes);
        System.out.println("Czas: " + (eTime - stime) + "ms | " + (eTotal - sfree) + "  bajtów ");
        System.out.println();

        stime = System.currentTimeMillis();
        sfree = Runtime.getRuntime().freeMemory();
        nodes = XMLDOMParser.run("big.xml");
        eTime = System.currentTimeMillis();
        eTotal = Runtime.getRuntime().totalMemory();
        System.out.println("DOM: " + nodes);
        System.out.println("Czas: " + (eTime - stime) + "ms | " + (eTotal - sfree) + "  bajtów ");
    }
}
