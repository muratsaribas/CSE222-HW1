public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        Company company = new Company("Saribas");

        AutomationSystem aSystem = new AutomationSystem("HW",company);

        try {


            //User log = aSystem.login(12345, "1234");

            // Login to system as Admin
            System.out.println("\n### Login to system as Admin ###");
            User loginUser = aSystem.login(company.getAdmin().getUserID(), "1234");
            Admin admin = null;
            if (loginUser instanceof Admin)
                admin = (Admin) loginUser;

            // Add branch
            System.out.println("\n ### Add branch ###");
            admin.addBranch(3);
            Branch branch = new Branch(company,4);
            admin.addBranch(branch.getBranchCode());

            int branches = company.getBranches().size();
            for(int i=0; i<branches;i++)
                System.out.println("Branch: "+ company.getBranches().at(i).getBranchCode());

            // Remove branch
            System.out.println("\n ### Remove branch ###");
            admin.removeBranch(3);
            admin.removeBranch(4);

            branches = company.getBranches().size();
            for(int i=0; i<branches;i++)
                System.out.println("Branch: "+ company.getBranches().at(i).getBranchCode());

            // Add branch employee
            System.out.println("\n ### Add branch employee ###");
            admin.addBranchEmployee(1,"be3","be3","be3@gmail.com","123");
            admin.addBranchEmployee(2,"be4","be4","be4@gmail.com","123");

            branches = company.getBranches().size();

            for(int i=0; i<branches;i++){
                int emp = company.getBranches().at(i).getEmployee().size();
                for (int j=0; j<emp;j++){
                    System.out.println(company.getBranches().at(i).getEmployee().at(j).toString());
                }
            }

            // Remove branch employee
            System.out.println("\n ### Remove branch employee ###");
            int userID = company.getBranches().at(0).getEmployee().at(1).getUserID();
            admin.removeBranchEmployee(1,userID);
            userID = company.getBranches().at(1).getEmployee().at(1).getUserID();
            admin.removeBranchEmployee(2,userID);


            for(int i=0; i<branches;i++){
                int emp = company.getBranches().at(i).getEmployee().size();
                for (int j=0; j<emp;j++){
                    System.out.println(company.getBranches().at(i).getEmployee().at(j).toString());
                }
            }

            // Login to system as branch employee
            System.out.println("\n### Login to system as branch employee ###");
            userID = company.getBranches().at(0).getEmployee().at(0).getUserID();
            loginUser = aSystem.login(userID,"123");

            BranchEmployee branchEmployee = null;
            if (loginUser instanceof BranchEmployee)
                branchEmployee = (BranchEmployee) loginUser;

            // Add customer
            System.out.println("\n ### Add customer ###");
            Customer customer = null;
            boolean flag = branchEmployee.addUser("Murat", "Saribas", "ms@gmail.com","123");
            int index = company.getCustomers().size();
            customer = company.getCustomers().at(index -1);
            if (flag)
                System.out.println("\nSuccessful: "+ customer.getName()+" "+customer.getSurname()+" ID: " + customer.getUserID());


            flag = branchEmployee.addUser("Veli","Kemal","vk@gmail.com","123");
            index = company.getCustomers().size();
            customer = company.getCustomers().at(index-1);
            if (flag)
                System.out.println("Successful: "+ customer.getName()+" "+customer.getSurname()+" ID: " + customer.getUserID());

            flag = branchEmployee.addUser("Enes","Ozgur","enes@gmail.com","123");
            index = company.getCustomers().size();
            customer = company.getCustomers().at(index-1);
            if (flag)
                System.out.println("Successful: "+ customer.getName()+" "+customer.getSurname()+" ID: " + customer.getUserID());

            flag = branchEmployee.addUser("Bilal","Eksi","eksi@gmail.com","123");
            index = company.getCustomers().size();
            customer = company.getCustomers().at(index-1);
            if (flag)
                System.out.println("Successful: "+ customer.getName()+" "+customer.getSurname()+" ID: " + customer.getUserID());

            System.out.println("Total Customer: " +company.getCustomers().size());
            // Remove customer
            System.out.println("\n ### Remove customer ###");
            customer = company.getCustomers().at(2);
            branchEmployee.removeUser(customer.getUserID());

            for (int i=0; i<company.getCustomers().size();i++){
                customer = company.getCustomers().at(i);
                System.out.println("Name: " + customer.getName()+" "+customer.getSurname()+" ID: "+ customer.getUserID());
            }
            System.out.println("Total Customer: " +company.getCustomers().size());

            // Prints the customer's previous orders
            System.out.println("\n ### Prints the customer's previous orders ###");
            customer = company.getCustomers().at(0);
            branchEmployee.printPreviousOrders(customer.getUserID());

            // Create and add/increase office chair
            System.out.println("\n ### Create and add/increase office chair ###");
            int branchCode = branchEmployee.getBranch().getBranchCode();
            OfficeChair chair1 = new OfficeChair(company, Furniture.Color.BLUE, branchCode, OfficeChair.ChairModel.CHAIR_MODEL1);
            branchEmployee.addProduct(chair1);
            branchEmployee.increaseStock(chair1);
            branchEmployee.increaseStock(chair1);
            OfficeChair chair2 = new OfficeChair(company, Furniture.Color.RED, branchCode, OfficeChair.ChairModel.CHAIR_MODEL2);
            branchEmployee.addProduct(chair2);
            branchEmployee.increaseStock(chair2);
            OfficeChair chair3 = new OfficeChair(company, Furniture.Color.BLACK, branchCode, OfficeChair.ChairModel.CHAIR_MODEL1);
            branchEmployee.addProduct(chair3);
            OfficeChair chair4 = new OfficeChair(company, Furniture.Color.GREEN, branchCode, OfficeChair.ChairModel.CHAIR_MODEL2);
            branchEmployee.addProduct(chair4);

            // Create and add/increase office desk
            System.out.println("\n ### Create and add/increase office desk ###");
            OfficeDesk desk1 = new OfficeDesk(company, Furniture.Color.WHITE, branchCode, OfficeDesk.OfficeDeskModel.MODEL1);
            branchEmployee.addProduct(desk1);
            branchEmployee.increaseStock(desk1);
            branchEmployee.increaseStock(desk1);
            branchEmployee.increaseStock(desk1);
            branchEmployee.increaseStock(desk1);
            OfficeDesk desk2 = new OfficeDesk(company, Furniture.Color.BLACK, branchCode, OfficeDesk.OfficeDeskModel.MODEL2);
            branchEmployee.addProduct(desk2);
            branchEmployee.increaseStock(desk2);
            OfficeDesk desk3 = new OfficeDesk(company, Furniture.Color.WHITE, branchCode, OfficeDesk.OfficeDeskModel.MODEL3);
            branchEmployee.addProduct(desk3);
            branchEmployee.increaseStock(desk3);
            OfficeDesk desk4 = new OfficeDesk(company, Furniture.Color.GREEN, branchCode, OfficeDesk.OfficeDeskModel.MODEL4);
            branchEmployee.addProduct(desk4);
            branchEmployee.increaseStock(desk4);

            // Create and add/increase meeting table
            System.out.println("\n ### Create and add/increase meeting table ###");
            MeetingTable table1 = new MeetingTable(company, Furniture.Color.WHITE, branchCode, MeetingTable.MeetingTableModel.MODEL1);
            branchEmployee.addProduct(table1);
            MeetingTable table2 = new MeetingTable(company, Furniture.Color.BLACK, branchCode, MeetingTable.MeetingTableModel.MODEL2);
            branchEmployee.addProduct(table2);
            branchEmployee.increaseStock(table2);
            MeetingTable table3 = new MeetingTable(company, Furniture.Color.WHITE, branchCode, MeetingTable.MeetingTableModel.MODEL3);
            branchEmployee.addProduct(table3);
            branchEmployee.increaseStock(table3);
            MeetingTable table4 = new MeetingTable(company, Furniture.Color.GREEN, branchCode, MeetingTable.MeetingTableModel.MODEL4);
            branchEmployee.addProduct(table4);
            branchEmployee.increaseStock(table4);
            branchEmployee.increaseStock(table4);

            // Print stock of the furniture
            System.out.println("\n ### Print stock of the furniture ###");
            System.out.println("Stock: "+ branchEmployee.getStock(chair1));
            chair1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(chair2));
            chair2.print();
            System.out.println("Stock: "+ branchEmployee.getStock(desk1));
            desk1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(table1));
            table1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(table2));
            table2.print();

            // Remove product
            System.out.println("\n ### Remove product ###");
            branchEmployee.removeProduct(table4);
            branchEmployee.removeProduct(desk3);
            branchEmployee.removeProduct(chair2);

            for (int i=0; i< branchEmployee.getBranch().getFurniture().size();i++)
                branchEmployee.getBranch().getFurniture().at(i).print();

            // Taking orders and selling
            System.out.println("\n ### Taking orders and selling ###");
            System.out.println("Stocks before sale: ");
            System.out.println("Stock: "+ branchEmployee.getStock(chair1));
            chair1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(desk1));
            desk1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(table1));
            table1.print();

            customer = company.getCustomers().at(0);
            userID = customer.getUserID();
            branchEmployee.newOrder(userID, OfficeChair.ChairModel.CHAIR_MODEL1, Furniture.Color.BLUE);
            branchEmployee.newOrder(userID, OfficeDesk.OfficeDeskModel.MODEL1, Furniture.Color.WHITE);
            branchEmployee.newOrder(userID, MeetingTable.MeetingTableModel.MODEL1, Furniture.Color.WHITE);
            branchEmployee.sale(userID);

            System.out.println("\nStocks after sale: ");
            System.out.println("Stock: "+ branchEmployee.getStock(chair1));
            chair1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(desk1));
            desk1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(table1));
            table1.print();

            // Prints the customer's previous orders
            System.out.println("\n ### Prints the customer's previous orders ###");
            branchEmployee.printPreviousOrders(userID);

            // Login to system as customer
            System.out.println("\n### Login to system as customer ###");
            customer = company.getCustomers().at(0);
            userID = customer.getUserID();
            loginUser = aSystem.login(userID,"123");
            if (loginUser instanceof Customer)
                customer = (Customer) loginUser;

            // Find product
            System.out.println("\n ### Find product ###");
            customer.findProduct(company, chair1);
            customer.findProduct(company, chair2);
            customer.findProduct(company, desk1);
            customer.findProduct(company, desk2);
            customer.findProduct(company, table1);
            customer.findProduct(company, table2);

            // List products in the branch
            System.out.println("\n ### List products in the branch ###");
            Branch branch1 = branchEmployee.getBranch();
            customer.listProducts(branch1);


            // Find the branch where the product is located
            System.out.println("\n ### Find the branch where the product is located ###");
            customer.printProductsBranch(company, chair1);
            customer.printProductsBranch(company, chair2);
            customer.printProductsBranch(company, desk1);
            customer.printProductsBranch(company, desk2);
            customer.printProductsBranch(company, table4);

            // Prints previous orders
            System.out.println("\n ### Prints previous orders ###");
            customer.printPreviousOrders();


        }
        catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }


    }
}
