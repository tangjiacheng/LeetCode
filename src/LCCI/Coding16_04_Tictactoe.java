package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/13 19:25
 * @description:
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * 示例 1：
 *
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * 示例 2：
 *
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * 示例 3：
 *
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * 提示：
 *
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 */
public class Coding16_04_Tictactoe {
    public String tictactoe(String[] board) {
        boolean pending = false;
        int len = board.length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            int horizontal = 0;
            int vertical = 0;
            for (int j = 0; j < len; j++) {
                horizontal += board[i].charAt(j);
                vertical += board[j].charAt(i);
                if (board[i].charAt(j) == ' ')
                    pending = true;
            }
            if (horizontal == 'O' * len || vertical == 'O' * len)
                return "O";
            if (horizontal == 'X' * len || vertical == 'X' * len)
                return "X";
            left += board[i].charAt(i);
            right += board[i].charAt(len - 1 - i);
        }
        if (left == 'O' * len || right == 'O' * len)
            return "O";
        if (left == 'X' * len || right == 'X' * len)
            return "X";
        if (pending)
            return "Pending";
        return "Draw";
    }

    public static void main(String[] args) {
        String[] board = {"OX ","OX ","O  "};
        Coding16_04_Tictactoe tictactoe = new Coding16_04_Tictactoe();
        System.out.println(tictactoe.tictactoe(board));
    }
}
