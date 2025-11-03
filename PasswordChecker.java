public class PasswordChecker {
    /**
     * Verifica si una contraseña es segura.
     * Una contraseña segura debe tener al menos:
     * - 8 caracteres
     * - 1 letra minúscula
     * - 1 letra mayúscula
     * - 1 dígito
     * - 1 carácter especial (!@#$%^&*())
     * 
     * @param password Cadena de entrada
     * @return true si la contraseña es segura, false en caso contrario
     */

    public static boolean esContrasenaSegura(String password) {

        /* Expresión regular para validar la seguridad de la contraseña
            * - (?=.*[a-z])          → al menos una letra minúscula
            * - (?=.*[A-Z])          → al menos una letra mayúscula
            * - (?=.*\\d)            → al menos un dígito
            * - (?=.*[!@#$%^&*()])   → al menos un carácter especial
            * - .{8,}                → mínimo 8 caracteres
        */
 
    String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$";

    if (password == null || password.isEmpty()) return false;
    return password.matches(regex);  
    }

    // Método para probar la función
    public static void main(String[] args){
        String passwordString1 = "Password123!";
        String passwordString2 = "pass";
        String passwordString3 = "PasswordHolaMundo1@4ever";

        for (String pwd : new String[]{passwordString1, passwordString2, passwordString3}) {
            boolean esSegura = esContrasenaSegura(pwd);
            System.out.println("La contraseña \"" + pwd + "\" es segura? : " + esSegura);
        }
    }
}