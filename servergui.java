import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame {

    private JTextField publicIPField;
    private JTextField privateIPField;
    private JTextField portField;
    private JTextField xmsField;
    private JTextField xmxField;
    private JTextArea consoleArea;

    public ServerGUI() {
        setTitle("PokeMMOFanonbeta Server GUI");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Server Status
        JLabel statusLabel = new JLabel("Status: ONLINE");
        statusLabel.setBounds(10, 10, 150, 25);
        add(statusLabel);

        // Public IP
        JLabel publicIPLabel = new JLabel("Public IP Address:");
        publicIPLabel.setBounds(10, 40, 150, 25);
        add(publicIPLabel);

        publicIPField = new JTextField("Your Public IP");
        publicIPField.setBounds(160, 40, 150, 25);
        add(publicIPField);

        // Private IP
        JLabel privateIPLabel = new JLabel("Private IP Address:");
        privateIPLabel.setBounds(10, 70, 150, 25);
        add(privateIPLabel);

        privateIPField = new JTextField("192.168.1.100");
        privateIPField.setBounds(160, 70, 150, 25);
        add(privateIPField);

        // Port
        JLabel portLabel = new JLabel("Port:");
        portLabel.setBounds(10, 100, 150, 25);
        add(portLabel);

        portField = new JTextField("25565");
        portField.setBounds(160, 100, 150, 25);
        add(portField);

        // Copy Button
        JButton copyButton = new JButton("Copy");
        copyButton.setBounds(320, 40, 100, 25);
        add(copyButton);

        // Refresh Button
        JButton refreshButton = new JButton("Refresh Now");
        refreshButton.setBounds(320, 70, 150, 25);
        add(refreshButton);

        // XMS
        JLabel xmsLabel = new JLabel("XMS:");
        xmsLabel.setBounds(10, 130, 150, 25);
        add(xmsLabel);

        xmsField = new JTextField("3");
        xmsField.setBounds(160, 130, 50, 25);
        add(xmsField);

        // XMX
        JLabel xmxLabel = new JLabel("XMX:");
        xmxLabel.setBounds(220, 130, 150, 25);
        add(xmxLabel);

        xmxField = new JTextField("3");
        xmxField.setBounds(260, 130, 50, 25);
        add(xmxField);

        // Stop Server Button
        JButton stopButton = new JButton("Stop Server");
        stopButton.setBounds(320, 100, 150, 25);
        add(stopButton);

        // Console Area
        consoleArea = new JTextArea();
        consoleArea.setBounds(10, 160, 460, 150);
        add(new JScrollPane(consoleArea));

        // Console Input Field
        JTextField consoleInput = new JTextField();
        consoleInput.setBounds(10, 320, 360, 25);
        add(consoleInput);

        // Enter Button
        JButton enterButton = new JButton("Enter");
        enterButton.setBounds(380, 320, 90, 25);
        add(enterButton);

        // Action Listener for Copy Button
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String publicIP = publicIPField.getText() + ":" + portField.getText();
                StringSelection stringSelection = new StringSelection(publicIP);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                JOptionPane.showMessageDialog(null, "Public IP copied to clipboard");
            }
        });

        // Action Listener for Refresh Button
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement refresh logic here
                consoleArea.append("Refreshing...\n");
            }
        });

        // Action Listener for Stop Server Button
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement stop server logic here
                consoleArea.append("Server stopped.\n");
            }
        });

        // Action Listener for Enter Button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement console input logic here
                String command = consoleInput.getText();
                consoleArea.append("Command: " + command + "\n");
                consoleInput.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }
}
