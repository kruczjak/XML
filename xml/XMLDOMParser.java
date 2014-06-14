package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.TreeWalker;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by kruczjak on 02.06.2014.
 */
public class XMLDOMParser {

    public static int nodes = 0;

    public static int run(String input_file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder loader = factory.newDocumentBuilder();
            Document document = loader.parse(input_file);
            DocumentTraversal traversal = (DocumentTraversal) document;
            TreeWalker walker = traversal.createTreeWalker(document.getDocumentElement(), NodeFilter.SHOW_ELEMENT, null, true);
            traverseLevel(walker);
            return nodes;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    private static void traverseLevel(TreeWalker walker) {
        nodes++;
        Node parent = walker.getCurrentNode();
        for (Node n = walker.firstChild(); n != null; n = walker.nextSibling()) {
            traverseLevel(walker);
        }
        walker.setCurrentNode(parent);
    }
}
