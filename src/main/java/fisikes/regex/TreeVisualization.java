package fisikes.regex;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeVisualization extends JFrame {

    public TreeVisualization() {
        // 创建树结构
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
        DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("Child 3");

        root.add(child1);
        root.add(child2);
        child1.add(new DefaultMutableTreeNode("Child 1-1"));
        child1.add(new DefaultMutableTreeNode("Child 1-2"));
        child2.add(new DefaultMutableTreeNode("Child 2-1"));
        child3.add(new DefaultMutableTreeNode("Child 3-1"));

        // 创建JTree
        JTree tree = new JTree(root);

        // 将JTree添加到滚动面板
        JScrollPane scrollPane = new JScrollPane(tree);

        // 将滚动面板添加到窗口
        add(scrollPane);

        // 设置窗口属性
        setTitle("Tree Visualization");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TreeVisualization treeVisualization = new TreeVisualization();
            treeVisualization.setVisible(true);
        });
    }
}
