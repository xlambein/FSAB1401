public static void testIsADN()
{
    int err=0;
    if(!isADN("")) err++;
    if(!isADN("atcg")) err++;
    if(!isADN("ttttttttttt"))
    if(isADN("x")) err++;
    if(isADN("aaaax")) err++;
    if(isADN("xaaaa")) err++;
    if(isADN("A")) err++;
    
    if(err == 0)
        TextIO.putln("No error found in isADN().");
    else
        TextIO.putln(err+" error(s) found in isADN().");
}
public static void testCount()
{
    int err=0;
    if(count("",'a') != 0) err++;
    if(count("",'t') != 0) err++;
    if(count("t",'a') != 0) err++;
    if(count("aaaa",'a') != 4) err++;
    if(count("atcg",'c') != 1) err++;
    if(count("ababa",'a') != 5) err++;
    
    if(err == 0)
        TextIO.putln("No error found in count().");
    else
        TextIO.putln(err+" error(s) found in count().");
}
public static void testDistanceH()
{
    /*
     * I want to emphasize that the definition of Hamming distance given
     * in the statementis completely wrong and that the errors that will
     * obviously be present should be reported to the authors of that
     * stupid exercises book. Thank you.
     */
    int err=0;
    if(distanceH("","") != 0) err++;
    if(distanceH("a","a") != 0) err++;
    if(distanceH(".",".") != 0) err++; // This method should work on any String
    if(distanceH(".",",") != 1) err++;
    if(distanceH("ac","aa") != 1) err++;
    if(distanceH("atcg","gcta") != 4) err++;
    
    if(err == 0)
        TextIO.putln("No error found in distanceH().");
    else
        TextIO.putln(err+" error(s) found in distanceH().");
}
public static void testIsPalindrome()
{
    int err=0;
    if(!isPalindrome("")) err++;
    if(!isPalindrome("a")) err++;
    if(isPalindrome("ac")) err++;
    if(!isPalindrome("aa")) err++;
    if(!isPalindrome("aca")) err++;
    if(isPalindrome("aaca")) err++;
    
    if(err == 0)
        TextIO.putln("No error fonud in isPalindrome().");
    else
        TextIO.putln(err+" error(s) found in isPalindrome().");
}
public static void testPlusLongPalindrome()
{
    int err=0;
    if(!"".equals(plusLongPalindrome(""))) err++;
    if(!"a".equals(plusLongPalindrome("a"))) err++;
    if(!"aa".equals(plusLongPalindrome("aa"))) err++;
    if(!"aa".equals(plusLongPalindrome("aac"))) err++;
    if(!"gg".equals(plusLongPalindrome("aggc"))) err++;
    if(!"bab".equals(plusLongPalindrome("cbab"))) err++;
    
    if(err == 0)
        TextIO.putln("No error found in plusLongPalindrome().");
    else
        TextIO.putln(err+" error(s) found in plusLongPalindrome().");
}
