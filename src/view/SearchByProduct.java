package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByProduct extends JFrame {
    private JButton jButton1;
    private JLabel jLabelProduct;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextFieldFindProduct;
    private JPanel panelSearchBar,panelTableByProduct;

    public SearchByProduct()
    {
        panelSearchBar = new JPanel();
        jLabelProduct = new JLabel();
        jTextFieldFindProduct = new JTextField();
        jButton1 = new JButton();
        panelTableByProduct = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelProduct.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelProduct.setText("Product");

        jTextFieldFindProduct.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldFindProduct.setText("");
        jTextFieldFindProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldFindProductActionPerformed(evt);
            }
        });
        jButton1.setBackground(new Color(0, 204, 204));
        jButton1.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("Search");

        jScrollPane1.setViewportView(jTable1);

        //region Code de mise en forme
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
                                .addComponent(jButton1)
                                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelSearchBarLayout.setVerticalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelProduct)
                                        .addComponent(jTextFieldFindProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
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
        //endregion

        pack();
    }
}
