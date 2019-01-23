package org.elevator;


	import javax.swing.JFrame;
	import javax.swing.table.*;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import java.awt.Dimension;
	import java.awt.GridLayout;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	public class Table extends JPanel {
	    private boolean DEBUG = false;
	    public static DefaultTableModel model;
	    public Table() {
	        super(new GridLayout(1,0));
	        model = new DefaultTableModel();
	        final JTable table = new JTable(model);
	        model.addColumn("Person number");
	        model.addColumn("Start Floor");
	        model.addColumn("End Floor");
	        model.addColumn("Wait for elevator");
	        model.addColumn("Traveling time");
	        model.addColumn("Total wait time");
	        

	        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
	        table.setFillsViewportHeight(true);

	        if (DEBUG) {
	            table.addMouseListener(new MouseAdapter() {
	                public void mouseClicked(MouseEvent e) {
	                    printDebugData(table);
	                }
	            });
	        }

	        //Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(table);

	        //Add the scroll pane to this panel.
	        add(scrollPane);
	    }

	    private void printDebugData(JTable table) {
	        int numRows = table.getRowCount();
	        int numCols = table.getColumnCount();
	        javax.swing.table.TableModel model = table.getModel();

	        System.out.println("Value of data: ");
	        for (int i=0; i < numRows; i++) {
	            System.out.print("    row " + i + ":");
	            for (int j=0; j < numCols; j++) {
	                System.out.print("  " + model.getValueAt(i, j));
	            }
	            System.out.println();
	        }
	        System.out.println("--------------------------");
	    }

	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    private static void createGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("SimpleTableDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Create and set up the content pane.
	        Table newContentPane = new Table();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);

	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createGUI();
	            }
	        });
	    }
	}