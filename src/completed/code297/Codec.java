package completed.code297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("1,2,3,null,null,4,5");
        String serialize = codec.serialize(deserialize);
        System.out.println(serialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return mySerialize(root, "");
    }

    public String mySerialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = mySerialize(root.left, str);
            str = mySerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        return myDeserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    public TreeNode myDeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        treeNode.left = myDeserialize(list);
        treeNode.right = myDeserialize(list);

        return treeNode;
    }
}