
public class AutomationSystem {

    private String name;
    private Company company;
    private Container<User> users;

    public AutomationSystem(String name, Company company){
        this.name = name;
        this.company = company;
        users = new Container<>();
        users.add(company.getAdmin());
        initialize();
    }

    private void initialize(){
        Branch branch1 = new Branch(company,1);
        Branch branch2 = new Branch(company,2);
        company.getAdmin().addBranch(1);
        company.getAdmin().addBranch(2);
        company.getAdmin().addBranchEmployee(  branch1.getBranchCode(),
                "be1", "be1",
                "be1@gmail.com","123");

        company.getAdmin().addBranchEmployee(  branch2.getBranchCode(),
                "be2", "be2",
                "be2@gmail.com","123");
        BranchEmployee be1 = company.getBranches().at(0).getEmployee().at(0);
        BranchEmployee be2 = company.getBranches().at(1).getEmployee().at(0);

    }

    public User login(int userID, String password) throws Exception {
        users.clear();
        users.add(company.getAdmin());

        for (int i=0; i<company.getEmployees().size();i++)
            users.add(company.getEmployees().at(i));
        for (int i=0; i<company.getCustomers().size();i++)
            users.add(company.getCustomers().at(i));

        for (int i=0; i<users.size();i++){
            User tempUser = users.at(i);
            if (tempUser.getUserID() == userID && tempUser.getPassword() == password){
                if (tempUser instanceof Admin){
                    Admin tempAdmin = (Admin) tempUser;
                    System.out.println("Login successful: "+tempUser.getName()+ " "+ tempUser.getSurname());
                    return tempAdmin;
                }
                else if(tempUser instanceof BranchEmployee){
                    BranchEmployee branchEmployee = (BranchEmployee) tempUser;
                    System.out.println("Login successful: "+tempUser.getName()+ " "+ tempUser.getSurname()+" Branch: "+branchEmployee.getBranch().getBranchCode());
                    return branchEmployee;
                }
                else if(tempUser instanceof Customer){
                    Customer customer = (Customer) tempUser;
                    System.out.println("Login successful: "+tempUser.getName()+ " "+ tempUser.getSurname());
                    return customer;
                }
                else
                    throw new Exception("Login failed invalid user!");
            }

        }
        throw new Exception("Login failed invalid user!");

    }


}
