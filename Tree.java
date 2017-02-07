
public class Tree {
	private int treeTop;
	private int trunkHeight = 3, trunkWidth = 3;
	
	public Tree(int treeHeight) {
		treeTop = treeHeight - trunkHeight;
	}
	
	public void printWith(char symbol) {
		for (int r=0; r<treeTop; r++) {
			for (int c=treeTop - r -1; c>0; c--)
				System.out.print(" ");
			for (int c=1; c<(r+1) * 2; c++)
				System.out.print(symbol);
			System.out.println();
		}
		for (int r=0; r<trunkHeight; r++) {
			for (int c=treeTop - trunkWidth/2 - 1; c>0; c--)
				System.out.print(" ");
			for (int c=0; c<trunkWidth; c++)
				System.out.print(symbol);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree(10);
		tree.printWith('#');
	}
}
