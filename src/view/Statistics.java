package view;


import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.OrderBusinessTask;
import model.StatisticsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Statistics extends JFrame {
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel jLabelAverage;
    private javax.swing.JLabel jLabelMaxPrice;
    private javax.swing.JLabel jLabelProfit1;
    private javax.swing.JLabel jLabelRepresentativeness;
    private javax.swing.JTextField profitTextField;
    private javax.swing.JTextField maxTextField;
    private javax.swing.JTextField averageTextField;
    private javax.swing.JTextField reprentativeness;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField searchProductReference;

    public Statistics(){
        mainPanel = new javax.swing.JPanel();
        searchProductReference = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jLabelMaxPrice = new javax.swing.JLabel();
        jLabelAverage = new javax.swing.JLabel();
        jLabelProfit1 = new javax.swing.JLabel();
        jLabelRepresentativeness = new javax.swing.JLabel();
        profitTextField = new javax.swing.JTextField();
        maxTextField = new javax.swing.JTextField();
        averageTextField = new javax.swing.JTextField();
        reprentativeness = new javax.swing.JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        searchProductReference.setFont(new java.awt.Font("Tahoma", 0, 18));

        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 18));
        SearchButton.setText("Search");
        SearchButton.addActionListener(evt -> {
            try {
                ApplicationController applicationController = new ApplicationController();
                ArrayList<OrderBusinessTask> orderBusinessTasks = applicationController.getAllOrderBusinessTask();

                StatisticsModel statisticsModel = applicationController.getStatsFromAllSales(orderBusinessTasks, Integer.parseInt(searchProductReference.getText()));
                maxTextField.setText(String.valueOf(statisticsModel.getMax()));
                profitTextField.setText(String.valueOf(statisticsModel.getProfit()));
                averageTextField.setText(String.valueOf(statisticsModel.getAverageOrdersPrices()));
                reprentativeness.setText(String.valueOf(statisticsModel.getPercentageRepresentativeness()));

            } catch (ConnectionException | SelectQueryException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }

        });
        jLabelMaxPrice.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabelMaxPrice.setText("Maximum price of an order");

        jLabelAverage.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabelAverage.setText("Average orders prices");

        jLabelProfit1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabelProfit1.setText("Company profit");

        jLabelRepresentativeness.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabelRepresentativeness.setText("Representativeness of the ordered product");

        profitTextField.setFont(new java.awt.Font("Tahoma", 0, 14));
        profitTextField.setText("");

        maxTextField.setFont(new java.awt.Font("Tahoma", 0, 14));
        maxTextField.setText("");

        averageTextField.setFont(new java.awt.Font("Tahoma", 0, 14));
        averageTextField.setText("");

        reprentativeness.setFont(new java.awt.Font("Tahoma", 0, 14));
        reprentativeness.setText("");

        WindowFormattingCode();

    }
    private void WindowFormattingCode(){
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(searchProductReference)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelProfit1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelRepresentativeness))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(0, 115, Short.MAX_VALUE)
                                                .addComponent(SearchButton))
                                        .addComponent(profitTextField)
                                        .addComponent(maxTextField)
                                        .addComponent(averageTextField)
                                        .addComponent(reprentativeness))
                                .addGap(31, 31, 31))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchProductReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchButton))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelRepresentativeness)
                                        .addComponent(reprentativeness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }
}
