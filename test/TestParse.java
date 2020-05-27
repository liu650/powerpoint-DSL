import ast.PROGRAM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestParse {
    private String input;
    private PROGRAM program = new PROGRAM();
    @BeforeEach
    public void setup(){

    }
    @Test
    public void test1(){
        // input = Files.readString(Paths.get("testInput.txt"));
        program.parse();


    }
}