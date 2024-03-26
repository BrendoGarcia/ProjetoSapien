
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;



public class gerandosenhs {


String criptografare(String password) {
	
	try {
        // Criação de uma instância do algoritmo de hash (SHA-256 neste exemplo)
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        
        // Atualização do algoritmo de hash com a senha
        md.update(password.getBytes());
        
        // Geração do hash
        byte[] hashedPassword = md.digest();
        
        // Convertendo o hash para uma representação em String (Base64 neste exemplo)
        return Base64.getEncoder().encodeToString(hashedPassword);
    } catch (NoSuchAlgorithmException e) {
        // Tratamento de exceção para caso o algoritmo de hash não seja suportado
        e.printStackTrace();
        return null;
    }
}   
}
