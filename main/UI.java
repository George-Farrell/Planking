package main;

import data.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class UI extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UI frame = new UI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UI() {
        setSize(600, 300);
        setResizable(false);
        setTitle("LordPlanking");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Normal", "Oak", "Teak", "Mahogany"}));
        contentPane.add(comboBox, BorderLayout.CENTER);

        lblLordplank.setFont(new Font("Southern Aire Personal Use Only", Font.PLAIN, 92));
        lblLordplank.setForeground(Color.DARK_GRAY);
        lblLordplank.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblLordplank, BorderLayout.NORTH);


        btnStartScript.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                StartButtonActionPerformed(e);
            }
        });
        contentPane.add(btnStartScript, BorderLayout.SOUTH);

    }

    private void StartButtonActionPerformed(java.awt.event.ActionEvent e) {
        switch (comboBox.getSelectedIndex()) {
            case 0:
                LordPlanking.LOG_ID = Constants.LOGS;
                LordPlanking.PLANK_ID = Constants.PLANKS;
                break;
            case 1:
                LordPlanking.LOG_ID = Constants.OAKLOGS;
                LordPlanking.PLANK_ID = Constants.OAKPLANKS;
                break;
            case 2:
                LordPlanking.LOG_ID = Constants.TEAKLOGS;
                LordPlanking.PLANK_ID = Constants.TEAKPLANKS;
                break;
            case 3:
                LordPlanking.LOG_ID = Constants.MAHOGANYLOGS;
                LordPlanking.PLANK_ID = Constants.MAHOGANYPLANKS;
                break;
            default:
                System.out.println("Error running the Script. Please Contact the Script Writer.");
                break;
        }
        isRunning = false;
        setVisible(false);
    }

    JButton btnStartScript = new JButton("Start Script");
    JComboBox comboBox = new JComboBox();
    JLabel lblLordplank = new JLabel("LordPlanking");
    boolean isRunning = true;
    private JPanel contentPane;
}
