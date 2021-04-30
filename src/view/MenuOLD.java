package view;

import exception.ConnectionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import exception.SelectQueryException;
import view.thread.PaneThread;

public class MenuOLD extends JFrame {
    private final JButton jButtonCreateOrder;
    private final JButton jButtonCustomer;
    private final JButton jButtonProduct;
    private final JMenu jMenu1;
    private final JMenu jMenu3;
    private final JMenuBar jMenuBar1;
    private final JMenu jMenuFile;
    private final JMenuItem jMenuItem1;
    private final JMenuItem jMenuItem2;
    private final JMenuItem jMenuItem3;
    private final JMenuItem jMenuItemExit;
    private final JMenuItem jMenuItemSearch1;
    private final JMenuItem jMenuItemSearch2;
    private final JMenuItem jMenuItemSearch3;
    private final JPanel jPanelMenu;
    private Container mainContainer;

    public MenuOLD(){
        jPanelMenu = new JPanel();
        jButtonCustomer = new JButton();
        jButtonCreateOrder = new JButton();
        jButtonProduct = new JButton();
        jMenuBar1 = new JMenuBar();
        jMenuFile = new JMenu();
        jMenuItemExit = new JMenuItem();
        jMenu3 = new JMenu();
        jMenuItemSearch1 = new JMenuItem();
        jMenuItemSearch2 = new JMenuItem();
        jMenuItemSearch3 = new JMenuItem();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainContainer = getContentPane();
        mainContainer.add(new PaneThread());

        jButtonCustomer.setFont(new Font("Dialog", 0, 24)); // NOI18N
        jButtonCustomer.setText("Customer");
        CustomerListner customerListner = new CustomerListner();
        jButtonCustomer.addActionListener(customerListner);


        jButtonCreateOrder.setFont(new Font("Dialog", 0, 24)); // NOI18N
        jButtonCreateOrder.setText("Create Order");
        CreateOrderListner createOrderListner = new CreateOrderListner();
        jButtonCreateOrder.addActionListener(createOrderListner);

        jButtonProduct.setFont(new Font("Dialog", 0, 24)); // NOI18N
        jButtonProduct.setText("Product list");
        ProductListListner productListListner = new ProductListListner();
        jButtonProduct.addActionListener(productListListner);

        GroupLayout jPanelMenuLayout = new GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
                jPanelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                                .addContainerGap(237, Short.MAX_VALUE)
                                .addGroup(jPanelMenuLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonCustomer, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButtonCreateOrder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonProduct, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
                                .addGap(231, 231, 231))
        );
        jPanelMenuLayout.setVerticalGroup(
                jPanelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                                .addContainerGap(214, Short.MAX_VALUE)
                                .addComponent(jButtonCustomer)
                                .addGap(31, 31, 31)
                                .addComponent(jButtonCreateOrder)
                                .addGap(32, 32, 32)
                                .addComponent(jButtonProduct)
                                .addGap(80, 80, 80))
        );

        jMenuFile.setText("File");
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar1.add(jMenuFile);

        jMenu3.setText("Search");

        jMenuItemSearch1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
        jMenuItemSearch1.setText("Search 1 Order listing");

        jMenuItemSearch1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SearchOrderListing orderListing = new SearchOrderListing();
                orderListing.setVisible(true);
            }
        });
        jMenu3.add(jMenuItemSearch1);

        jMenuItemSearch2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.ALT_DOWN_MASK));
        jMenuItemSearch2.setText("Search 2 Customer by country");
        jMenuItemSearch2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SearchByCountry searchByCountry = null;
                try {
                    searchByCountry = new SearchByCountry();
                } catch (ConnectionException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(), "ConnectionException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (SelectQueryException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(), "ConnectionException",
                            JOptionPane.WARNING_MESSAGE);
                }
                searchByCountry.setVisible(true);
            }
        });
        jMenu3.add(jMenuItemSearch2);

        jMenuItemSearch3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        jMenuItemSearch3.setText("Search 3 Product");


        jMenuItemSearch3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SearchByProduct searchByProduct = new SearchByProduct();
                searchByProduct.setVisible(true);
            }
        });
        jMenu3.add(jMenuItemSearch3);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Navigate");

        jMenuItem1.setText("Customer");
        jMenuItem1.addActionListener(customerListner);

        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Create Order");
        jMenuItem2.addActionListener(createOrderListner);

        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Product list");
        jMenuItem3.addActionListener(productListListner);

        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
    }

    private class CustomerListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                CustomerList customerList = new CustomerList();
                customerList.setVisible(true);
            } catch (ConnectionException connectionException) {
                JOptionPane.showMessageDialog(null,connectionException.getMessage(), "ConnectionException",
                        JOptionPane.WARNING_MESSAGE);
            } catch (SelectQueryException selectQueryException) {
                JOptionPane.showMessageDialog(null, selectQueryException.getMessage(), "SelectQueryException",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    private class CreateOrderListner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CreateOrder createOrder = new CreateOrder();
            createOrder.setVisible(true);
        }
    }
    private class ProductListListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductList productList = null;
            try {
                productList = new ProductList();
                productList.setVisible(true);
            } catch (ConnectionException connectionException) {
                JOptionPane.showMessageDialog(null,connectionException.getMessage(), "ConnectionException",
                        JOptionPane.WARNING_MESSAGE);
            } catch (SelectQueryException selectQueryException) {
                JOptionPane.showMessageDialog(null, selectQueryException.getMessage(), "SelectQueryException",
                        JOptionPane.WARNING_MESSAGE);
            }

        }
    }

}
