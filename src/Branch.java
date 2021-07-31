public class Branch {
    private int branchCode;
    private Company company;
    private Container<BranchEmployee> employee;
    private Container<Furniture> furniture;

    /**
     * Constructor
     * @param company branch's company
     * @param branchCode branch's code
     */
    public Branch(Company company, int branchCode){
        this.company = company;
        setBranchCode(branchCode);
        employee = new Container<>();
        furniture = new Container<>();
    }

    /**
     * Getter for branch's code
     * @return branch's code
     */
    public int getBranchCode(){
        return branchCode;
    }

    /**
     * Setter for branch's code
     * @param branchCode branch's code
     */
    public void setBranchCode(int branchCode){
        this.branchCode = branchCode;
    }

    /**
     * Getter for branch's company
     * @return branch's company
     */
    public Company getCompany(){
        return company;
    }

    /**
     * Getter for all employees in this branch
     * @return all employees in this branch
     */
    public Container<BranchEmployee> getEmployee(){return employee;}

    /**
     * Getter for furnitures in this branch
     * @return furnitures in this branch
     */
    public Container<Furniture> getFurniture(){
        return furniture;}

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Branch))
            return false;

        Branch other = (Branch) o;
        return getBranchCode() == other.getBranchCode();
    }

    @Override
    public String toString() {
        return String.format(" Branch Code: " + getBranchCode());
    }


}
