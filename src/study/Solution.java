package study;

public class Solution {
    public int solution(int n, int k, int[][] grid) {
        int answer = 0;

        // dp 배열 초기화
        int[][][] dp = new int[n][n][k + 1];

        // 초기값 설정
        dp[0][0][grid[0][0]] = 1;

        // 격자의 각 칸에 대해 dp 배열 갱신
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = 0; m <= k; m++) {
                    if (dp[i][j][m] == 0) continue;

                    // 오른쪽으로 이동
                    if (j + 1 < n) {
                        int newK = (grid[i][j + 1] == grid[i][j]) ? m : m - 1;
                        if (newK >= 0) {
                            dp[i][j + 1][newK] = Math.max(dp[i][j + 1][newK], dp[i][j][m] + 1);
                        }
                    }

                    // 아래로 이동
                    if (i + 1 < n) {
                        int newK = (grid[i + 1][j] == grid[i][j]) ? m : m - 1;
                        if (newK >= 0) {
                            dp[i + 1][j][newK] = Math.max(dp[i + 1][j][newK], dp[i][j][m] + 1);
                        }
                    }
                }
            }
        }

        // 최댓값 찾기
        for (int i = 0; i <= k; i++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    answer = Math.max(answer, dp[x][y][i]);
                }
            }
        }

        return answer * answer; // 최대 정사각형 넓이 반환
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예시 테스트 케이스
        int n1 = 4, k1 = 3;
        int[][] grid1 = {{1, 2, 2, 2}, {1, 2, 1, 1}, {1, 2, 2, 1}, {3, 2, 1, 1}};
        System.out.println(solution.solution(n1, k1, grid1)); // 출력: 9

        int n2 = 3, k2 = 2;
        int[][] grid2 = {{1, 1, 1}, {1, 2, 2}, {1, 2, 4}};
        System.out.println(solution.solution(n2, k2, grid2)); // 출력: 4

        int n3 = 2, k3 = 4;
        int[][] grid3 = {{1, 2}, {3, 4}};
        System.out.println(solution.solution(n3, k3, grid3)); // 출력: 4
    }
}
