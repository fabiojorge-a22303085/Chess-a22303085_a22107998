package pt.ulusofona.lp2.deisichess;

public class InvalidTeamException extends RuntimeException {
    private final String invalidPieceName;

    public InvalidTeamException(String invalidPieceName) {
        super("Equipa inválida para a peça: " + invalidPieceName);
        this.invalidPieceName = invalidPieceName;
    }

    public String getInvalidPieceName() {
        return invalidPieceName;
    }
}
