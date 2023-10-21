package BST;

public class BST {
    public BSTNode root;

    public BST() {
        this.root = null;
    }

    public void Insert(BSTcar data) {
        BSTNode temp = new BSTNode(data);

        if (root == null) {
            root = temp;
            return;
        }

        BSTNode current = root;
        BSTNode parent = null;

        while (true) {
            parent = current;

            if (data.ID < current.data.ID) {
                current = current.left;

                if (current == null) {
                    parent.left = temp;
                    return;
                }
            } else {
                current = current.right;

                if (current == null) {
                    parent.right = temp;
                    return;
                }
            }
        }
    }

    public void InOrder(BSTNode root) {
        if (root != null) {
            InOrder(root.left);
            System.out.println(root.data.ID + " " + root.data.make + " " + root.data.model + " (" + root.data.year
                    + ") " + root.data.mileage + " mi - $" + root.data.price);
            InOrder(root.right);
        }
    }

    public void PostOrder(BSTNode root) {
        if (root != null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.println(root.data.ID + " " + root.data.make + " " + root.data.model + " (" + root.data.year
                    + ") " + root.data.mileage + " mi - $" + root.data.price);
        }
    }

    public void PreOrder(BSTNode root) {
        if (root != null) {
            System.out.println(root.data.ID + " " + root.data.make + " " + root.data.model + " (" + root.data.year
                    + ") " + root.data.mileage + " mi - $" + root.data.price);
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public BSTNode Search(int ID) {
        BSTNode current = root;

        while (current != null && current.data.ID != ID) {
            if (ID < current.data.ID) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current;
    }

    public void PrintCar(BSTNode car) {
        System.out.println("ID: " + car.data.ID);
        System.out.println("Make: " + car.data.make);
        System.out.println("Model: " + car.data.model);
        System.out.println("Year: " + car.data.year);
        System.out.println("Mileage: " + car.data.mileage);
        System.out.println("Price: " + car.data.price);
    }

    public void Delete(int ID) {
        if (root == null || Search(ID) == null) {
            System.out.println("No item found to delete");
            return;
        }
        root = Delete(root, ID);
    }

    public BSTNode Delete(BSTNode node, int ID) {
        BSTNode temp1, temp2;

        if (node.data.ID == ID) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                temp1 = node.right;
                temp2 = temp1;
                while (temp2.left != null) {
                    temp2 = temp2.left;
                }
                temp2.left = node.left;
                return temp1;
            }
        } else if (ID < node.data.ID) {
            node.left = Delete(node.left, ID);
        } else {
            node.right = Delete(node.right, ID);
        }

        return node;
    }
}
