class StreamChecker {

    TreeNode root = new TreeNode();

    StringBuilder s = new StringBuilder();

    class TreeNode {
        boolean word;
        TreeNode[] next = new TreeNode[26];
    }

    public StreamChecker(String[] words) {
        createTrie(words);
    }

    private void createTrie(String[] words) {
        for (String word: words) {
            TreeNode curr = root;
            for (int i=word.length()-1;i>=0;i--) {
                if (curr.next[word.charAt(i)-'a'] == null) {
                    curr.next[word.charAt(i)-'a'] = new TreeNode();
                }
                curr = curr.next[word.charAt(i)-'a'];
            }
            curr.word = true;
        }
    }

    public boolean query(char letter) {
        s.append(letter);
        TreeNode curr = root;
        for (int i=s.length()-1;i>=0 && curr!=null;i--) {
            curr = curr.next[s.charAt(i)-'a'];
            if (curr!=null && curr.word) return true;
        }
        return false;
    }
}


/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
