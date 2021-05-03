
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class LockedMe
        {
            static File root=new File("//home//debasishpujapan//Desktop//practise//");
            
            static int numberinput()
            {
                String choice;
                int ret;
                Scanner sc = new Scanner(System.in);
                try {
                    choice = sc.nextLine();
                    ret = Integer.parseInt(choice);
                    return (ret);
                } catch (Exception e) {
                    return (0);
                }
            }

                static String stringinput()
                {
                    String choice="";
                    Scanner sc=new Scanner(System.in);
                    try{
                        choice=sc.nextLine();
                        return(choice);
                    }
                    catch(Exception e)
                    {
                        return("error");
                    }
                }

                public static String typeOfFile(File f)
                {
                	String type = "";
                	if (f.isDirectory())type = "Folder";
                	else {
                		type=f.getName().split(".")[1];
                	}
                	return type;
                }
         	   public static void printFiles(List<File> filesList) {
         		   if (filesList ==null)System.out.printf("Directory is Empty\n");
         		   
         		   else {
         			  System.out.printf("%-5s | %-77s | %-20s | %-20s","SrNO.\n","FileName","Type","Path");
         			   int j= 0;
         			   for(File i:filesList) {
         				   System.out.printf("%-5s | %-77s | %-20s | %-20s\n",++j,i.getName(),i.getAbsolutePath());
         				 
         			   }System.out.println(" ");}
         		   }

                public static void searching() {
                	File[] fileArray = root.listFiles();
                System.out.print("Enter the file name to search : ");
              List<File>filesFounded = new ArrayList<>();
                String filetoBeSearch = stringinput();
                for(File i: fileArray) 
                	if(i.getName().equalsIgnoreCase(filetoBeSearch)) {
                		filesFounded.add(i);
                	}
                printFiles(filesFounded); }
                
                public static void deleting() {
                	System.out.print("Enter the file name to delete : ");
                	String fileToDelete = stringinput();
                	File fd = new File(root+"/"+fileToDelete);
                	try {
                		if (!fd.exists())System.out.println("File do not exist");
                		else {
                			boolean deleted = fd.delete();
                			if(!deleted&&fd.isDirectory()) {
                				System.out.println("Directory must be empty ot delete the file");
                			}else System.out.println("File has been deleted successfully");
                		}
                	}catch(Exception e) {
                		System.out.println("Exceptions occurs "+e);
                	}
               
                }
                
                
        public static void main(String[] args)

        {
                System.out.println("\nProject Name :- LockedMe.com");
                System.out.println("Project developed by :- Debasish Pujapanda");
                
                System.out.println("\nRoot Directory:- "+root);
                
            while(true)
            {
            System.out.println("\n1. Show the files in Ascending Order");
            System.out.println("2. Business-level operations");
            System.out.println("3. Close the Application");
            int choice=0;
                choice=numberinput();
               if(choice==0)
                  {
                      System.out.println("Invalid Input!");
                      System.out.println("Please try Again!");
                  }
               else if(choice==1)
                  {
                      File[] fileascending=root.listFiles();
                      Arrays.sort(fileascending);
                       if(fileascending.length==0)
                      System.out.println("Root folder is an empty directory");
                       else
                              {
                               System.out.println("List of files are :-");
                               for(File e:fileascending)
                               System.out.println(e.getName());
                               }
                   }
               else if(choice==2)
                   {
                       while(true)
                       {
                           int secondinput=0;
                           System.out.println("\n1. Add a new File");
                           System.out.println("2. Delete a file");
                           System.out.println("3. Search a file");
                           System.out.println("4. Go Back to the Main Menu");
                           System.out.println("5. Exit the application");
                           secondinput=numberinput();
                          
                           if(secondinput==0)
                           {
                               System.out.println("Invalid Input!");
                               System.out.println("Please try Again!");
                           }
                           else if(secondinput==3)  LockedMe.searching();  
                           else if(secondinput==2) deleting();
                        	           
                           else if(secondinput==1)
                           {
                               String filename;
                               System.out.println("Enter the file name:");
                               filename=stringinput();
                               if(filename.equals("error")||filename.equals(""))
                               {
                                   System.out.println("Invalid Input");
                                   System.out.println("Please try Again!");
                               }
                               else
                               {
                                   String temp=root.getAbsolutePath();
                                   temp=temp.concat("\\"+filename);
                                   File newfile= new File(temp);
                                   if(newfile.exists())
                                   {
                                       System.out.println("A file already exists with the same name");
                                       System.out.println("Try Again with a different name");
                                   }
                                   else
                                   {
                                       try{
                                           newfile.createNewFile();
                                       }
                                       catch(IOException e)
                                       {
                                           System.out.println("Exception Occured");
                                       }

                                       if(newfile.exists())
                                           System.out.println("New File has been created successfully");
                                       else
                                           System.out.println("New File creation failed");
                                   }

                               }
                           }
                           else if(secondinput==2)
                           {
                               

                           }
                           else if(secondinput==3)
                           {
                        	 
                           }
                           else if(secondinput==4)
                           {
                               break;
                           }
                           else if(secondinput==5)
                           {
                               System.out.println("Thank you");
                               System.exit(0);
                           }
                           else
                           {
                               System.out.println("Invalid Input!");
                               System.out.println("Please try Again!");
                           }

                       }

                    }
            
              else if(choice==3)               
                       {
                        System.out.println("Thank you");
                        System.exit(0);
                       }
                 else
                  {
                      System.out.println("Invalid Input");
                  }
             }
        }
     }

