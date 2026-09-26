//Leetcode 824 - Goat Latin

//
// Approach: String Manipulation
//
// Split the sentence into words and process each word individually.
// If a word starts with a vowel, keep it unchanged.
// Otherwise, move its first character to the end.
// Append "ma" followed by an increasing number of 'a' characters.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {
    public String toGoatLatin(String sentence) {
        String[] words=sentence.split(" ");
        StringBuilder res=new StringBuilder();
        String vowels="aeiouAEIOU";
            for(int i=0;i<words.length;i++){
                String word=words[i];
                
            
        if(vowels.indexOf(word.charAt(0))==-1){
            word=word.substring(1)+word.charAt(0);
        }
        word=word+"ma";
             word += "a".repeat(i + 1);
        if(i>0)
        res.append(" ");
        res.append("word");
    }
        return res.toString();
}
}
