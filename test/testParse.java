public class TestParse {
    private String input;
    private PROGRAM program = new PROGRAM();
    @BeforeEach
    public void setup(){

    }
    @Test
    public void test1(){
        input = Files.readString(Paths.get("testInput.txt"));
        program.parse();


    }
}