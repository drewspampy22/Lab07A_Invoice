import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvoiceFrame extends JFrame {
    JPanel mainPanel;
    JPanel titlePanel;
    JPanel lineItemsPanel;
    JPanel totalDuePanel;

    JLabel titleTxt;

    JTextArea lineItemsTxt;
    JTextArea totalTxt;

    JButton totalButton;

    public InvoiceFrame(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createTitlePanel();
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        createLineItemsPanel();
        mainPanel.add(lineItemsPanel, BorderLayout.CENTER);

        createTotalDuePanel();
        mainPanel.add(totalDuePanel, BorderLayout.SOUTH);

        add(mainPanel);
        setSize(400,500);
        setVisible(true);
    }

    public void createTitlePanel(){
        titlePanel = new JPanel();
        titleTxt = new JLabel();

        titleTxt.setText("INVOICE");
        titleTxt.setFont(new Font("Serif", Font.PLAIN, 36));
        titleTxt.setHorizontalTextPosition(JLabel.CENTER);

        titlePanel.add(titleTxt);
    }

    public void createLineItemsPanel(){
        lineItemsPanel = new JPanel();
        lineItemsTxt = new JTextArea("", 3,21);

        lineItemsPanel.add(lineItemsTxt);

        totalTxt = new JTextArea("",1,21);
        lineItemsPanel.add(totalTxt);
    }

    public void createTotalDuePanel(){
        totalDuePanel = new JPanel();
        totalButton = new JButton("Add Item");

        totalButton.addActionListener((ActionEvent ae)->
                {
                    totalTxt.selectAll();
                    totalTxt.replaceSelection("");

                    String Product = "";
                    String p = null;

                    do{
                        p = (String)JOptionPane.showInputDialog(
                                mainPanel,
                                "Input Product Name",
                                "",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                null,
                                ""
                        );
                        if(p != null && p.length() > 0){
                            Product = p;
                            p = "next";
                        }
                        else{
                            p = null;
                            JOptionPane.showMessageDialog(null, "Invalid Product!, Please try again.");
                        }
                    }while(p == null);

                    int Quantity = 0;
                    String q = null;
                    do{
                        q = (String) JOptionPane.showInputDialog(
                                mainPanel,
                                "Input Product Quantity",
                                "",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                null,
                                ""
                        );
                        if(q != null && q.length() > 0){
                            Quantity = Integer.parseInt(q);
                            q = "next";
                        }
                        else{
                            q = null;
                            JOptionPane.showMessageDialog(null, "Invalid Quantity!, Please try again.");
                        }
                    }while(q == null);

                    double unitPrice = 0;
                    String u = null;
                    do{
                        u = (String) JOptionPane.showInputDialog(
                                mainPanel,
                                "Input Unit Price",
                                "",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                null,
                                ""
                        );
                        if(u != null && u.length() > 0){
                            unitPrice = Double.parseDouble(u);
                            u = "next";
                        }
                        else{
                            u = null;
                            JOptionPane.showMessageDialog(null, "Invalid Price!, Please try again.");
                        }
                    }while(u == null);

                    Product product = new Product(Product, unitPrice);
                    lineItemsTxt.append(LineItems.listFormat(product, Quantity) + "\n");
                    totalTxt.append(LineItems.amountDue + "");
                }
        );
        totalDuePanel.add(totalButton);
    }
}
