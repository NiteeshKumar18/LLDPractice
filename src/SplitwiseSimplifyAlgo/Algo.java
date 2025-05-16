package SplitwiseSimplifyAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algo {

    public int simplifyTransactions(int[][] transactions) {
        Map<Integer, Integer> userToBalanceMap = new HashMap<>();
        List<Integer> balanceArray = new ArrayList<>();
        for (int[] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];

            int fromUserBalance = userToBalanceMap.getOrDefault(from, 0);
            userToBalanceMap.put(from, fromUserBalance - amount);

            int toUserBalance = userToBalanceMap.getOrDefault(to, 0);
            userToBalanceMap.put(to, toUserBalance + amount);


            for (int balanceLocal : userToBalanceMap.values()) {
                if (balanceLocal > 0) {
                    balanceArray.add(balanceLocal);
                }
            }
        }
        return dfs(balanceArray, 0);
    }


    public int dfs(List<Integer> balanceArray, int currIndex) {
        if (balanceArray.isEmpty() || currIndex >= balanceArray.size()) return 0;

        int minTransactions = Integer.MAX_VALUE;
        int currentValue = balanceArray.get(currIndex);

        for (int i = currentValue + 1; i < balanceArray.size(); i++) {
            int newValue = balanceArray.get(i);
            if (currentValue * newValue < 0) {
                balanceArray.set(i, balanceArray.get(i) + balanceArray.get(currIndex));
                minTransactions = Math.min(minTransactions, 1 + dfs(balanceArray, currIndex + 1));
                balanceArray.set(i, newValue);
            }
        }
        return minTransactions;
    }
}
