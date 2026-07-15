// Leetcode - 819 - Most Common Word

/*
Approach (HashMap + HashSet):
1. Store all banned words in a HashSet for O(1) lookup.
2. Convert the paragraph to lowercase.
3. Replace all punctuation with spaces.
4. Split the paragraph into words.
5. Traverse each word:
   - Ignore banned words.
   - Count the frequency using a HashMap.
6. Track the word with the maximum frequency.
7. Return the most frequent non-banned word.

Time Complexity: O(N)
Space Complexity: O(N)
*/










class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String>set=new HashSet<>();
        for(String ban:banned){
set.add(ban);
        }
paragraph=paragraph.toLowerCase().replaceAll("[^a-z]"," ");
String[]words=paragraph.split("\\s+");
        HashMap<String,Integer>map=new HashMap<>();
        int maxfreq=0;
        String ans="";
for(String word:words){
    if(word.length() == 0) continue;
if(!set.contains(word)){
int freq=map.getOrDefault(word,0)+1;
    map.put(word,freq);

if(freq>maxfreq){
maxfreq=freq;
    ans=word;
}
}
}
    return ans;
    }
}
        
    
