
public class Customer extends User{

    private Container<Furniture> oldOrder;
    /**
     * Constructor
     *
     * @param name     customer's name
     * @param surname  customer's surname
     * @param email    customer's email
     * @param password customer's password
     */
    public Customer(String name, String surname, String email, String password) {
        super(name, surname, email, password);
        oldOrder = new Container<>();
    }

    /**
     * Constructor for create temporary custumer object
     * @param userID customer's userID
     */
    public Customer(int userID){
        super("temp","temp", "temp", "temp");
        this.setUserID(userID);
    }

    /**
     * Returns the customer's previous orders
     * @return customer's previous orders
     */
    public Container<Furniture> getOldOrder(){
        return oldOrder;
    }

    /**
     * Finds any furniture in the company
     * @param company company
     * @param fr furniture
     */
    public void findProduct(Company company, Furniture fr){
        int len = company.getBranches().size();
        for (int i=0;i<len;i++){
            int stock = company.getBranches().at(i).getEmployee().at(0).getStock(fr);
            System.out.println("Branch: "+company.getBranches().at(i).getBranchCode()+ "  Stock: "+stock);
        }
    }

    /**
     * List the products in the branch
     * @param branch branch
     */
    public void listProducts(Branch branch){
        int len = branch.getFurniture().size();
        for (int i=0;i<len;i++){
            branch.getFurniture().at(i).print();
        }
    }

    /**
     * Prints in which branches the furniture is located
     * @param company company
     * @param fr furniture
     */
    public void printProductsBranch(Company company, Furniture fr){
        int len = company.getEmployees().size();
        boolean flag = true;
        for (int i=0; i<len; i++){
            int idx = company.getEmployees().at(i).getBranch().getFurniture().contains(fr);
            if (idx!=-1){
                flag = false;
                System.out.println("Branch: "+company.getEmployees().at(i).getBranch().getBranchCode());}
        }
        if (flag)
            System.out.println("Product not found");
    }


    /**
     * Prints the previous orders
     */
    public void printPreviousOrders(){
        if (oldOrder.isEmpty())
            System.out.println("Siparişiniz bulunmamakta");
        else {
            int len = oldOrder.size();
            for (int i=0;i<len;i++)
                oldOrder.at(i).print();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Customer))
            return false;

        Customer other = (Customer) o;

        return getUserID() == other.getUserID();
    }


}
