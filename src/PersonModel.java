import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class PersonModel implements TableModel {
    private ArrayList<TableModelListener> listeners;

    public PersonModel(){
        listeners = new ArrayList<TableModelListener>();
    }

    @Override
    public int getRowCount() {
        return Main.persons.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                s = "Name";
            break;
            case 1:
                 s = "Surname";
            break;
        }
        return s;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj = null;
        switch (columnIndex){
            case 0:
                obj = Main.persons.get(rowIndex).getName();
                break;
            case 1:
                obj = Main.persons.get(rowIndex).getSurName();
                break;
        }
        return obj;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                Main.persons.get(rowIndex).setName((String)aValue);
                break;
            case 1:
                Main.persons.get(rowIndex).setSurName((String)aValue);
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
}
