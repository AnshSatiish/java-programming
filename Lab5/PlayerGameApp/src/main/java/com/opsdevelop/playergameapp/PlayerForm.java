package com.opsdevelop.playergameapp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Player Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Components
        JTextField playerIdField = new JTextField(10);
        JTextField firstNameField = new JTextField(20);
        JTextField lastNameField = new JTextField(20);
        JTextField addressField = new JTextField(30);
        JTextField postalCodeField = new JTextField(10);
        JTextField provinceField = new JTextField(15);
        JTextField phoneNumberField = new JTextField(15);

        JButton insertButton = new JButton("Insert");

        // Panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Player ID:"));
        panel.add(playerIdField);
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Postal Code:"));
        panel.add(postalCodeField);
        panel.add(new JLabel("Province:"));
        panel.add(provinceField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(insertButton);

        frame.add(panel);
        frame.setVisible(true);

        // Action Listener for Insert Button
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int playerId = Integer.parseInt(playerIdField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                String postalCode = postalCodeField.getText();
                String province = provinceField.getText();
                String phoneNumber = phoneNumberField.getText();

                PlayerDAO playerDAO = new PlayerDAO();
                playerDAO.insertPlayer(playerId, firstName, lastName, address, postalCode, province, phoneNumber);
            }
        });
    }
}
