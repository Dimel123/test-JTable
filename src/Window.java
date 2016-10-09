import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {


    private JTable jTable;
    private JScrollPane jScrollPane;
    private JButton btnAdd;
    private JButton btnRemove;
    private PersonModel model;

    public Window(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(640, 480);
        model = new PersonModel();
        jTable = new JTable(model);
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jTable);
        jScrollPane.setBounds(10, 10, 480, 420);
        getContentPane().add(jScrollPane);

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person person = new Person();
                person.setName(JOptionPane.showInputDialog("Enter name:"));
                person.setSurName(JOptionPane.showInputDialog("Enter surName"));
                Main.persons.add(person);
                jTable.updateUI();
            }
        });

        btnAdd.setBounds(520, 10, 100, 20);
        getContentPane().add(btnAdd);
        btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jTable.getSelectedRow()==-1||Main.persons.size()==0){return;}
                Main.persons.remove(jTable.getSelectedRow());
                jTable.updateUI();
            }
        });

        btnRemove.setBounds(520, 40, 100, 20);
        getContentPane().add(btnRemove);

        getContentPane().setLayout(null);

        setVisible(true);
    }
}
