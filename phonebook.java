/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/



class Contacts{

    long id, mobile_number;
    String email_id;


    Contacts(long id, long mobile_number, String email_id)
    {
        this.id = id;
        this.mobile_number = mobile_number;
        this.email_id = email_id;
    } //parametrised constructure

    public String toString()
    {
        return "Email: " + this.email_id + "\nMobile Number: " + this.mobile_number;
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
	public static void main(String[] args) 
	{
        System.out.println("Hello World");
        Contacts c1 = new Contacts(1, 9435015890L, "abc@gmail.com");
        Contacts c2 = new Contacts(2, 9123456643L, "def@gmail.com");
        Contacts c3 = new Contacts(3, 9090911143L, "ghi@gmail.com");
        
        
        try {
            c1.mobile_number_setter(9435011111L);
            c1.email_id_setter("bbc@gmail.com");
            
        }
        catch(Exception m){
            System.out.println("Exception occured: "+m);
            
        }  
        /*   try {
          c1.mobile_number_setter(873);
            
        }
        catch(Exception m){
            System.out.println("Exception occured: "+m);
            
        }*/
        
        ContactServiceImpl cc = new ContactServiceImpl();
        cc.insertContact(c1, "SIM");
        cc.insertContact(c2, "SIM");
        cc.insertContact(c3, "PHONE");
        cc.displayContacts();
	}
}

