class Tree
{
    TreeNode root = null;
    String str = null;
    public Tree() {}
    public String preorder()
    {
    	str = " ";
    	preorder(root);
    	return str;
    }
    public void preorder(TreeNode t)
    {
    	if (t == null)
    		return;
    	else
    	{
    		str = str + t.s + " ";
    		preorder(t.left);
    		preorder(t.right);
    	}
    }
    public TreeNode buildAVL(String s)
    {
    	String a[] = s.split(" ");
    	root = null;
    	for (int i = 0; i < a.length; i++)
    	{
    		insert(a[i]);
    	}
    	return root;
    }
    public void insert(String v)
    {
    	root = insert(v, root);
    }
    public TreeNode insert(String v, TreeNode t)
    {
        if (t == null)
            return new TreeNode(v);
        if(v.charAt(0) < t.s.charAt(0))
        {
        	t.left = insert(v,t.left);
        	t = rotate(t);
        }
        else if(v.charAt(0) >= t.s.charAt(0))
        {
        	t.right = insert(v, t.right);
        	t = rotate(t);
        }
        t.height = newHeight(t);
        return t;
    }
    public void delete(String v)
    {
    	root = delete(v, root);
    }
    public TreeNode delete(String v, TreeNode t)
    {
    	if(root == null)
    		return null;
    	else
    	{
    		if (v.charAt(0) < t.s.charAt(0))
    		{
    			t.left = delete(v, t.left);
    			t = rotate(t);
    		}
    		else if (v.charAt(0) > t.s.charAt(0))
    		{
    			t.right = delete(v, t.right);
    			t = rotate(t);
    		}
    		else
    		{
    			if (t.left != null && t.right != null)
    			{
    				t.s = findMin(t.right).s;
    				t.right = delete(t.s, t.right);
    				t = rotate(t);
    			}
    			else
    			{
    				if (t.right != null)
    					t = t.right;
    				else if(t.left != null)
    					t = t.left;
    			}
    		}
    		return t;
    	}
    }
    public String rotateState(TreeNode t)
  	{
  		int d = Math.abs(newHeight(t.left) - newHeight(t.right));
  		if (d > 1)
  		{
  			if (newHeight(t.left) > newHeight(t.right))
  			{
  				if (newHeight(t.left.left) < newHeight(t.left.right)) return "lr";
  				else return "ll";
  			}
  			else
  			{
  				if (newHeight(t.right.left) > newHeight(t.right.right)) return "rl";
  				else return "rr";
  			}
  		} else return "";
  	}
    public TreeNode rotate(TreeNode t)
    {
    	if (t != null)
        {
    		t.height = newHeight(t);
    		switch (rotateState(t))
    		{
    			case "ll":
				t = rotateClockwise(t);
				t.height = newHeight(t);
				break;
    			case "rr":
				t = rotateCounterClockwise(t);
				t.height = newHeight(t);
				break;
    			case "lr":
				t.left = rotateCounterClockwise(t.left);
				t = rotateClockwise(t);
				t.height = newHeight(t);
				break;
    			case "rl":
				t.right = rotateClockwise(t.right);
				t = rotateCounterClockwise(t);
				t.height = newHeight(t);
				break;
			}
		}
		return t;
    }
    TreeNode rotateClockwise(TreeNode a) 
    {
		TreeNode b, x;
		b = a.left;
		x = b.right;
		a.left = x;
		b.right = a;
		return b;
	}
	TreeNode rotateCounterClockwise(TreeNode a) 
	{
		TreeNode b, x;
		b = a.right;
		x = b.left;
		a.right = x;
		b.left = a;
		return b;
	}
    public int newHeight(TreeNode t)
    {
    	if (t == null)
    		return 0;
    	t.height = Math.max(newHeight(t.left), newHeight(t.right)) + 1;
    	return t.height;
    }
    public TreeNode findMin(TreeNode t)
    {
    	if (t == null)
    		return null;
    	else if (t.left == null) 
    		return t;
    	else return findMin(t.left);
    }
}
