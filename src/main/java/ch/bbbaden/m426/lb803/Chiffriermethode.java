package ch.bbbaden.m426.lb803;

/**
 *
 * @author Manuel Bachofner
 */
public enum Chiffriermethode {
    Transposition, Caesar, Kamasutra;

    public String getTitel() {
        switch (this) {
            case Transposition:
                return "Transposition";
            case Caesar:
                return "Cäsar";
            case Kamasutra:
                return "Kamasutra";
            default:
                throw new IllegalArgumentException();
        }
    }
}
