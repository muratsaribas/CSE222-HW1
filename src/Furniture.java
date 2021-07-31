public abstract class Furniture {

    enum Color{
        NONE, RED, GREEN, BLUE, WHITE, BLACK
    }

    private Company company;
    private Color color = Color.NONE;
    private int branchCode;
    private int stock;

    /**
     * Constructor
     * @param company company
     * @param color furniture's color
     * @param branchCode of branch where it is located
     * @throws Exception Invalid Branch Code
     */
    public Furniture(Company company, Color color, int branchCode) throws Exception {
        this.company = company;
        this.color = color;
        this.stock = 3;
        setBranchCode(branchCode);
    }

    /**
     * Getter for furniture's company
     * @return company
     */
    public Company getCompany(){
        return company;
    }

    /**
     * Getter for furniture's color
     * @return furniture's color
     */
    public Color getColor(){
        return color;
    }

    /**
     * Getter for furniture's branch code
     * @return branch code
     */
    public int getBranchCode(){
        return branchCode;
    }

    /**
     * Setter for furniture's color
     * @param color furniture's color
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * Setter for furniture's branch
     * @param branchCode furniture's new branch
     * @throws Exception Invalid Branch Code
     */
    public void setBranchCode(int branchCode) throws Exception {
        int len = getCompany().getBranches().size();
        Branch br = new Branch(getCompany(), branchCode);
        int index = getCompany().getBranches().contains(br);
        if (index == -1)
            throw new Exception("Invalid Branch Code.");
        this.branchCode = branchCode;
    }

    /**
     * Getter for furniture's stock
     * @return furniture's stock
     */
    public int getStock(){
        return stock;
    }

    /**
     * Increase the furniture's stock by 1
     */
    protected void increaseStock(){
        stock++;
    }

    /**
     * Decrease the furniture's stock by 1
     * @throws Exception Stock is insufficient!
     */
    protected void decreaseStock() throws Exception {
        if (stock > 0)
            stock--;
        else
            throw new Exception("Stock is insufficient!");
    }

    public abstract int getModelCode();
    public abstract void print();
    public abstract void showAvailableColors();
}
