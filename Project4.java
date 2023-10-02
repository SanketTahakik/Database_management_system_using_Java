//////////////////////////////////////////////////////////////
//
// Function name : 
// input         : integer
// Output        : integer
// Discption     : Project
// Auther        : Tahakik Sanket Rajendra
// Date          : 26/07/2023
//
/////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////
//
// Problem Statement : DBMS using java
//
/////////////////////////////////////////////////////////////

import java.util.*;

import javax.swing.plaf.basic.BasicDirectoryModel;

class Student 
{
    public int Rno;
    public String Name;
    public int Age;
    public int Marks;

    public static int Generator;

    static 
    {
        Generator = 0;
    }

    public Student(String str, int X, int Y)
    {
        this.Rno = ++Generator;
        this.Name = str;
        this.Age = X;
        this.Marks = Y;
    }
    public void Display()
    {
        System.out.println(this.Rno+ " " + this.Name + " " + this.Age + " "+ this.Marks);
    }
}

class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList <Student> ();
    }

    public void StartDBMS()
    {
        System.out.println("Sanket DBMS started succesfully...");
        System.out.println("Table schema created succesfully...");

        String Query;
        String Tokens[];

        Scanner sobj = new Scanner(System.in);
        int TokensCount = 0;

        while(true)
        {
            System.out.print("Sanket DBMS : ");
            Query = sobj.nextLine();

            Tokens = Query.split(" ");

            TokensCount = Tokens.length;

            if(TokensCount == 1)
            {
                if("exit".equals(Tokens[0]))
                {
                    System.out.println("Thank you");
                    break;
                }
            }
            else if(TokensCount == 2)
            {

            }
            else if(TokensCount == 3)
            {
                
            }
            else if(TokensCount == 4)
            {
                if("select".equals(Tokens[0]))
                {
                    SelectFrom();
                }
            }
            else if(TokensCount == 5)
            {
                if("select".equals(Tokens[0]))
                {
                    if("Max".equals(Tokens[1]))
                    {
                        System.out.println("Maximun marks are : " + Aggregate_MAX());
                    }
                    if("Min".equals(Tokens[1]))
                    {
                        System.out.println("Maximun marks are : " + Aggregate_MIN());
                    }
                    if("Avg".equals(Tokens[1]))
                    {
                        System.out.println("Maximun marks are : " + Aggregate_AVG());
                    }
                    if("Sum".equals(Tokens[1]))
                    {
                        System.out.println("Maximun marks are : " + Aggregate_SUM());
                    }
                }
            }
            else if(TokensCount == 6)
            {
                
            }
            
            else if(TokensCount == 7)
            {
                if("insert".equals(Tokens[0]))
                {
                    InsertIntoTable(Tokens[4], Integer.parseInt(Tokens[5]), Integer.parseInt(Tokens[6]));
                }   
                else if("delete".equals(Tokens[0]))
                {
                    DeleteFrom(Integer.parseInt(Tokens[6]));
                }
            }
        }
    }

    // Insert into table student value(_________, ________, ________)
    public void InsertIntoTable(String name, int age, int marks)
    {
        Student sobj = new Student(name, age, marks);

        lobj.add(sobj);
    }

    // select * from studen
    public void SelectFrom()
    {
        System.out.println("Recoeds from the student database are : ");

        for(Student sref : lobj)
        {
            sref.Display();
        }
    }

    // select * from student where Rno = 11  
    public void SelectFrom(int no)
    {
        System.out.println("Recoeds from the student database are : ");

        for(Student sref : lobj)
        {
            if(sref.Rno == no)
            {
                sref.Display();
                break;
            }
        }
    }  
    // select * from student where name = Sayali
    public void SelectFrom(String str)
    {
        System.out.println("Recoeds from the student database are : ");

        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.Display();
                break;
            }
        }
    }  

    // Select MAX(marks) from strudent
    public int Aggregate_MAX()
    {
        Student temp = lobj.get(0);
        int iMin = temp.Marks;
        
        int iMax = 0;
        
        for(Student sref : lobj)
        {
            if(sref.Marks > iMax)
            {
                iMax = sref.Marks;
            }
        }
        return iMax;
    }
    
    // Select MIN(marks) from strudent
    public int Aggregate_MIN()
    {
        Student temp = lobj.get(0);
        int iMin = temp.Marks;

        for(Student sref : lobj)
        {
            if(sref.Marks < iMin)
            {
                iMin = sref.Marks;
            }
        }
        return iMin;
    }
    
    // Select SUM(marks) from strudent
    public int Aggregate_SUM()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Marks;
            
        }
        return iSum;
    }
    
    // Select Avg(marks) from strudent
    public float Aggregate_AVG()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Marks;
        }
        return (iSum / (lobj.size()));
    }

    // delete from from strudent where Rno = 2
    public void DeleteFrom(int no)
    {
        int i = 0;

        for(Student sref : lobj)
        {
            if(sref.Rno == no)
            {
                lobj.remove(i);
                break;
            }
            i++;
        }
        
    }
}

class program538
{
    public static void main(String args[])
    {
        DBMS obj = new DBMS();
        obj.InsertIntoTable("Rahul", 23, 89);
        obj.StartDBMS();

        /*
        obj.InsertIntoTable("Sagar", 26, 98);
        obj.InsertIntoTable("Pooja", 20, 56);
        obj.InsertIntoTable("Sayali", 30, 78);
        obj.InsertIntoTable("Tejas", 29, 68);

        obj.SelectFrom();
        obj.SelectFrom(4);
        obj.SelectFrom("Tejas");
        
        System.out.println("Maximum marks are : " +obj.Aggregate_MAX());
        System.out.println("Mainum marks are : " +obj.Aggregate_MIN());
        System.out.println("Sumation of marks are : " +obj.Aggregate_SUM());
        System.out.println("Avreage of marks are : " +obj.Aggregate_AVG());

        obj.DeleteFrom(4);
        obj.SelectFrom();
        */


    }
}

// Insert Query
// insert into student Rahul  23  67
//   0     1      2       3    4  5
// No of token = 5

// Selete Query
// selete * from student
//   0    1   2     3
// No of tokens = 4

// delete from student where Rno = 4
//   0      1     2       3   4  5  6
// No of Tokens = 7

// select Max Mark from student
//   0     1    2    3      4
// No of Tokens = 5

// select Min Mark from student
//   0     1    2    3      4
// No of Tokens = 5

// select Avg Mark from student
//   0     1    2    3      4
// No of Tokens = 5

// select Sum Mark from student
//   0     1    2    3      4
// No of Tokens = 5

// clear
//   0
// No of Tokens = 1
