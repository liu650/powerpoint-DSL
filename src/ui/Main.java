package ui;

import ast.PROGRAM;
import libs.Node;
import libs.Tokenizer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static String outputFolder = "out/";
    public static String testFolder = "test/";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> literals = Arrays.asList("Title:", "Author:", "Section:", "NewPage:", "BulletPoint:", "Paragraph:",
                "Image:", "Url:", "Path:", "@(", ")@", "Formula:", "$", "Color:", "Size:", "Bi:");
        String inputFile = testFolder + "input_slide.thtml";
        String inputFilename = inputFile.substring(inputFile.lastIndexOf("/") + 1, inputFile.lastIndexOf("."));
        String latexPath = outputFolder + inputFilename + ".tex";

        Tokenizer.makeTokenizer(inputFile, literals);
        try{
            Node.setWriter(latexPath);
        } catch (FileNotFoundException e){
            new File(outputFolder + inputFilename).mkdir();
            Node.setWriter(latexPath);
        }
        PROGRAM p = new PROGRAM();
        System.out.println("\nDone tokenizing");
        p.parse();
        System.out.println("\nDone parsing");
        p.evaluate();
        System.out.println("\nDone evaluation\n");
        Node.closeWriter();

        //take the beamer input, and convert it to slides output
        //any failure encounter here will throw errors
        generatePdf(outputFolder);
    }

    private static void generatePdf(String givenPath){
        ArrayList<String> validPaths = getAllLatex(givenPath);
        String pdfLatexPath = findPdfLatexPath();
        if (validPaths.isEmpty()){
            // should not appear on user's side, as the Latex file is generated by code.
            System.out.println("Failed to find any Latex file.");
        } else if (pdfLatexPath != null) {
            latexToSlides(validPaths, pdfLatexPath);
        } else {
            System.out.println("Failed to load pdfLatex program. Please make sure you have basicTex " +
                    "or LaTex installed. Check \"Installation\" in README.md for more details.");
        }
    }

    // input can either be a directory or an input file
    private static ArrayList<String> getAllLatex(String givenPath){
        //get all the valid paths
        File givenFile = new File(givenPath);
        ArrayList<String> validPaths = new ArrayList<>();
        if (givenFile.exists() && givenFile.isDirectory()) {
            for (File f : givenFile.listFiles()) {
                if (f.isFile() && f.toString().endsWith(".tex")) {
                    System.out.println("Found file with path: " + f.toString());
                    validPaths.add(f.toString());
                }
            }
        } else if (givenFile.exists() && givenFile.isFile()
                && givenFile.toString().endsWith(".tex")){
            System.out.println("Found file with path: " + givenFile.toString());
            validPaths.add(givenFile.toString());
        } else {
            System.out.println("No valid path is detected. Please verify your given path.");
        }
        System.out.println(); //print an empty line for separation
        return validPaths;
    }

    // find PATH of pdflatex
    // TODO: need to test on OS other than Mac, and it would be best to automate this part.
    private static String findPdfLatexPath() {
        return "/Library/TeX/texbin/pdflatex";
    }

    private static void latexToSlides(ArrayList<String> validPaths, String pdfLatexPath){
        for (String p: validPaths){
            try {
                Process process = Runtime.getRuntime().exec(pdfLatexPath
                        + " -output-directory=" + p.substring(0, p.lastIndexOf("/"))
                        + " " + p);

                StringBuilder fullOutput = new StringBuilder();
                StringBuilder shortOutput = new StringBuilder();

                BufferedReader stdInput = new BufferedReader(new
                        InputStreamReader(process.getInputStream()));

                BufferedReader stdError = new BufferedReader(new
                        InputStreamReader(process.getErrorStream()));

                String lineInput;
                while ((lineInput = stdInput.readLine()) != null) {
                    fullOutput.append(lineInput + "\n");
                    if (lineInput.startsWith("Output")){
                        shortOutput.append(lineInput + "\n");
                    }
                }

                String lineError;
                while ((lineError = stdError.readLine()) != null) {
                    fullOutput.append(lineError + "\n");
                }

                // kill the process if it takes over than 1 min
                boolean exitVal = process.waitFor(1, TimeUnit.MINUTES);

                if (exitVal) {
                    System.out.println("Success!");
                    System.out.println(shortOutput);
                    cleanUpPdfLog(p);
                } else {
                    System.out.println("Failure in pdf generating!");
                    System.out.println(fullOutput);
                }
            } catch (IOException e) {
                System.out.println("Failed to load pdfLatex program. Please make sure you have basicTex installed" +
                        "using Homebrew command \n ==> brew cask install basictex");
                // e.printStackTrace();
            } catch (InterruptedException e) {
                System.out.println("The program is forced to quit.");
                // e.printStackTrace();
            }
        }
    }

    // remove all the log files if the pdf is created successfully.
    private static void cleanUpPdfLog(String p) throws IOException {
        String fileName = p.substring(0, p.lastIndexOf("."));
        String[] logFiles = {".aux", ".log", ".nav", ".out", ".snm", ".toc"};
        for (String log: logFiles){
            Runtime.getRuntime().exec("rm " + fileName + log);
        }
    }
}
