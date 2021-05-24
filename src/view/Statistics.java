package view;


import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.OrderBusinessTask;
import model.Product;
import model.StatisticsModel;
import util.NumberFormater;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Statistics extends JFrame {
    private  JButton SearchButton;
    private  JLabel jLabelAverage,jLabelMaxPrice,jLabelProfit1,jLabelRepresentativeness, jLabelTotalProductPrice,jLabelProductReference,jLabelTitle;
    private  JTextField profitTextField,maxTextField,averageTextField,reprentativeness,referencedProductTotalPrice;
    private JComboBox<String> searchProductReference;
    private  JPanel mainPanel;
    private StatisticsModel statisticsModel;
    private Container frameContainer;

    public Statistics() throws ConnectionException, SelectQueryException {

        super("Statistics");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ApplicationController applicationController = new ApplicationController();
        ArrayList<Product> products = applicationController.getAllProducts();

        int i = 0;
        String [] pattern = new String[products.size()];
        for (Product p : products){
            pattern[i] = p.getWording();
            i++;
        }
        searchProductReference = new JComboBox<>(pattern);

        initLabelAndTextField();

        WindowFormattingCode();

        ArrayList<OrderBusinessTask> orderBusinessTasks = applicationController.getAllOrderBusinessTask();
        statisticsModel = applicationController.getStatsFromAllSales(orderBusinessTasks,searchProductReference.getSelectedItem().toString());

        maxTextField.setText(NumberFormater.primaryDecimalFormater(statisticsModel.getMax()) + " €");
        profitTextField.setText(NumberFormater.primaryDecimalFormater(statisticsModel.getProfit()) + " €");
        averageTextField.setText(NumberFormater.primaryDecimalFormater(statisticsModel.getAverageOrdersPrices()) + " €");

        SearchButton.addActionListener(evt -> {
            statisticsModel = applicationController.getStatsFromAllSales(orderBusinessTasks,searchProductReference.getSelectedItem().toString());
            reprentativeness.setText(NumberFormater.primaryDecimalFormater(statisticsModel.getPercentageRepresentativeness()) + " %");
            referencedProductTotalPrice.setText(NumberFormater.primaryDecimalFormater(statisticsModel.getReferencedProductTotalPrice()) + " €");

        });

    }
    private void initLabelAndTextField(){
        mainPanel = new JPanel();
        SearchButton = new JButton();
        jLabelMaxPrice = new JLabel();
        jLabelAverage = new JLabel();
        jLabelProfit1 = new JLabel();
        jLabelRepresentativeness = new JLabel();
        jLabelTotalProductPrice = new JLabel();
        profitTextField = new JTextField();
        maxTextField = new JTextField();
        averageTextField = new JTextField();
        reprentativeness = new JTextField();
        referencedProductTotalPrice = new JTextField();
        jLabelProductReference = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();

        jLabelProductReference.setFont(new java.awt.Font("Tahoma", 0, 16));
        jLabelProductReference.setText("Product wording");

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 16));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Statistics");

        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 16));
        SearchButton.setText("Search");

        searchProductReference.setFont(new java.awt.Font("Tahoma", 0, 16));
        searchProductReference.setToolTipText("Choose your product (The product list will give you more information - CTRL P in the menu)");

        jLabelMaxPrice.setFont(new java.awt.Font("Tahoma", 0, 16));
        jLabelMaxPrice.setText("Maximum price of an order");

        jLabelAverage.setFont(new java.awt.Font("Tahoma", 0, 16));
        jLabelAverage.setText("Average orders prices");

        jLabelProfit1.setFont(new java.awt.Font("Tahoma", 0, 16));
        jLabelProfit1.setText("Company profit");

        jLabelRepresentativeness.setFont(new java.awt.Font("Tahoma", 0, 16));
        jLabelRepresentativeness.setText("Representativeness of the ordered product");

        jLabelTotalProductPrice.setFont(new java.awt.Font("Tahoma", 0, 16));
        jLabelTotalProductPrice.setText("Referenced product total price");

        profitTextField.setFont(new java.awt.Font("Tahoma", 0, 16));
        profitTextField.setHorizontalAlignment(SwingConstants.CENTER);

        maxTextField.setFont(new java.awt.Font("Tahoma", 0, 16));
        maxTextField.setHorizontalAlignment(SwingConstants.CENTER);

        averageTextField.setFont(new java.awt.Font("Tahoma", 0, 16));
        averageTextField.setHorizontalAlignment(SwingConstants.CENTER);

        reprentativeness.setFont(new java.awt.Font("Tahoma", 0, 16));
        reprentativeness.setHorizontalAlignment(SwingConstants.CENTER);

        referencedProductTotalPrice.setFont(new java.awt.Font("Tahoma", 0, 16));
        referencedProductTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void WindowFormattingCode(){
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelTotalProductPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelRepresentativeness, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(33, 295, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelProfit1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelProductReference, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                                                .addComponent(searchProductReference, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(SearchButton))
                                                                        .addComponent(maxTextField)
                                                                        .addComponent(profitTextField)
                                                                        .addComponent(averageTextField)
                                                                        .addComponent(reprentativeness)
                                                                        .addComponent(referencedProductTotalPrice))))
                                                .addGap(31, 31, 31))))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchProductReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchButton)
                                        .addComponent(jLabelProductReference))
                                .addGap(35, 35, 35)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelProfit1)
                                        .addComponent(profitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelMaxPrice)
                                        .addComponent(maxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelAverage)
                                        .addComponent(averageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelRepresentativeness)
                                        .addComponent(reprentativeness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTotalProductPrice)
                                        .addComponent(referencedProductTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }



}
