import org.junit.Test;

import java.util.*;

public class Biscuits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int n = sc.nextInt();

        int len = number.length();
        long[][] dp = new long[len + 1][n];
        dp[0][0] = 1;//chu shi tiao jian hen zhong yao
        for(int i = 1; i <= len; i++) {
            char ch = number.charAt(i - 1);
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 10; k++) {
                    if(ch == 'X' || ch == '0' + k) {
                        dp[i][(j * 10 + k) % n] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println();
    }
    @Test
    public void test() {
       String beginWord = "hit";
       String endWord = "cog";
       String[] s = {"hot","dot","dog","lot","log"};
       List<String> wordList =Arrays.asList(s);
       int ret = ladderLength(beginWord, endWord, wordList);
       System.out.println(ret);

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        visited.add(beginWord);
        int size = queue.size();
        int path = 0;
        while(!queue.isEmpty()) {
            for(int i = 0; i < size; i++) {
                char[] word = queue.poll().toCharArray();
                for(int j = 0; j < word.length; j++) {
                    char tmp = word[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        word[j] = c;
                        String s = String.valueOf(word);
                        if(!visited.contains(s)) {
                            if(s.equals(endWord)) {
                                path++;
                                return path;
                            }
                            if(set.contains(s)) {
                                queue.offer(s);
                                visited.add(s);
                            }
                        }
                    }
                    word[j] = tmp;
                }
            }
            size = queue.size();
            path++;
        }
        return path;
    }
}
