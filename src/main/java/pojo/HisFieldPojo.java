package pojo;

public class HisFieldPojo {
    
    private int row;
    private int column;
    private int position;
    private String fieldKey;
    
    public HisFieldPojo(int row, int column, int position, String fieldKey) {
        super();
        this.row = row;
        this.column = column;
        this.position = position;
        this.fieldKey = fieldKey;
    }

    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public void setColumn(int column) {
        this.column = column;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }
    
    public String getFieldKey() {
        return fieldKey;
    }
    
    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    @Override
    public String toString() {
        return "HisFieldPojo [row=" + row + ", column=" + column + ", position=" + position + ", fieldKey=" + fieldKey + "]";
    }

}
