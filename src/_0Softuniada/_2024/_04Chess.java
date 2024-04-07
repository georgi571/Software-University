package _0Softuniada._2024;

import java.util.*;

public class _04Chess {
    static int[] dr = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dc = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int R = Integer.parseInt(scanner.nextLine());
        int C = Integer.parseInt(scanner.nextLine());
        int T = Integer.parseInt(scanner.nextLine());
        int F = Integer.parseInt(scanner.nextLine());
        int result = minMoves(N, R, C, T, F);
        System.out.printf("%d", result);
    }

    static class Point {
        int row, col, dist;

        public Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static int minMoves(int N, int R, int C, int T, int F) {
        Deque<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new Point(R, C, 0));
        visited[R][C] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.row == T && current.col == F) {
                return current.dist;
            }
            for (int i = 0; i < 8; i++) {
                int newRow = current.row + dr[i];
                int newCol = current.col + dc[i];
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && !visited[newRow][newCol]) {
                    queue.offer(new Point(newRow, newCol, current.dist + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return -1;
    }
}
