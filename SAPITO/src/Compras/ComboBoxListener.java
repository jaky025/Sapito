package Compras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author K-PB-C05-L01
 */
public class ComboBoxListener implements ActionListener {

    JComboBox jComboBox;

    public ComboBoxListener(JComboBox jComboBox) {
        this.jComboBox = jComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("e:" + e.paramString());
        System.out.println(this.jComboBox.getSelectedIndex());
    }

}
