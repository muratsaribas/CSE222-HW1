
public class OfficeChair extends Furniture{

    enum ChairModel{
        CHAIR_MODEL1,
        CHAIR_MODEL2,
        CHAIR_MODEL3,
        CHAIR_MODEL4,
        CHAIR_MODEL5,
        CHAIR_MODEL6,
        CHAIR_MODEL7
    }

    private ChairModel chairModel;
    private int modelCode;
    private Color[] availableColors = new Color[]{  Color.BLACK,
                                                    Color.BLUE,
                                                    Color.GREEN,
                                                    Color.WHITE,
                                                    Color.RED};

    /**
     * Constructor
     * @param company furniture's company
     * @param color furniture's color
     * @param branchCode furniture's branch code
     * @param chairModel chair's model
     * @throws Exception This color is not available
     */
    public OfficeChair(Company company, Color color, int branchCode, ChairModel chairModel) throws Exception {
        super(company, color, branchCode);
        this.chairModel = chairModel;
        if (!isAvailable(color))
            throw new Exception("This color is not available");
        modelCode = modelToCode(chairModel);
    }

    /**
     * Getter for chair's model
     * @return chair's model
     */
    public ChairModel getModel(){
        return chairModel;
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
     * @param cm chair's model
     * @return chair's code
     */
    public int modelToCode(ChairModel cm){
        int code;
        switch (cm){
            case CHAIR_MODEL1:
                code = 200;
                break;
            case CHAIR_MODEL2:
                code = 201;
                break;
            case CHAIR_MODEL3:
                code = 202;
                break;
            case CHAIR_MODEL4:
                code = 203;
                break;
            case CHAIR_MODEL5:
                code = 204;
                break;
            case CHAIR_MODEL6:
                code = 205;
                break;
            case CHAIR_MODEL7:
                code = 206;
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
        System.out.println("Office Chair: " + getModel() + " Color: "+getColor()+ " Code: " + getModelCode());
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
        if (!(o instanceof OfficeChair))
            return false;

        OfficeChair other = (OfficeChair) o;
        return getModelCode() == other.getModelCode() && getColor() == other.getColor();
    }

}
