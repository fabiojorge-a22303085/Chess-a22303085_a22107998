package pt.ulusofona.lp2.deisichess;

public class InvalidGameInputException extends Exception {
    private int lineWithError;
    private String problemDescription;

    public InvalidGameInputException(int lineWithError, String problemDescription) {
        super("Ocorreu um erro a ler o ficheiro, na linha " + lineWithError + " com o seguinte problema: " + problemDescription);
        this.lineWithError = lineWithError;
        this.problemDescription = problemDescription;
    }

    public int getLineWithError() {
        return lineWithError;
    }

    public String getProblemDescription() {
        return problemDescription;
    }
}