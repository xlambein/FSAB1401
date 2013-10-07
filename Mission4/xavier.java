/**
 * @pre -
 * @post returns true if adn only contains the characters 'a', 't', 'c' and 'g', false otherwise
 */
public static boolean isADN(String adn)
{
    for(int i = 0; i < adn.length(); i++) 
	    if(!(adn.charAt(i) == 'a' || adn.charAt(i) == 't' || adn.charAt(i) == 'c' || adn.charAt(i) == 'g'))
	        return false;
    return true;
}

/**
 * @pre -
 * @post returns the number of occurences of c in adn
 */
public static int count(String adn, char c)
{
    int count = 0;
    for(int i = 0; i < adn.length(); i++)
        if(adn.charAt(i) == c)
            count++;
    return count;
}

/**
 * @pre adn1 and adn2 have the same length
 * @post returns the Hamming Distance between adn1 and adn2
 */
public static int distanceH(String adn1, String adn2)
throws IllegalArgumentException
{
    if(adn1.length() != adn2.length())
        throw new IllegalArgumentException("The two strings have different length");
    int dist = 0;
    for(int i = 0; i < adn1.length(); i++)
        if(adn1.charAt(i) == adn2.charAt(i))
            dist++;
    return dist;
}

/**
 * @pre -
 * @post returns true if adn is a palindrome, false otherwise
 */
public static String isPalindrome(String adn)
{
    for(int i = 0; i < adn.length(); i++)
        if(adn.charAt(i) != adn.charAt(adn.length()-1-i))
            return false;
    return true;
}

/**
 * @pre adn.length() > 0
 * @post returns the longest palindrome in adn
 */
public static String plusLongPalindrome(String adn)
{
    if(adn.length() == 0)
        return "";
    String palindrome = adn.charAt(0);
    for(int i = 0; i < adn.length(); i++)
        for(int j = i; j < adn.length(); j++)
            if(i-j > 1)
            {
                String str = adn.substring(i, j)
                if(isPalindrome(str) and str.length() > palindrome.length())
                    palindrome = str;
            }
    
    return palindrome;
}
