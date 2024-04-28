package fisikes.regex;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphVisualization extends JFrame {

    private Map<String, Set<String>> graph;

    public GraphVisualization() {
        // 初始化图结构
        initializeGraph();

        // 设置窗口属性
        setTitle("Graph Visualization");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建画布面板
        GraphPanel graphPanel = new GraphPanel();
        add(graphPanel);
    }

    private void initializeGraph() {
        // 无环图
        graph = new HashMap<>();
        graph.put("A", new HashSet<>(Set.of("B", "C")));
        graph.put("B", new HashSet<>(Set.of("D")));
        graph.put("C", new HashSet<>(Set.of("E")));
        graph.put("D", new HashSet<>(Set.of("E")));
        graph.put("E", new HashSet<>());
    }

    private class GraphPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 绘制图形
            drawGraph(g);
        }

        private void drawGraph(Graphics g) {
            int startX = 50;
            int startY = 200;
            int circleRadius = 30;

            // 遍历图的节点
            for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
                String node = entry.getKey();
                int centerX = startX + circleRadius;
                int centerY = startY;

                // 绘制节点
                g.drawOval(centerX - circleRadius, centerY - circleRadius, 2 * circleRadius, 2 * circleRadius);
                g.drawString(node, centerX - 5, centerY + 5);

                // 绘制边
                for (String neighbor : entry.getValue()) {
                    int neighborCenterX = startX + (circleRadius * 3);
                    int neighborCenterY = startY;

                    g.drawLine(centerX, centerY, neighborCenterX, neighborCenterY);

                    // 绘制箭头
                    drawArrow(g, centerX, centerY, neighborCenterX, neighborCenterY);
                }

                startX += circleRadius * 4;
            }
        }

        private void drawArrow(Graphics g, int startX, int startY, int endX, int endY) {
            int arrowSize = 5;

            double angle = Math.atan2(endY - startY, endX - startX);
            int x1 = (int) (endX - arrowSize * Math.cos(angle - Math.PI / 6));
            int y1 = (int) (endY - arrowSize * Math.sin(angle - Math.PI / 6));
            int x2 = (int) (endX - arrowSize * Math.cos(angle + Math.PI / 6));
            int y2 = (int) (endY - arrowSize * Math.sin(angle + Math.PI / 6));

            g.drawLine(endX, endY, x1, y1);
            g.drawLine(endX, endY, x2, y2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphVisualization graphVisualization = new GraphVisualization();
            graphVisualization.setVisible(true);
        });
    }
}
