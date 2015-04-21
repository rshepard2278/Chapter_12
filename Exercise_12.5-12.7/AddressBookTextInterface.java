/**
 * Provide a textual interface to an AddressBook.
 * Different commands provide access to the data in the address book.
 *
 *      One to search the address book.
 *
 *      One to allow a set of contact details to be entered.
 *
 *      One to show all the entries in the book.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class AddressBookTextInterface
{
    // The address book to be viewed and manipulated.
    private AddressBook book;
    // A parser for handling user commands.
    private Parser parser;
    
    /**
     * Constructor for objects of class AddressBookTextInterface
     * @param book The address book to be manipulated.
     */
    public AddressBookTextInterface(AddressBook book)
    {
        this.book = book;
        parser = new Parser();
    }
    
    /**
     * Read a series of commands from the user to interact
     * with the address book. Stop when the user types 'quit'.
     */
    public void run()
    {
        System.out.println("Address Book.");
        System.out.println("Type 'help' for a list of commands.");
        
        String command;
        do{
            command = parser.getCommand();
            if(command.equals("add")){ 
                add();
            }
            else if(command.equals("list")){
                list();
            }
            else if(command.equals("search")){
                find();
            }
            else if(command.equals("help")){
                help();
            }   
            else if(command.equals("get")) {
                getDetails();
            }
            else if(command.equals("remove")) {
                removeDetails();
            }
            else{
                // Do nothing.
            }
        } while(!(command.equals("quit")));

        System.out.println("Goodbye.");
    }

    private void getDetails() {
        System.out.print("Name:  ");
        String name = parser.readLine();
        ContactDetails searchDetails = book.getDetails(name);
        if(searchDetails != null) {
            System.out.println("Found\n" + "=====================\n" + 
                "Name: " + searchDetails.getName());
            System.out.println("Phone:  " + searchDetails.getPhone());
            System.out.println("Address: " + searchDetails.getAddress());
        } else {
            System.out.println(name + " not found in database...");
        }
    }

    private void removeDetails() {
        System.out.print("Name:  ");
        String name = parser.readLine();
        ContactDetails searchDetails = book.getDetails(name);
        if(searchDetails != null) {
            System.out.println("Are you sure you want to remove " + name + " (y/n)");
            String answer = parser.readLine();
            if(answer.toLowerCase().equals("y")) {
                book.removeDetails(name);
                System.out.println(name + " has been removed.");
            } else {
                return;
            }
        } else {
            System.out.println(name + " not found in database...");
        }
    }
    
    /**
     * Add a new entry.
     */
    private void add()
    {
        System.out.print("Name: ");
        String name = parser.readLine();
        System.out.print("Phone: ");
        String phone = parser.readLine();
        System.out.print("Address: ");
        String address = parser.readLine();
        book.addDetails(new ContactDetails(name, phone, address));
    }
    
    /**
     * Find entries matching a key prefix.
     */
    private void find()
    {
        System.out.println("Type a prefix of the key to be found.");
        String prefix = parser.readLine();
        ContactDetails[] results = book.search(prefix);
        for(int i = 0; i < results.length; i++){
            System.out.println(results[i]);
            System.out.println("=====");
        }
    }
    
    /**
     * List the available commands.
     */
    private void help()
    {
        parser.showCommands();
    }
    
    /**
     * List the address book's contents.
     */
    private void list()
    {
        System.out.println(book.listDetails());
    }
}
