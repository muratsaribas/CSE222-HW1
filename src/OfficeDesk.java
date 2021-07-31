import java.util.Arrays;

public class OfficeDesk extends Furniture{

    enum OfficeDeskModel{
        MODEL1,
        MODEL2,
        MODEL3,
        MODEL4,
        MODEL5
    }

    private OfficeDeskModel model;
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
     * @param branchCode furniture's branch code
     * @param model desk's model
     * @throws Exception This color is not available
     */
    public OfficeDesk(Company company, Color color, int branchCode, OfficeDeskModel model) throws Exception {
        super(company, color, branchCode);
        this.model = model;
        if (!isAvailable(color))
            throw new Exception("Bu renk mevcut değil");
        modelCode = modelToCode(model);
    }

    /**
     * Getter for desk's model
     * @return
     */
    public OfficeDeskModel getModel(){
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
     * @param od desk's model
     * @return desk's code
     */
    public int modelToCode(OfficeDeskModel od){
        int code;
        switch (od){
            case MODEL1:
                code = 300;
                break;
            case MODEL2:
                code = 301;
                break;
            case MODEL3:
                code = 302;
                break;
            case MODEL4:
                code = 303;
                break;
            case MODEL5:
                code = 304;
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
        System.out.println("Office Desk: " + getModel() + " Color: " + getColor()+" Code: "+getModelCode());
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
        if (!(o instanceof OfficeDesk))
            return false;

        OfficeDesk other = (OfficeDesk) o;
        return getModelCode() == other.getModelCode() && getColor() == other.getColor();
    }

}
