import java.util.Scanner;
class TreeNode 
{
	String data;
	TreeNode left = null, right = null;

	public TreeNode(String x) 
  {
		data = x;
	}
}

public class Tree 
{
	TreeNode root = null;

	public void insert(String x) 
  {
		root = new TreeNode(x);
	}
	
	public void insert(String x, TreeNode parent, String role) 
  {
		TreeNode n = new TreeNode(x);

		if (root == null)
			root = n;
		else if (role.equalsIgnoreCase("L")) 
    {
			n.left = parent.left;
			parent.left = n;
		} 
    else 
    {
			n.right = parent.right;
			parent.right = n;
		}
	}

	public TreeNode find(String x, TreeNode n) 
  {
		if (n == null)
			return null;

		if (n.data.equalsIgnoreCase(x))
			return n;
		else 
    {
			TreeNode target;
			if ((target = find(x, n.left)) != null)
				return target;
			else
				return find(x, n.right);
		}
	}

	public void printPreOrder(TreeNode n) 
  {
		if (n == null)
			return;
		System.out.print(n.data + "\t");
		printPreOrder(n.left);
		printPreOrder(n.right);
	}

	public void printInOrder(TreeNode n) 
  {
		// your code here
		if (n == null) return;
		printInOrder(n.left);
		System.out.print(n.data + "\t");
		printInOrder(n.right);
	}

	public void printPostOrder(TreeNode n) 
  {
		// your code here
		if (n == null) return;
		printPostOrder(n.left);
		printPostOrder(n.right);
		System.out.print(n.data + "\t");
	}

	public static void process(String command, Tree tree) 
  {
		String[] v = command.split(" ");
		try 
    {
			switch (v[0].toLowerCase()) 
      {
			case "insert":
				if (v.length == 4) 
        {
					TreeNode parent = tree.find(v[2], tree.root);
					tree.insert(v[1], parent, v[3]);
				} 
        else if (v.length == 2)
        {
					tree.insert(v[1]);
				} 
        else 
					throw new Exception("Unknown command!\n");
				
			case "print":
				switch (v[1].toLowerCase()) 
       {
				case "preorder":
					tree.printPreOrder(tree.root);
					break;
				case "inorder":
					tree.printInOrder(tree.root);
					break;
				case "postorder":
					tree.printPostOrder(tree.root);
					break;
				}
				System.out.println();
				break;
			default:
				System.out.println("Unknown command!\n");
			}
		} 
    catch (ArrayIndexOutOfBoundsException ex) 
    {
			System.out.println("Unknown command!\n");
		} 
    catch (NullPointerException ex) 
    {
			System.out.println("Parent not found!\n");
		} 
    catch (Exception ex) 
    {
			System.out.println(ex.getMessage());
		}
	}

	public static void init(Tree tree)
  {
		process("insert A", tree);
		process("insert B A L", tree);
		process("insert C A R", tree);
		process("insert D B L", tree);
		process("insert E B R", tree);
		process("insert F D L", tree);
		process("insert G D R", tree);
		process("print preorder", tree);
		System.out.println();
	}
	
	public static void main(String[] args) 
  {
		Scanner scanner = new Scanner(System.in);
		String command;
		Tree tree = new Tree();
    
		init(tree);
    
		System.out.println("INSERT command: insert {data} {parent} {role}");
		System.out.println("\te.g., Create a new tree and set A as root: insert A");
		System.out.println("\te.g., Insert B as left child of A: insert B A L");
		System.out.println("\te.g., Insert C as right child of A: insert C A R");
		System.out.println("PRINT command: print {order}");
		System.out.println("\te.g., Print tree using Pre-order: print preorder");
		System.out.println("\te.g., Print tree using In-order: print inorder");
		System.out.println("\te.g., Print tree using Post-order: print postorder");
		System.out.println();
		
		while(true)
    {
			System.out.print("command: ");
			command = scanner.nextLine();
			if (command.equalsIgnoreCase("\\END"))
				break;
			else
				process(command, tree);
		}
		scanner.close();
	}
}
