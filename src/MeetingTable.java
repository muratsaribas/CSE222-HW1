
public class MeetingTable extends Furniture{

    enum MeetingTableModel{
        MODEL1,
        MODEL2,
        MODEL3,
        MODEL4,
        MODEL5,
        MODEL6,
        MODEL7,
        MODEL8,
        MODEL9,
        MODEL10
    }

    private MeetingTableModel model;
    private int modelCode;
    private Color[] availableColors = new Color[]{  Color.BLACK,
            Color.BLUE,
            Color.GREEN,
            Color.WHITE,
    };

    /**
     * Constructor
     * @param company furniture's company
     * @param color furniture's color
     * @param branchCode furniture's model
     * @param model table's model
     * @throws Exception this color is not available
     */
    public MeetingTable(Company company, Color color, int branchCode, MeetingTableModel model) throws Exception {
        super(company, color, branchCode);
        this.model = model;
        if (!isAvailable(color))
            throw new Exception("This color is not available");
        modelCode = modelToCode(model);
    }

    /**
     * Getter for table's model
     * @return table's model
     */
    public MeetingTableModel getModel(){
        return model;
    }

    /**
     * Check if there is color in the available colors
     * @param color furniture's color
     * @return true if the color is available
     */
    public boolean isAvailable(Color color){
        for (int i=0; i<availableColors.length;i++)
            if (availableColors[i] == color)
                return true;
        return false;
    }

    /**
     * Convert model to code
     * @param mt table's model
     * @return table's code
     */
    public int modelToCode(MeetingTableModel mt){
        int code;
        switch (mt){
            case MODEL1:
                code = 100;
                break;
            case MODEL2:
                code = 101;
                break;
            case MODEL3:
                code = 102;
                break;
            case MODEL4:
                code = 103;
                break;
            case MODEL5:
                code = 104;
                break;
            case MODEL6:
                code = 105;
                break;
            case MODEL7:
                code = 106;
                break;
            case MODEL8:
                code = 107;
                break;
            case MODEL9:
                code = 108;
                break;
            case MODEL10:
                code = 109;
                break;
            default:
                code = -1;
                break;
        }
        return code;
    }

    /**
     * Returns model's code
     * @return model's code
     */
    @Override
    public int getModelCode() {
        return modelCode;
    }

    @Override
    public void print() {
        System.out.println("Meeting Table : " + getModel() + " Color: " +getColor() + " Code: "+ getModelCode());
    }

    @Override
    public void showAvailableColors() {
        System.out.println("Available Colors: ");
        for (int i=0; i< availableColors.length;i++)
            System.out.println(availableColors[i]);

    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof MeetingTable))
            return false;

        MeetingTable other = (MeetingTable) o;
        return getModelCode() == other.getModelCode() && getColor() == other.getColor();
    }

}
