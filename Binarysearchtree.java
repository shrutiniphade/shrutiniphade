import java.util.*;
class node
{
    int data;
    node left,right;
    node(int element)   //parameterized constructor
    {
        data=element;
    }
}
class Binarysearchtree {
    node root;
    Binarysearchtree()  //default constructo
    {
        root=null;
    }

    void insert(int data)
    {
        root=insertdata(root,data);
    }

    node insertdata(node root, int data)
    {
        if(root==null){
        root=new node(data);
        return root;
        }
        else if(root.data>data)
        {
            root.right=insertdata(root.right, data);
            return root.right;
        }
        else
        {
            root.left=insertdata(root.left, data);
            return root.left;
        }
    }

    node search(node root,int data)
    {
        if(root==null)
        {
        return root;
        }
        else 
        {
            if(root.data>data)
            search(root.right,data);
            else
            search(root.left,data);
        }
        return root;
    }
    void delete(int key)
    {
        root=deletedata(root,key);
    }

    node deletedata(node root,int key)
    {
        if(root==null)
        {
        return null;
        }
        else if(key<root.data)
        {
            root.left=insertdata(root.left, key);
        }
        else if(key>root.data)
        {
            root.right=insertdata(root.right, key);
        }
        else
        {
            if(root.left==null)
            {
                root.left=root.right;
            }
            else if(root.right==null)
            {
                root.right=root.left;
            }
            else 
            {
                root.data=inordersucessor(root.right);
                root.right=deletedata(root.right,root.data);
            }
            

        }
        return null;
    }

    int inordersucessor(node root)
    {   //int current;
        if(root==null){
        System.out.println("tree i empty");
        }
        else
        {
            while(root!=null)
            {
                root=root.left;
            }
        }
        return 0;
    }
    void inorder(node root)
    {
        if(root==null)
        return ;
        else
        {
            inorder(root.left);
            System.out.println(root.data+" ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Binarysearchtree b=new Binarysearchtree();
        int choice;
        do {
            
            System.out.println("welcome to tree program \n 1.insert \n2.delete\n3.search\n4.inorder \n5.exit\nEnter your choice");
            choice=s.nextInt();
            switch(choice)
            {
                case 1:
                System.out.println("enter the value to insert into the tree");
                int x=s.nextInt();
                b.insert(x);
                break;

                case 2:
                System.out.println("enter the value to delete value into tree");
                int y=s.nextInt();
                b.delete(y);
                break;

                case 3:
                System.out.println("enter the value to search into tree");
                int a=s.nextInt();
                b.search(b.root,a);
                break;

                case 4:
                System.out.println("display the inorder traversal");
                b.inorder(null);
                break;

                
                default:
                System.out.println("Invalid choice.Please enter the void choice");
            } 

        }while (choice!=5);
        //while(ch!=5)
        s.close();


    }
}
