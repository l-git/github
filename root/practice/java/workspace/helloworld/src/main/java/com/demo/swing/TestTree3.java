package com.demo.swing;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeModel;

public class TestTree3 extends JFrame {

  JTree tree;

  DefaultTreeModel treeModel;

  public TestTree3() {
    super("Tree Test Example");
    setSize(200, 150);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Add our own customized tree icons.
   /* UIManager.put("Tree.leafIcon", new ImageIcon("world.gif"));
    UIManager.put("Tree.openIcon", new ImageIcon("door.open.gif"));
    UIManager.put("Tree.closedIcon", new ImageIcon("door.closed.gif"));
    UIManager.put("Tree.expandedIcon", new ImageIcon("unlocked.gif"));
    UIManager.put("Tree.collapsedIcon", new ImageIcon("locked.gif"));*/
  }

  public void init() {
    // Build the hierarchy of containers & objects.
    String[] schoolyard = { "School", "Playground", "Parking Lot", "Field" };
    String[] mainstreet = { "Grocery", "Shoe Shop", "Five & Dime",
        "Post Office" };
    String[] highway = { "Gas Station", "Convenience Store" };
    String[] housing = { "Victorian_blue", "Faux Colonial",
        "Victorian_white" };
    String[] housing2 = { "Mission", "Ranch", "Condo" };
    Hashtable homeHash = new Hashtable();
    homeHash.put("Residential 1", housing);
    homeHash.put("Residential 2", housing2);

    Hashtable cityHash = new Hashtable();
    cityHash.put("School grounds", schoolyard);
    cityHash.put("Downtown", mainstreet);
    cityHash.put("Highway", highway);
    cityHash.put("Housing", homeHash);

    Hashtable worldHash = new Hashtable();
    worldHash.put("My First VRML World", cityHash);

    // Build our tree out of our big hash table.
    tree = new JTree(worldHash);

    // Pick an angled line style.
    tree.putClientProperty("JTree.lineStyle", "Angled");
    getContentPane().add(tree, BorderLayout.CENTER);
  }

  public static void main(String args[]) {
	  
	  
	  //JOptionPane.showMessageDialog(null," message");
	  
	  
    TestTree3 tt = new TestTree3();
    tt.init();
    tt.setVisible(true);
  }
}
