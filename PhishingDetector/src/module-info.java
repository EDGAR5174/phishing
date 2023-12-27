import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhishingDetector {

    private static final Map<String, Integer> KEYWORDS = new HashMap<>();

    static {
        KEYWORDS.put("alerta", 3);
        KEYWORDS.put("atención", 2);
        KEYWORDS.put("confirmación", 2);
        KEYWORDS.put("crédito", 2);
        KEYWORDS.put("cuenta", 2);
        KEYWORDS.put("dinero", 2);
        KEYWORDS.put("efectivo", 2);
        KEYWORDS.put("información confidencial", 3);
        KEYWORDS.put("inminente", 3);
        KEYWORDS.put("interés", 2);
        KEYWORDS.put("importante", 2);
        KEYWORDS.put("inscripción", 2);
        KEYWORDS.put("legal", 2);
        KEYWORDS.put("legalmente", 2);
        KEYWORDS.put("llamada", 2);
        KEYWORDS.put("mantenimiento", 2);
        KEYWORDS.put("mensaje importante", 3);
        KEYWORDS.put("notificación", 2);
        KEYWORDS.put("número de tarjeta de crédito", 3);
        KEYWORDS.put("número de cuenta", 2);
        KEYWORDS.put("oferta", 2);
        KEYWORDS.put("pago", 2);
        KEYWORDS.put("problema", 2);
        KEYWORDS.put("renovación", 2);
        KEYWORDS.put("servicio", 2);
        KEYWORDS.put("suscripción", 2);
        KEYWORDS.put("verificado", 2);
        KEYWORDS.put("urgente", 2);
        KEYWORDS.put("actualización", 2);
        KEYWORDS.put("acuerdo", 2);
        KEYWORDS.put("banco", 2);
        KEYWORDS.put("correo electrónico", 2);
        KEYWORDS.put("dirección", 2);
        KEYWORDS.put("dirección de correo electrónico", 2);
        KEYWORDS.put("documento", 2);
    }

    public static boolean isPhishing(String mensaje) {
        int puntuacion = 0;

        for (String palabra : mensaje.split(" ")) {
            if (KEYWORDS.containsKey(palabra)) {
                puntuacion += KEYWORDS.get(palabra);
            }
        }

        return puntuacion >= 5;
    }

    public static void main(String[] args) {
        String mensaje = "Su cuenta bancaria ha sido bloqueada. Haga clic aquí para desbloquearla.";

        if (isPhishing(mensaje)) {
            System.out.println("El mensaje es phishing.");
        } else {
            System.out.println("El mensaje no es phishing.");
        }
    }
}