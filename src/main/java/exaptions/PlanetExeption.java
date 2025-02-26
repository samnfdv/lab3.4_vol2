package exaptions;

public class PlanetExeption extends RuntimeException {
    public PlanetExeption(String message) {
        super(message);
    }
  @Override
  public String getMessage() {
    return "Ошибка выполнения из-за политического строя " + super.getMessage();
  }
}

