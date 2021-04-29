package view;

import exception.ConnectionException;
import exception.SelectQueryException;
import view.thread.PaneThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Menu extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu jMenuNavigate,jMenuSearch,jMenuFile;
    private JMenuItem jMenuItemCustomer, jMenuItemCreateOrder,jMenuItemProductList,jMenuItemExit,jMenuItemSearch1,jMenuItemSearch2,jMenuItemSearch3;
    private JLabel welcomeMessage,info;
    private Container mainContainer;

    public Menu(){
        super("Menu With a Thread");
        //Opération spécifique à la fenêtre
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800,600));

        //Container
        mainContainer = getContentPane();
        mainContainer.add(new PaneThread(),BorderLayout.CENTER);

        //MenuBar
        jMenuBar = new JMenuBar();

        jMenuFile = new JMenu("File");
        jMenuSearch = new JMenu("Search");
        jMenuNavigate = new JMenu("Navigate");

        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuSearch);
        jMenuBar.add(jMenuNavigate);

        jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        jMenuFile.add(jMenuItemExit);


        jMenuItemCustomer = new JMenuItem("Customer list");
        jMenuItemCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CustomerList customerList = null;
                try {
                    customerList = new CustomerList();
                } catch (ConnectionException connectionException) {
                    connectionException.printStackTrace();
                } catch (SelectQueryException selectQueryException) {
                    selectQueryException.printStackTrace();
                }
                customerList.setVisible(true);
            }
        });
        jMenuItemCreateOrder = new JMenuItem("Create Order");
        jMenuItemCreateOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CreateOrder createOrder = new CreateOrder();
                createOrder.setVisible(true);
            }
        });
        jMenuItemProductList = new JMenuItem("Product List");
        jMenuItemProductList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ProductList productList = null;
                try {
                    productList = new ProductList();
                } catch (ConnectionException connectionException) {
                    JOptionPane.showMessageDialog(null,connectionException.getMessage(), "ConnectionException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (SelectQueryException selectQueryException) {
                    JOptionPane.showMessageDialog(null,selectQueryException.getMessage(), "ConnectionException",
                            JOptionPane.WARNING_MESSAGE);
                }
                productList.setVisible(true);
            }
        });
        jMenuNavigate.add(jMenuItemCustomer);
        jMenuNavigate.add(jMenuItemCreateOrder);
        jMenuNavigate.add(jMenuItemProductList);

        jMenuItemSearch1 = new JMenuItem("Search 1 Order listing");
        jMenuItemSearch1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
        jMenuItemSearch1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SearchOrderListing orderListing = new SearchOrderListing();
                orderListing.setVisible(true);
            }
        });
        jMenuItemSearch2 = new JMenuItem("Search 2 Customer by country");
        jMenuItemSearch2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.ALT_DOWN_MASK));
        jMenuItemSearch2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                SearchByCountry searchByCountry = null;
                try {
                    searchByCountry = new SearchByCountry();
                } catch (ConnectionException connectionException) {
                    JOptionPane.showMessageDialog(null,connectionException.getMessage(), "ConnectionException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (SelectQueryException selectQueryException) {
                    JOptionPane.showMessageDialog(null,selectQueryException.getMessage(), "QueryException",
                            JOptionPane.WARNING_MESSAGE);
                }
                searchByCountry.setVisible(true);

            }
        });
        jMenuItemSearch3 = new JMenuItem("Search 3 Product");
        jMenuItemSearch3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        jMenuItemSearch3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SearchByProduct searchByProduct = new SearchByProduct();
                searchByProduct.setVisible(true);
            }
        });
        jMenuSearch.add(jMenuItemSearch1);
        jMenuSearch.add(jMenuItemSearch2);
        jMenuSearch.add(jMenuItemSearch3);

        setJMenuBar(jMenuBar);


        //Welcome Message
        welcomeMessage = new JLabel("Welcome to the Order and Invoice Manager",JLabel.CENTER);
        welcomeMessage.setFont(new Font("Tahoma", Font.BOLD, 30));
        welcomeMessage.setForeground(new Color(102,102,255));
        mainContainer.add(welcomeMessage,BorderLayout.NORTH);
        info = new JLabel("You can visit this link to learn more about the program",JLabel.CENTER);
        info.setForeground(Color.BLUE);
        info.setFont(new Font("Tahoma", Font.ITALIC, 20));
        info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Desktop.getDesktop().browse(new URI("https://github.com/Cosmoss215/OrderAndInvoiceManager"));

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage(), "ConnectionException",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        mainContainer.add(info,BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);//Met la fenêtre au millieux de l'écran
        setVisible(true);
    }

}