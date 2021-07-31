
public class Company {

    private String companyName;
    private Admin admin;
    private Container<Branch> branch;
    private Container<BranchEmployee> employee;
    private Container<Customer> customer;
    private Container<Furniture> furniture;


    /**
     * Constructor
     * @param companyName Company name
     */
    public Company(String companyName) {
        this.companyName = companyName;
        Admin admin1 = new Admin("admin", "admin", "admin@gmail.com", "1234",this);
        admin = admin1;
        branch = new Container<>();
        employee = new Container<>();
        customer = new Container<>();
        furniture = new Container<>();
    }

    /**
     * Getter for company's name
     * @return company's name
     */
    public String getCompanyName(){
        return companyName;
    }

    /**
     * Setter for company's name
     * @param companyName company's name
     */
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    /**
     * Getter for admin
     * @return admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * Getter for branches owned by the company
     * @return branches in the company
     */
    public Container<Branch> getBranches(){
        return branch;
    }

    /**
     * Getter for branch employees owned by the company
     * @return branch employees in the company
     */
    public Container<BranchEmployee> getEmployees(){
        int len = getBranches().size();
        for (int i=0; i<len;i++){
            Branch br = getBranches().at(i);
            int emp = br.getEmployee().size();
            for (int j=0;j<emp;j++){
                employee.add(br.getEmployee().at(j));
            }
        }

        return employee;
    }

    /**
     * Getter for customers
     * @return customers
     */
    public Container<Customer> getCustomers(){
        return customer;
    }


    @Override
    public String toString() {
        return String.format("Company Name: "+getCompanyName()+
                " Admin: "+ getAdmin().getName()+ " " + getAdmin().getSurname()+
                "\nAdmin's ID: " +getAdmin().getUserID() +
                " Password: "+ getAdmin().getPassword());
    }
}
