package view;

import exception.ConnectionException;
import exception.NullException;
import exception.SelectQueryException;
import exception.ThreadException;
import view.thread.PaneThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Menu extends JFrame {
    private JMenuItem jMenuItemCustomer,jMenuItemExit,jMenuItemCreateOrder,jMenuItemProductList,jMenuItemStatistics,jMenuItemSearch1,jMenuItemSearch2,jMenuItemSearch3;
    private final Container mainContainer;

    public Menu(){
        super("Menu With a Thread");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(800,500));

        mainContainer = getContentPane();
        try{
            PaneThread paneThread = new PaneThread();
            mainContainer.add(paneThread,BorderLayout.CENTER);
        } catch (ThreadException threadException) {
            JOptionPane.showMessageDialog(null,threadException.getMessage(), threadException.getTypeError(), JOptionPane.WARNING_MESSAGE);
        }
        initMenuBar();

        messageDisplay();

        pack();

        setLocationRelativeTo(null);//Met la fenêtre au millieu de l'écran

        setVisible(true);
    }

    private void messageDisplay(){
        JLabel welcomeMessage = new JLabel("Welcome to the Order and Invoice Manager", JLabel.CENTER);
        welcomeMessage.setFont(new Font("Tahoma", Font.BOLD, 30));
        welcomeMessage.setForeground(new Color(102,102,255));
        mainContainer.add(welcomeMessage,BorderLayout.NORTH);
        JLabel info = new JLabel("You can visit this link to learn more about the program", JLabel.CENTER);
        info.setForeground(Color.BLUE);
        info.setFont(new Font("Tahoma", Font.ITALIC, 20));
        info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Desktop.getDesktop().browse(new URI("https://github.com/Cosmoss215/OrderAndInvoiceManager"));

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage(), "Exception",JOptionPane.WARNING_MESSAGE);
                }
            }});
        mainContainer.add(info,BorderLayout.SOUTH);
    }

    private void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        JMenu jMenuSearch = new JMenu("Search");
        JMenu jMenuNavigate = new JMenu("Navigate");

        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuSearch);
        jMenuBar.add(jMenuNavigate);

        initJMenuItem();

        jMenuFile.add(jMenuItemExit);
        jMenuNavigate.add(jMenuItemCustomer);
        jMenuNavigate.add(jMenuItemCreateOrder);
        jMenuNavigate.add(jMenuItemProductList);
        jMenuNavigate.add(jMenuItemStatistics);

        jMenuSearch.add(jMenuItemSearch1);
        jMenuSearch.add(jMenuItemSearch2);
        jMenuSearch.add(jMenuItemSearch3);
        setJMenuBar(jMenuBar);
    }

    private void initJMenuItem(){
        jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_DOWN_MASK));
        jMenuItemExit.addActionListener(evt -> {
            JOptionPane.showMessageDialog(null,"The task failed succesfully","ouch", JOptionPane.WARNING_MESSAGE); //Il s'agit bien évidement d'un référence à un blague mythique : https://medium.com/swlh/the-ten-most-ridiculous-error-messages-in-the-history-of-software-4198d710ea8e
            System.exit(0);
        });

        jMenuItemCustomer = new JMenuItem("Customer list");
        jMenuItemCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
        jMenuItemCustomer.addActionListener(evt -> {
            try {
                CustomerList customerList = new CustomerList();
                customerList.setVisible(true);
            } catch (ConnectionException | SelectQueryException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }

        });
        jMenuItemCreateOrder = new JMenuItem("Create Order");
        jMenuItemCreateOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
        jMenuItemCreateOrder.addActionListener(evt -> {
            try {
                CreateOrder createOrder = new CreateOrder();
                createOrder.setVisible(true);
            } catch (ConnectionException | SelectQueryException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }

        });
        jMenuItemProductList = new JMenuItem("Product List");
        jMenuItemProductList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        jMenuItemProductList.addActionListener(evt -> {
            try {
                ProductList productList = new ProductList();
                productList.setVisible(true);
            } catch (ConnectionException | SelectQueryException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }
        });
        jMenuItemStatistics = new JMenuItem("Statistics");
        jMenuItemStatistics.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.ALT_DOWN_MASK));
        jMenuItemStatistics.addActionListener(evt -> {
            Statistics statisticsView = new Statistics();
            statisticsView.setVisible(true);
        });
        jMenuItemSearch1 = new JMenuItem("Search 1 Order listing");
        jMenuItemSearch1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.ALT_DOWN_MASK));
        jMenuItemSearch1.addActionListener(evt -> {
            try {
                SearchOrderListing orderListing = new SearchOrderListing();
                orderListing.setVisible(true);
            } catch (ConnectionException | SelectQueryException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }
        });
        jMenuItemSearch2 = new JMenuItem("Search 2 Customer by country");
        jMenuItemSearch2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.ALT_DOWN_MASK));
        jMenuItemSearch2.addActionListener(evt -> {
            try {
                SearchByCountry searchByCountry = new SearchByCountry();
                searchByCountry.setVisible(true);
            } catch (ConnectionException connectionException) {
                JOptionPane.showMessageDialog(null,connectionException.getMessage(), "ConnectionException", JOptionPane.WARNING_MESSAGE);
            } catch (SelectQueryException selectQueryException) {
                JOptionPane.showMessageDialog(null,selectQueryException.getMessage(), "QueryException", JOptionPane.WARNING_MESSAGE);
            }
        });
        jMenuItemSearch3 = new JMenuItem("Search 3 By product");
        jMenuItemSearch3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
        jMenuItemSearch3.addActionListener(evt -> {
            try {
                SearchByProduct searchByProduct = new SearchByProduct();
                searchByProduct.setVisible(true);
            } catch (SelectQueryException | ConnectionException | NullException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }
        });
    }


}