package contactoperation;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class Contacts{
	String name;
	String email;
	String phoneno;
	Contacts next;
	Contacts(String name,String phoneno,String email)
	{
		this.name=name;
		this.email=email;
		this.phoneno=phoneno;
	}
}
class operation{
	static PrintStream out=new PrintStream(new FileOutputStream(FileDescriptor.out));
	  Contacts head=null;
	  void insertcontact()
	  {
		  String name=getname();
		  String email=getemail();
		  String phoneno=getphoneno();
		  if(this.head==null)
		  {
			  this.head=new Contacts(name,phoneno,email);
			  this.head.next=null;
		  }
		  else {
			  Contacts temp=new Contacts(name,phoneno,email);
			  temp.next=this.head;
			  this.head=temp;
			  
		  }
	  }
	  String getname()
	  {
		  Scanner p = new Scanner(System.in);
		  out.print("\nName should be in this format:Ganeshkumar S:");
		  String name=p.nextLine();
		  if(Character.isUpperCase(name.charAt(0))&&Character.isUpperCase(name.charAt(name.length()-1))&& name.charAt(name.length()-2)==' ')
		  {
			  return name;
		  }
		  else {
			  return getname();
		  }
	  }
	  String getemail()
	  {
		  out.print("\nEnter Email:");
		  Scanner p = new Scanner(System.in);
		  String email=p.next();
		  if(email.charAt(email.length()-4)=='.'&&email.contains("@"))
		  {
			  return email;
		  }
		  else {
			    return getemail();
		  }
	  }
	  String getphoneno()
	  {
		  out.print("\nEnter Phonenumber:");
		  Scanner p = new Scanner(System.in);
		  String phoneno=p.next();
		  try {
			  Double.parseDouble(phoneno);
			  if(phoneno.length()==10){
			  return phoneno;
			  }
			  else {
				  out.print("Invalis phone no please Enter the valid phone number!!!");
				  return getphoneno();
			  }
		  }
		  catch(NumberFormatException e)
		  {
			  out.print("Invalis phone no please Enter the valid phone number!!!");
			  return getphoneno();
		  }
	  }
	public void displaycontacts(){
		Contacts temp=this.head;
		if(this.head==null)
		{
			out.print("Contact list is empty!!\n");
		}
		else {
					while(temp!=null)
					{
						  out.print("\nName:"+temp.name+"\nPhoneno:"+temp.phoneno+"\nEmail:"+temp.email);
					      temp=temp.next;
					}
		}
	}	
	public void deletecontact()
	{
		out.print("\nEnter your Phoneno to delete your contact:");
		String phoneno=getphoneno();
		Contacts temp=this.head;
		Contacts  address=this.head;
		if(this.head==null)
		{
			out.print("Contact list is empty!!\n");
		}
		else {
						while(temp!=null)
						{	
							if(temp.phoneno.equals(phoneno))break;
							address=temp;
						    temp=temp.next;
						}
						if(temp==null)
						{
							out.print("Oops your Contact is not found in the list");
						}
						else if(address.phoneno.equals(phoneno) && this.head.next==null)
						{
							this.head=null;
							out.print("Deleted Successfully!!!!\n");
						}
						else {
							address.next=address.next.next;
							out.print("Deleted Successfully!!!!\n");
						}
		}
	}
	public void searchcontact()
	{
		out.print("\nEnter your Phoneno to search your contactdetails:");
		String phoneno=getphoneno();
		Contacts temp=this.head;
	    if(this.head==null)
	    {
	    	out.print("Contact list is empty!!\n");
	    }
	    else {
	    	while(temp!=null)
			{	
				if(temp.phoneno.equals(phoneno))break;
			    temp=temp.next;
			}
	    	if(temp==null)
	    	{
	    		out.print("Oops your Contact is not found in the list");
	    	}
	    	else {
				    	out.print("Your details\n");
				    	out.print("\nName:"+temp.name+"\nPhoneno:"+temp.phoneno+"\nEmail:"+temp.email);
	    	
	    	}
	    }
	}
}
public class Contactslist {
	static PrintStream out=new PrintStream(new FileOutputStream(FileDescriptor.out));
	private static Scanner p;
	public static void main(String[] args) {
		p = new Scanner(System.in);
		operation a1=new operation();
		int choice;
	      while(true)
	      {
	    	  out.print("\nEnter your Choice\n1-addcontact , 2-displaycontact,3-deletecontact,4-searchcontact,0-Exit");
	    	  choice=p.nextInt();
	    	  switch(choice)
	    	  {
	    	  case 0:
	    	  {
	    		  System.exit(0);
	    	  }
	    	  case 1:
	    	  {
	    		  a1.insertcontact();
	    		  break;
	    	  }
	    	  case 2:
	    	  {
	    		  a1.displaycontacts();
	    		  break;
	    	  }
	    	  case 3:
	    	  {
	    		  a1.deletecontact();
	    		  break;
	    	  }
	    	  case 4:
	    	  {
	    		  a1.searchcontact();
	    		  break;
	    	  }
	    	  default:
	    	  {
	    		  out.print("Invalid Choice");
	    		  System.exit(0);
	    	  }
	    	  }
	      }
		
	}

}
