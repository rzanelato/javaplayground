package logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pojo.HisFieldPojo;

public class LogicHisFormFields {

    private static final String SEPARATOR = "SEPARATOR";
    private static final String LINE = "LINE";
    private static final String INPUT = "INPUT";
    private static final String BUTTON = "BUTTON";
    private static List<HisFieldPojo> listFields;

    public static void main(String[] args) {
        listFields = getListFields();
      
        deleteField(0,0,0, BUTTON);
        printList(1);
        
        deleteField(0,0,0, INPUT);
        printList(2);

        deleteField(0,0,1, LINE);
        printList(3);
    }
    
    private static void deleteField(int row, int column, int position, String fieldKey) {
        Iterator<HisFieldPojo> iterator = listFields.iterator();

        int cont = 0;
        while (iterator.hasNext()) {
            HisFieldPojo hfField = iterator.next();
            System.out.println("Field -> " + hfField);
            if (hfField.getRow() == row 
                    && hfField.getColumn() == column 
                    && hfField.getPosition() == position 
                    && hfField.getFieldKey().equalsIgnoreCase(fieldKey)){
                System.out.println("Removed -> " + hfField);
                iterator.remove();
            }else{
                hfField.setPosition(cont);
                cont++;
            }
        }

    }

    private static void printList(int index) {
        for (HisFieldPojo pojo : listFields) {
            System.out.println("Delete "+index+": [" + listFields.indexOf(pojo)+ "] " + pojo);
        }
        System.out.println();
    }

    private static List<HisFieldPojo> getListFields() {
        List<HisFieldPojo> listFields = new ArrayList<>();
        
        HisFieldPojo pojo1 = new HisFieldPojo(0, 0, 0, BUTTON);
        HisFieldPojo pojo2 = new HisFieldPojo(0, 0, 1, INPUT);
        HisFieldPojo pojo3 = new HisFieldPojo(0, 0, 2, SEPARATOR);
        HisFieldPojo pojo4 = new HisFieldPojo(0, 0, 3, LINE);
        HisFieldPojo pojo5 = new HisFieldPojo(0, 1, 0, BUTTON);
        HisFieldPojo pojo6 = new HisFieldPojo(0, 1, 1, INPUT);
        HisFieldPojo pojo7 = new HisFieldPojo(0, 1, 2, BUTTON);
        HisFieldPojo pojo8 = new HisFieldPojo(0, 1, 3, BUTTON);
     
        listFields.add(pojo1);
        listFields.add(pojo2);
        listFields.add(pojo3);
        listFields.add(pojo4);
        listFields.add(pojo5);
        listFields.add(pojo6);
        listFields.add(pojo7);
        listFields.add(pojo8);
        
        return listFields;
    }
    
}
