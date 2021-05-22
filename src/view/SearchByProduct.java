package view;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.NullException;
import exception.SelectQueryException;
import model.Customer;
import model.CustomerByProduct;
import model.Product;
import util.Verification;
import view.tableModel.AllCustomersByProductModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SearchByProduct extends JFrame {
    private final JLabel jLabelProduct;
    private final JScrollPane jScrollPane1;
    private final JTable jTableCustomersByProduct;
    private final JTextField jTextFieldFindProduct;
    private final JPanel panelSearchBar;
    private final JPanel panelTableByProduct;
    private ArrayList<Product> products;
    private Integer currentReference;

    public SearchByProduct() throws SelectQueryException, ConnectionException, NullException {
        super("Search product with reference");
        this.setResizable(false);
        panelSearchBar = new JPanel();
        jLabelProduct = new JLabel();
        jTextFieldFindProduct = new JTextField();
        panelTableByProduct = new JPanel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelProduct.setFont(new Font("Tahoma", 0, 18));
        jLabelProduct.setText("Product");

        ApplicationController getProductByReference = new ApplicationController();
        products = getProductByReference.getAllProducts();
        ArrayList<CustomerByProduct> customersByProduct = getProductByReference.getProductByReference(0);
        AllCustomersByProductModel customersByProductModel = new AllCustomersByProductModel(customersByProduct);

        jTableCustomersByProduct = new JTable(customersByProductModel);
        jTableCustomersByProduct.setAutoCreateRowSorter(true);
        jScrollPane1 = new JScrollPane(jTableCustomersByProduct);
        jScrollPane1.setViewportView(jTableCustomersByProduct);

        jTextFieldFindProduct.setFont(new Font("Tahoma", 0, 16));
        jTextFieldFindProduct.setText("");
        KeyboardListner keyboardListner = new KeyboardListner();
        jTextFieldFindProduct.addKeyListener(keyboardListner);

        jTextFieldFindProduct.addActionListener(evt -> {
            try {
                ApplicationController getProductByReference1 = new ApplicationController();
                ArrayList<CustomerByProduct> customersByProduct1;
                if (Verification.productReferenceVerification(currentReference.toString()))
                {
                    customersByProduct1 = getProductByReference1.getProductByReference(currentReference);
                    AllCustomersByProductModel customersByProductModel1 = new AllCustomersByProductModel(customersByProduct1);
                    jTableCustomersByProduct.setModel(customersByProductModel1);
                }
                else {
                    JOptionPane.showMessageDialog(null,"The given reference is not correct, open the product list to help you", "Incorrect reference ", JOptionPane.INFORMATION_MESSAGE);
                    jTextFieldFindProduct.setBorder(new LineBorder(Color.red,3));
                }
            } catch (ConnectionException | SelectQueryException | NullException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }
        });

        WindowFormattingCode();

        pack();
    }
    private void WindowFormattingCode(){
        GroupLayout panelSearchBarLayout = new GroupLayout(panelSearchBar);
        panelSearchBar.setLayout(panelSearchBarLayout);
        panelSearchBarLayout.setHorizontalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelProduct)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldFindProduct, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelSearchBarLayout.setVerticalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelProduct)
                                        .addComponent(jTextFieldFindProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout panelTableByProductLayout = new GroupLayout(panelTableByProduct);
        panelTableByProduct.setLayout(panelTableByProductLayout);
        panelTableByProductLayout.setHorizontalGroup(
                panelTableByProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelTableByProductLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelTableByProductLayout.setVerticalGroup(
                panelTableByProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelTableByProductLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 21, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelSearchBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(panelTableByProduct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(590, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 66, Short.MAX_VALUE)
                                        .addComponent(panelTableByProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );

    }

    private void autoComplete (String txt){
        String complete = "";
        int start = txt.length();
        int last = txt.length();

        int iCustomer = 0;
        boolean isFind = false;
        while (iCustomer < products.size() && !isFind){
            Product currentProduct = products.get(iCustomer);
            if (currentProduct.getWording().startsWith(txt) ||currentProduct.getReference().toString().startsWith(txt)) {
                complete = products.get(iCustomer).getWording() + " " + products.get(iCustomer).getReference();
                currentReference = products.get(iCustomer).getReference();
                last = complete.length();
                isFind = true;
            }
            iCustomer++;
        }

        if (last > start) {
            jTextFieldFindProduct.setText(complete);
            jTextFieldFindProduct.setCaretPosition(last);
            jTextFieldFindProduct.moveCaretPosition(start);
            currentReference = products.get(iCustomer).getReference();
        }
    }

    private class KeyboardListner implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent evt) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_BACK_SPACE:
                    break;
                case KeyEvent.VK_ENTER:
                    jTextFieldFindProduct.setText(jTextFieldFindProduct.getText());
                    break;
                default:
                    EventQueue.invokeLater(new Runnable(){
                        @Override

                        public void run(){
                            String txt = jTextFieldFindProduct.getText();
                            autoComplete(txt);
                        }
                    });
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
