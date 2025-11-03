import java.util.regex.*;

public class FileNameExtractor {
    public static String extractFileName(String dirtyFileName) {
      
      // veriy is a valid string
      if (dirtyFileName == null || dirtyFileName.isEmpty()){
        return "String can not be empty or Null";
      }
      
      // captures the group that matches the file name format
      Pattern patron = Pattern.compile("_([\\w\\-]+\\.\\w+)");
      Matcher matcher = patron.matcher(dirtyFileName);
      
      
      if(matcher.find()){
         return matcher.group(1);
      }
      
      return "";
    }

    // método para probar la funciónw
    public static void main(String[] args) {
        String[] pruebas = {
            "user_12345-report.pdf.sdkjsdf",
            "data_backup_2023-08-15.zip-941654",
            "9465468797849864_image_profile-pic.png",
            "document_final_v2.docx",
            "no_filename_here",
            "another_invalid_file-name"
        };

        for (String prueba : pruebas) {
            String resultado = extractFileName(prueba);
            System.out.println("Entrada: \"" + prueba + "\" -> Salida: \"" + resultado + "\"");
        }
    }
}
