package fisikes.regex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DraggableGraph extends JFrame {

    private Map<String, Point> nodePositions;
    private Set<String> draggedNodes;

    public DraggableGraph() {
        initializeGraph();

        // 设置窗口属性
        setTitle("Draggable Graph");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建画布面板
        GraphPanel graphPanel = new GraphPanel();
        add(graphPanel);

        // 初始化拖拽状态
        draggedNodes = new HashSet<>();
    }

    private void initializeGraph() {
        // 有环图
        nodePositions = new HashMap<>();
        nodePositions.put("A", new Point(50, 150));
        nodePositions.put("B", new Point(150, 50));
        nodePositions.put("C", new Point(250, 150));
        nodePositions.put("D", new Point(150, 250));
    }

    private class GraphPanel extends JPanel {
        public GraphPanel() {
            // 添加鼠标事件监听器
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // 检查鼠标点击的节点
                    checkNodeClicked(e.getPoint());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // 释放拖拽状态
                    draggedNodes.clear();
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    // 拖拽节点
                    dragNodes(e.getPoint());
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 绘制图形
            drawGraph(g);
        }

        private void drawGraph(Graphics g) {
            // 遍历图的节点
            for (Map.Entry<String, Point> entry : nodePositions.entrySet()) {
                String node = entry.getKey();
                Point position = entry.getValue();

                // 绘制节点
                g.drawOval(position.x - 20, position.y - 20, 40, 40);
                g.drawString(node, position.x - 5, position.y + 5);

                // 绘制边
                for (Map.Entry<String, Point> neighborEntry : nodePositions.entrySet()) {
                    String neighbor = neighborEntry.getKey();
                    if (!node.equals(neighbor)) {
                        Point neighborPosition = neighborEntry.getValue();
                        g.drawLine(position.x, position.y, neighborPosition.x, neighborPosition.y);
                    }
                }
            }
        }

        private void checkNodeClicked(Point clickPoint) {
            // 检查鼠标点击的节点
            for (Map.Entry<String, Point> entry : nodePositions.entrySet()) {
                Point position = entry.getValue();
                if (distance(clickPoint, position) < 20) {
                    draggedNodes.add(entry.getKey());
                }
            }
        }

        private void dragNodes(Point dragPoint) {
            // 拖拽节点
            for (String nodeName : draggedNodes) {
                nodePositions.put(nodeName, dragPoint);
            }

            // 重绘
            repaint();
        }

        private double distance(Point p1, Point p2) {
            int dx = p2.x - p1.x;
            int dy = p2.y - p1.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DraggableGraph draggableGraph = new DraggableGraph();
            draggableGraph.setVisible(true);
        });
    }
}
