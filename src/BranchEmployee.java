public class BranchEmployee extends User{
    private Branch branch;
    private Container<Furniture> customerOrder;

    /**
     * Constructor
     * @param name branch employee's name
     * @param surname branch employee's surname
     * @param email branch employee's email
     * @param password branch employee's password
     * @param branch where the branch employee's will work
     */
    public BranchEmployee(String name, String surname, String email, String password, Branch branch) {
        super(name, surname, email, password);
        this.branch = branch;
        customerOrder = new Container<>();
    }

    /**
     * Constructor for create temporary branch employee object
     * @param branch branch
     * @param userID userID
     */
    public BranchEmployee(Branch branch, int userID) {
        super("temp", "temp", "temp", "temp");
        this.branch = branch;
        this.setUserID(userID);
    }

    /**
     * Getter for branch employee's branch
     * @return employee's branch
     */
    public Branch getBranch(){
        return branch;
    }

    /**
     * Add new customer
     * @param name customer's name
     * @param surname customer's surname
     * @param email customer's email
     * @param password customer's password
     * @return true if the customer is added
     */
    public boolean addUser(String name, String surname, String email, String password){
        Customer cs = new Customer(name, surname, email, password);
        return getBranch().getCompany().getCustomers().add(cs);
    }

    /**
     * Remove the existing customer in the company
     * @param userID customer's userID
     * @return true if the customer is removed
     */
    public boolean removeUser(int userID){
        Customer cs = new Customer(userID);
        return getBranch().getCompany().getCustomers().remove(cs);
    }

    /**
     * Prints the customer's previous orders
     * @param userID customer's userID
     */
    public void printPreviousOrders(int userID){
        Customer cs = new Customer(userID);
        int index = getBranch().getCompany().getCustomers().contains(cs);
        if (index == -1)
        {
            System.out.println("Invalid ID");
            return;
        }
        if (getBranch().getCompany().getCustomers().at(index).getOldOrder().isEmpty()){
            System.out.println("Order history is blank!");
            return;
        }
        int len = getBranch().getCompany().getCustomers().at(index).getOldOrder().size();
        Container<Furniture> temp = getBranch().getCompany().getCustomers().at(index).getOldOrder();
        for (int i=0;i<len;i++){
            temp.at(i).print();
        }

    }

    /**
     * Add new order
     * @param userID customer's userID
     * @param model OfficeChair's model
     * @param color OfficeChair's color
     * @throws Exception Stock is insufficient!
     */
    public void newOrder(int userID, OfficeChair.ChairModel model, Furniture.Color color) throws Exception {
        Customer cs = new Customer(userID);
        int idx = getBranch().getCompany().getCustomers().contains(cs);
        if (idx == -1)
        {
            System.out.println("Invalid ID");
            return;
        }

        OfficeChair temp = new OfficeChair(getBranch().getCompany(), color, getBranch().getBranchCode(), model);
        idx = getBranch().getFurniture().contains(temp);
        if (idx == -1){
            System.out.println("The product is out of stock.");
            return;
        }

        temp = (OfficeChair) getBranch().getFurniture().at(idx);

        if (getStock(temp) == 0)
            increaseStock(temp);

        customerOrder.add(temp);
        decreaseStock(temp);

    }

    /**
     * Add new order
     * @param userID customer's userID
     * @param model MeetingTable's model
     * @param color MeetingTable's color
     * @throws Exception Stock is insufficient!
     */
    public void newOrder(int userID, MeetingTable.MeetingTableModel model, Furniture.Color color) throws Exception {
        Customer cs = new Customer(userID);
        int idx = getBranch().getCompany().getCustomers().contains(cs);
        if (idx == -1)
        {
            System.out.println("Invalid ID");
            return;
        }

        MeetingTable temp = new MeetingTable(getBranch().getCompany(), color, getBranch().getBranchCode(), model);
        idx = getBranch().getFurniture().contains(temp);
        if (idx == -1){
            System.out.println("The product is out of stock.");
            return;
        }

        temp = (MeetingTable) getBranch().getFurniture().at(idx);

        if (getStock(temp) == 0)
            increaseStock(temp);

        customerOrder.add(temp);
        decreaseStock(temp);
    }

    /**
     * Add new order
     * @param userID customer's userID
     * @param model OfficeDesk's model
     * @param color OfficeDesk's color
     * @throws Exception Stock is insufficient!
     */
    public void newOrder(int userID, OfficeDesk.OfficeDeskModel model, Furniture.Color color) throws Exception {
        Customer cs = new Customer(userID);
        int idx = getBranch().getCompany().getCustomers().contains(cs);
        if (idx == -1)
        {
            System.out.println("Invalid ID");
            return;
        }

        OfficeDesk temp = new OfficeDesk(getBranch().getCompany(), color, getBranch().getBranchCode(), model);
        idx = getBranch().getFurniture().contains(temp);
        if (idx == -1){
            System.out.println("The product is out of stock.");
            return;
        }

        temp = (OfficeDesk) getBranch().getFurniture().at(idx);

        if (getStock(temp) == 0)
            increaseStock(temp);

        customerOrder.add(temp);
        decreaseStock(temp);

    }

    /**
     * Add new furniture to the branch
     * @param furniture to be added
     */
    public void addProduct(Furniture furniture){
        getBranch().getFurniture().add(furniture);
        System.out.println("Product added ");
        furniture.print();
    }

    /**
     * Remove the furniture in the branch
     * @param furniture to be removed
     * @return true if the furniture is removed
     */
    public boolean removeProduct(Furniture furniture){
        int index = getBranch().getFurniture().contains(furniture);
        if (index==-1){
            System.out.println("Ürün mevcut değil");
            return false;
        }
        getBranch().getFurniture().remove(furniture);
        return true;
    }

    /**
     * Sells received orders
     * @param userID customer's userID
     */
    public void sale(int userID){
        Customer cs = new Customer(userID);
        int idx = getBranch().getCompany().getCustomers().contains(cs);
        if (idx == -1)
        {
            System.out.println("Invalid ID");
            return;
        }
        if(customerOrder.isEmpty())
            System.out.println("Sipariş girilmedi");
        else{
            int len = customerOrder.size();
            for(int i=0;i<len;i++){
                Furniture temp = customerOrder.at(i);
                getBranch().getCompany().getCustomers().at(idx).getOldOrder().add(temp);
            }
            customerOrder.clear();
        }
    }

    /**
     * Getter for the furniture's stock
     * @param fr furniture
     * @return furniture's stock
     */
    public int getStock(Furniture fr){
        int idx = getBranch().getFurniture().contains(fr);
        if (idx == -1)
            return 0;
        return fr.getStock();
    }

    /**
     * Increases furniture stock by 1
     * @param fr furniture
     */
    public void increaseStock(Furniture fr){
        int idx = getBranch().getFurniture().contains(fr);
        if (idx == -1){
            System.out.println("Product not found!");
            return;
        }
        fr.increaseStock();
    }

    /**
     * Decreases furniture stock by 1
     * @param fr furniture
     * @throws Exception Stock is insufficient!
     */
    public void decreaseStock(Furniture fr) throws Exception {
        int idx = getBranch().getFurniture().contains(fr);
        if (idx == -1){
            System.out.println("Product not found!");
            return;
        }
        fr.decreaseStock();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof BranchEmployee))
            return false;

        BranchEmployee other = (BranchEmployee) o;
        return getUserID() == other.getUserID();
    }


    @Override
    public String toString() {
        return String.format(super.toString()+ " Branch: " + getBranch().getBranchCode());
    }
}
