package libs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tokenizer {

    private String reserved = "`";
    private static String rawInput;
    private static List<String> literals;
    private List<String> tokens = new ArrayList<>();
    private int index = 0;
    private static Tokenizer theTokenizer;

    private Tokenizer(String filename, List<String> literalsList){
        literals = literalsList;
        try {
            rawInput = Files.readString(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Didn't find file");
            System.exit(0);
        }
        tokenize();
    }

     private void tokenize (){

        System.out.println(rawInput);
        String newInput = rawInput;

        //2. Replace all constant literals with “RESERVEDWORD”<the literal>“RESERVEDWORD”
        for(String s : literals) {
            newInput = newInput.replace(s, reserved + s + reserved);
            System.out.println(newInput);
        }

        //3. Replace all “RESERVEDWORDRESERVEDWORD” with just “RESERVEDWORD”
        newInput = newInput.replace("```",reserved);
        newInput = newInput.replace("``",reserved);
        System.out.println(newInput);

        //4. Remove leading “_” character, then split on “_”
        if(newInput.length() > 0 && newInput.charAt(0) == reserved.charAt(0)) {
            newInput = newInput.substring(1); // without first character
        }
        String[] tempArray = newInput.split(reserved);
        System.out.println(Arrays.asList(tempArray));

        //5. Trim whitespace
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = tempArray[i].trim();
        }

        //6. Remove empty tokens
        // tokens = Arrays.stream(tokens).filter(s -> !s.isEmpty()).toArray(String[]::new);
        for (String s:tempArray){
            System.out.println("hell");
            System.out.println(s);
            if(!s.isEmpty()){
               tokens.add(s);
            }
        }

        System.out.println("!!!!!!!!!!!!!!!!!!");
        System.out.println(Arrays.asList(tempArray));
    }

























    private String checkNext(){
        String token="NO_MORE_TOKENS";
        if (moreTokens()){
            token = tokens.get(index);
        }
        return token;
    }

    public String getNext(){
        String token = "NULLTOKEN";
        if (moreTokens()){
            token = tokens.get(index);
            index++;
        }
        return token;
    }


    public boolean checkToken(String regexp){
        String s = checkNext();
        System.out.println("comparing: |"+s+"|  to  |"+regexp+"|");
        return (s.matches(regexp));
    }


    public String getAndCheckNext(String regexp){
        String s = getNext();
        if (!s.matches(regexp)) {
            throw new Error("Unexpected next token for Parsing! Expected something matching: " + regexp + " but got: " + s);
        }
        System.out.println("matched: "+s+"  to  "+regexp);
        return s;
    }

    public boolean moreTokens(){
        return index <tokens.size();
    }

    public static void makeTokenizer(String filename, List<String> literals){
        if (theTokenizer==null){
            theTokenizer = new Tokenizer(filename,literals);
        }
    }

    public static Tokenizer getTokenizer(){
        return theTokenizer;
    }

}
