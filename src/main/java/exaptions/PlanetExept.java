package exaptions;

public class PlanetExept extends RuntimeException {
    public PlanetExept(String message) {
        super(message);
    }
  @Override
  public String getMessage() {
    return "Ошибка выполнения из-за политического строя " + super.getMessage();
  }
}

