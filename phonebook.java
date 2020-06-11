import java.util.*;


class Contacts{

    long id, mobile_number;
    String email_id;
    String name;


    Contacts (Contacts contact)
    {
        id = contact.id;
        name = contact.name;
        mobile_number = contact.mobile_number;
        email_id = contact.email_id;
    }

    Contacts(String name, long id, long mobile_number, String email_id)
    {
        this.name = name;
        this.id = id;
        this.mobile_number = mobile_number;
        this.email_id = email_id;
    } //parametrised constructure

    public String toString()
    {
        return "\nName: "+ this.name + "\nEmail: " + this.email_id + "\nMobile Number: " + this.mobile_number;
    }

    public long id_getter()
    {
        return this.id;
    }
    public long mobile_number_getter()
    {
        return this.mobile_number;
    }
    public String email_id_getter()
    {
        
        return this.email_id;
    }


    public void id_setter(long id)
    {
        this.id = id;
    }

    
    public void mobile_number_setter(long mobile_number) throws InvalidMobileNumberException
    {
        if(String.valueOf(mobile_number).length()<10){
            throw new InvalidMobileNumberException("Mobile number cannot be less than 10 digits");
            
        }
        this.mobile_number = mobile_number;
    }

    
    public void email_id_setter(String email_id) throws InvalidEmailException
    {
          String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if(email_id.matches(regex))
                this.email_id = email_id;
            else
                throw new InvalidEmailException("Email is not valid");
         
    }

    

}

class ContactService
{
    public Contacts[] SIM = new Contacts[10];
    public Contacts[] PHONE = new Contacts[10];
}

interface ContactServices
{
    public void insertContact(Contacts contact, String memory);
    public void updateContact(Contacts contact, String memory);
    //public Contacts searchContact(long mobileNumber, String memory);
}

class ContactServiceImpl extends ContactService implements ContactServices 
{
    public static int i = 0;
    public static int j = 0;
    public void insertContact(Contacts contact, String memory)
    {
        if(memory.equals("SIM"))
        {
            SIM[i] = contact;
            i++;
        }
        else if(memory.equals("PHONE"))
        {
            PHONE[j] = contact;
            j++;
        }
    }
    public void updateContact(Contacts contact, String memory)
    {

    }
   // public Contacts searchContact(long mobileNumber, String memory)
    {
       
    }
    
    public void displayContacts()
    {
        System.out.println("\nCONTACTS IN SIM: ");
        for(int k = 0; k<SIM.length; k++)
        {
            System.out.println("\n" + SIM[k]);
        }

        System.out.println("\n\nCONTACTS IN PHONE: ");        
        for(int k = 0; k<PHONE.length; k++)
        {
            System.out.println("\n" + PHONE[k]);
        }
    }
    
     public void sortContacts()
    {
        Contacts temp;
        for (int i = 0; i < SIM.length; i++) 
        {
            for (int j = i + 1; j < SIM.length; j++)
            {
                if(SIM[i] == null || SIM[j] == null)
                    break;
                else if (SIM[i].name.compareTo(SIM[j].name)>0) 
                {
                    temp = SIM[i];
                    SIM[i] = SIM[j];
                    SIM[j] = temp;
                }
            }
        }
    }
    
    public void CopyAll(String memory)
    {
        if(memory.equals("SIM")){
            int k =0;
            while(j!=10)
            {
                if(SIM[k]!=null)
                {
                    PHONE[j] = SIM[k];
                    j++;
                    k++;
                }
                else
                {
                    break;
                }
            }
        }
       else if(memory.equals("PHONE"))
        {
           int k =0;
            while(i!=10)
            {
                if(PHONE[k]!=null)
                {
                    SIM[i] = PHONE[k];
                    i++;
                    k++;
                }
                else
                {
                    break;
                }
            }
        }
    }
    
    public void Copy(Contacts contact, String memory)
    {
        if(memory.equals("SIM")){
            SIM[i] = contact;
            i++;
        }
        else if(memory.equals("PHONE"))
        {
            PHONE[j] = contact;
            j++;
        }
    }
}

class InvalidMobileNumberException extends Exception
{
    InvalidMobileNumberException(String s)
    {
        super(s);
    }
}

class InvalidEmailException extends Exception
{
    InvalidEmailException(String s)
    {
        super(s);
    }
}

public class Main
{
            public static int id_X = 1;
	public static void main(String[] args) 
	{
        System.out.println("Hello World");
       /* Contacts c1 = new Contacts("dik",1, 9435015890L, "abc@gmail.com");
        Contacts c2 = new Contacts("abc", 2, 9123456643L, "def@gmail.com");
        Contacts c3 = new Contacts("yoyo",3, 9090911143L, "ghi@gmail.com");
        
        
        try {
            c1.mobile_number_setter(9435011111L);
            c1.email_id_setter("bbc@gmail.com");
            
        }
        catch(Exception m){
            System.out.println("Exception occured: "+m);
            
        }  */
        /*   try {
          c1.mobile_number_setter(873);
            
        }
        catch(Exception m){
            System.out.println("Exception occured: "+m);
            
        }*/
        
        ContactServiceImpl cc = new ContactServiceImpl();
        
        System.out.println("MAIN MENU");
        System.out.println("1. INSERT");
        System.out.println("2. UPDATE");
        System.out.println("3. SEARCH");
        System.out.println("4. DISPLAY");
        System.out.println("5. COPY");    
        System.out.println("6. COPY ALL");
        System.out.println("0. EXIT");
       // Contacts gen = new Contacts();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter your choice   :   ");
        int choice = s.nextInt();
        
        do{
            switch(choice)
            {
                case 1: 
                    System.out.println("\nMobile number             :    "); long mobile_input = s.nextLong();s.nextLine();
                    System.out.println("\nName of contact           :    "); String name_input = s.nextLine();
                    System.out.println("\nEmail id                  :    ");  String email_input = s.nextLine();
                    System.out.println("\nStorage(SIM/PHONE)        :    ");  String memory_input = s.nextLine();
                    
                    Contacts c = new Contacts(name_input, id_X, mobile_input, email_input); //etu contact copy koribo lagibo case 2 t
                    cc.insertContact(c, memory_input); //ContactServiceImpl object to insert contact object in array contacts
                    id_X++;
                    break;
                case 5: 
                    Contacts copy_const = new Contacts(c);
                    System.out.println("\nCopy contact to (SIM/PHONE)        :    ");   memory_input = s.nextLine();
                    cc.Copy(c, memory_input);
                case 6: 
                    System.out.println("\nCopy all contacts from (SIM/PHONE)        :    ");   memory_input = s.nextLine();
                    cc.CopyAll(memory_input);
                    
                case 4: cc.displayContacts();
                    break;
            }
            System.out.println("Enter your choice(Press 0 to exit)  :   ");
            choice = s.nextInt();
        }while(choice!=0);
        
        
        
        /*cc.insertContact(c1, "SIM");
        cc.insertContact(c2, "SIM");
        cc.insertContact(c3, "PHONE");
        cc.sortContacts();
        cc.displayContacts();
        cc.Copy(c3, "SIM");
        cc.displayContacts();
        cc.CopyAll("SIM");
        cc.displayContacts();*/
        
	}
}

