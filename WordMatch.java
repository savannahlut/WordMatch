public class WordMatch
{
    /** The secret string. */
    private String secret;

    /** Constructs a WordMatch object with the given secret string of lowercase letters. */
    public WordMatch(String word)
    {
        secret = word; 
    }

    /** Returns a score for guess, as described in part (a).
    * Precondition: 0 < guess.length() <= secret.length()
    */
    public int scoreGuess(String guess)
    {
        int occurence = 0;
        int a = guess.length();
        for(int i=0; i<=secret.length()-a; i++){
            if(secret.substring(i, i+a).equals(guess)){
                occurence++;
            }
        }
        return a * a * occurence;
    }

    /** Returns the better of two guesses, as determined by scoreGuess and the rules for a
    * tie-breaker that are described in part (b).
    * Precondition: guess1 and guess2 contain all lowercase letters.
    * guess1 is not the same as guess2.
    */
    public String findBetterGuess(String guess1, String guess2)
    {
        int score1 = this.scoreGuess(guess1);
        int score2 = this.scoreGuess(guess2);
        if(score1 > score2) return guess1;
        if(score2 > score1) return guess2;
        return (guess1.compareTo(guess2) > 0)? guess1 : guess2 ;
        /* could also be:
        if(guess1.compareTo(guess2) > 0){
        return guess1;
        }else{
        return guess2;
        }
        */
    }
}