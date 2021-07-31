
public class Admin extends User{

    private Company company;

    /**
     * Constructor
     * @param name admin's name
     * @param surname admin's surname
     * @param email admin's email
     * @param password admin's password
     * @param company admin's company
     */
    public Admin(String name, String surname, String email, String password, Company company) {
        super(name, surname, email, password);
        this.company = company;
    }

    /**
     * Getter for admin's company
     * @return company
     */
    public Company getCompany(){
        return company;
    }

    /**
     * Add new branch
     * @param branchCode of the branch to be added
     * @return true if the company doesn't have that branch
     */
    public boolean addBranch(int branchCode){
        Branch br = new Branch(getCompany(), branchCode);
        return getCompany().getBranches().add(br);
    }

    /**
     * Remove the existing branch
     * @param branchCode of the branch to be deleted
     * @return true if the company already has that branch and remove operation is successful
     */
    public boolean removeBranch(int branchCode){
        Branch br = new Branch(getCompany(), branchCode);
        return getCompany().getBranches().remove(br);
    }

    /**
     * Add new branch employee
     * @param branchCode of the branch
     * @param name branch employee's name
     * @param surname branch employee's surname
     * @param email branch employee's email
     * @param password branch employee's password
     * @return true if the branch doesn't have that branch employee
     */
    public boolean addBranchEmployee(int branchCode, String name, String surname, String email ,String password){
        Branch br = new Branch(getCompany(), branchCode);
        int index = getCompany().getBranches().contains(br);
        if (index == -1)
            return false;
        BranchEmployee be = new BranchEmployee(name,surname,email,password, br);
        return getCompany().getBranches().at(index).getEmployee().add(be);
    }

    /**
     * Remove the existing branch employee from the branch
     * @param branchCode of the employee to be deleted
     * @param userID of the employee to be deleted
     * @return true if the branch employee is removed
     */
    public boolean removeBranchEmployee(int branchCode, int userID){
        Branch br = new Branch(getCompany(), branchCode);
        int index = getCompany().getBranches().contains(br);
        if (index == -1)
            return false;
        BranchEmployee be = new BranchEmployee(br, userID);
        return getCompany().getBranches().at(index).getEmployee().remove(be);
    }
    
    public void testt(){}

}
